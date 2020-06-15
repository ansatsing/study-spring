package cn.antsing.thinking.in.spring.bean.factory;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * 默认的{@link UserFactory}实现<br>
 *
 * @author <a href="mailto:ansatsing@gmail.com">antsing</a> <br>
 * 创建时间: 2020.04.30 16:29:29 <br>
 * @since
 */
public class DefaultUserFactory implements UserFactory, InitializingBean {
    @PostConstruct
    public void method1() {
        System.out.println("@PostConstruct method1.....");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean#afterPropertiesSet....");
    }

    public void init(){
     System.out.println("自定义初始化方法：init()...");
    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println("当前 DefaultUserFactory对象正在被垃圾回收...");
    }
}
