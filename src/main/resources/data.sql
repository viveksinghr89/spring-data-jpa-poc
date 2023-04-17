create table block(block_pk numeric(19,0) identity, version int null, quantity numeric(10,0) not null);

create table allocation(allocation_pk numeric(19,0) identity, version int null, block_pk numeric(19,0) not null, quantity numeric(10,0) not null);
ALTER TABLE allocation ADD FOREIGN KEY (block_pk)
    REFERENCES block(block_pk)

create table booking(booking_pk numeric(19,0) identity, version int null, block_pk numeric(19,0) not null);

INSERT INTO block (version, quantity) values (1, 400000);
INSERT INTO block (version, quantity) values (1, 600000);
INSERT INTO block (version, quantity) values (1, 800000);

INSERT INTO allocation (version, quantity) values (1, 200000);
INSERT INTO allocation (version, quantity) values (1, 300000);
INSERT INTO allocation (version, quantity) values (1, 400000);