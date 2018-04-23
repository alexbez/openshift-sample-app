DROP TABLE IF EXISTS account;

BEGIN;

CREATE TABLE account (id serial PRIMARY KEY, ac_number varchar);

INSERT INTO account (ac_number) VALUES ('AAA-3874728');
INSERT INTO account (ac_number) VALUES ('AAA-1545743');
INSERT INTO account (ac_number) VALUES ('AAA-0302342');
INSERT INTO account (ac_number) VALUES ('BBB-2942343');
INSERT INTO account (ac_number) VALUES ('BBB-2742343');
INSERT INTO account (ac_number) VALUES ('BBB-8348754');
INSERT INTO account (ac_number) VALUES ('CCC-4974573');
INSERT INTO account (ac_number) VALUES ('CCC-0587547');
INSERT INTO account (ac_number) VALUES ('CCC-2843689');
INSERT INTO account (ac_number) VALUES ('DDD-3034333');
INSERT INTO account (ac_number) VALUES ('DDD-4343822');
INSERT INTO account (ac_number) VALUES ('DDD-7834267');
INSERT INTO account (ac_number) VALUES ('EEE-5804289');
INSERT INTO account (ac_number) VALUES ('EEE-1089438');
INSERT INTO account (ac_number) VALUES ('EEE-5562367');

COMMIT;
