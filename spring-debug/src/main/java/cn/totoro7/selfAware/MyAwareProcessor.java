package cn.totoro7.selfAware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.*;

import java.security.AccessControlContext;

/**
 * 功能：
 *
 * @author toroto
 * @date 2025/11/23/周日
 */
public class MyAwareProcessor implements BeanPostProcessor {
	private final ConfigurableApplicationContext applicationContext;

	public MyAwareProcessor(ConfigurableApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {


		AccessControlContext acc = null;

		if (System.getSecurityManager() != null) {
			acc = this.applicationContext.getBeanFactory().getAccessControlContext();
		}
		((ApplicationContextAware) bean).setApplicationContext(applicationContext);
		System.out.println("----------实现aware--------");

		return bean;
	}
}
