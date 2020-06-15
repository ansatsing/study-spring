package cn.antsing.thinking.in.spring.bean.definition;

import cn.antsing.thinking.in.spring.bean.factory.DefaultUserFactory;
import cn.antsing.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 外部单例Bean注册Demo<br>
 *
 * @author <a href="mailto:ansatsing@gmail.com">antsing</a> <br>
 * 创建时间: 2020.05.07 09:35:17 <br>
 * @since
 */
public class SingletonBeanRegistrationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        UserFactory userFactory = new DefaultUserFactory();

        /**
         * SingletonBeanRegistry 与此类似的BeanDefinitionRegsitry
         */
        SingletonBeanRegistry singletonBeanRegistry = applicationContext.getBeanFactory();

        singletonBeanRegistry.registerSingleton("userFactory", userFactory);

        //无此行代码会报错：has not been refreshed yet
        applicationContext.refresh();

        UserFactory userFactoryByLookup = applicationContext.getBean("userFactory", UserFactory.class);

        System.out.println("userFactory == userFactoryByLookup:" + (userFactory == userFactoryByLookup));
    }
}
