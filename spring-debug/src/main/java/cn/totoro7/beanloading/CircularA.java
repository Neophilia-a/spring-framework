package cn.totoro7.beanloading;

public class CircularA {

	private CircularB circularB;

	public CircularA() {
		System.out.println("CircularA 构造方法：A 原始对象创建完成");
	}

	public void setCircularB(CircularB circularB) {
		System.out.println("CircularA setCircularB：注入 B");
		this.circularB = circularB;
	}

	public CircularB getCircularB() {
		return circularB;
	}
}
