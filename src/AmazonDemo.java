import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AmazonDemo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Connection string
		String dburl = "jdbc:mysql://localhost:3306/Amazon"; 
		
		//Entering DB Credentials
		String username="root";
		String password = "mysql";
		
		//Mysql query for selecting every record from Product table
		String query = "Select * from Product";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		Connection con = DriverManager.getConnection(dburl,username,password); 
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
	    
		//Iterating through every product that product table contains
		while(rs.next()) {
			System.out.print("Brand: " + rs.getString("Brand") + "\t");
			System.out.print("ModelName: " + rs.getString("ModelName") + "\t");
			System.out.print("Price: " + rs.getString("Price") + "\t");
			System.out.println();
		}
	}

}
