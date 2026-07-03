package cn.totoro7.propertysource;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.PropertySourcesPropertyResolver;
import org.springframework.core.io.ClassPathResource;

public class PropertySourcesOverrideDemo {

	public static void main(String[] args) {
		MutablePropertySources propertySources = new MutablePropertySources();
		propertySources.addLast(loadYaml("application-datasource.yml"));

		PropertySourcesPropertyResolver resolver = new PropertySourcesPropertyResolver(propertySources);
		System.out.println("Before override:");
		printDatasource(resolver);

		Map<String, Object> override = new LinkedHashMap<>();
		override.put("spring.datasource.url", "jdbc:mysql://override-host:3306/override_db");
		override.put("spring.datasource.username", "override_user");
		propertySources.addFirst(new MapPropertySource("manualOverride", override));

		System.out.println();
		System.out.println("After addFirst(manualOverride):");
		printPropertySources(propertySources);
		printDatasource(resolver);

		assertValue(resolver, "spring.datasource.url", "jdbc:mysql://override-host:3306/override_db");
		assertValue(resolver, "spring.datasource.username", "override_user");
		assertValue(resolver, "spring.datasource.password", "yaml_password");
	}

	private static PropertiesPropertySource loadYaml(String location) {
		YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
		factory.setResources(new ClassPathResource(location));
		Properties properties = factory.getObject();
		if (properties == null) {
			throw new IllegalStateException("Cannot load yaml: " + location);
		}
		return new PropertiesPropertySource("yaml:" + location, properties);
	}

	private static void printPropertySources(MutablePropertySources propertySources) {
		System.out.println("PropertySource search order:");
		for (PropertySource<?> propertySource : propertySources) {
			System.out.println("- " + propertySource.getName());
		}
	}

	private static void printDatasource(PropertySourcesPropertyResolver resolver) {
		System.out.println("spring.datasource.url = " + resolver.getProperty("spring.datasource.url"));
		System.out.println("spring.datasource.username = " + resolver.getProperty("spring.datasource.username"));
		System.out.println("spring.datasource.password = " + resolver.getProperty("spring.datasource.password"));
	}

	private static void assertValue(PropertySourcesPropertyResolver resolver, String key, String expected) {
		String actual = resolver.getProperty(key);
		if (!expected.equals(actual)) {
			throw new IllegalStateException(key + " expected <" + expected + "> but was <" + actual + ">");
		}
	}
}
