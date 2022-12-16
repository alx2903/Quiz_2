package model;

public class Coffee extends Drink {

	private String coftype;
	
	public Coffee(String type, String name, int price, String id, String coftype) {
		super(type, name, price, id);
		this.coftype = coftype;
		// TODO Auto-generated constructor stub
	}

	public String getCoftype() {
		return coftype;
	}

	public void setCoftype(String coftype) {
		this.coftype = coftype;
	}
	
	

}
