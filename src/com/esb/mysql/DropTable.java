package com.esb.mysql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.esb.rslab.Conn;



public class DropTable
{

	public static void main(String[] args)
	{

		String DROP_WORK_FINAL_FYD = "drop table fxdb.WORK_FINAL_FYD";
		Connection connection;
		connection = Conn.connDB();
		try
		{
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

			int result_DROP_WORK_FINAL_FYD = statement.executeUpdate(DROP_WORK_FINAL_FYD);
			System.out.println(DROP_WORK_FINAL_FYD+ ",WORK_FYD table dropped...");

			connection.close();

		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}