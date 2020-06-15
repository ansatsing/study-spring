package cn.antsing.thinking.in.spring.ioc.overview.container;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
  *
  *   AutowireCapableBeanFactory例子<br>
  *
  * @author <a href="mailto:ansatsing@gmail.com">antsing</a> <br>
  * 创建时间: 2020.05.06 13:29:45 <br>
  *
  * @since
  */
 @Configuration
public class AutowireCapableBeanFactoryDemo {
     public static void main(String[] args) {
         ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutowireCapableBeanFactoryDemo.class);

         AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();

         HelloController helloController = (HelloController) autowireCapableBeanFactory.createBean(HelloController.class,AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE,false);

         //得到期望的运行效果说明Bean创建成功的同时其依赖helloService也注入成功。
         helloController.getHelloService().hello("[autowire capable beanFactory]");

         //抛出异常：
         //Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException:
         // No qualifying bean of type 'cn.antsing.thinking.in.spring.ioc.overview.container.AutowireCapableBeanFactoryDemo$HelloController' available
         //说明通过autowireCapableBeanFactory创建的Bean没有交给spring容器管理。
         HelloController helloController0 = applicationContext.getBean(HelloController.class);
     }

     class HelloService{
         public void hello(String str){
             System.out.println("print string:"+str);
         }
     }
     class HelloController{
         private HelloService helloService;

         public HelloService getHelloService() {
             return helloService;
         }

         //一定要set方法，否则无法自动装配helloService
         public void setHelloService(HelloService helloService) {
             this.helloService = helloService;
         }
     }
     @Bean
     public HelloService helloService(){
         return new HelloService();
     }
}
