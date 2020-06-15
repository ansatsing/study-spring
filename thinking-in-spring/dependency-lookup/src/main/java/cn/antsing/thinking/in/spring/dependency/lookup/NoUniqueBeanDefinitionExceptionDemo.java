package cn.antsing.thinking.in.spring.dependency.lookup;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
  *
  *   {@link NoUniqueBeanDefinitionException} Demo<br>
  *
  * @author <a href="mailto:ansatsing@gmail.com">antsing</a> <br>
  * 创建时间: 2020.05.08 08:54:30 <br>
  *
  * @since
  */
public class NoUniqueBeanDefinitionExceptionDemo {
     public static void main(String[] args) {
         AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

         applicationContext.register(NoUniqueBeanDefinitionExceptionDemo.class);

         applicationContext.refresh();


         try {
             applicationContext.getBean(String.class);
         } catch (NoUniqueBeanDefinitionException e) {
            // e.printStackTrace();
             System.err.printf("Spring IOC容器存在%d个 有%s 类型的 Bean,具体原因：%s%n"
                     ,e.getNumberOfBeansFound()
                     ,String.class.getName()
                     ,e.getMessage());
         }


         applicationContext.close();
     }

     @Bean
     public String bean1(){
         return "bean1";
     }

    @Bean
    public String bean2(){
        return "bean2";
    }
}
