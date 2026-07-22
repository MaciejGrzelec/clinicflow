CREATE TABLE specializations
(
    id           UUID          NOT NULL,
    code         VARCHAR(50)   NOT NULL,
    name         VARCHAR(150)  NOT NULL,
    description  VARCHAR(1000),
    active       BOOLEAN       NOT NULL,

    created_at   TIMESTAMPTZ   NOT NULL,
    created_by   VARCHAR(100)  NOT NULL,
    modified_at  TIMESTAMPTZ   NOT NULL,
    modified_by  VARCHAR(100)  NOT NULL,

    CONSTRAINT pk_specializations
        PRIMARY KEY (id)
);