package packagedatadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleUnitTest 
{
	@Test
	public void projectCheckTest() throws Throwable {
		
	
		String expectedProjectName="Emp01";
		boolean flag=false;

	// Step1: load and register the database driver
			Driver driveRef = new Driver();
			DriverManager.registerDriver(driveRef);
			
			//Step2: connect to the database
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/vitegar","root" ,"root");
			
			
			   
	        // Step3:  create sql statement
			Statement stat = conn.createStatement();
			
			//Step4: execute a querry
			ResultSet resultset = stat.executeQuery("select * from VitegarData");
			while(resultset.next()) {
				String actProjectName = resultset.getString(1);
				if(expectedProjectName.equals(actProjectName)) {
					flag=true;
					System.out.println("pass");
				}
				if(flag==false)
				{
					System.out.println("fail");
					Assert.fail();
					  
				}
				
			}
			
			
			/*int result =stat.executeUpdate("insert into VitegarData values('Emp05','Vikram',45678)");
			System.out.println(result);
			*/
			conn.close();
	}
	
}
