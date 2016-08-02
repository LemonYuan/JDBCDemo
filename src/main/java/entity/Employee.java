package entity;


public class Employee extends IdEntity{
   private String name;
   private String job_id;
   private int age;
   private int department_id;  
   private int manager_id;
   
   
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getJob_id() {
	return job_id;
}
public void setJob_id(String job_id) {
	this.job_id = job_id;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public int getDepartment_id() {
	return department_id;
}
public void setDepartment_id(int department_id) {
	this.department_id = department_id;
}
public int getManager_id() {
	return manager_id;
}
public void setManager_id(int manager_id) {
	this.manager_id = manager_id;
}
public String toString() {
	return "Employees [name=" + name + ", job_id=" + job_id + ", age=" + age
			+ ", department_id=" + department_id + ", manager_id=" + manager_id
			+ ", id=" + id + "]";
}  
   
}
