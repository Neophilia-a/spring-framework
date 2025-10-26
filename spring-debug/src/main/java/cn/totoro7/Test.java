package cn.totoro7;

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
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(applicationContext.getBean("user"));
		System.out.println("ssfsgag");
	}
}
