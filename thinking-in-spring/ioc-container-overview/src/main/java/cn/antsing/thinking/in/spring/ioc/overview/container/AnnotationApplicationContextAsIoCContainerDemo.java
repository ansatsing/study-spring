package cn.antsing.thinking.in.spring.ioc.overview.container;

import cn.antsing.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
  *
  *   <br>
  *                
  * @author <a href="mailto:ansatsing@gmail.com">antsing</a> <br>
  * 创建时间: 2020.04.30 10:40:25 <br>
  *
  */
@Configuration
public class AnnotationApplicationContextAsIoCContainerDemo {

     public static void main(String[] args) {
         //create BeanFactory container
         AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
         //将当前类作为配置类
         applicationContext.register(AnnotationConfigApplicationContext.class);

         //启动容器
         applicationContext.refresh();

         int beanDefinitionCount = applicationContext.getBeanDefinitionCount();
         System.out.println("BeanDefinition加载数量："+beanDefinitionCount);

         applicationContext.close();

     }

     @Bean
    public User user(){
         User user = new User();
         user.setId(2L);
         user.setName("ansatsing");
         return user;
     }

}
