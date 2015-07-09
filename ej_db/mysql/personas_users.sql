# Grant privileges for user 'javaapp'@''
GRANT SELECT, INSERT, UPDATE, DELETE ON *.* TO 'javaapp'@'';

# Grant privileges for user 'root'@'localhost'
GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' WITH GRANT OPTION;

# Grant privileges for user ''@''
GRANT USAGE ON *.* TO ''@'';

