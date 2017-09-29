package com.wipro.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.wipro.sms.util.DBUtil;

public class PopulateTables {

Connection con = DBUtil.con;
	
	// Populates Inventory - NOT DONE
	public boolean populateInventory()
	{
		try {
				
				String sql="CREATE TABLE Inventory("
						+ "Product_ID varchar(255) NOT NULL PRIMARY KEY,"
						+ "Product_Name varchar(20) NOT NULL,"
						+ "Product_Quantity NUMBER CHECK (Product_Quantity>=0),"
						+ "Product_Price NUMBER NOT NULL)";
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
}
