package cn.antsing.thinking.in.spring.ioc.overview.container;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
  *
  * {@link org.springframework.beans.factory.BeanFactory}作为IoC容器例子 <br>
  *
  * @author <a href="mailto:ansatsing@gmail.com">antsing</a> <br>
  * 创建时间: 2020.04.30 10:30:58 <br>
  *
  */
public class BeanFactoryAsIoCContainerDemo {
     public static void main(String[] args) {
         //创建BeanFactory容器
         DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

         //创建xml文件资源读取器
         XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

         //加载BeanDefinition
         String location = "classpath:/META-INF/dependency-lookup-context.xml";
         int beanDefinitionsCount = reader.loadBeanDefinitions(location);
         System.out.println("BeanDefinition加载数量："+beanDefinitionsCount);

     }
}
