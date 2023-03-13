create table if not exists "endpoint"
(
    id         bigserial primary key,
    name       varchar unique              not null,
    created_at timestamp without time zone not null
);

INSERT INTO endpoint(name, created_at)
VALUES ('endpoint', now());