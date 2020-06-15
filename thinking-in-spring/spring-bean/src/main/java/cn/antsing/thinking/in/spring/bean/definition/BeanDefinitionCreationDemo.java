package cn.antsing.thinking.in.spring.bean.definition;

import cn.antsing.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.*;

/**
  *
  *   {@link org.springframework.beans.factory.config.BeanDefinition}创建例子<br>
  *
  * @author <a href="mailto:ansatsing@gmail.com">antsing</a> <br>
  * 创建时间: 2020.04.30 14:11:36 <br>
  *
  */
public class BeanDefinitionCreationDemo {
     public static void main(String[] args) throws InterruptedException {
         User user = null;
         BeanDefinitionBuilder beanDefinitionBuilder = genericBeanDefinition(User.class);
         Thread.sleep(1);
     }
}
