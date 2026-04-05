package cn.totoro7.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.PriorityOrdered;

/**
 * 功能：
 *
 * @author toroto
 * @date 2025/12/20/周六
 */
public class MySelfBeanDefinitionRegisterPostProcessor implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("执行----MySelfBeanDefinitionRegisterPostProcessor.postProcessBeanDefinitionRegistry");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("执行----MySelfBeanDefinitionRegisterPostProcessor.postProcessBeanFactory");
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
