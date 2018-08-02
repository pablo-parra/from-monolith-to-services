CREATE SEQUENCE public.SEQ_PURCHASE START 1;

CREATE TABLE Purchase (
  id BIGINT DEFAULT nextval('SEQ_PURCHASE') NOT NULL PRIMARY KEY,
  article_id BIGINT NOT NULL,
  amount INTEGER NOT NULL,
  date_of_purchase timestamp NOT NULL,
  user_name VARCHAR (100) NOT NULL
);