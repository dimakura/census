CREATE TABLE surveys (
  id SERIAL PRIMARY KEY,
  status VARCHAR(20) NOT NULL,
  slug VARCHAR(50) NOT NULL,
  name VARCHAR(50) NOT NULL,
  description TEXT
);

INSERT INTO surveys (id, status, slug, name)
VALUES (1, 'draft', 'test-survey', 'Test Survey');
