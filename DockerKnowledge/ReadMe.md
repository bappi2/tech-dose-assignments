docker run --name mySql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=my_secret_pw -d 
-v mysqldata:/var/lib/mysql mysql:latest