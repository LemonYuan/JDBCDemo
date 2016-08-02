package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;
    private static final ConnectionFactory factory=new ConnectionFactory();
    private ConnectionFactory(){}
    //static用于初始化数据，在加载这个类时会运行一次
	static{
		Properties p=new Properties();
		try {

			InputStream in=ConnectionFactory.class.getClassLoader()     //用于加载配置文件
					.getResourceAsStream("dbconfig.properties");        //并转换字节流
			p.load(in);
		} catch (Exception e) {
			System.out.println("读取错误");
		}
		driver=p.getProperty("driver");
		dburl=p.getProperty("dburl");
		user=p.getProperty("user");
		password=p.getProperty("password");
	}
	
	//获取工厂类对象，并且是一个单实例
	public static ConnectionFactory getFactory()
	{
		return factory;
	}
	//获得数据库连接对象
	public Connection getConn()
	{
		Connection conn=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(dburl,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) {
		System.out.println(driver);
	}
}
