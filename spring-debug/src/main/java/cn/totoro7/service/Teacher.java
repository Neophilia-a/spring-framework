package cn.totoro7.service;

/**
 * 功能：
 *
 * @author toroto
 * @date 2025/12/20/周六
 */
public class Teacher {
	private String name;

	public Teacher() {
		System.out.println("创建teacher类信息");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
