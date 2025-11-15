package cn.totoro7;

import cn.totoro7.service.MyApplicationContextService;
import cn.totoro7.service.MyClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 功能：
 *
 * @author toroto
 * @date 2025/10/26/周日
 */
public class Test {
	public static void main(String[] args) {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-${username}.xml");
		ApplicationContext applicationContext = new MyClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(applicationContext.getBean("user"));
		MyApplicationContextService myApplicationContextService = (MyApplicationContextService) applicationContext.getBean("myApplicationContextService");
		System.out.println(myApplicationContextService.getApplicationContext());
		System.out.println("ssfsgag");
	}
}
