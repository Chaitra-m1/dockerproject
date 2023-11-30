package docker;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;



public class table {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Connection connection=null;
		Statement statement=null;
		connection db_connect=new connection();
		connection=db_connect.get_connection();
		//System.out.println(db_connect.get_connection()); 
		try {
			String query = "Create table TotalMeasuredResponsesTime(MeasuredTime BIGINT, StepName varchar, MeasuredResponseTime BIGINT)";
			statement=connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("finished");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
