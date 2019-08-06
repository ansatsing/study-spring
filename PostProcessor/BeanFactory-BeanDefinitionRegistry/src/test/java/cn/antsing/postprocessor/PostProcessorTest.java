package cn.antsing.postprocessor;

import cn.antsing.postprocessor.config.SpringConfig;
import cn.antsing.postprocessor.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PostProcessorTest {
    @Test
    public void postProcessorTest(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        User user1 = (User) applicationContext.getBean("user1");
        User user = (User) applicationContext.getBean("user");
        Assert.assertNotNull(user);
        Assert.assertNotNull(user1);
        Assert.assertNotEquals(user,user1);
    }
}
