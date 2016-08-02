package test;

import java.sql.Connection;

import util.ConnectionFactory;

public class FactoryTest {
     public static void main(String[] args) throws Exception{
		  ConnectionFactory factory=ConnectionFactory.getFactory();
		  Connection conn=factory.getConn();
		  System.out.println(conn.isClosed());
	}
}
