# springboot-jpa
### spring－boot整合JPA
#### 1.创建springboot项目
- IDEA选择spring initializer
- 项目类型选择Web
- pom依赖添加:web jpa mysql

#### 2.配置数据源
- 此处url如果写错，比如mysql后冒号缺失，会出现以下错误：
---
org.springframework.jdbc.support.MetaDataAccessException: Could not get Connection for extracting meta data; nested exception is org.springframework.jdbc.CannotGetJdbcConnectionException: Could not get JDBC Connection; nested exception is java.sql.SQLException: Driver:com.mysql.jdbc.Driver@ac20bb4 returned null for URL:jdbc:mysq://localhost:3306/test?useUnicode=true&characterEncoding=utf8&characterSetResults=utf8

---

org.springframework.beans.factory.BeanCreationException: Error creating bean with name '**entityManagerFactory**' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaAutoConfiguration.class]: Invocation of init method failed; nested exception is org.hibernate.service.spi.ServiceException: Unable to create requested service [org.hibernate.engine.jdbc.env.spi.JdbcEnvironment]

>插入一条数据库纪录：
INSERT INTO(大写) user(username,password) VALUES('zc','123')

#### 3.创建实体对象
- @Entity注解需要使用javax.persistance.x;非org.hibernate.anotation;
- setter/getter可使用lombok，需要在pom添加依赖

#### 4.依次创建DAO／Service

#### 5.创建Controller
- @GetMapping("/{username}") @PathVariable("username")配合从RESTful风格URL中
获取username
> 例如http://localhost:8080/user/zc　,从该URL中提取zc赋值到username
	
