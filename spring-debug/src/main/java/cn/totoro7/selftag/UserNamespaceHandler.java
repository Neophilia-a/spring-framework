package cn.totoro7.selftag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 功能：
 *
 * @author toroto
 * @date 2025/11/16/周日
 */
public class UserNamespaceHandler extends NamespaceHandlerSupport {
	@Override
	public void init() {
		registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
	}
}
