-- CREATE TABLE VirtualObject
-- (
--     id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--     name varchar(100)
-- )

-- CREATE TABLE VirtualField
-- (
--     id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--     virtual_object_id int REFERENCES virtualobject(Id) ON DELETE SET NULL,
--     fieldName varchar(256),
--     dataType varchar(100),
--     indexed bool,
--     fieldNum int check (fieldNum < 10)
-- )

-- drop table VirtualField;

-- CREATE TABLE VirtualData
-- (
--     id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--     virtual_object_id int REFERENCES virtualobject(Id) ON DELETE SET NULL,
--     name varchar(100),
--     value0 varchar(256),
--     value1 varchar(256),
--     value2 varchar(256),
--     value3 varchar(256),
--     value4 varchar(256),
--     value5 varchar(256),
--     value6 varchar(256),
--     value7 varchar(256),
--     value8 varchar(256),
--     value9 varchar(256)
-- )