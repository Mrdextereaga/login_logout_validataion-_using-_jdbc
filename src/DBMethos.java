import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBMethos {

	public static Connection establishConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db","root","admin");
		//System.out.println(c);
		return c;
	} 
	
	public void saveUser(User u) throws Exception {
	Connection c=establishConnection();
		
		PreparedStatement ps=c.prepareStatement("insert into user values(?,?,?,?,?,?)");
		ps.setInt(1, u.getId());
		ps.setString(2,u.getFirst_name());
		ps.setString(3, u.getLast_name());
		ps.setString(4, u.getGender());
		ps.setString(5, u.getEmail());
		ps.setString(6, u.getPassword());
		ps.executeUpdate();
		System.out.println("Regsister successfull"+Character.toString(0x1F601));
	}
	public User fectById(int Id) throws Exception {

		Connection c=establishConnection();
	
		PreparedStatement ps=c.prepareStatement("select * from user where id =?");
		
		ps.setInt(1, Id);
		 ResultSet rs=ps.executeQuery();
		while(rs.next()){
			int id=rs.getInt(1);
			String first_name=rs.getString(2);
			String last_name=rs.getString(3);
			String gender =rs.getString(4);
			String email=rs.getString(5);
			String password=rs.getString(6);
			User u =new User();
			u.setId(id);
			u.setFirst_name(first_name);
			u.setLast_name(last_name);
			u.setGender(gender);
			u.setEmail(email);
			u.setPassword(password);
			return u;
		} 
		return null;
	}
	public User fecthByEmail(String email) throws Exception{
		Connection c=establishConnection();
		
		PreparedStatement ps=c.prepareStatement("select * from user where email =?");
		ps.setString(1, email);
		 ResultSet rs=ps.executeQuery();
		while(rs.next()){
			int id=rs.getInt(1);
			String first_name=rs.getString(2);
			String last_name=rs.getString(3);
			String gender =rs.getString(4);
			String email1=rs.getString(5);
			String password=rs.getNString(6);
			
			User u =new User();
			u.setId(id);
			u.setFirst_name(first_name);
			u.setLast_name(last_name);
			u.setGender(gender);
			u.setEmail(email1);
			u.setPassword(password);
			
			return u;
		} 
		return null;
		
	}
	public String deleteById(int id) throws Exception{
		
		Connection c=establishConnection();
		PreparedStatement ps=c.prepareStatement("delete from user where id =?");
		ps.setInt(1, id);
		ps.executeUpdate();
		return "data deleted";
	}
	public void upadate (User u) throws Exception {
		Connection c=establishConnection();
		PreparedStatement ps=c.prepareStatement("update user set first_name=?,last_name=?,gender=?,email=?,password=? where id =?");
		ps.setString(1, u.getFirst_name());
		ps.setString(2, u.getLast_name());
		ps.setString(3, u.getGender());
	    ps.setString(4, u.getEmail());
	    ps.setString(5,u.getPassword());
	    ps.setInt(6, u.getId());
	    ps.executeUpdate();
	    System.out.println("data update");
		
		
		
	}
	public ArrayList<User> fetchAllLavadekaBalls()throws Exception{
		
		Connection c=establishConnection();
		Statement s=c.createStatement();
		  ResultSet rs=s.executeQuery("select * from user");
		
		ArrayList<User> al=new ArrayList();
		
		while(rs.next()){
			int id=rs.getInt(1);
			String first_name=rs.getString(2);
			String last_name=rs.getString(3);
			String gender =rs.getString(4);
			String email=rs.getString(5);
			String password=rs.getString(6);
			
			User u =new User();
			u.setId(id);
			u.setFirst_name(first_name);
			u.setLast_name(last_name);
			u.setGender(gender);
			u.setEmail(email);
			u.setPassword(password);
			al.add(u);
		}
		return al;
		
		
		
	}
	
	
	
}
