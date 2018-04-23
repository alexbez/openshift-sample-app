package com.openshift.hcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;


public class DBAccountNumberGenerator extends AccountNumberGenerator {

	private static final long serialVersionUID = 4134149485208505751L;
	private static final Logger LOGGER = Logger.getLogger( "DBAccountNumberGenerator" );
	@Override
	public String[] generateAccountNumbers() {
	int num_acc = 0;
	LOGGER.log(Level.INFO, "Entering generateAccountNumbers()...");
	ArrayList<String> list = new ArrayList<String>();
	try {
			String databaseURL = "jdbc:postgresql://";
			databaseURL += System.getenv("POSTGRESQL_SERVICE_HOST");
			databaseURL += "/" + System.getenv("POSTGRESQL_DATABASE");
			String username = System.getenv("POSTGRESQL_USER");
			String password = System.getenv("PGPASSWORD");
			Class.forName("org.postgresql.Driver"); 			
			Connection connection = DriverManager.getConnection(databaseURL, username, password);
			if (connection != null) {
				LOGGER.log(Level.INFO, "Loading account numbers from the database");
				String SQL = "select a.ac_number as account_number from account a";
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(SQL);
				while (rs.next()) {
					list.add(rs.getString("account_number"));
					num_acc++;
				}
				String snum = "Number of records read: " + Integer.toString(num_acc);
				LOGGER.log(snum);
				rs.close();
				connection.close();
			} else
				LOGGER.log(Level.SEVERE, "Could not connect to the database.");
	} catch (Exception e) {
		LOGGER.log(Level.SEVERE, e.toString(), e);
		System.out.println("Database connection problem!");
	}
	return list.toArray(new String[list.size()]);	  
}

}
