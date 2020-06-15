package cn.antsing.thinking.in.spring.bean.definition;

import cn.antsing.thinking.in.spring.bean.factory.DefaultUserFactory;
import cn.antsing.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
  *
  *   Bean垃圾回收[GC]Demo<br>
  *     1，必须容器关闭
  *     2，强制GC
  * @author <a href="mailto:ansatsing@gmail.com">antsing</a> <br>
  * 创建时间: 2020.05.07 09:12:05 <br>
  *
  * @since
  */
@Configuration
public class BeanGarbageCollectionDemo {
     public static void main(String[] args) throws InterruptedException {
         AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanGarbageCollectionDemo.class);

         //GenericApplicationContext does not support multiple refresh attempts: just call 'refresh' once
         //applicationContext.refresh();


         applicationContext.close();


         //强制GC
         System.gc();

         //不加这行代码没有演示效果
         TimeUnit.SECONDS.sleep(3);
     }

     @Bean
     public UserFactory userFactory(){
         return new DefaultUserFactory();
     }
}
