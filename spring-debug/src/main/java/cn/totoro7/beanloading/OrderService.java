package cn.totoro7.beanloading;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;

public class OrderService implements BeanNameAware, InitializingBean {

	private OrderRepository orderRepository;

	private String orderPrefix;

	private String beanName;

	public OrderService() {
		System.out.println("OrderService 构造方法：实例化 Bean");
	}

	public void setOrderRepository(OrderRepository orderRepository) {
		System.out.println("OrderService setOrderRepository：填充 ref 属性");
		this.orderRepository = orderRepository;
	}

	public void setOrderPrefix(String orderPrefix) {
		System.out.println("OrderService setOrderPrefix：填充普通属性 " + orderPrefix);
		this.orderPrefix = orderPrefix;
	}

	@Override
	public void setBeanName(String beanName) {
		System.out.println("BeanNameAware#setBeanName：" + beanName);
		this.beanName = beanName;
	}

	@Override
	public void afterPropertiesSet() {
		System.out.println("InitializingBean#afterPropertiesSet");
	}

	public void init() {
		System.out.println("custom init-method：init");
	}

	public String createOrder(String id) {
		String orderNo = this.orderPrefix + "-" + id;
		return this.beanName + " -> " + this.orderRepository.save(orderNo);
	}

	public void destroy() {
		System.out.println("custom destroy-method：destroy");
	}
}
