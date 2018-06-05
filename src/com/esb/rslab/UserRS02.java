package com.esb.rslab;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/users02")
public class UserRS02
{
	@GET
	@Path("/WebUpdate/{ID}/{Money}/{NO}")
	public String sayHello2(@PathParam("ID") String ID,@PathParam("Money") String Money,@PathParam("NO") String NO) 
	{
		try {
			Connection connection;
			connection = Conn.connDB();
			
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			statement.executeUpdate("UPDATE fxdb.WORK_FINAL_FYD set USER_ID = '" + ID +"' , USER_MONEY = '" + Money +"' where USER_NO = '" + NO +"'");

			connection.close();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Sucess!Update NO."+NO+" deal,and your ID: "+ID + " ,and save money:$ " + Money;
	}
		
	
}
