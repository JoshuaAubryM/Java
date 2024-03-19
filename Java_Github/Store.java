package storeProject;
import java.util.Scanner;

import java.util.HashMap;

import java.util.ArrayList;

import storeProject.storeLaptop;

public class Store {
	public Object storeLaptop;
	public Object Table;
	public Object Light;
	//	private ArrayList<String> Customers = new ArrayList<String>();
	//	private HashMap<String, Long> customerInformation = new HashMap<String, Long>();
	public static ArrayList<Object> laptopInventory = new ArrayList<Object>();
	public static ArrayList<Object> tableInventory = new ArrayList<Object>();
	public static ArrayList<Object> lightInventory = new ArrayList<Object>();
	//---------------Initialized an ArrayList---------------//
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] arg) {
	//	two options a and b 
	//	a yields 3 new queries as well as b
	
	Scanner sc = new Scanner(System.in);
	
	//---------------New Block----------------
	//	int active = 0;
	Boolean runApp = true;
	//	String Application = "active";
	
	//	the application is running when active
		
	while (runApp) {
			//	created the application
		System.out.println("Hello");
		System.out.println("A. Add to Inventory?: ");
		System.out.println("B. Check Inventory?: ");
		System.out.println("C. QUIT? ");
		System.out.println("\nSelect A LETTER.");
		//	System.out.println("\nPLEASE ANSWER WITH CAPITALS.");
		String Application = " ";
		Application = sc.nextLine();
		Application = Application.toUpperCase();
			switch(Application) {
		//	the application is running
			//---------------Case A---------------
			//---------------Case A---------------
			//---------------Case A---------------
			case "A":
				//	Boolean nextQuestion = false;
				System.out.println("Do you want to add an item to the inventory?:\nYES / NO");
				
				if (sc.nextLine().equalsIgnoreCase("yes")) {
					System.out.println("\nDo you want to make a Laptop, a Table, or a Light?: ");
					String secondQuestion = sc.nextLine();
					
						if (secondQuestion.equalsIgnoreCase("Laptop")) {
							//storeProject.storeLaptop.newLaptop(null);
							//	laptopInventory.add(storeProject.storeLaptop.newLaptop(null));
							storeProject.storeLaptop laptop = new storeLaptop();
							laptopInventory.add(laptop);
							System.out.println("Laptop Inventory: " + laptopInventory.size());
							//System.out.println(Inventory.add(storeProject.storeLaptop.createLaptop().get(0)));
							System.out.println("DO You Want To Continue?: ");
							if (sc.nextLine().equalsIgnoreCase("No") && sc.nextLine() != "yes") {
							runApp = false;
							break;
							} else {
								continue;
							}
							
						} else if (secondQuestion.equalsIgnoreCase("Table")) {
								//	storeProject.Table.createTable();
								storeProject.Table table = new Table();
								tableInventory.add(table);
								System.out.println("Table Inventory: " + tableInventory.size());
								System.out.println("Do You Want To Continue?: ");
								if (sc.nextLine().equalsIgnoreCase("No") && sc.nextLine() != "yes") {
								runApp = false;
								break;
								} else {
									continue;
								}
				
						}	else if (secondQuestion.equalsIgnoreCase("Light")) {
								//	Create a Light Object;
								storeProject.Light light = new Light();
								lightInventory.add(light);
								System.out.println("Light Inventory: " + lightInventory.size());
								System.out.println("Do You Want To Continue?: ");
								if (sc.nextLine().equalsIgnoreCase("No") && sc.nextLine() != "yes") {
									runApp = false;
									break;
									} else {
										continue;
									}
							}	
							
			//---------------New Block---------------
							//---------------New Block---------------
							//---------------New Block---------------
					} else {
						System.out.println("Check Inventory?: ");
						if (sc.nextLine().equalsIgnoreCase("No") && sc.nextLine() != "yes") {
						runApp = false;
						break;
						}
				};
			
			//---------------Case B---------------
			//---------------Case B---------------
			//---------------Case B---------------
			case "B":
				
				System.out.println("1.	Laptop Inventory?");
				System.out.println("2.	Table Inventory?");
				System.out.println("3.	Light Inventory?");
				System.out.println("Enter RETURN to return");
				String checkInventory = sc.nextLine();
				//	String checkInventory = sc.nextLine();
				
				switch(checkInventory) {
				case "1":
					System.out.println("Laptop Inventory: " +laptopInventory.size());
					System.out.println("\n");
					continue;
				
				case "2":
					System.out.println("Table Inventory: " + tableInventory.size());
					System.out.println("\n");
					continue;
					
				case "3":
					System.out.println("Light Inventory: " + lightInventory.size());
					System.out.println("\n");
					continue;
					
				case "RETURN":
					break;
				
				
			case "C":
				runApp = false;
			default:
				}
		//---------------End of While Loop---------------//
					//---------------End of While Loop---------------//
			}
//---------------End of Main Method---------------
		}
	}
}
