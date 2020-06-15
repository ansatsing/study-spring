package cn.antsing.thinking.in.spring.ioc.dependency.source;

import cn.antsing.thinking.in.spring.ioc.dependency.source.external.bean.ExternalBean;
import cn.antsing.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
  *
  *   ResolvableDependency 作为依赖来源<br>
  *
  * @author <a href="mailto:ansatsing@gmail.com">antsing</a> <br>
  * 创建时间: 2020/5/30 4:52 下午 <br>
  *
  * @since
  */
public class ResolvableDependencySourceDemo {
    @Resource
    String value;
    @PostConstruct
    public void init(){
        System.out.println("=========="+value);
    }
    //value无法自动注入
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//        applicationContext.register(ResolvableDependencySourceDemo.class);
//        applicationContext.refresh();
//        DefaultListableBeanFactory defaultListableBeanFactory = applicationContext.getDefaultListableBeanFactory();
//        if(defaultListableBeanFactory instanceof ConfigurableListableBeanFactory){
//            ConfigurableListableBeanFactory configurableListableBeanFactory
//                    = ConfigurableListableBeanFactory.class.cast(defaultListableBeanFactory);
//            configurableListableBeanFactory
//                    .registerResolvableDependency(String.class,"antsing");
//        }
//
//        applicationContext.close();
//    }

    //可以自动注入value
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ResolvableDependencySourceDemo.class);
        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            beanFactory.registerResolvableDependency(String.class,"antsing");
            //beanFactory.registerResolvableDependency(ExternalBean.class,new ExternalBean());//无法创建需自动装配能力的外部bean
        });
        applicationContext.refresh();
//        DefaultListableBeanFactory defaultListableBeanFactory = applicationContext.getDefaultListableBeanFactory();
//        if(defaultListableBeanFactory instanceof ConfigurableListableBeanFactory){
//            ConfigurableListableBeanFactory configurableListableBeanFactory
//                    = ConfigurableListableBeanFactory.class.cast(defaultListableBeanFactory);
//            configurableListableBeanFactory
//                    .registerResolvableDependency(String.class,"antsing");
//        }
        ExternalBean externalBean = applicationContext.getBean(ExternalBean.class);
        externalBean.printUser();
        applicationContext.close();
    }

    @Bean
    public User getUser(){
        return User.createUser();
    }
}
