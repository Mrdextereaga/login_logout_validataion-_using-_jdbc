import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {

	public static void main(String[] args)  {
		
   try { 
	   Class.forName("com.mysql.cj.jdbc.Driver");
	     DriverManager.getConnection("jdbc:mysql://localhost:3306:user_db","root","admin");
   }
    catch(ClassNotFoundException e) {
    	e.printStackTrace();
    } catch (SQLException e) {
	
		e.printStackTrace();
	}
	}

}
