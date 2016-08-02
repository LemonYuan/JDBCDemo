package com.hand.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App 
{
	public static void main( String[] args )
	{
//		query();
//		insert();
//		delete();
	}

	public static Connection getConn(){
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql_prac","root","");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void query(){
		try {
			Connection conn=getConn();
			String sql="select * from employees";
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				System.out.print(rs.getInt("id")+" ");
				System.out.print(rs.getString("name")+" ");
				System.out.println(rs.getInt("age")+" ");
			}
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public static void insert(){
		try {
			Connection conn=getConn();
			String sql="insert into employees(id,name,age) "
					+"values(6,'tom',18)";
			Statement st=conn.createStatement();
			int  rs=st.executeUpdate(sql);
			System.out.println("一共有"+rs+"行被影响了");
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void delete(){
		try {
			Connection conn=getConn();
			String sql="delete from employees where id=6";
			Statement st=conn.createStatement();
			int  rs=st.executeUpdate(sql);
			System.out.println("一共有"+rs+"行被影响了");
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
