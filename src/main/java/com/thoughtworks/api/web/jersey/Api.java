package com.thoughtworks.api.web.jersey;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.thoughtworks.api.domain.core.OrderRepository;
import com.thoughtworks.api.domain.core.ProductRepository;
import com.thoughtworks.api.domain.core.UserRepository;
import com.thoughtworks.api.domain.userExample.EncryptionService;
import com.thoughtworks.api.infrastructure.records.Models;
import com.thoughtworks.api.infrastructure.util.DefaultEncryptionService;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

import javax.inject.Inject;
import java.util.Properties;

import static org.jvnet.hk2.guice.bridge.api.GuiceBridge.getGuiceBridge;

public class Api extends ResourceConfig {
    @Inject
    public Api(ServiceLocator locator) throws Exception {
        Properties properties = new Properties();
        String dbname = System.getenv().getOrDefault("DB_NAME", "data_store");
        String host = System.getenv().getOrDefault("DB_HOST", "localhost");
        String port = System.getenv().getOrDefault("DB_PORT", "3307");
        String username = System.getenv().getOrDefault("DB_USERNAME", "mysql");
        String password = System.getenv().getOrDefault("DB_PASSWORD", "mysql");
        String connectURL = String.format(
                "jdbc:mysql://%s:%s/%s?userExample=%s&password=%s&allowMultiQueries=true&zeroDateTimeBehavior=convertToNull",
                host,
                port,
                dbname,
                username,
                password
        );
        String redistHost = System.getenv().getOrDefault("REDIS_HOST", "127.0.0.1");
        String redisPort = System.getenv().getOrDefault("REDIS_PORT", "6379");
        final String redisURL = String.format("%s:%s", redistHost, redisPort);

        properties.setProperty("db.url", connectURL);

        bridge(locator, Guice.createInjector(new Models("development", properties), new AbstractModule() {
            @Override
            protected void configure() {
                bind(ServiceLocator.class).toInstance(locator);
            }
        }));

        property(org.glassfish.jersey.server.ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, true);
        packages("com.thoughtworks.api.web");
        register(RoutesFeature.class);
        register(LoggingFilter.class);
        register(CORSResponseFilter.class);
        register(OpenSessionInViewRequestFilter.class);
        register(OpenSessionInViewResponseFilter.class);
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(com.thoughtworks.api.infrastructure.repositories.ProductRepository.class).to(ProductRepository.class);
                bind(com.thoughtworks.api.infrastructure.repositories.UserRepository.class).to(UserRepository.class);
                bind(com.thoughtworks.api.infrastructure.repositories.OrderRepository.class).to(OrderRepository.class);
                bind(DefaultEncryptionService.class).to(EncryptionService.class);
            }
        });
    }

    private void bridge(ServiceLocator serviceLocator, Injector injector) {
        getGuiceBridge().initializeGuiceBridge(serviceLocator);
        serviceLocator.getService(GuiceIntoHK2Bridge.class).bridgeGuiceInjector(injector);
    }

}
