package com.wipro.sms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wipro.sms.util.DBUtil;

public class KeyDao {
	
	
	
	public static int counter = 0;
	public static int itemCounter = 0;
	public static String createKey()
	{
		Connection con= DBUtil.con;
		
		if(counter == 0)
		{
			try {
				Statement st=con.createStatement();


				// Changed is to =
				String sql="SELECT PURCHASE_ID FROM (SELECT * FROM purchase ORDER BY PURCHASE_ID DESC) WHERE ROWNUM = 1";
				ResultSet rs=st.executeQuery(sql);
				boolean flag=false;
				while (rs.next())
				{
					flag=true;
					counter = Integer.parseInt(rs.getString(1));
					System.out.println("COunter = " +counter);
					counter++;
					return Integer.toString(counter);
				}				
				if (!flag)
				{
					System.out.println("Database empty");
					return "0";
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			  catch (NumberFormatException e)
			{
				System.out.println("ID is not an INT Number Format Exception");
			}

			
		}		
		counter++;
		return Integer.toString(counter);

	}
	
	public static String createItemKey()
	{
		Connection con= DBUtil.con;
		
		if(itemCounter == 0)
		{
			try {
				Statement st=con.createStatement();

				String sql="SELECT PRODUCT_ID FROM (SELECT * FROM INVENTORY ORDER BY PRODUCT_ID DESC) WHERE ROWNUM = 1";
				ResultSet rs=st.executeQuery(sql);
				boolean flag=false;
				while (rs.next())
				{
					flag=true;
					itemCounter = Integer.parseInt(rs.getString(1));
					System.out.println("COunter = " +itemCounter);
					itemCounter++;
					return Integer.toString(itemCounter);
				}				
				if (!flag)
				{
					System.out.println("Database empty");
					return "0";
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			  catch (NumberFormatException e)
			{
				System.out.println("ID is not an INT Number Format Exception");
			}

			
		}		
		itemCounter++;
		return Integer.toString(itemCounter);

	}

}
