package com.esb.mysql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.esb.rslab.Conn;


public class CrateTable
{

	public static void main(String[] args)
	{

		String CREATE_WORK_FINAL_FYD = "create table fxdb.WORK_FINAL_FYD (USER_NO integer not null generated always as identity "
				+ "(start with 1, increment by 1), USER_ID varchar(1000) not null, USER_MONEY varchar(100) not null)";
		Connection connection;
		connection = Conn.connDB();

		try
		{

			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			int result_WORK_FINAL_FYD = statement.executeUpdate(CREATE_WORK_FINAL_FYD);
			System.out.println(result_WORK_FINAL_FYD + ",WORK_FINAL_FYD table is created");

			connection.close();

		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}