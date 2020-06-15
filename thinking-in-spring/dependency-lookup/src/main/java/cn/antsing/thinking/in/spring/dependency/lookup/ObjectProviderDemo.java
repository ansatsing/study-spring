package cn.antsing.thinking.in.spring.dependency.lookup;

import cn.antsing.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * 通过 {@link org.springframework.beans.factory.ObjectProvider} 进行延迟依赖查找<br>
 *     1,支持lambda
 *     2,支持兜底
 *     3，支持延迟获取
 *
 * @author <a href="mailto:ansatsing@gmail.com">antsing</a> <br>
 * 创建时间: 2020.05.07 10:42:37 <br>
 * @since
 */
public class ObjectProviderDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(ObjectProviderDemo.class);

        applicationContext.refresh();

        lookupByObjectProviderOfIfAvailable(applicationContext);
        System.out.println("===================");
        lookupByObjectProvider(applicationContext);
        System.out.println("===================");

        lookupByObjectProviderStream(applicationContext);
        System.out.println("===================");

        applicationContext.close();
    }

    private static void lookupByObjectProviderStream(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> stringObjectProvider = applicationContext.getBeanProvider(String.class);
        //stringObjectProvider.stream().forEach(a-> System.out.println(a));
        stringObjectProvider.stream().forEach(System.out::println);
    }

    private static void lookupByObjectProviderOfIfAvailable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        //如果ioc容器没有的话，则用兜底的方案：() -> User.createUser()
        User user = userObjectProvider.getIfAvailable(() -> User.createUser());
        System.out.println("当前 user 对象：" + user);
    }

    private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(objectProvider.getObject());
    }

    @Bean
    @Primary
    public String helloWorld() {
        return "Hello World";
    }

    @Bean
    public String message(){
        return "Message";
    }
}
