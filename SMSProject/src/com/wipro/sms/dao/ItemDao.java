package com.wipro.sms.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	static Connection con= DBUtil.con;
	
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
	}
	
	public static boolean updateStock(int stock,String Product_ID){		
		Scanner scan=new Scanner(System.in);		
		try {
			
			int previous = getStock(Product_ID);
			
			int newStock = previous + stock;
			
			String sql="UPDATE Inventory SET Product_Quantity="+newStock+" WHERE Product_ID= '"+Product_ID+"'";
			Statement st=con.createStatement();
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
	}
	
	public static int getStock(String productID) {
        try {               
            Statement st = con.createStatement();
            String sql = "SELECT Product_Quantity FROM Inventory WHERE Product_ID = " + productID;
            ResultSet rs=st.executeQuery(sql);
           if(rs.next()){                    
        	   return rs.getInt(1);}
	       else
	        {
	        	return 0;
	        }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
	}
	
	public boolean updateName(String Product_ID,String Product_Name){
		
		Scanner scan=new Scanner(System.in);
		try {
			Statement st=con.createStatement();
			
			
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
	}
	
	public boolean readItem(String Product_ID){
	    
		   try {
		       Statement st=con.createStatement();


		       String sql="SELECT * FROM Inventory where Product_ID ="+Product_ID;
		       System.out.println(sql);
		       ResultSet rs=st.executeQuery(sql);
		       boolean flag=false;
		       while (rs.next())
		       {
		           flag=true;
		           System.out.println("Product_ID: "+rs.getString(2));
		           System.out.println("Product_Name: "+rs.getString(1));
		           System.out.println("Product_Quantity: "+rs.getInt(3));
		           System.out.println("Prouct_Price: "+rs.getDouble(4));
		       }
		       
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
	
	

	
}
