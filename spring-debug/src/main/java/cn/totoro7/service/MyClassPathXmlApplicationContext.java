package cn.totoro7.service;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 功能：
 *
 * @author toroto
 * @date 2025/11/8/周六
 */
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

	public MyClassPathXmlApplicationContext(String... configLocations) {
		super(configLocations);
	}

	@Override
	protected void initPropertySources() {
		System.out.println("扩展initPropertySources");
		getEnvironment().setRequiredProperties("username");
	}

	@Override
	protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
		super.setAllowBeanDefinitionOverriding(false);
		super.setAllowCircularReferences(false);
		// 或者
//		beanFactory.setAllowBeanDefinitionOverriding(false);
//		beanFactory.setAllowCircularReferences(false);
		super.customizeBeanFactory(beanFactory);
	}
}
