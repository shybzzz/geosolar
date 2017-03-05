CREATE KEYSPACE IF NOT EXISTS
    geosolar
    WITH
        replication = {'class': 'SimpleStrategy', 'replication_factor': '3'} AND
        durable_writes = true;

CREATE TABLE IF NOT EXISTS
    geosolar.dst (
       id       uuid        PRIMARY KEY,
       yy       int,
       mo       int,
       da       int,
       hh       int,
       value    double
    );

CREATE TABLE IF NOT EXISTS
    geosolar.interplanetary_magnetic_field_values (
       id       uuid        PRIMARY KEY,
       YR       int,
       MO       int,
       DA       int,
       HHMM     int,
       Bz       double
    );