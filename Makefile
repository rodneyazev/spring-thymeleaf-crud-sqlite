package:
	@ mvn clean package;
docker-image-build: package
	@ docker build -t rdnazev/spring-app . ;
run: docker-image-build
	@ docker-compose up -d ;
stop:
	@ docker-compose down -v ;
