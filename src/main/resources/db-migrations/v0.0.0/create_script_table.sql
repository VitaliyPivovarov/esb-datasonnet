create table if not exists "script"
(
    id         bigserial primary key,
    name       varchar unique              not null,
    body       varchar                     not null,
    created_at timestamp without time zone not null
);

INSERT INTO script (name, body, created_at)
VALUES ('XML_TO_JSON',
        '/** DataSonnet
            version=2.0
            output application/json
            input payload application/xml
            */

            local log = [ x["$"] for x in payload["profiles"]["profile"]["logs"]["p"] ];

            {
                "name": payload["profiles"]["profile"]["@name"],
                "time": payload["profiles"]["profile"]["@time"],
                "logs": log
            }',
        now())