package docker;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class read_value {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Connection connection=null;
		Statement statement=null;
		ResultSet rs=null;
		connection db_connect=new connection();
		connection=db_connect.get_connection();
		try {
			String query="select * from TotalMeasuredResponsesTime";
			statement=connection.createStatement();
			rs=statement.executeQuery(query);
			while(rs.next())
			{
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
			}
		}catch(Exception e)
		{
			
		}

	}

}
