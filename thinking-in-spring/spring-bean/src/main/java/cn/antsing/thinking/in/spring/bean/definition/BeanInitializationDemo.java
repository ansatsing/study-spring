package cn.antsing.thinking.in.spring.bean.definition;

import cn.antsing.thinking.in.spring.bean.factory.DefaultUserFactory;
import cn.antsing.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
  *
  *   Bean的初始化Demo<br>
  *       1,@PostConstruct
  *       2,实现接口InitializingBean的afterPropertiesSet()方法
  *       3，自定义方法
  *         3.1,xml配置：<bean init-method="init" .../>
  *         3.2,java注解:@Bean(initMethod="init")
  *         3.3,java API:AbstractBeanDefinition#setInitMethodName(String)
 *
 *        注意顺序：1-》2-》3
  *
  * @author <a href="mailto:ansatsing@gmail.com">antsing</a> <br>
  * 创建时间: 2020.05.06 15:59:43 <br>
  *
  * @since
  */
@Configuration
public class BeanInitializationDemo {
     public static void main(String[] args) {
         AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
         applicationContext.register(BeanInitializationDemo.class);

         applicationContext.refresh();

         applicationContext.close();
     }

     @Bean(initMethod = "init")
     public UserFactory userFactory(){
         return new DefaultUserFactory();
     }
}
