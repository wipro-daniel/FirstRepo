package com.wipro.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wipro.sms.bean.Purchase;
import com.wipro.sms.service.CreateStrings;
import com.wipro.sms.util.DBUtil;

// Insert (DONE)
// DeleteByCustomer
// DeleteByPurchase(DONE)


public class PurchaseDao {
	
	Connection con= DBUtil.con;
	
	public boolean insertPurchase (Purchase p) {
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
			
			ItemDao.updateStock((p.getPurchase_Quantity()*-1),p.getProduct_ID());
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
	
	public boolean readPurchase(String number) {
        // SELECT * FROM Purchase WHERE Customer_Number = x
        Connection con = DBUtil.getConnection();
        try {
	        Statement st=con.createStatement();
	        String sql = "SELECT * FROM Purchase WHERE Customer_Number =" + number;
			ResultSet rs=st.executeQuery(sql);
			boolean flag=false;
			double total = 0.0;
			while (rs.next()) {
	             flag = true;
	             total = total + rs.getDouble(6);
	             System.out.println("Purchase ID: " + rs.getString(1));
	             System.out.println("Product ID: " + rs.getString(2));
	             System.out.println("Customer Number: " + rs.getString(3));
	             System.out.println("Product Price: " + rs.getDouble(4));
	             System.out.println("Subtotal: " + rs.getDouble(6));
	             System.out.println("Purchase Quantity: " + rs.getInt(5));                
	         }
			 System.out.println(total);
			
			if (!flag)
			{
				System.out.println("Record not found");
				return false;
			}
			else
			{
				return true;
			}
	} catch (SQLException e) {
		e.printStackTrace();
		return true;
	}
    }
	
	public boolean readPurchaseByPurchaseId(String productID) {

        Connection con = DBUtil.getConnection();
        try {
	        Statement st=con.createStatement();
	        String sql = "SELECT * FROM Purchase WHERE Purchase_ID =" + productID;
			ResultSet rs=st.executeQuery(sql);
			boolean flag=false;
			double total = 0.0;
			while (rs.next()) {
	             flag = true;
	             total = total + rs.getDouble(6);
	             System.out.println("Purchase ID: " + rs.getString(1));
	             System.out.println("Product ID: " + rs.getString(2));
	             System.out.println("Customer Number: " + rs.getString(3));
	             System.out.println("Product Price: " + rs.getDouble(4));
	             System.out.println("Subtotal: " + rs.getDouble(6));
	             System.out.println("Purchase Quantity: " + rs.getInt(5));                
	         }
			 System.out.println(total);
			
			if (!flag)
			{
				System.out.println("Record not found");
				return false;
			}
			else
			{
				return true;
			}
	} catch (SQLException e) {
		e.printStackTrace();
		return true;
	}
    }
	
	 public boolean updateQuantity(){          
	        try {
	            Statement st = con.createStatement();
	            String Product_ID = CreateStrings.scanItemID();
	            int Purchase_Quantity = CreateStrings.scanItemQuantity();
	            
	            String sql = "UPDATE Purchase SET Purchase_Quantity = " + Purchase_Quantity + " WHERE Product_ID = '" + Product_ID + "'";
	            // UPDATE Purchase SET Product_Quantity= '1' WHERE Product_ID = 'S256';
	            System.out.println(sql);
	            int count = st.executeUpdate(sql);
	            
	            if (count == 1) {
	                System.out.println("Quantity updated.");
	                return true;
	            }
	            else {
	                System.out.println("Quantity not updated.");
	                return false;
	            }           
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	 }
	
//	public boolean ArrayList<Purchase> selectAll() {
//		// SELECT ALL statement
//		ArrayList<Purchase> list = new ArrayList<Purchase>();
//		try {
//			// Statement st = con.createStatement();
//			Connection con = DBUtil.getConnection();
//			String sql = "SELECT * FROM Purchase";
//			PreparedStatement pst = con.prepareStatement(sql);
//			ResultSet rs = pst.executeQuery();
//	
//			while(rs.next()) {
//				Purchase bean = new Purchase();
//				bean.setInt(rs.getInt("Purchase_ID"));
//				bean.setInt(rs.getInt("Product_ID"));
//				bean.setString(rs.getString("Customer_Number"));
//				bean.setDouble(rs.getDouble("Product_Price"));
//				bean.setDouble(rs.getDouble("Sub_total"));
//				bean.setInt(rs.getInt("Purchase_Quantity"));
//				list.add(bean);
//			}
//		}
//		
//		catch (SQLException e1) {
//			e1.printStackTrace();
//			return null;
//		}
//		return list;
//	}
}
