# geditor

## Introduction

A Graph Editor implementing by Spring Boot, Kotlin, Java, based on [jgraphx](https://github.com/jgraph/jgraphx).

## Quick Start

### Environment requirements

``` 
Java 8
Maven 3
```

### Configuration

``` 
server:
  port: 9999

management:
  endpoints:
    web:
      exposure:
        include: "*"

spring:
  groovy:
    template:
      suffix: .groovy
      cache: false
      configuration:
        auto-new-line: true
        auto-indent: true
```

Step 1 Clone Code
```
git clone https://github.com/to-be-architect/geditor
```

Step 2 Run Application
``` 
mvn spring-boot:run
```

Step 3 Visit geditor

http://localhost:9999/

