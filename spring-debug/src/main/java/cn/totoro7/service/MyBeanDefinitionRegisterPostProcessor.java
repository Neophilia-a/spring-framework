package cn.totoro7.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * 功能：
 *
 * @author toroto
 * @date 2025/12/20/周六
 */
public class MyBeanDefinitionRegisterPostProcessor implements BeanDefinitionRegistryPostProcessor {
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("执行----MyBeanDefinitionRegisterPostProcessor.postProcessBeanDefinitionRegistry");
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(Teacher.class);
		builder.addPropertyValue("name", "totoro");
		//registry.registerBeanDefinition("teacher", new RootBeanDefinition("cn.totoro7.service.MyService.Teacher"));
		registry.registerBeanDefinition("teacher", builder.getBeanDefinition());

		BeanDefinitionBuilder builder2 = BeanDefinitionBuilder.rootBeanDefinition(MySelfBeanDefinitionRegisterPostProcessor.class);
		builder2.addPropertyValue("name", "totoro1");
		registry.registerBeanDefinition("mySelfBeanDefinitionRegisterPostProcessor", builder2.getBeanDefinition());

	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("执行----MyBeanDefinitionRegisterPostProcessor.postProcessBeanFactory");
	}
}
