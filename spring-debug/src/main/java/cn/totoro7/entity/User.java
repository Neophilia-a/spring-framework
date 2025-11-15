package cn.totoro7.entity;

/**
 * 简单的 User 实体类
 *
 * @author toroto
 * @date 2025/10/26/周日
 */
public class User {
	private String name;
	private Integer age;

	public User() {
	}

	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public void init() {
		System.out.println("---init---");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User{name='" + name + "', age=" + age + "}";
	}
}
