package cn.antsing.postprocessor.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 国产引擎
 */
@Component
public class ChinaEngine implements BeanFactoryPostProcessor {
    public ChinaEngine(){
        System.out.println("国产引擎构造函数...........");
    }
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor方法执行。。。。。。。。。。。");
        BeanDefinitionRegistry bdr = (BeanDefinitionRegistry)beanFactory;
        GenericBeanDefinition gbd = new GenericBeanDefinition();
        gbd.setBeanClass(EngineFactory.class);
       // gbd.setScope(BeanDefinition.SCOPE_SINGLETON);
       // gbd.setAutowireCandidate(true);
        bdr.registerBeanDefinition("engine01-gbd", gbd);
    }
    static class EngineFactory implements FactoryBean<Engine>, InvocationHandler{
        public EngineFactory(){
            System.out.println("引擎工厂构造函数.............");
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("起火成功...........");
            return null;
        }

        @Override
        public Engine getObject() throws Exception {
            Engine proxy = (Engine) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{Engine.class},this);
            return proxy;
        }

        @Override
        public Class<?> getObjectType() {
            return Engine.class;
        }

        @Override
        public boolean isSingleton() {
            return true;
        }
    }
}
