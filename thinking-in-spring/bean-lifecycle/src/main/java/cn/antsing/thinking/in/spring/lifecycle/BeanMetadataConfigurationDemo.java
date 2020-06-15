package cn.antsing.thinking.in.spring.lifecycle;

import cn.antsing.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
  *
  *   bean meta data configuration demo
  *
  * @author <a href="mailto:ansatsing@gmail.com">antsing</a> <br>
  * creationtime: 2020/6/15 3:30 PM <br>
  *
  * @since
  */
public class BeanMetadataConfigurationDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertiesBeanDefinitionReader propertiesReader = new PropertiesBeanDefinitionReader(beanFactory);

        //the default encode of properties file  is iso-8859-1,but current encode is utf-8,so messy code will appear
        // if not does like below.
        String file = "META-INF/user.properties";
        Resource resource = new ClassPathResource(file);
        EncodedResource encodedResource = new EncodedResource(resource,"UTF-8");


        //propertiesReader.loadBeanDefinitions(resource); //will appear messy code
        propertiesReader.loadBeanDefinitions(encodedResource);//will not appear messy code

        User user = beanFactory.getBean(User.class);
        System.out.println(user);
    }
}
