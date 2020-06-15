package cn.antsing.thinking.in.spring.bean.definition;

import cn.antsing.thinking.in.spring.bean.factory.DefaultUserFactory;
import cn.antsing.thinking.in.spring.bean.factory.UserFactory;
import cn.antsing.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.util.StringUtils;

import java.util.Iterator;
import java.util.ServiceLoader;

import static java.util.ServiceLoader.load;
import static org.springframework.beans.factory.support.BeanDefinitionBuilder.*;

/**
  *
  *   Bean实例化的特殊方式Demo<br>
  *      1,ServiceLoaderFactoryBean
  *         -ServiceLoader
  *             -jdk1.6加入的功能
 *              -具有去重功能
 *       2,AutowireCapableBeanFactory#createBean(Class,int,boolean)
 *          -其创建的bean是不在spring容器里的
 *       3，BeanDefinitionRegistry#registerBeanDefinition(String,BeanDefinition)
  *
  * @author <a href="mailto:ansatsing@gmail.com">antsing</a> <br>
  * 创建时间: 2020.05.06 09:14:06 <br>
  *
  * @since
  */
public class SpecialBeanInstantiationDemo {
     public static void main(String[] args) {
         //无法转换
         //AutowireCapableBeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-instantiation-context.xml");

         ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-instantiation-context.xml");

         // 其创建的bean是不受spirng容器控制的
         AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();

         //ServiceLoaderFactoryBean方式创建
         ServiceLoader<UserFactory> servieLoaderBean = beanFactory.getBean("servieLoaderBean", ServiceLoader.class);
         displayServiceLoader(servieLoaderBean);

         //AutowireCapableBeanFactory
         UserFactory userFactory = beanFactory.createBean(DefaultUserFactory.class);
         System.out.println(userFactory.createUser());


         //会报错：找不到bean
        // System.out.println(applicationContext.getBean(UserFactory.class));

            //为了能变成BeanDefinitionRegistry
         DefaultListableBeanFactory beanFactory1 = (DefaultListableBeanFactory) (applicationContext.getBeanFactory());
         //
         createBeanByBeanDefinitionRegistry(beanFactory1,"ssss");

         System.out.println("createBeanByBeanDefinitionRegistry："+applicationContext.getBean(User.class));

         // demoServiceLoader();
     }

     public static void demoServiceLoader(){
         ServiceLoader<UserFactory> load = load(UserFactory.class, Thread.currentThread().getContextClassLoader());
         displayServiceLoader(load);
     }

    private static void displayServiceLoader(ServiceLoader<UserFactory> load) {
        Iterator<UserFactory> iterator = load.iterator();
        while (iterator.hasNext()){
            UserFactory next = iterator.next();
            System.out.println(next.createUser());
        }
    }

    /**
     * AnnotationConfigApplicationContext 才行，而classpathxmlapplicationcontext不行
     * @param registry
     * @param beanName
     */
    public static void createBeanByBeanDefinitionRegistry(BeanDefinitionRegistry registry,String beanName){
        BeanDefinitionBuilder beanDefinitionBuilder = genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id",3L)
                                .addPropertyValue("name","dsfsd");

        if(StringUtils.hasText(beanName)){
            registry.registerBeanDefinition(beanName,beanDefinitionBuilder.getBeanDefinition());
        }else {
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(),registry);
        }
    }
}
