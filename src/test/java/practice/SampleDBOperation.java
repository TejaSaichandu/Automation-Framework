package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.cj.jdbc.Driver;

public class SampleDBOperation {

	public static void main(String[] args) throws Exception {
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3","root","ROOT");
		java.sql.Statement s = c.createStatement();
		ResultSet r = s.executeQuery("select * from data;");
		while(r.next()) {
			System.out.println(r.getString(1)+"\t"+r.getInt(2)+"\t"+r.getString(3));
		}
		c.close();
	}
}
