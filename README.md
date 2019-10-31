#### Build the project

```
gradle clean build
```

#### Run the project:

```
./gradlew build
```
```
./gradlew bootRun
```

Access http://localhost:8080

Or you can simply run:

```
java -jar ./build/libs/microservice-0.0.1-SNAPSHOT.jar
```

By default the application uses embedded in-memory database H2. So you don't need to setup anything else for it.
In order to use PostgreSQL create a database sampledb.
It's assumed that it has postgres/postgres credentials. Otherwise, correct the configuration in application-prod.yml.

Then run the application as described above but with _-Dspring.profiles.active=production_ option. 
It will create automatically all necessary tables and data.
 

