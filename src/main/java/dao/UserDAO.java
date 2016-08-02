package dao;

import java.sql.Connection;
import java.sql.SQLException;

import entity.Employee;

public interface UserDAO {
     public void save(Connection conn,Employee employee) throws SQLException;
     public void update(Connection conn,long id,Employee employee) throws SQLException;
     public void delete(Connection conn,Employee employee)throws SQLException;
     
}
