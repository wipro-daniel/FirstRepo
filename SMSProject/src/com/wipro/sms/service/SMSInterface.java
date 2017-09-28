package com.wipro.sms.service;

import java.util.Scanner;

import com.wipro.sms.bean.Customer;
import com.wipro.sms.bean.Item;
import com.wipro.sms.bean.Purchase;
import com.wipro.sms.dao.CreateDatabase;
import com.wipro.sms.dao.CustomerDao;
import com.wipro.sms.dao.ItemDao;
import com.wipro.sms.dao.PurchaseDao;

public class SMSInterface {
	
	
	
	public static void menu(){
		
		// Objects
		CustomerDao cd = new CustomerDao();
		ItemDao id = new ItemDao();
		PurchaseDao pd = new PurchaseDao();
		// Created a demo objects for testing
		Customer vincent = new Customer("07834226811","John Baron", "2 dss Close", "RH13 5lP");
		Item curry = new Item("Curry",100,10.01);
		//Purchase thur01 = new Purchase("curry101","07834226811",3.20,3.20,10);
		
		int selection; 
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please select from the following options \n");
		System.out.println("1. Inventory Management");
		System.out.println("2. Billing");
		System.out.println("3. Customer Management");
		
		selection = Integer.parseInt(scan.nextLine());
		
		switch(selection){
			case 1: int choice1;
			System.out.println("Please select from the following options \n");
			System.out.println("1. Create New Item");
			System.out.println("2. Edit Item Name");
			System.out.println("3. Delete Item");
			
			choice1 = Integer.parseInt(scan.nextLine());
			
				switch(choice1){
				case 1: System.out.println("You have chosen to create a new item.");
						id.insertItem(CreateStrings.ScanItem());
						System.out.println("Item created.");
				case 2: System.out.println("You have chosen to edit an item.");
						id.updateName();
						System.out.println("Item edited.");
				case 3: System.out.println("You have chosen to delete an item.");
						id.deleteItem();
						System.out.println("Item deleted.");
				}			
				break;
				
			case 2: int choice2;
			System.out.println("Please select from the following options \n");
			System.out.println("1. Create New Transaction");
			System.out.println("2. View Transaction");
			System.out.println("3. Delete Transaction");
			
			choice2 = Integer.parseInt(scan.nextLine());
			
				switch(choice2){
				case 1: System.out.println("You have chosen to start a new transaction.");
						//insertPurchase();
						System.out.println("New transaction commenced.");
						break;
						
				case 2: System.out.println("You have chosen to view transaction.");
						System.out.println("Would you like to provide purchase ID or customer number?");
						System.out.println("1. Purchase ID");
						System.out.println("2. Customer Number");
//				
//						int choiceA; 
//						choiceA = Integer.parseInt(scan.nextLine());
//						switch(choiceA){
//						case 1: readPurchase(int Purchase_ID);
//							break;
//					
//						case 2: readPurchase(String Customer_Number);
//							break;
//						}
						System.out.println("Transaction record displayed.");
						break;
						
				case 3: System.out.println("You have chosen to delete an item.");
						System.out.println("Would you like to provide purchase ID or customer number?");
						System.out.println("1. Purchase ID");
						System.out.println("2. Customer Number");
						
						int choiceB; 
						choiceB = Integer.parseInt(scan.nextLine());
						switch(choiceB){
//						case 1: pd.deleteByPurchase(Purchase_ID);
//								break;
//							
//						case 2: pd.deleteByCustomer(Customer_Number);
//								break;
						}						
						System.out.println("Transaction record deleted.");
						}				
				break;
				
			case 3:
				break;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		menu();

	}
}


