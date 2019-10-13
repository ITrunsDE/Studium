
public class MyClass {

	String name;
	private int var;
	
	public MyClass(){
		this.var = 10;
	}
	
	public MyClass(int num) {
		this.var = num;
	}
	
	public int getValue() {
		return var;
	}
	
	public static void main(String[] args) {
		MyClass obj = new MyClass();
		MyClass obj2 = new MyClass(100);
		System.out.println("var is: " + obj.getValue());
		System.out.println("var is: " + obj2.getValue());
	}
}
