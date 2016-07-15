CREATE TABLE products (
  id VARCHAR(255) PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL,
  price FLOAT NOT NULL,
  rating INT
);

CREATE TABLE users (
  id VARCHAR(255) PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE orders (
  id VARCHAR(255) PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL,
  phone VARCHAR(255) NOT NULL,
  date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  user_id VARCHAR(255) NOT NULL,

  FOREIGN KEY (user_id)
    REFERENCES users(id)
);

CREATE TABLE order_items (
  id VARCHAR(255) PRIMARY KEY,
  quantity INT NOT NULL ,
  order_id VARCHAR(255) NOT NULL,
  product_id VARCHAR(255) NOT NULL,

  FOREIGN KEY (order_id)
    REFERENCES orders(id),

  FOREIGN KEY (product_id)
    REFERENCES products(id)
)


# CREATE TABLE users (
#   id VARCHAR(255) PRIMARY KEY,
#   name VARCHAR(255) NOT NULL,
#   email VARCHAR(255) NOT NULL,
#   role VARCHAR(255),
#   password varchar(255)
# );
#
# insert into users (id, name, email, role, password) values ("001", "admin", "admin@example.com", "BACKGROUND_JOB", "$2a$04$DbgJbGA4dkQSzAvXvJcGBOv5kHuMBzrWfne3x3Cx4JQv4IJcxtBIW");
