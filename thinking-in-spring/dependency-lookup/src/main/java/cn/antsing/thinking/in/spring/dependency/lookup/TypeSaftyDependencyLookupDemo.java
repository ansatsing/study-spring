package cn.antsing.thinking.in.spring.dependency.lookup;

import cn.antsing.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
  *
  *   类型安全依赖查找<br>
  *
  *
  * @author <a href="mailto:ansatsing@gmail.com">antsing</a> <br>
  * 创建时间: 2020.05.07 14:47:01 <br>
  *
  * @since
  */
public class TypeSaftyDependencyLookupDemo {
     public static void main(String[] args) {
         AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

         applicationContext.register(TypeSaftyDependencyLookupDemo.class);

         applicationContext.refresh();

         displayObjectProviderStreamOps(applicationContext);

         displayListableBeanFactoryGetBeansOfType(applicationContext);

         displayBeanFactoryGetBeanException(applicationContext);

         displayObjectProviderBeanException(applicationContext);

         displayObjectProviderIfAvailable(applicationContext);

         applicationContext.close();
     }

    private static void displayObjectProviderStreamOps(AnnotationConfigApplicationContext applicationContext) {
         printBeanException("displayObjectProviderStreamOps",()->applicationContext
                 .getBeanProvider(User.class)
                 .stream()
                 .forEach(System.out::println));
     }

    /**
     * 演示 ListableBeanFactory#getBeansOfType 方法安全性
     * @param applicationContext
     */
    private static void displayListableBeanFactoryGetBeansOfType(AnnotationConfigApplicationContext applicationContext) {
         printBeanException("displayListableBeanFactoryGetBeansOfType",()->applicationContext.getBeansOfType(User.class));
    }

    /**
     * 演示beanFactory.getBeanProvider(User.class).getIfAvailable()方法的安全性
     * @param beanFactory
     */
     public static void displayObjectProviderIfAvailable(BeanFactory beanFactory){
         printBeanException("displayObjectProviderIfAvailable",()->beanFactory.getBeanProvider(User.class).getIfAvailable());
     }
    /**
     * 演示beanFactory.getBeanProvider(User.class).getObject()方法的安全性
     * getBeanProvider模拟BeanException
     * @param beanFactory
     */
     public static void displayObjectProviderBeanException(BeanFactory beanFactory){
         printBeanException("displayObjectProviderBeanException",()->beanFactory.getBeanProvider(User.class).getObject());
     }

    /**
     * 演示beanFactory.getBean(User.class)方法的安全性
     * getBean模拟BeanException
     * @param beanFactory
     */
     public static void displayBeanFactoryGetBeanException(BeanFactory beanFactory){
         printBeanException("displayBeanFactoryGetBeanException",()->beanFactory.getBean(User.class));
     }

     private static void printBeanException(String methodName,Runnable runnable){
         try {
             runnable.run();
         }catch (Exception e){
             System.err.println("error from method:"+methodName);
             e.printStackTrace();
         }
     }
}
