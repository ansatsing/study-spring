package cn.antsing.postprocessor.beanfactory;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * 奔驰车
 */
public class Benz implements InitializingBean {
    private Engine engine;
    public void fire(){
        System.out.print("奔驰车");
        engine.fire();
    }
    public Benz(){
        System.out.println("BenzCar Constructorh");
        if(engine==null){
            System.out.println("BenzCar's engine not setting");
        }else{
            System.out.println("BenzCar's engine installed");
        }
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BenzCar initializingBean after propertieSet");
        if(engine==null){
            System.out.println("BenzCar's engine not setting, in initializingBean ");
        }else{
            System.out.println("BenzCar's engine installed, in initializingBean");
           // engine.fire();
        }
    }
    @PostConstruct
    public void postConstruct(){
        System.out.println("BenzCar postConstruct");
        if(engine==null){
            System.out.println("BenzCar's engine not setting, in postConstruct");
        }else{
            System.out.println("BenzCar's engine installed, in postConstruct");
        }
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
