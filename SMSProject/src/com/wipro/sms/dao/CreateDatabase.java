package com.wipro.sms.dao;

import java.sql.*;
import com.wipro.sms.util.DBUtil;

public class CreateDatabase{
	
	Connection con = DBUtil.con;	
	// Creates the inventory table
	public boolean createInventory()
	{
		try {
				
			    String sql = "CREATE TABLE Inventory "
                     + "("
                     + "Product_ID varchar(10) NOT NULL,"
                     + "Product_Name varchar(20) NOT NULL,"
                     + "Product_Quantity NUMBER CHECK (Product_Quantity>=0),"
                     + "Product_Price NUMBER NOT NULL,"
                     + "CONSTRAINT Product_PK PRIMARY KEY (Product_ID)"
                     + ")";
				PreparedStatement pst=con.prepareStatement(sql);		
				int complete = pst.executeUpdate();			
				if (complete == 1)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}
	}

	public boolean createCustomerData()
	{
		try {
			//Connection con= DBUtil.getConnection();
			String sql="CREATE TABLE Customer_Data"
                    + "("
                    + "Customer_Number VARCHAR(11) NOT NULL,"
                    + "Customer_Name VARCHAR(255) NOT NULL,"
                    + "Customer_Address VARCHAR(255) NOT NULL,"
                    + "Customer_PostCode VARCHAR(8) NOT NULL,"
                    + "CONSTRAINT Customer_PK PRIMARY KEY (Customer_Number)"
                    + ")";
			PreparedStatement pst=con.prepareStatement(sql);		
			int complete = pst.executeUpdate();			
			if (complete == 1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
	}
	
	// Creates the Purchase database table
	public boolean createPurchase()
	{
		try {
			
		  String sql="CREATE TABLE Purchase"
                    + "("
                    + "Purchase_ID VARCHAR(255) NOT NULL,"
                    + "Product_ID VARCHAR(255) NOT NULL,"
                    + "Customer_Number VARCHAR(11) NOT NULL,"
                    + "Product_Price NUMBER(6,2) NOT NULL,"
                    + "Purchase_Quantity NUMBER NOT NULL,"
                    + "Sub_total NUMBER(6,2) NOT NULL,"
                    + "CONSTRAINT FK_Inventory FOREIGN KEY (Product_ID) REFERENCES Inventory(Product_ID),"
                    + "CONSTRAINT FK_Customer FOREIGN KEY (Customer_Number) REFERENCES Customer_Data(Customer_Number)"
                    + ")";
			
			PreparedStatement pst=con.prepareStatement(sql);		
			int complete = pst.executeUpdate();
			
			if (complete == 1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
	}
	
	/*
	 * CREATE SEQUENCE Inventory_Sequence START WITH 1
INCREMENT BY 1
MINVALUE 1
NOMAXVALUE;
CREATE SEQUENCE Purchase_Sequence START WITH !
INCREMENT BY 1
MINVALUE 1
NOMAXVALUE;
	 */
	
	// Uncomment if needed - Creates a list of purchasers
//	public boolean createPurchaseList()
//	{
//		try {
//			String sql="CREATE TABLE purchaseList( "
//					+ "Purchase_ID VARCHAR(255) NOT NULL FOREIGN KEY REFERENCES Purchase(Purchase_ID), "
//					+ "Customer_Number VARCHAR(11) NOT NULL FOREIGN KEY( REFERENCES CustomerData(Customer_Number)))";
//			PreparedStatement pst=con.prepareStatement(sql);		
//			int complete = pst.executeUpdate();
//			
//			if (complete == 1)
//			{
//				return true;
//			}
//			else
//			{
//				return false;
//			}
//		}
//		catch (SQLException e1) {
//			e1.printStackTrace();
//			return false;
//		}
//	}
	
	public boolean createInventoryIncrement()
	{
		try {
			String sql="CREATE SEQUENCE Inventory_Sequence "
					+ "START WITH 0 "
					+ "INCREMENT BY 1 "
					+ "MINVALUE 1 "
					+ "NOMAXVALUE";
		
			PreparedStatement pst=con.prepareStatement(sql);		
			int complete = pst.executeUpdate();
			
			if (complete == 1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
	}
	
	public boolean createPurchaseIncrement()
	{
		try {
			String sql="CREATE SEQUENCE Purchase_Sequence "
					+ "START WITH 0 "
					+ "INCREMENT BY 1 "
					+ "MINVALUE 1 "
					+ "NOMAXVALUE";
	
			PreparedStatement pst=con.prepareStatement(sql);		
			int complete = pst.executeUpdate();
			
			if (complete == 1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
	}
	
	public boolean createInvTrigger()
	{
		try
		{
			String sql = "CREATE TRIGGER inv_trigger "
					+ "BEFORE insert on Inventory "
					+ "referenceing new as new "
					+ "FOR EACH ROW "
					+ "BEGIN "
					+ "SELECT inventory_sequence.nextval INTO :new.Product_ID FROM dual";
		//			+ ";"
//					+ "end;"
//					+ "/";
			
			PreparedStatement pst=con.prepareStatement(sql);		
			int complete = pst.executeUpdate();
			
			if (complete == 1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (SQLException e1) 
		{
			e1.printStackTrace();
			return false;
		}
	}

}
