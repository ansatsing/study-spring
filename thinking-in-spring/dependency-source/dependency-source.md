## 依赖注入的模式
### 手动模式
*配置或者编程的方式，提前安排注入规则*
- xml资源配置元信息
- java注解配置元信息
- API配置元信息
### 自动模式
*实现方提供依赖自动关联的方式，按照内建的注入规则*
- Autowiring(自动绑定)
## 依赖注入的类型

类型|配置元数据举例
---|---
Setter方法|<property name="user" ref="beanId" />
构造器方式|<constuctor-arg name="user" ref="beanId" />
字段|@Autowire User user;
方法| @Autowire public void user(User user){...}
接口回调|class MyBean implements BeanFactoryAware{...}