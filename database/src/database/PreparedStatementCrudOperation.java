package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementCrudOperation {
	Connection connection;
	public  Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/insurance","root","root");
		return connection;
	}
	public String  createOperation(String query,Connection connection) throws SQLException{
		PreparedStatement st=connection.prepareStatement(query);
		st.executeUpdate();
		return "table created";
	}
	public String   insertOperation(String query,Connection connection,int id,String name,int age,String dept) throws SQLException{
		PreparedStatement st=connection.prepareStatement(query);
		st.setInt(1,id);
		st.setString(2, name);
		st.setInt(3, age);
		st.setString(4, dept);
		st.executeUpdate();
		return "values inserted ";
	}
	public String  updateOperation(String query,Connection connection,int id,int age) throws SQLException{
		PreparedStatement st=connection.prepareStatement(query);
		st.setInt(1,id);
		st.setInt(3, age);
		st.executeUpdate();
		return "values updated";
	}
	public ResultSet selectOperation(String query,Connection connection) throws SQLException {
		PreparedStatement st=connection.prepareStatement(query);
		ResultSet rs=st.executeQuery();
		return rs;
		
	}
}
