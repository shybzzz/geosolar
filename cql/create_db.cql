CREATE KEYSPACE IF NOT EXISTS geosolar
 WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '3'}
   AND durable_writes = true;

  CREATE TABLE IF NOT EXISTS geosolar.dst (
      yy int,
      mo int,
      da int,
      hh int,
      value double,
      PRIMARY KEY ((yy, mo, da, hh))
  );

  CREATE TABLE IF NOT EXISTS geosolar.interplanetary_magnetic_field_values (
        YR int,
        MO int,
        DA int,
        HHMM int,
        Bz double,
        PRIMARY KEY ((YR, MO, DA, HHMM))
    );