package SeleniumDB_Integration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadingDataFromMySql {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		//JDBC driver 
		String driver = "com.mysql.cj.jdbc.Driver";		
		//ipAddress
		String host="localhost";		
		//PortNumber
		String port= "3307";			
		//UserName
		String UN = "root";		
		//Password
		String pwd = "Root@321#";

		//Load mysql jdbc driver	
		Class.forName(driver);

		////Create Connection to DB
		//("jjdbc:mysql://" + host + ":" + port + "/selenium_db_integration", "root", "root@321#");");
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" +port+ "/selenium_db_integraton", "root", "Root@321#");
				
		System.out.println("Connection established successfully");

		//Create Statement Object
		Statement st= con.createStatement();

		// Execute the SQL Query. Store results in ResultSet
		ResultSet rs = st.executeQuery("Select * from PrsnInfo;");

		// While Loop to iterate through all data and print results
		while(rs.next()){

			String fName = rs.getString("fisrtName");
			String lName = rs.getString("lastName");
			String age = rs.getString("Age").toString();
			String PrsnID = rs.getString("PsrnId").toString();

			System.out.println("fisrtName" +" == " + fName + " == "+ lName + " == " + age + "==" + PrsnID);				
		}				

		//Closing DB Connecction 
		con.close();
	}
}
