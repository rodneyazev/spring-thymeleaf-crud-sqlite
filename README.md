# Spring Thymeleaf Crud SQLite

mvn clean package

docker build -t rdnazev/spring-app .

docker login

docker push rdnazev/spring-app

docker run -d -p "8085:8085" rdnazev/spring-app .
