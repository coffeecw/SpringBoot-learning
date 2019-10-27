### Spring Boot
1. 简介
- 简化Spring应用开发的一个框架
- 整个Spring技术栈的一个大整合
- J2EE开发的一站式解决方案
2. 优点  
- 快速创建独立运行的Spring项目以及主流框架集成
- 使用嵌入式Tomcat，应用无需打成war包
- starters自动依赖与版本控制
- 大量的自动配置，简化开发，也可修改默认值
- 无需配置XML,无代码生成，开箱即用
- 准生产环境的运行时应用监控
- 与云计算的天然集成
3. 微服务  
2014 Martin fowler  
微服务:架构风格(服务微化)  
一个应用是一组小型服务，可以通过HTTP的方式互通  
每个功能元素最终都是一个可独立替换和独立升级的软件单元  
[微服务文档](https://martinfowler.com/microservices/)  
4. 环境准备  
- jdk1.8
- maven3.6
- IDEA 
- SpringBoot 2.1.6.RELEASE  
5. SpringBoot HelloWorld  
一个功能  
浏览器发送hello请求,服务器接收请求并处理，响应Hello World字符串 
> 1、创建maven工程(jar)  
> 2、导入SpringBoot相关的依赖  
> 3、编写一个主程序，启动SpringBoot应用  
> 4、编写相关的Controller,Service  
> 5、运行主程序测试  
> 6、简化部署
6. Hello World探究
### 1、pom文件  
```xml
父项目
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.1.6.RELEASE</version>
</parent>
他的父项目是
<parent>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-dependencies</artifactId>
<version>2.1.6.RELEASE</version>
<relativePath>../../spring-boot-dependencies<relativePath>
</parent>
他来真正管理Spring Boot应用里面的所有依赖版本
``` 
Spring Boot的版本仲裁中心:  
以后我们导入依赖默认是不需要写版本号:(没有在dependencies里面管理的依赖自然需要声明版本号)  

### 2、启动器 
```xml
 <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```  
spring-boot-starter:  Spring Boot场景启动器    

spring-boot-starter-web: 帮我们导入了web模块正常运行所依赖的组件

Spring Boot将所有的功能场景都抽取出来，做成一个个的starters(启动器)，只需要在项目里引入这些starter相关的场景的所有的依赖都会导入进来，要用什么功能就导入什么场景的启动器  
### 3、主程序类  
```java
//标注一个主程序类，说明这是一个Spring Boot应用
@SpringBootApplication
public class HelloWorldApplicationBoot {
    public static void main(String[] args) {
        //Spring Boot应用启动起来
SpringApplication.run.(HelloWorldApplicationBoot.class,args);
    }
}
```  
@SpringBootApplication: Spring Boot应用标注在某个类上，说明这个类是Spring Boot的主配置类，SpringBoot就应该运行这个类的main方法来启动Spring Boot应用.  
```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
    excludeFilters = {@Filter(
    type = FilterType.CUSTOM,
    classes = {TypeExcludeFilter.class}
), @Filter(
    type = FilterType.CUSTOM,
    classes = {AutoConfigurationExcludeFilter.class}
)}
)
```  
@**SpringBootConfiguration** :Spring Boot的配置类  
标注在某个类上，表示这是一个Spring Boot的配置类  
@**Configuration**: 配置类上标注这个注解  
配置类 --- 配置文件；配置类也是容器中的一个组件  

@**EnableAutoConfiguration**  开启自动配置功能  
```java
@AutoConfigurationPackage
@Import({AutoConfigurationImportSelector.class})
public @interface EnableAutoConfiguration {
```  
@**AutoConfigurationPackage** : 自动配置包  

@**Import**({AutoConfigurationImportSelector.class}) 

Spring的底层注解@Import,给容器中导入一个组件，导入的组件由AutoConfigurationImportSelector.class指定.  

将主配置类(@SpringBootConfiguration标注的类)的所在包及下面所有子包里面的所有组件扫描到Spring容器.  
@Import({AutoConfigurationImportSelector.class})： 给容器导入组件？

AutoConfigurationImportSelector：导入组件选择器

将所有需要导入的组件以及全类名的方式返回；这些组件将以字符串数组 String[] 添加到容器中；

会给容器非常多的自动配置类，（xxxAutoConfiguration）;就是给容器中导入这个场景需要的所有组件，并配置 好这些组件。  

Spring Boot在启动的时候从类路径下的META-INF/spring.factorys中获取的EnableAutoConfiguration指定的值；

将这些值作为自动配置类导入到容器中，自动配置就生效了。  

J2EE的整体解决方案
org\springframework\boot\spring-boot-autoconfigure\2.1.6.RELEASE\spring-boot-autoconfigure-2.1.6.RELEASE.jar  
6. 使用Spring Initializer创建一个快速向导    

1.IDE支持使用Spring Initializer

自己选择需要的组件:例如web

默认生成的SpringBoot项目

- 主程序已经生成好了，我们只需要完成我们的逻辑

- resources文件夹目录结构

> static:保存所有的静态文件；js css images

> templates:保存所有的模板页面；（Spring Boot默认jar包使用嵌入式的Tomcat,默认不支持JSP）；可以使用模板引擎(freemaker,thymeleaf).

- application.properties:Spring Boot的默认配置，例如 server.port=9000  

## 二、Spring Boot配置  

### 1. 配置文件  
SpringBoot使用一个全局的配置文件，配置文件名是固定的  
- application.properties
- application.yml  
配置文件的作用:修改SpringBoot自动配置的默认值;  
SpringBoot在底层都给我们自动配置好.  

YAML(YAML Ain't a Markup Language)  
YAML 的意思其实是："Yet Another Markup Language"（仍是一种标记语言）  
YAML:以数据为中心，比json、xml等更适合做配置文件    
#### yaml语法
1. 基本语法  
k:(空格)v:   表示一对键值对(空格必须有);  
以**空格的缩进**来控制层级关系，只要是左对齐的一列数据，都是同一个层级  
```yaml
server: 
    port: 8081
    path: /hello
```  
属性和值也是大小写敏感.  

2. 值的写法   
- 字面量:普通的值(数字,字符串,布尔)   
k: v: 字面量直接来写  
字符串默认不用加上单引号或双引号;  
"":双引号;不会转义字符里面的特殊字符;特殊字符会作为本身想表示的意思  
name: "zhangsan \n hi"  输出:zhangsan 换行 hi  
'':单引号;会转义特殊字符;特殊字符最终只是一个普通的字符串数据  
name: "zhangsan \n hi" 输出:zhangsan \n hi  
- 对象、Map(属性和值)(键值对)  
k: v: 在下一行来写对象的属性和值的关系,注意缩进  
对象还是k: v: 的方式  
```yaml
friends: 
    lastName: zhangsan
    age: 18
```
行内写法
```yaml
friends: {lastName: zhangsan,age: 18}
```
- 数组(List、Set)  
用- 值表示数组中的一个元素  
```yaml
pets: 
    - cat
    - dog
    - pig
```  
行内写法  
```yaml
pets: {cat,dog,pig}
```
3. 配置文件值注入  
```yaml
person:
  lastName: zhangsan
  age: 18
  boss: false
  birth: 2019/10/21
  maps: {k1: v1,k2: v2}
  lists:
    - lisi
    - wangwu
  dog:
    name: uzi
    age: 21
```
javaBean:  
```java
/**
 *将配置文件中配置的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties  告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定
 * prefix = "person"  配置文件中哪个下面的属性进行一一映射
 * 只有这个组件是容器中的组价，才能使用容器中提供的@ConfigurationProperties功能
 */
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    private String lastName;
    private Integer age;
    private Boolean boss;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;
```  
导入配置文件处理器  
```xml
  <!--导入配置文件处理器，配置文件绑定就会有提示-->
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-configuration-processor<artifacId>
<optional>true</optional>
</dependency>
```  
拓展:  
@Value获取值和@ConfigurationProperties获取值比较  
功能上:  
@Value---一个个指定  
@ConfigurationProperties---批量注入配置文件中的属性  
松散绑定:  
@Value---不支持  
@ConfigurationProperties---支持  
SpEL:  
@Value---支持  
@ConfigurationProperties---不支持   
JSR303数据校验:  
@Value---不支持  
@ConfigurationProperties---支持  
复杂类型封装:  
@Value---不支持  
@ConfigurationProperties---支持  
配置文件无论是yml还是properties都能获取到值  
如果说，我们只是在某个业务逻辑中需要获取一下配置文件中的某项值，使用@Value  
如果说，我们专门编写了一个javaBean来和配置文件进行映射，我们直接使用@ConfigurationProperties  

@PropertySource&@ImportResource  

@PropertySource:加载指定的配置文件; 
 ```java
@PropertySource("classpath:person.properties")
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    private String lastName;
    private Integer age;
    private Boolean boss;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;
 ```
@ImportResource:导入Spring的配置文件，让配置文件的内容生效  
Spring Boot里面没有Spring的配置文件，我们自己编写的配置文件，也不能自动识别;想让Spring Boot的配置文件生效，加载进来;@ImportResource  
```xml
@ImportResource(locations = {"classpath:beans.xml"})
导入Spring的配置文件让其生效
```  
不来编写Spring的配置文件  
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="helloService" class="cn.cwcoffee.springbootconfig.service.HelloService"></bean>
</beans>
```
SpringBoot推荐给容器中添加组件的方式; 推荐使用全注解的方式  
1、配置类----Spring的配置文件  
2、使用@Bean给容器中添加组件  
```java
/**
 * @Configuration  指明当前类是一个配置类，就是用来替代之前的Spring配置文件
 * 在配置文件中<bean></bean>标签添加组件
 */
@Configuration
public class MyConfig {
    //将方法的返回值添加到容器中，容器中这个组件默认的id就是方法名
    @Bean
    public HelloService helloService02(){
        System.out.println("给容器添加组件");
        return new HelloService();
    }
}
```  
4. 配置文件占位符  


5. profile  
1、多profile文件  
我们在主配置文件编写的时候，文件名可以是application-(profile).properties/yml  
默认使用application.properties  
2、yml支持多文档块的方式  
```yaml
server:
  port: 8081
spring:
  profiles:
    active: dev
---
server:
  port: 80
spring:
  profiles: prod
---
server:
  port: 8082
spring:
  profiles: dev  #指定属于哪个环境
```
3、激活指定的profile  
1、在配置文件中指定 spring.profiles.active=dev  
2、命令行的方式:java -jar springboot03-config-0.0.1-SNPASHOT.jar --spring.profiles.active=dev;可以在测试的时候配置传入命令行参数  
3、虚拟机参数: -Dspring.profiles.active=dev   

6. 配置文件的加载位置  
Spring Boot启动扫描以下位置的application.properties或者application.yml文件作为Spring Boot的默认配置文件  
- file:./config/
- file:./
- classpath:/config/
- classpath:/  
优先级由高到低，高优先级的配置会覆盖低优先级的配置;  
Spring Boot会从这四个位置全部加载主配置文件;互补配置  
我们还可以通过spring.config.location来改变默认的配置文件的位置    

项目打包好以后，可以用命令行参数的形式，启动项目的时候指定配置文件的新位置;指定配置文件和默认加载的这些配置文件共同起作用形成互补配置  
springboot03-config-0.0.1-SNPASHOT.jar --spring.config.location=路径  
7. 外部配置加载顺序  
SpringBoot也可以从以下位置加载配置;优先级从高到低;高优先级的会覆盖度优先级的配置，所有的配置会形成互补配置.  
1、命令行参数  
springboot03-config-0.0.1-SNPASHOT.jar --spring.config.location=路径 --server.context-path=/abc  
多个配置用空格分开； --配置项=值

2.来自java:comp/env的JNDI属性

3.Java系统属性（System.getProperties()）

4.操作系统环境变量

5.RandomValuePropertySource配置的random.*属性值

由jar包外向jar包内进行寻找；

优先加载带profile

6.jar包外部的application-{profile}.properties或application.yml(带spring.profile)配置文件

7.jar包内部的application-{profile}.properties或application.yml(带spring.profile)配置文件

再来加载不带profile

8.jar包外部的application.properties或application.yml(不带spring.profile)配置文件

9.jar包内部的application.properties或application.yml(不带spring.profile)配置文件

10.@Configuration注解类上的@PropertySource

11.通过SpringApplication.setDefaultProperties指定的默认属性

所有支持的配置加载来源；   
[官方参考文档](https://docs.spring.io/spring-boot/docs/2.1.9.RELEASE/reference/html/boot-features-external-config.html)  
