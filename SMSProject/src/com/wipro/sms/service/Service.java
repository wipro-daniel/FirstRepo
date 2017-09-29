package com.wipro.sms.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.wipro.sms.bean.Customer;
import com.wipro.sms.bean.Item;
import com.wipro.sms.bean.Purchase;
import com.wipro.sms.dao.CreateDatabase;
import com.wipro.sms.dao.CustomerDao;
import com.wipro.sms.dao.DropTables;
import com.wipro.sms.dao.ItemDao;
import com.wipro.sms.dao.PurchaseDao;
import com.wipro.sms.util.DBUtil;

public class Service {

	public static void main(String[] args) {
			
		// Creates a connection
		DBUtil.getConnection();
		SMSInterface.menu();
//		
		// Creates a create object
		CreateDatabase cdb = new CreateDatabase();
		// Customer Database object
		CustomerDao cd = new CustomerDao();
		ItemDao id = new ItemDao();
		PurchaseDao pd = new PurchaseDao();
		// Created a demo objects for testing
		Customer vincent = new Customer("07834226811","John Baron", "2 dss Close", "RH13 5lP");
		Item curry = new Item("Burnt",100,10.01);
		Purchase thur01 = new Purchase("02","curry101","07834226811",3.20,10);
		DropTables drop = new DropTables();
		
		

		//cd.insertCustomer(vincent);
		
		
//		drop.dropCustomer();
//		drop.dropInventory();
//		drop.dropPurchase();
//		
//		
//		
// ----------- Creates the databases if not doneso already	
//		if(cdb.createCustomerData())
//		{
//			System.out.println("Customer Data Created");
//		}
//		if(cdb.createInventory())
//		{
//			System.out.println("Inventory Created");
//		}
//
//		if(cdb.createPurchase())
//		{
//			System.out.println("Inventory Created");
//		}

//		if(cdb.createInventoryIncrement())
//		{
//			System.out.println("Create Inventory Increment");
//		}
//		if(cdb.createPurchaseIncrement())
//		{
//			System.out.println("Create Purchase Increment");
//		}
//		cdb.createInvTrigger();
//		
//		 ---- TESTED
		
//		cd.readCustomer();
//		cd.updateAddress();
//		cd.readCustomer();
//		cd.updateName();
//		cd.deleteCustomer();
		
		// ------- TESTED
	//	id.insertItem(curry);
		//id.deleteItem();
		//id.updateQuantity();
		//id.updateName();
		
		//pd.insertPurchase(thur01);
		//pd.deleteByCustomer("07834226811");
		
		
	}
		
}
