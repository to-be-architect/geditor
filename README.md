# geditor

![](https://upload-images.jianshu.io/upload_images/1233356-291b99a56abf3f9c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


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




---
# Kotlin 开发者社区

![](https://upload-images.jianshu.io/upload_images/1233356-4cc10b922a41aa80?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


国内第一Kotlin 开发者社区公众号，主要分享、交流 Kotlin 编程语言、Spring Boot、Android、React.js/Node.js、函数式编程、编程思想等相关主题。

越是喧嚣的世界，越需要宁静的思考。