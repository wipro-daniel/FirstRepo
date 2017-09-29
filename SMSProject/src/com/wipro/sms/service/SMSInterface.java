package com.wipro.sms.service;

//TODO: Loop the Menu and create the system so that one purchase has one ID
// Create Item ID automatically
// Create a select Item method
// A Select transaction function which takes all that have the same purchase ID
// Change purchase_ID so that it isn't a primary key so that you can have multiple.
import java.util.Scanner;

import com.wipro.sms.bean.Customer;
import com.wipro.sms.bean.Item;
import com.wipro.sms.bean.Purchase;
import com.wipro.sms.dao.CreateDatabase;
import com.wipro.sms.dao.CustomerDao;
import com.wipro.sms.dao.DropTables;
import com.wipro.sms.dao.ItemDao;
import com.wipro.sms.dao.KeyDao;
import com.wipro.sms.dao.PurchaseDao;

public class SMSInterface {

	// Objects
	static CustomerDao cd = new CustomerDao();
	static ItemDao id = new ItemDao();
	static PurchaseDao pd = new PurchaseDao();
	static CreateDatabase cdb = new CreateDatabase();
	static DropTables drop = new DropTables();
	// Created a demo objects for testing
	static Customer vincent = new Customer("07834226811", "John Baron",
			"2 dss Close", "RH13 5lP");
	static Item curry = new Item("Curry", 100, 10.01);
	static Scanner scan = new Scanner(System.in);

	// Purchase thur01 = new Purchase("curry101","07834226811",3.20,3.20,10);

