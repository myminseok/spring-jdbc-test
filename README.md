
## how to build



```
 git clone https://github.com/myminseok/spring-cloud-cloudfoundry-connector-extend
 gradle clean assemble
```
## how to use (for example with spring music)

1 install to local maven repo
```
mvn install:install-file  -Dfile=build/libs/spring-cloud-cloudfoundry-connector-extend-1.0.0.BUILD-SNAPSHOT.jar -DgroupId=org.springframework.cloud -DartifactId=spring-cloud-cloudfoundry-connector-extend -Dversion=1.0.0.BUILD-SNAPSHOT -Dpackaging=jar
```

2 clone this repo 
```
git clone https://github.com/myminseok/spring-jdbc-test
```

3 add dependency to your build.gradle
```
  dependencies {
    compile "org.springframework.cloud:spring-cloud-cloudfoundry-connector-extend:1.0.0.BUILD-SNAPSHOT"
  
  or

  <dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-cloudfoundry-connector-extend</artifactId>
	<version>1.0.0.BUILD-SNAPSHOT</version>
</dependency>

```

4 create a user-provided Maridb database service instance
```
$ cf create-user-provided-service mymariadb -p '{"uri":"mariadb://root:secret@dbserver.example.com:3306/mydatabase"}'
```

5 edit your manifest.yml
```
---
applications:
- name: spring-jdbc-test
  memory:  512M
  instances: 1
  host: spring-jdbc-test
  path: target/spring-jdbc-test-0.0.1-SNAPSHOT.jar
  services:
  - mymariadb

```

6 push to cloud foundry
```
cf push -f manifest.yml
```
7. test
```
empty in user table.
curl http://spring-jdbc-test.apps.pcfdemo.net/

add new record
curl http://spring-jdbc-test.apps.pcfdemo.net/newrecord -X POST

restart app
cf restart spring-jdbc-test

now ther is new record in table
curl http://spring-jdbc-test.apps.pcfdemo.net/
[{"id":1,"name":"new"}]

```

## reference:
* http://cloud.spring.io/spring-cloud-connectors/spring-cloud-connectors.html
* https://github.com/spring-cloud/spring-cloud-connectors
* https://github.com/cloudfoundry-samples/spring-music
