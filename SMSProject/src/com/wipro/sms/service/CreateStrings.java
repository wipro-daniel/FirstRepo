package com.wipro.sms.service;
import java.util.Scanner;

import com.wipro.sms.bean.Customer;
import com.wipro.sms.bean.Item;
public class CreateStrings {
	
	static Scanner sc = new Scanner(System.in);
	
	public static Item ScanItem(){
		
		Item item = new Item();
		
		System.out.println("Please enter item ID");
		String item_ID = sc.nextLine();
		item.setProduct_ID(item_ID);
				
		System.out.println("Please enter item name");
		String item_Name = sc.nextLine();
		item.setProduct_Name(item_Name);
		
		System.out.println("Please enter quantity of item in stock");
		int item_stock = Integer.parseInt(sc.nextLine());
		item.setProduct_Quantity(item_stock);
		
		System.out.println("Please enter RRP for item");
		double item_price = Double.parseDouble(sc.nextLine());
		item.setProduct_Price(item_price);
		
		return item;
	}
	
	public static Customer ScanCustomer(){
		
		Customer customer = new Customer();
		System.out.println("Please enter item ID");
		String Customer_Number = sc.nextLine();
		customer.setCustomer_Number(Customer_Number);
				
		System.out.println("Please enter item name");
		String Customer_Name = sc.nextLine();
		customer.setCustomer_Name(Customer_Name);
		
		System.out.println("Please enter quantity of item in stock");
		String Customer_Address = sc.nextLine();
		customer.setCustomer_Address(Customer_Address);
		
		System.out.println("Please enter price for item");
		String Customer_Postcode= sc.nextLine();
		customer.setCustomer_Postcode(Customer_Postcode);
		
		return customer;
	}
	
//	public static void PurchaseItem(){
//		
//		System.out.println("Enter Purchase ID");
//		int Purchase_id =(scan.nextInt());
//		
//		System.out.println("Enter Product ID");
//		int Prodct_id = (scan.nextInt());
//		
//		System.out.println("Enter Customer Number");
//		String Customer_number = (scan.nextLine());
//		
//		System.out.println("Enter Product Price");
//		double Product_Price = Double.parseDouble (scan.nextLine());
//		
//		System.out.println("Enter Subtotal");
//		double Subtotal = Double.parseDouble(scan.nextLine());
//		
//		System.out.println("Enter Purchase Quantity");
//		int Purcase_Quantity = (scan.nextInt());
//				
//}

}
