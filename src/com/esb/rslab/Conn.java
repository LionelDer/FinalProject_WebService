package com.esb.rslab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conn {
	public static Connection connDB() {
		try {
			String connectionString="jdbc:as400://172.17.214.87;database name=ESBSG3";
			
			String userName="fxdb";
			String password="fx201101db";
			Class.forName("com.ibm.as400.access.AS400JDBCDriver");
			return  DriverManager.getConnection(connectionString,userName,password);
			
			
		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}
		
	}
}
