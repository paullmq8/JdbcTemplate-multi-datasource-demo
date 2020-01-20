#mysql
CREATE TABLE USER (
    ID BIGINT PRIMARY KEY AUTO_INCREMENT,
    USERNAME VARCHAR(100) NOT NULL,
    ADDRESS VARCHAR(1000)
);

#postgresql
-- auto-generated definition
CREATE TABLE user_profile
(
  id                 BIGINT       NOT NULL
    CONSTRAINT user_profile_pkey
    PRIMARY KEY
    CONSTRAINT user_profile_id_fkey
    REFERENCES account
    ON DELETE CASCADE,
  name               VARCHAR(126) NOT NULL
    CONSTRAINT user_profile_name_key
    UNIQUE,
  display_name       VARCHAR(126) NOT NULL,
  description        VARCHAR(10000),
  profile_picture    VARCHAR(2000),
  background_picture VARCHAR(2000),
  first_name         VARCHAR(126),
  last_name          VARCHAR(126),
  address            VARCHAR(126),
  gender_id          INTEGER
    CONSTRAINT user_profile_gender_id_fkey
    REFERENCES gender
    ON DELETE CASCADE,
  birthday           DATE                     DEFAULT '1970-01-01' :: DATE,
  disabled           BOOLEAN                  DEFAULT FALSE,
  last_modified      TIMESTAMP WITH TIME ZONE DEFAULT now(),
  created            TIMESTAMP WITH TIME ZONE DEFAULT now(),
  website            VARCHAR(2000),
  customer_id        BIGINT
);
