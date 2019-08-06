package cn.antsing.postprocessor.config;

import cn.antsing.postprocessor.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("cn.antsing.postprocessor")
public class SpringConfig {
    @Bean
    public User user(){
        return new User();
    }
}
