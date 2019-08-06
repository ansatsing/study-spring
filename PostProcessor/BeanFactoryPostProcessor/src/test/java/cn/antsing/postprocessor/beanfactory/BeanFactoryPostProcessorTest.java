package cn.antsing.postprocessor.beanfactory;

import cn.antsing.postprocessor.beanfactory.config.SpringConfig;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanFactoryPostProcessorTest {
    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        Benz benz = applicationContext.getBean(Benz.class);
        benz.fire();
        Assert.assertNotNull(benz);
    }
}
