package model;

public abstract class Drink {
	
	private String id;
	private String type;
	private String name;
	private int price;
	
	public Drink(String type, String name, int price, String id) {
		super();
		this.type = type;
		this.name = name;
		this.price = price;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
