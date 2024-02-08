package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.entity.Customer;
import com.hexaware.util.DBUtil;

public class CustomerDao {
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	
	public void createCustomer(Customer cust) {
		con = DBUtil.getDBConn();
		try {
			ps=con.prepareStatement("INSERT INTO  Customer "+
			"(customerId,firstName,lastName,emailAddress,phoneNumber,address)"+
					"values(?,?,?,?,?,?)");
			ps.setInt(1, cust.getCustomerId());
			ps.setString(2, cust.getFirstName());
			ps.setString(3, cust.getLastName());
			ps.setString(4, cust.getEmailAddress());
			ps.setString(5, cust.getPhoneNumber());
			ps.setString(6, cust.getAddress());
			int rows = ps.executeUpdate();
			System.out.println(rows+"rows inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void viewCustomerDetails() {
		con=DBUtil.getDBConn();
		try {
			ps = con.prepareStatement("select * from Customer where customerId=?");
			ps.setInt(1, 2);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getString(6));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
