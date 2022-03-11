package shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class connection {

	public Connection getConnection()throws SQLException,ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		java.sql.Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping", "ahalya", "Root@123ahalya");
		if(con!=null) {
			return(Connection)con;
		}else {
		
		return null;}
		
	}
	
	
	
}
