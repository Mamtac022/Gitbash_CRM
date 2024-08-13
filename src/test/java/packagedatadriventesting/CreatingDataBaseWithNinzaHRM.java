package packagedatadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class CreatingDataBaseWithNinzaHRM 
{

	public static void main(String[] args) throws Throwable 
	{
		Driver driver = new Driver();
		
		DriverManager.registerDriver(driver);
		
		Connection con =DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333","root@%","root");
		
		Statement stat =con.createStatement();
		ResultSet res =stat.executeQuery("Select * from projects");
		{
			System.out.println("execution successful");
		}
		con.close();
		
	}

}
