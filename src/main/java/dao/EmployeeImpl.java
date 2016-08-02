package dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import entity.Employee;

public class EmployeeImpl implements UserDAO{

	public void save(Connection conn, Employee employee) throws SQLException {
		PreparedStatement st=(PreparedStatement) conn.prepareCall("insert into employees values(?,?,?,?,?,?)");
		st.setLong(1,employee.getId());
		st.setString(2,employee.getName());
		st.setString(3,employee.getJob_id());
		st.setInt(4,employee.getAge());
		st.setInt(5,employee.getDepartment_id());
		st.setInt(6,employee.getManager_id());
	    st.execute();
	}

	public void update(Connection conn, long id, Employee employee) throws SQLException{
		PreparedStatement st=(PreparedStatement) conn.prepareCall("update employees set name=?,job_id=?,age=?," +
				"department_id=?,manager_id=? where id=?");
		st.setLong(6,employee.getId());
		st.setString(1,employee.getName());
		st.setString(2,employee.getJob_id());
		st.setInt(3,employee.getAge());
		st.setInt(4,employee.getDepartment_id());
		st.setInt(5,employee.getManager_id());
	    st.execute();
	}

	public void delete(Connection conn, Employee employee) throws SQLException{
		PreparedStatement st=(PreparedStatement) conn.prepareCall("delete from employees where id=?");
		st.setLong(1,employee.getId());
	    st.execute();
	}

}
