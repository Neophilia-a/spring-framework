package cn.totoro7.beanloading;

public class CircularB {

	private CircularA circularA;

	public CircularB() {
		System.out.println("CircularB 构造方法：B 原始对象创建完成");
	}

	public void setCircularA(CircularA circularA) {
		System.out.println("CircularB setCircularA：注入 A 的提前暴露引用");
		this.circularA = circularA;
	}

	public CircularA getCircularA() {
		return circularA;
	}
}
