package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages="springboot.blog.*")//指定要扫描的包
@EnableJpaRepositories(basePackages="springboot.blog.repository")
@EntityScan(basePackages="springboot.blog.*")
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
    /**
     报错：
     org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'userController':
     Unsatisfied dependency expressed through field 'userRepository'; nested exception is org.springframework.beans.factory.
     BeanCreationException: Error creating bean with name 'userRepository': Invocation of init method failed;
     nested exception is java.lang.IllegalArgumentException: Not a managed type: class com.etc.domain.User
     解决办法：
     在启动类Application.java类上添加注解:@EntityScan(basePackages="com.etc.*")
     */
    /**
     报错：
     Description:
     Field userRepository in com.etc.controller.UserController required a bean of type 'com.etc.domain.UserRepository' that could not be found.
     Action:
     Consider defining a bean of type 'com.etc.domain.UserRepository' in your configuration.
     解决办法：
     在启动类Application.java类上添加注解:@EnableJpaRepositories(basePackages="com.etc.*")
     */

}
