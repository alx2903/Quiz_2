package main;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import model.Drink;
import model.Coffee;
import model.NonCoffee;

public class Main {

	public Main() {
		int menu;
		String id;
		String type;
		String name;
		int price;
		
		String coftype;
		String base;
		String topping;
		
		int sell;
		
		Scanner scan = new Scanner(System.in);
		Vector<Drink> Vec = new Vector<>();
		
		do {
			System.out.println("Mizology");
			System.out.println("==================");
			System.out.println("1. Insert New Drink");
			System.out.println("2. View All Drinks");
			System.out.println("3. Sell Drink");
			System.out.println("4. Exit");
			System.out.printf("Choose: ");
			menu = scan.nextInt();
			scan.nextLine();
			
			switch (menu) {
			case 1:
				for(;;) {
					System.out.printf("Input Drink Type [Coffee | Non-Coffee]: ");
					type = scan.nextLine();
					if(type.matches("Coffee") == true || type.matches("Non-Coffee") == true) {
						break;
					}
				}
				for(;;) {
					System.out.printf("Input Drink Name [5..20]: ");
					name = scan.nextLine();
					if(name.length() >= 5 && name.length() <= 20) {
						break;
					}
				}
				for(;;) {
					System.out.printf("Input Base Price [5000 - 30000 | divisible by 1000]: ");
					price = scan.nextInt();
					scan.nextLine();
					if(price >= 5000 && price <= 30000 && price%1000 == 0) {
						break;
					}
				}
				
				Random rand = new Random();
				int rand1 = rand.nextInt(1000);
				String randnum;
				randnum = String.format("%03d", rand1);
				id = "DI" + randnum;
				
				if(type.matches("Coffee") == true) {
					for(;;) {
						System.out.printf("Input Coffee Type [Latte | Espresso]: ");
						coftype = scan.nextLine();
						if(coftype.equalsIgnoreCase("Latte") == true || coftype.equalsIgnoreCase("Espresso") == true) {
							break;
						}
					}
					Coffee cof = new Coffee(type, name, price, id,coftype);
					Vec.add(cof);
				}
				else if(type.matches("Non-Coffee") == true) {
					for(;;) {
						System.out.printf("Input Base Drink [MilkTea | Smoothie | Chocolate]: ");
						base = scan.nextLine();
						if(base.equalsIgnoreCase("MilkTea") == true || base.equalsIgnoreCase("Smoothie") == true || base.equalsIgnoreCase("Chocolate") == true) {
							break;
						}
					}
					for(;;) {
						System.out.printf("Input Topping [Boba | Jelly | Pudding]: ");
						topping = scan.nextLine();
						if(topping.equalsIgnoreCase("Boba") == true || topping.equalsIgnoreCase("Jelly") == true || topping.equalsIgnoreCase("Pudding") == true) {
							break;
						}
					}
					NonCoffee noncof = new NonCoffee(type, name, price, id, base, topping);
					Vec.add(noncof);
				}
				System.out.println("Drink successfully inserted.");
				Util.PressEnter();
				break;
			
			case 2:
				if(Vec.isEmpty() == true) {
					System.out.println("No drink available");
					Util.PressEnter();
				}
				else {
					int i = 1;
					for (Drink drink : Vec) {
						System.out.printf("Drink-%d\n", i);
						System.out.println("===================");
						if(drink instanceof Coffee) {
							System.out.println("Drink ID: " + drink.getId());
							System.out.println("Drink Name: " + drink.getName());
							System.out.println("Drink Type: " + drink.getType());
							System.out.println("Coffee Type: " + ((Coffee) drink).getCoftype());
							System.out.println("Base Price: " + drink.getPrice());
							System.out.printf("\n\n");
						}
						else if(drink instanceof NonCoffee) {
							System.out.println("Drink ID: " + drink.getId());
							System.out.println("Drink Name: " + drink.getName());
							System.out.println("Drink Type: " + drink.getType());
							System.out.println("Base Drink: " + ((NonCoffee) drink).getBase());
							System.out.println("Topping: " + ((NonCoffee) drink).getTopping());
							System.out.println("Base Price: " + drink.getPrice());
							System.out.printf("\n\n");
						}
						i++;
					}
				}
				Util.PressEnter();
				break;
				
			case 3:
				if(Vec.isEmpty() == true) {
					System.out.println("No drink available");
				}
				else {
					int i = 1;
					for (Drink drink : Vec) {
						System.out.printf("Drink-%d\n", i);
						System.out.println("===================");
						if(drink instanceof Coffee) {
							System.out.println("Drink ID: " + drink.getId());
							System.out.println("Drink Name: " + drink.getName());
							System.out.println("Drink Type: " + drink.getType());
							System.out.println("Coffee Type: " + ((Coffee) drink).getCoftype());
							System.out.println("Base Price: " + drink.getPrice());
							System.out.printf("\n\n");
						}
						else if(drink instanceof NonCoffee) {
							System.out.println("Drink ID: " + drink.getId());
							System.out.println("Drink Name: " + drink.getName());
							System.out.println("Drink Type: " + drink.getType());
							System.out.println("Base Drink: " + ((NonCoffee) drink).getBase());
							System.out.println("Topping: " + ((NonCoffee) drink).getTopping());
							System.out.println("Base Price: " + drink.getPrice());
							System.out.printf("\n\n");
						}
						i++;
					}
				}
				System.out.printf("Select Drink [1..%d]: ", Vec.size());
				sell = scan.nextInt();
				System.out.printf("\n");
				System.out.printf("%s\n", Vec.get(sell-1).getName());
				System.out.println("Tax 10%");
				System.out.printf("Base Price: %d\n", Vec.get(sell-1).getPrice());
				double total;
				total = Vec.get(sell-1).getPrice() * 1.1;
				System.out.println("Total Price: " + total);
				System.out.println("");
				for(;;) {
					System.out.println("Input Payment [min. " + total + "]: ");
					int pay;
					pay = scan.nextInt();
					if(pay >= total) {
						double change;
						change = pay - total;
						System.out.println("Change: " + change);
						break;
					}
				}
				Vec.remove(sell-1);
				System.out.println("Thank You!");
				Util.PressEnter();
				break;
				
			case 4:
				break;
				
			default:
				break;
			}
			
		} while (menu!=4);
	}

	public static void main(String[] args) {
		new Main();
	}

}
