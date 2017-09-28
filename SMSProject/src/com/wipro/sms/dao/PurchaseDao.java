package com.wipro.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.wipro.sms.bean.Purchase;
import com.wipro.sms.util.DBUtil;

// Insert (DONE)
// DeleteByCustomer
// DeleteByPurchase


public class PurchaseDao {
	
	Connection con= DBUtil.con;
	
	public boolean insertPurchase (Purchase p){
		try {
			String sql = "INSERT INTO Purchase VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, p.getPurchase_ID());
			pst.setString(2, p.getProduct_ID());
			pst.setString(3, p.getCustomer_Number());
			pst.setDouble(4, p.getProduct_Price());
			pst.setDouble(6,(p.getProduct_Price()*p.getPurchase_Quantity()));
			pst.setInt(5, p.getPurchase_Quantity());
			
			int count = pst.executeUpdate();
			
			if (count == 1) {
				return true;
			}
			
			else {
				return false;
			}
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteByCustomer(String Customer_Number) {
		try {
			String sql = "DELETE FROM Purchase WHERE Customer_Number = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, Customer_Number);
		
			int count = pst.executeUpdate();
		
			if (count == 1) {
				return true;
			}
		
			else {
				return false;
			}
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
	}
	public boolean deleteByPurchase(String Purchase_ID) {
		try {
			String sql = "DELETE FROM Purchase WHERE Purchase_ID = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, Purchase_ID);
		
			int count = pst.executeUpdate();
		
			if (count == 1) {
				return true;
			}
		
			else {
				return false;
			}
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
	}
	
	
	

}
