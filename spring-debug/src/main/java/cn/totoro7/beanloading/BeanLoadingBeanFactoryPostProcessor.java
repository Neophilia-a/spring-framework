package cn.totoro7.beanloading;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * BeanFactoryPostProcessor 发生在 BeanDefinition 已加载、普通 Bean 未创建之前。
 */
public class BeanLoadingBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("orderService");
		beanDefinition.getPropertyValues().addPropertyValue("orderPrefix", "BFPP-ORDER");
		System.out.println("BeanFactoryPostProcessor：修改 orderService 的 BeanDefinition");
	}
}
