package packagedatadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteSelectQuerytest 
{
	public static void main(String[] args) throws SQLException
	{
		
	

	// Step1: load and register the database driver
			Driver driveRef = new Driver();
			DriverManager.registerDriver(driveRef);
			
			//Step2: connect to the database
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/vitegar","root" ,"root");
			
			
			   
	        // Step3:  create sql statement
			Statement stat = conn.createStatement();
			
			//Step4: execute a querry
			ResultSet resultset = stat.executeQuery("select * from VitegarData");
			while(resultset.next()) 
			{
				System.out.println(resultset.getString(1) +" "+ resultset.getString(2)+ " "+ resultset.getString(3));
				
			}
			
			conn.close();
	}
}
