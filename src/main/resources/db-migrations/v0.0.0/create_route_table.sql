create table if not exists "route"
(
    id         bigserial primary key,
    name       varchar unique              not null,
    created_at timestamp without time zone not null
);

INSERT INTO route(name, created_at)
VALUES ('inputRoute', now());