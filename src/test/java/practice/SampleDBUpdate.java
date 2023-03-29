package practice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleDBUpdate {

	public static void main(String[] args) throws Exception {
		
		Connection c = null;
		try 
		{
			Driver d = new Driver();
		
			DriverManager.registerDriver(d);
			
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3","root","ROOT");
		
			Statement s = c.createStatement();
		
			String query = "insert into data values('Chandu',006,'Kakinada');";
			int result = s.executeUpdate(query);
			if(result>=1) {
				System.out.println("data added");
			}
			ResultSet res = s.executeQuery("select * from data;");
			while(res.next()) {
				System.out.println(res.getString(1)+"\t"+res.getInt(2)+"\t"+res.getString(3));
			}
		}
		catch (Exception e){
			
		}
		finally {
			c.close();
		}
	}

}
