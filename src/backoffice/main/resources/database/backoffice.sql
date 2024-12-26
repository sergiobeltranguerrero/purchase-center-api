CREATE TABLE IF NOT EXISTS inscriptions
(
    id            CHAR(36) NOT NULL,
    name          TEXT     NOT NULL,
    price         DOUBLE   NOT NULL,
    member_number INT      NOT NULL,
    is_double     BOOLEAN  NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;