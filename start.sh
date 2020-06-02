#!/bin/sh
export SQL_HOST=mssqlser01.database.windows.net
export SQL_PORT=1433
export SQL_DBNAME=AdventureWorksLT
export SQL_USERNAME=nachalnikadm
export SQL_PASSWORD=

echo '==================='
echo 'Running : java ' '-jar aw-server.jar'
echo '==================='
exec java -jar aw-server.jar
