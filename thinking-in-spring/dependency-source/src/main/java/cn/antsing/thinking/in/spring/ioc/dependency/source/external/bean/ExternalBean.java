package cn.antsing.thinking.in.spring.ioc.dependency.source.external.bean;

import cn.antsing.thinking.in.spring.ioc.overview.domain.User;

import javax.annotation.Resource;

public class ExternalBean {
    @Resource
    private User user;
    public void printUser(){
        System.out.println("外部Bean所自动注入的IOC容器里的Bean:"+user);
    }
}
