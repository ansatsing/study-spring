package cn.antsing.thinking.in.spring.ioc.dependency.source;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
  *
  *   基于XML资源的Setter依赖注入方式Demo<br>
  *
  * @author <a href="mailto:ansatsing@gmail.com">antsing</a> <br>
  * 创建时间: 2020.05.11 08:54:59 <br>
  *
  * @since
  */
public class XmlDependencySetterInjectionDemo {
     public static void main(String[] args) {
         DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

         XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

         String xmlResourcePath = "classpath:/META-INF/dependency-setter-injection.xml";
         beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

     }
}