	public static void menu() {

		int selection;
		boolean loop = true;
		
		while(loop)
		{
			
	
			System.out.println("Please select from the following options");
			System.out.println("1. Inventory Management");
			System.out.println("2. Billing");
			System.out.println("3. Customer Management");
			System.out.println("4. Create Database");
			System.out.println("5. Drop Tables");
			System.out.println("6. Exit");
		
			selection = Integer.parseInt(scan.nextLine());

		
			switch (selection) {
			case 1:
				int choice1;
				System.out.println("Please select from the following options \n");
				System.out.println("1. Create New Item");
				System.out.println("2. Edit Item Name");
				System.out.println("3. Delete Item");
				System.out.println("4. View Item");
	
				choice1 = Integer.parseInt(scan.nextLine());
	
				switch (choice1) {
				case 1:
					System.out.println("You have chosen to create a new item.");
					id.insertItem(CreateStrings.ScanItem());
					System.out.println("Item created.");
					break;
				case 2:
					System.out.println("You have chosen to edit an item.");
					id.updateName(CreateStrings.scanItemID(),CreateStrings.scanItemName());
					System.out.println("Item edited.");
					break;
				case 3:
					System.out.println("You have chosen to delete an item.");
					id.deleteItem();
					System.out.println("Item deleted.");
					break;
				case 4:
					System.out.println("You have chosen to view an item");
					id.readItem(CreateStrings.scanItemID());
					break;
				default: break;
				}
				break;
	
			case 2:
				int choice2;
				System.out.println("Please select from the following options \n");
				System.out.println("1. Create New Transaction");
				System.out.println("2. View Transaction");
				boolean stop = false;
	
				choice2 = Integer.parseInt(scan.nextLine());
	
				switch (choice2) {
	
				case 1:
					String purchase_id = KeyDao.createKey();
					while (!stop) {
						System.out
								.println("You have chosen to start a new transaction.");
						int trChoice;
						System.out
								.println("Please select from the following options \n");
						System.out.println("1. Add new item");
						System.out.println("2. Delete item.");
						System.out.println("3. Edit item quantity.");
						System.out.println("4. End transaction.");
						trChoice = Integer.parseInt(scan.nextLine());
						switch (trChoice) {
						case 1:
							pd.insertPurchase(CreateStrings
									.scanPurchase(purchase_id));
							break;
						case 2:
							System.out
									.println("You have chosen to delete an item.");
							System.out
									.println("Would you like to provide purchase ID or customer number?");
							System.out.println("1. Purchase ID");
							System.out.println("2. Customer Number");
							System.out.println("3. Back");
	
							int choiceB;
							choiceB = Integer.parseInt(scan.nextLine());
							switch (choiceB) {
							case 1:
								pd.deleteByPurchase(CreateStrings.scanPurchaseID());
								break;
	
							case 2:
								pd.deleteByCustomer(CreateStrings.scanNumber());
								break;
							case 3:
								pd.updateQuantity();
								break;
							}
							break;
						
						case 3:
							
							break;
						case 4:
							stop = true;
							break;
						}						
					}
					break;
	
				case 2:
					System.out.println("You have chosen to view transaction.");
					System.out
							.println("Would you like to provide purchase ID or customer number?");
					System.out.println("1. Purchase ID");
					System.out.println("2. Customer Number");
					System.out.println("3. Back");
	
					int choiceA;
					choiceA = Integer.parseInt(scan.nextLine());
					switch (choiceA) {
					case 1:
						pd.readPurchaseByPurchaseId(CreateStrings.scanPurchaseID());
						break;
	
					case 2:
						pd.readPurchase(CreateStrings.scanNumber());
						break;
					case 3:
						break;
					}
				
					System.out.println("Transaction record displayed.");
					break;
					
				}
				break;
	
				case 3: 
					int choice3;
					System.out
							.println("Please select from the following options \n");
					System.out.println("1. Create New Customer");
					System.out.println("2. Delete Customer");
					System.out.println("3. Update Customer details");
					System.out.println("4. View Customer Data");
					choice3 = Integer.parseInt(scan.nextLine());
	
					switch (choice3) {
					case 1:
						System.out
								.println("You have chosen to create a new record");
						cd.insertCustomer(CreateStrings.ScanCustomer());
						break;
	
					case 2:
						System.out
								.println("You have chosen to delete a new record");
						System.out.println("Enter Customer_Number to be deleted");
						cd.deleteCustomer(CreateStrings.scanNumber());
						break;
	
					case 3:
						System.out
								.println("You have chosen to update customer details.");
						System.out.println("1. Update Name.");
						System.out.println("2. Update Address.");
						System.out.println("3. Update Postcode.");
						int choice4 = Integer.parseInt(scan.nextLine());
	
						switch (choice4) {
						case 1:
							System.out
									.println("You have chosen to update customer name.");
							cd.updateName();
							break;
						case 2:
							System.out
									.println("You have chosen to update customer address.");
							cd.updateAddress();
							break;
						case 3:
							System.out
									.println("You have chosen to update customer postcode.");
							cd.updatePostcode();
							break;
						}
						break;
					case 4:
						System.out.println("You have chosen to read a record");
						cd.readCustomer(CreateStrings.scanNumber());
						break;
					}	
					break;
	
				case 4:
//					System.out.println("Creating tables");
//					if (cdb.createCustomerData()) {
//						System.out.println("Customer Data Created");
//					}
//					if (cdb.createInventory()) {
//						System.out.println("Inventory Created");
//					}
//					if (cdb.createPurchase()) {
//						System.out.println("Purchase Created");
//					}
					// if(cdb.createPurchaseList())
					// {
					// System.out.println("PurchaseList Created");
					// }
					// if(cdb.createInventoryIncrement())
					// {
					// System.out.println("Create Inventory Increment");
					// }
					// if(cdb.createPurchaseIncrement())
					// {
					// System.out.println("Create Purchase Increment");
					// }
					break;
				case 5:
					System.out.println("Dropping tables");
					drop.dropCustomer();
					drop.dropInventory();
					drop.dropPurchase();
					// drop.dropInventorySequence();
					// drop.dropPurchaseSequence();
					// drop.dropPurchaseList();
					break;
				case 6:
					loop = false;
					break;
	
				
			}
			//scan.close();
		}
	}

}
