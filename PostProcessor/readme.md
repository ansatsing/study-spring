#  后置处理器执行顺序
## 1-BeanDefinitionRegistryPostProcessor
> BeanDefinitionRegistryPostProcessor继承了BeanFactoryPostProcessor
#### postProcessBeanFactory
> public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException 
#### postProcessBeanDefinitionRegistry
> public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException
## 2-BeanFactoryPostProcessor
#### postProcessBeanFactory
> public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException
## 3-BeanPostProcessor
> 每个普通bean实例化时都要执行此后置处理器
#### postProcessBeforeInitialization
> public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
#### postProcessAfterInitialization
> public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException
## 4-普通bean实例化