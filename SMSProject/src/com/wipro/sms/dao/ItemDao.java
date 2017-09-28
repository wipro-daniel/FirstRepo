package com.wipro.sms.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.wipro.sms.util.DBUtil;
import com.wipro.sms.bean.Item;

// Insert Item (DONE)
// DELETE ITEM (DONE)
// UPDATE QUANTITY (DONE)
// UPDATE NAME (DONE)
// TODO : SELECTITEM
public class ItemDao {
	
	Connection con= DBUtil.con;
	
	public boolean insertItem(Item i){
		   
		try {
				String sql="INSERT INTO Inventory values(?,?,?,?)";
				PreparedStatement pst=con.prepareStatement(sql);
				pst.setString(1,i.getProduct_ID());
				pst.setString(2,i.getProduct_Name());
				pst.setInt(3,i.getProduct_Quantity());
				pst.setDouble(4,i.getProduct_Price());
				
				
				int count=pst.executeUpdate();
				
				if (count==1)
				{
					System.out.println("Element inserted");
					return true;
				}
				else
					return false;
				
			} catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}
	}
	
	public boolean deleteItem(){
		
		Scanner scan=new Scanner(System.in);
		try {
			Statement st=con.createStatement();
			System.out.println("Enter Product_ID to be deleted");
			String Product_ID=scan.nextLine();
			String sql="DELETE FROM Inventory WHERE Product_ID = '"+ Product_ID + "'";
			System.out.println(sql);
			int count=st.executeUpdate(sql);
			
			if (count==1)
			{
				System.out.println("Item deleted");
				return true;
			}
			else
			{
				System.out.println("Item not deleted");
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally
		{
			scan.close();
		}
	}
	
	// Do we want to ask for the name of a product or the ID? 
	public boolean updateQuantity(){		
		Scanner scan=new Scanner(System.in);		
		try {
			Statement st=con.createStatement();
			System.out.println("Enter Product ID");
			String Product_ID = scan.nextLine();
			System.out.println("Enter new quantity");
			int Product_Quantity=scan.nextInt();
			String sql="UPDATE Inventory SET Product_Quantity="+Product_Quantity+" WHERE Product_ID= '"+Product_ID+"'";
			//UPDATE Item SET Product_Quantity= '1' WHERE Product_ID = 'S256';
			System.out.println(sql);
			int count=st.executeUpdate(sql);
			
			if (count==1)
			{
				System.out.println("Quantity Updated");
				return true;
			}
			else
			{
				System.out.println("Quantity not Updated");
				return false;
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally
		{
			scan.close();
		}
	}
	
	public boolean updateName(){
		
		Scanner scan=new Scanner(System.in);
		try {
			Statement st=con.createStatement();
			
			System.out.println("Enter Product ID");
			String Product_ID = scan.nextLine();
			System.out.println("Enter new name");
			String Product_Name=scan.nextLine();
			String sql="UPDATE Inventory SET Product_Name='"+Product_Name+"' WHERE Product_ID='"+Product_ID + "'";
			System.out.println(sql);
			int count=st.executeUpdate(sql);
			
			if (count==1)
			{
				System.out.println("Name Updated");
				return true;
			}
			else
			{
				System.out.println("Name not Updated");
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally
		{
			scan.close();
		}
	}

	
}
