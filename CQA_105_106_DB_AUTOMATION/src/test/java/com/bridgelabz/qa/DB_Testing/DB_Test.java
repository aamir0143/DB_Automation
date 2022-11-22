package com.bridgelabz.qa.DB_Testing;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DB_Test extends Base{
	@Test
	public void getTableData() throws SQLException {
		con=this.setUp();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select *  from emp");
		// While Loop to iterate through all data and print results		
		while (rs.next()){
	        		int ID = rs.getInt(1);								        
                    String Name = rs.getString(2);
                    int Age = rs.getInt(3);
                    String City = rs.getString(4);
                    System. out.println(ID+" "+Name+" "+Age+" "+City);
		}
	}	
	
	//Inserting Method
	@Test
	public void insertData() throws SQLException {
		con=this.setUp();
		PreparedStatement stmt = con.prepareStatement("insert into emp(ID,Name,Age,City) values(?,?,?,?)");
		stmt.setInt(1,4);
		stmt.setString(2, "Aamir");
		stmt.setInt(3, 25);
		stmt.setString(4, "Bangalore");
		stmt.executeUpdate();
		getTableData();
	}
	
	//Updating Method
	@Test
	public void updateData() throws SQLException {
		con=this.setUp();
		PreparedStatement stmt = con.prepareStatement("update emp set Name='Aamir1'  where ID=4 ");
		stmt.executeUpdate();
		getTableData();
	}
	
	//Deleting Method
	@Test
	public void deleteData() throws SQLException {
		con=this.setUp();
		PreparedStatement stmt = con.prepareStatement("delete from emp where ID=5 ");
		stmt.executeUpdate();
		getTableData();
	}
}
