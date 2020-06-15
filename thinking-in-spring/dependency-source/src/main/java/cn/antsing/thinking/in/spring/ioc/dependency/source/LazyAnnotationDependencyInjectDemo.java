package cn.antsing.thinking.in.spring.ioc.dependency.source;

import cn.antsing.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
  *
  *   <br>
  *
  * @author <a href="mailto:ansatsing@gmail.com">antsing</a> <br>
  * 创建时间: 2020/5/24 12:52 下午 <br>
  *
  * @since
  */
public class LazyAnnotationDependencyInjectDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(LazyAnnotationDependencyInjectDemo.class);
        ObjectProvider bean = applicationContext.getBeanProvider(User.class);
        bean.forEach(System.out::println);
        User user = applicationContext.getBean(User.class);
        System.out.println(user);

    }
    @Autowired
    private ObjectProvider<User> objectProvider;
    @Bean
    @Primary
    public User user1(){
        return User.createUser(1,"syq");
    }

    @Bean
    public User user2(){
        return User.createUser(2,"syq2");
    }
}
