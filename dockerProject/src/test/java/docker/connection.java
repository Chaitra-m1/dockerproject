package docker;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;



public class connection {
	public static Properties confiqrepo;
	public static void main(String[] args) {
		connection db_connect=new connection();
		System.out.println(db_connect.get_connection());  
	}

	public Connection get_connection() {
		// TODO Auto-generated method stub
		
		Connection connection=null;
		try {
			FileInputStream confiqfis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\confiqs\\configuration.properties");
			confiqrepo=new  Properties(); 
			confiqrepo.load(confiqfis);
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection(confiqrepo.getProperty("ipaddress"),"postgres", "postsimtech");
			if(connection!=null)
			{
				System.out.println("ok");
			}else
			{
				System.out.println("not ok");
			}
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return connection;

	}

}
