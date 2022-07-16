# Example hibernate project

1. install portable PostgreSQL by instruction: https://github.com/malexple/postgresql-portable

2. create database:

   ```sql
   CREATE TABLE Person (
      id int PRIMARY KEY,
      name varchar(100),
      age int
   )
   ```

3. add test row:

   ```sql
   INSERT INTO person(id, name, age) VALUES(1, 'Test person', 20);
   ```

4. mvn clean compile package
5. run app