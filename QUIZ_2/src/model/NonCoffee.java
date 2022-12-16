package model;

public class NonCoffee extends Drink {
	private String base;
	private String topping;
	
	public NonCoffee(String type, String name, int price, String id, String base, String topping) {
		super(type, name, price, id);
		this.base = base;
		this.topping = topping;
		// TODO Auto-generated constructor stub
	}
	
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getTopping() {
		return topping;
	}
	public void setTopping(String topping) {
		this.topping = topping;
	}
	
	
}
