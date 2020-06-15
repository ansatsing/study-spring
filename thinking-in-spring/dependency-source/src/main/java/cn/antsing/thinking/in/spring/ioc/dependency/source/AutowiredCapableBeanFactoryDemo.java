package cn.antsing.thinking.in.spring.ioc.dependency.source;

import cn.antsing.thinking.in.spring.ioc.dependency.source.external.bean.ExternalBean;
import cn.antsing.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
  *
  *   外部对象具有自动装配IOC容器里的bean演示<br>
  *
  * @author <a href="mailto:ansatsing@gmail.com">antsing</a> <br>
  * 创建时间: 2020/6/4 5:33 下午 <br>
  *
  * @since
  */
public class AutowiredCapableBeanFactoryDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(AutowiredCapableBeanFactoryDemo.class);
        AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
        ExternalBean externalBean = autowireCapableBeanFactory.createBean(ExternalBean.class);
        externalBean.printUser();
        applicationContext.close();

    }
    @Bean
    public User getUser(){
        return User.createUser();
    }
}
