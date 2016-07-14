package com.thoughtworks.api.web;

//@RunWith(ApiTestRunner.class)
//public class UsersApiTestExample extends ApiSupport {
//    @Inject
//    UserRepositoryExample userRepository;
//
//    @Test
//    public void should_import_user_success() throws Exception {
//        Map<String, Object> userInfo = new HashMap<String, Object>() {{
//            put("id", "123");
//            put("email", "scxu@thoughtworks.com");
//            put("name", "scxu");
//            put("role", "DEV");
//            put("password", "123");
//        }};
//
//        final Response post = post("/users", userInfo);
//        assertThat(post.getStatus(), is(201));
//    }
//
//    @Test
//    public void should_400_if_id_not_valid() throws Exception {
//        Map<String, Object> userInfo = new HashMap<String, Object>() {{
//            put("email", "scxu@thoughtworks.com");
//            put("name", "Xu Shanchuan");
//            put("role", "Dev");
//        }};
//
//        final Response post = post("/users", userInfo);
//        assertThat(post.getStatus(), is(400));
//    }
//
//    @Test
//    public void should_400_if_email_not_valid() throws Exception {
//        Map<String, Object> userInfo = new HashMap<String, Object>() {{
//            put("id", "123");
//            put("name", "Xu Shanchuan");
//            put("role", "Dev");
//        }};
//
//        final Response post = post("/users", userInfo);
//        assertThat(post.getStatus(), is(400));
//    }
//
//    @Test
//    public void should_400_when_create_user_if_user_exist() throws Exception {
//        final UserExample user = TestHelper.userForTest("123", "scxu", UserRole.DEV);
//        userRepository.save(user);
//
//        Map<String, Object> userInfo = new HashMap<String, Object>() {{
//            put("id", "123");
//            put("name", "scxu");
//            put("email", "scxu@tw.com");
//            put("role", "Dev");
//        }};
//
//        final Response post = post("/users", userInfo);
//        assertThat(post.getStatus(), is(400));
//    }
//
//    @Test
//    public void should_get_user_by_id() throws Exception {
//        final UserExample user = TestHelper.userForTest("123", "scxu", UserRole.DEV);
//        userRepository.save(user);
//
//        final Response response = get("/users/" + user.getUserId().id());
//        assertThat(response.getStatus(), is(200));
//        final Map userMap = response.readEntity(Map.class);
//        assertThat(userMap.get("id"), is(user.getUserId().id()));
//        assertThat(userMap.get("name"), is(user.getName()));
//        assertThat(userMap.get("email"), is(user.getEmail()));
//        List urls = (List) userMap.get("links");
//        assertThat(urls.size(), is(1));
//        assertThat(canFindLink(urls, "self", "/users/123"), is(true));
//    }
//
//    @Test
//    public void should_404_if_user_not_exist() throws Exception {
//        final Response response = get("/users/abc");
//        assertThat(response.getStatus(), is(404));
//    }
//}
