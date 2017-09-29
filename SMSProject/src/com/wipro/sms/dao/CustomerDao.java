package com.wipro.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.Statement;
import java.util.Scanner;

import com.wipro.sms.bean.Customer;
import com.wipro.sms.util.DBUtil;

// Insert Customer (DONE)
//Update Address (DONE)
//UPDATE Postcode (DONE)
//UPDATE NAME (DONE)
// DeleteCustomer (DONE)
//readCUSTOMER (DONE)


public class CustomerDao {
	
	Connection con= DBUtil.con;
	
	public boolean insertCustomer(Customer c){
		   
		try {
				
				String sql="INSERT into Customer_Data values(?,?,?,?)";
				PreparedStatement pst=con.prepareStatement(sql);
				pst.setString(1,c.getCustomer_Number());
				pst.setString(2,c.getCustomer_Name());
				pst.setString(3,c.getCustomer_Address());
				pst.setString(4,c.getCustomer_Postcode());
				
				int count=pst.executeUpdate();
				
				if (count==1)
					return true;
				else
					return false;
				
			} catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}
	}
	
	public boolean updateAddress(){
		
		
		//Create a Statement Object
		Scanner scan=new Scanner(System.in);
		
		try {
			
			
			Statement st=con.createStatement();
			System.out.println("Enter customer number to be updated");
			String number=scan.nextLine();
			System.out.println("Enter new address");
			String address=scan.nextLine();
			String sql="update Customer_Data set Customer_Address='"+address+"' WHERE Customer_Number= "+number;
			System.out.println(sql);
			int count=st.executeUpdate(sql);
			
			if (count==1)
			{
				System.out.println("Record Updated");
				return true;
			}
			else
			{
				System.out.println("Record not updated");
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	public boolean updatePostcode(){
		
		Scanner scan=new Scanner(System.in);
		
		try {
			Statement st=con.createStatement();
			
			System.out.println("Enter customer number to be updated");
			String number=scan.nextLine();
			System.out.println("Enter Postcode to be updated");
			String postcode=scan.nextLine();
			String sql="update Customer_Data set Customer_Postcode='"+postcode+"' where Customer_Number="+number;
			System.out.println(sql);
			int count=st.executeUpdate(sql);
			
			if (count==1)
			{
				System.out.println("Record Updated");
				return true;
			}
			else
			{
				System.out.println("Record not updated");
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean updateName(){
		
		Scanner scan=new Scanner(System.in);
		
		try {
			Statement st=con.createStatement();
			
			System.out.println("Enter customer number to be updated");
			String number=scan.nextLine();
			System.out.println("Enter Name to be updated");
			String name=scan.nextLine();
			String sql="update Customer_Data set Customer_Name='"+name+"' where Customer_Number="+number;
			System.out.println(sql);
			int count=st.executeUpdate(sql);
			
			if (count==1)
			{
				System.out.println("Record Updated");
				return true;
			}
			else
			{
				System.out.println("Record not updated");
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		

	}
	
	public boolean deleteCustomer(String number) {
		
		Scanner scan=new Scanner(System.in);
		
		try {
			Statement st=con.createStatement();
			
//			System.out.println("Enter Customer_Number to be deleted");
//			String number=scan.nextLine();
			String sql="DELETE FROM Customer_Data where Customer_Number="+number;
			System.out.println(sql);
			int count=st.executeUpdate(sql);
			
			if (count==1)
			{
				System.out.println("Record deleted");
				return true;
			}
			else
			{
				System.out.println("Record not deleted");
				return false;
			}
				
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	
	
	public boolean readCustomer(String Customer_Number){
		try {
			Statement st=con.createStatement();
//			Scanner scan=new Scanner(System.in);
//			System.out.println("Enter Customer Number to be read");
//			String Customer_Number=scan.nextLine();

			// Changed is to =
			String sql="SELECT * FROM Customer_Data where Customer_Number ="+Customer_Number;
			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			boolean flag=false;
			while (rs.next())
			{
				flag=true;
				System.out.println("Customer Number: "+rs.getString(1));
				System.out.println("Name: "+rs.getString(2));
				System.out.println("Address: "+rs.getString(3));
				System.out.println("Post code: "+rs.getString(4));
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
