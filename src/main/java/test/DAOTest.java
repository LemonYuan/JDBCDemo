package test;

import java.sql.Connection;
import java.sql.SQLException;

import util.ConnectionFactory;
import dao.EmployeeImpl;
import entity.Employee;

public class DAOTest {
	public static void main(String[] args) {
		ConnectionFactory factory=ConnectionFactory.getFactory();
		Connection conn=factory.getConn();
		Employee e=new Employee();
		e.setId(7);
		e.setAge(20);
		e.setName("david");
		EmployeeImpl empDAO=new EmployeeImpl();
		try {
			empDAO.delete(conn, e);
//			empDAO.save(conn, e);
		} catch (SQLException e1) {
			System.out.println("输入错误");			}
	}
}
