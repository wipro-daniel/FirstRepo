package com.wipro.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.wipro.sms.util.DBUtil;

public class DropTables {
	
	Connection con= DBUtil.con;
	
	public boolean dropInventory()
	{
		try {
				
				String sql="DROP TABLE Inventory";
				PreparedStatement pst=con.prepareStatement(sql);		
				int complete = pst.executeUpdate();			
				if (complete == 1)
				{
					System.out.println("Inventory table dropped");
					return true;
				}
				else
				{
					System.out.println("Drop failed");
					return false;
				}
			}
		catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}
	}
	
	public boolean dropCustomer()
	{
		try {
				
				String sql="DROP TABLE Customer_Data";
				PreparedStatement pst=con.prepareStatement(sql);		
				int complete = pst.executeUpdate();			
				if (complete == 1)
				{
					System.out.println("Customer table dropped");
					return true;
				}
				else
				{
					System.out.println("Drop failed");
					return false;
				}
			}
		catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}
	}
	
	public boolean dropPurchase()
	{
		try {
				
				String sql="DROP TABLE Purchase";
				PreparedStatement pst=con.prepareStatement(sql);		
				int complete = pst.executeUpdate();			
				if (complete == 1)
				{
					System.out.println("Purchase table dropped");
					return true;
				}
				else
				{
					System.out.println("Drop failed");
					return false;
				}
			}
		catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}
	}

}
