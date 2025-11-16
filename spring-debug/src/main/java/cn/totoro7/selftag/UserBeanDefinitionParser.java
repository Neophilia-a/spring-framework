package cn.totoro7.selftag;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * 功能：
 *
 * @author toroto
 * @date 2025/11/16/周日
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
	@Override
	protected Class<?> getBeanClass(Element element) {
		// 返回属性值所对应的对象
		return User.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		// 获取属性值
		String userName = element.getAttribute("username");
		String email = element.getAttribute("email");
		String age = element.getAttribute("age");
		if (StringUtils.hasText(userName)) {
			builder.addPropertyValue("username", userName);
		}
		if (StringUtils.hasText(email)) {
			builder.addPropertyValue("email", email);
		}
		if (StringUtils.hasText(age)) {
			builder.addPropertyValue("age", age);
		}
	}
}
