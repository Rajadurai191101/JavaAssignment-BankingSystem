package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.entity.Account;
import com.hexaware.entity.Customer;
import com.hexaware.util.DBUtil;

public class AccountDao {
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	
	public void createAccount(Account acc) {
		con = DBUtil.getDBConn();
		
		try {
			ps = con.prepareStatement("insert into Account"+
			"(customerId,accountNumber,accountType,accountBalance)"+
					"values(?,?,?,?)");
			ps.setInt(1, acc.getCustomerId());
			ps.setLong(2, acc.getAccountNumber());
			ps.setString(3, acc.getAccountType());
			ps.setDouble(4, acc.getAccountBalance());
			int rows = ps.executeUpdate();
			System.out.println(rows+" row added successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}