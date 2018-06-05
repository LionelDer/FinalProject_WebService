package com.esb.rslab;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/users03")
public class UserRS03
{
	@GET
	@Path("/WebDelete/{NO}")
	public String sayHello3(@PathParam("ID") String ID,@PathParam("Money") String Money,@PathParam("NO") String NO) 
	{
		try {
			Connection connection;
			connection = Conn.connDB();
			
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String SELECT = "SELECT* from fxdb.WORK_FINAL_FYD where USER_NO = '" + NO +"'";
			ResultSet resultSet = statement.executeQuery(SELECT);
			
			while (resultSet.next()) {
				resultSet.deleteRow();
			}
			connection.close();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Sucess!Delete NO."+NO+" deal";
	}
		
	
}
