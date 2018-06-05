package com.esb.rslab;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users04")
public class UserRS04
{

	@GET
	public String getUsers(){
		return "test";
	}
	
	@GET
	@Path("/WebSelect")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello3() 
	{
		System.out.println("!!!!userrs04");
		ArrayList<String> dbResult = new ArrayList<>();
		try {
			Connection connection;
			connection = Conn.connDB();
			
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String SELECT = "SELECT * from fxdb.WORK_FINAL_FYD";
			
			ResultSet resultSet = statement.executeQuery(SELECT);
			System.out.println("!!!!userrs04~~");
			while (resultSet.next()) {
				dbResult.add("NO: " + resultSet.getString("USER_NO")+ "  ;ID Card: " 
										+ resultSet.getString("USER_ID")+ "  ;Money: " 
										+ resultSet.getString("USER_MONEY"));
				System.out.println(dbResult.toString());
			}
			System.out.println("!!!!userrs04~");
			connection.close();
			System.out.println("!!!!userrs04");
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("!!!!userrs04~~~~~~~~~~~~~");
		return dbResult.toString();
	}
		
	
}
