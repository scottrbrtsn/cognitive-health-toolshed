-- noinspection SqlNoDataSourceInspectionForFile
CREATE TABLE flow(
  id BIGSERIAL PRIMARY KEY,
  survey_name VARCHAR,
  user_name VARCHAR,
  fss1 INT,
  fss2 INT,
  fss3 INT,
  fss4 INT,
  fss5 INT,
  fss6 INT,
  fss7 INT,
  fss8 INT,
  fss9 INT,
  fss10 INT,
  fss11 INT,
  fss12 INT,
  fss13 INT,
  fssa INT,
  fssb INT,
  fssc INT,
  date_recorded TIMESTAMP
);

CREATE TABLE anxiety(
  id BIGSERIAL PRIMARY KEY,
  survey_name VARCHAR,
  user_name VARCHAR,
  gad1 INT,
  gad2 INT,
  gad3 INT,
  gad4 INT,
  gad5 INT,
  gad6 INT,
  gad7 INT,
  gad8 INT,
  date_recorded TIMESTAMP
);

CREATE TABLE depression(
  id BIGSERIAL PRIMARY KEY,
  survey_name VARCHAR,
  user_name VARCHAR,
  phq1 INT,
  phq2 INT,
  phq3 INT,
  phq4 INT,
  phq5 INT,
  phq6 INT,
  phq7 INT,
  phq8 INT,
  phq9 INT,
  phq10 INT,
  date_recorded TIMESTAMP
);

CREATE TABLE mindfulness(
  id BIGSERIAL PRIMARY KEY,
  survey_name VARCHAR,
  user_name VARCHAR,
  opened INT,
  body INT,
  returned INT,
  appreciate INT,
  intentions INT,
  nonjudgement INT,
  connected INT,
  acceptance INT,
  friendly INT,
  watchful INT,
  pause INT,
  peace INT,
  patient INT,
  smile INT,
  date_recorded TIMESTAMP
);

CREATE TABLE personality(
  id BIGSERIAL PRIMARY KEY,
  survey_name VARCHAR,
  user_name VARCHAR,
  bfi1 INT,
  bfi2 INT,
  bfi3 INT,
  bfi4 INT,
  bfi5 INT,
  bfi6 INT,
  bfi7 INT,
  bfi8 INT,
  bfi9 INT,
  bfi10 INT,
  date_recorded TIMESTAMP
);

CREATE TABLE user_info(
  id INT NOT NULL,
  name VARCHAR,
  location VARCHAR,
  ip VARCHAR,
  host VARCHAR,
  usr VARCHAR
);

