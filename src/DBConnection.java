import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class DBConnection {
	   
		String BDD = "nomBD";
		String url = "jdbc:mysql://localhost:3306/" + BDD;
		static String user = "root";
		static String passwd = "";
		// turning the instance to static 
	    static Connection conn;
	    // and the constructor to private so we can't make instances 
	    private DBConnection() throws SQLException {
			conn=DriverManager.getConnection(url, user,passwd);
		}

	    public static Connection getConn() {
	    	try {
	    		if (conn== null ) {
	    			Class.forName("com.mysql.jdbc.Driver");
	    			conn= DriverManager.getConnection("jdbc:mysql://localhost/tp2Archi","root","");
	    			java.sql.Statement stmt = conn.createStatement();	 
	    			String sql = "Select * from dbconnction where userName='"+user.toString()+"'abd Password='"+passwd.toString()+"'";
	    			ResultSet rs = stmt.executeQuery(sql);
	    			if (rs.next())
					{
						System.out.println("connecté");
					}else {
						System.out.println("nom d'utilisateur ou mot de passe incorrecte");
					}
					conn.close();
	    		}
	    			
	    	}catch (Exception e) {
	    		e.printStackTrace();
	    	}
			return conn;
		}

	
}

