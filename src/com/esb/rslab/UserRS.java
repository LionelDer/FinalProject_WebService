package com.esb.rslab;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/users")
public class UserRS
{
	@GET
	@Path("/WebInsert/{ID}/{Money}")
	public String sayHello(@PathParam("ID") String ID,@PathParam("Money") String Money) 
	{
		
		try 
		{	
			System.out.println("!!in web!!!!"+ID+", "+Money);
			
			Connection connection;
			connection = Conn.connDB();
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			statement.executeUpdate("INSERT INTO fxdb.WORK_FINAL_FYD VALUES(default,'" + ID + "','"+ Money + "')");
			connection.close();
			System.out.println("!!!!!!in web!!!!!!!!!!!!"+ID+", "+Money);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Sucess,your ID: "+ID + " ,and save money:$ " + Money;
	}
}
