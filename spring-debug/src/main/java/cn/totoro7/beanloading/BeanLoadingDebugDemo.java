package cn.totoro7.beanloading;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring Bean 加载流程调试入口。
 */
public class BeanLoadingDebugDemo {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-loading-debug.xml")) {
			OrderService orderService = context.getBean(OrderService.class);
			String orderNo = orderService.createOrder("1001");
			System.out.println("最终业务调用结果：" + orderNo);

			Object sameBean = context.getBean("orderService");
			assertSame(orderService, sameBean, "默认 singleton 应该从一级缓存返回同一个对象");

			CircularA circularA = context.getBean(CircularA.class);
			CircularB circularB = context.getBean(CircularB.class);
			assertSame(circularB, circularA.getCircularB(), "CircularA 应该成功注入 CircularB");
			assertSame(circularA, circularB.getCircularA(), "CircularB 应该拿到 CircularA 的提前暴露引用");
		}
	}

	private static void assertSame(Object expected, Object actual, String message) {
		if (expected != actual) {
			throw new IllegalStateException(message);
		}
	}
}
