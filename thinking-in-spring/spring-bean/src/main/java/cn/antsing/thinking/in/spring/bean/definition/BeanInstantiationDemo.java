package cn.antsing.thinking.in.spring.bean.definition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
  *
  *   Bean实例化<br>
  *
  * @author <a href="mailto:ansatsing@gmail.com">antsing</a> <br>
  * 创建时间: 2020.04.30 16:36:23 <br>
  *
  * @since
  */
public class BeanInstantiationDemo {
     public static void main(String[] args) {
         BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-instantiation-context.xml");
     }
}
