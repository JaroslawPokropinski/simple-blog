DROP TABLE IF EXISTS post;

CREATE TABLE post (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(250) DEFAULT NULL,
  description VARCHAR(250) DEFAULT NULL,
  image VARCHAR(250) DEFAULT NULL
);

INSERT INTO
  post (title, description, image)
VALUES
  ('title1', 'description', NULL),
  ('title2', 'description', NULL),
  ('title3', 'description', NULL);