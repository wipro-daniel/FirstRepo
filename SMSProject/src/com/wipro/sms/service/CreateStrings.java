package com.wipro.sms.service;
import java.util.Scanner;

import com.wipro.sms.bean.Customer;
import com.wipro.sms.bean.Item;
import com.wipro.sms.bean.Purchase;
import com.wipro.sms.dao.KeyDao;
public class CreateStrings {
	
	
	
	public static Item ScanItem(){
		Scanner sc = new Scanner(System.in);
		Item item = new Item();
		item.setProduct_ID(KeyDao.createItemKey());
				
		System.out.println("Please enter item name");
		String item_Name = sc.nextLine();
		item.setProduct_Name(item_Name);
		
		System.out.println("Please enter quantity of item in stock");
		int item_stock = Integer.parseInt(sc.nextLine());
		item.setProduct_Quantity(item_stock);
		
		System.out.println("Please enter RRP for item");
		double item_price = Double.parseDouble(sc.nextLine());
		item.setProduct_Price(item_price);
		//sc.close();
		return item;
	}
	
	public static Customer ScanCustomer(){
		Scanner sc = new Scanner(System.in);
		Customer customer = new Customer();
		System.out.println("Please enter Customer number");
		String Customer_Number = sc.nextLine();
		customer.setCustomer_Number(Customer_Number);
				
		System.out.println("Please enter Customer name");
		String Customer_Name = sc.nextLine();
		customer.setCustomer_Name(Customer_Name);
		
		System.out.println("Please enter Customer Address");
		String Customer_Address = sc.nextLine();
		customer.setCustomer_Address(Customer_Address);
		
		System.out.println("Please enter postcode");
		String Customer_Postcode= sc.nextLine();
		customer.setCustomer_Postcode(Customer_Postcode);
		//sc.close();
		return customer;
	}
	
	public static Purchase scanPurchase(String key){
		Scanner sc = new Scanner(System.in);
		Purchase purchase = new Purchase();
		purchase.setPurchase_ID(key);

		
		System.out.println("Enter Product ID");
		String Product_id = (sc.nextLine());
		purchase.setProduct_ID(Product_id);
		
		System.out.println("Enter Customer Number");
		String Customer_number = (sc.nextLine());
		purchase.setCustomer_Number(Customer_number);
		
		System.out.println("Enter Product Price");
		double Product_Price = Double.parseDouble (sc.nextLine());
		purchase.setProduct_Price(Product_Price);
		
		
		System.out.println("Enter Purchase Quantity");
		int Purcase_Quantity = (sc.nextInt());
		purchase.setPurchase_Quantity(Purcase_Quantity);
		//sc.close();
		return purchase;
				
	}
	
	public static String scanNumber()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Customer Number");
		String Customer_number =(sc.nextLine());
		//sc.close();
		return Customer_number;
	}
	
	public static String scanPurchaseID()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Purchase ID");
		String Purchase_ID =(sc.nextLine());
		//sc.close();
		return Purchase_ID;
	}
	public static String scanItemID()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Item ID");
		String Item_ID =(sc.nextLine());
		//sc.close();
		return Item_ID;
	}
	
	public static String scanItemName()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter new name");
		String Product_Name=sc.nextLine();
		return Product_Name;
	}

	public static int scanItemQuantity() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter new quantity");
		int Product_Quantity=sc.nextInt();
		return Product_Quantity;
	}
	

}
