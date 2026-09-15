package cn.totoro7.beanloading;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * BeanPostProcessor 发生在 Bean 实例化、属性填充之后，初始化方法前后。
 */
public class BeanLoadingBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if ("orderService".equals(beanName)) {
			System.out.println("BeanPostProcessor beforeInitialization：" + beanName);
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if ("orderService".equals(beanName)) {
			System.out.println("BeanPostProcessor afterInitialization：" + beanName);
		}
		return bean;
	}
}
