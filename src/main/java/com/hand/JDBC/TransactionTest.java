package com.hand.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionTest {

	public static void main(String[] args) {
		Connection conn=getCon();
		try {
			conn.setAutoCommit(false);
			insert(conn);
			insertError(conn);    //这里将会抛出异常
			conn.commit();

		} catch (Exception e) {
			System.out.println("事物出错，即将回滚");
			try {
				conn.rollback();
				System.out.println("回滚成功");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// 获得数据库连接
	public static Connection getCon(){
		Connection conn=null;
		try {
			conn = null;
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql_prac","root","");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void insert(Connection conn) throws Exception{
		try {
			String sql="update employees set age=14 where id=3";
			Statement st=conn.createStatement();
			int rs=st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void insertError(Connection conn) throws Exception{
		try {
			String sql="update employees set age=age-1 where id=3";
			Statement st=conn.createStatement();
			int i=10/0;                              //故意运行错误
			int rs=st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
