package cn.antsing.postprocessor.beanfactory.config;

import cn.antsing.postprocessor.beanfactory.Benz;
import cn.antsing.postprocessor.beanfactory.Engine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("cn.antsing.postprocessor.beanfactory")
public class SpringConfig {
    @Bean
    public Benz benz(Engine engine){
        Benz benz = new Benz();
        benz.setEngine(engine);
        return benz;
    }
}
