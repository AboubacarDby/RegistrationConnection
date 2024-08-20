package fr.formation.exercice1registrationcorrection.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.formation.exercice1registrationcorrection.model.Employee;

public class EmployeeDao {
	private static final long serialVersionUID = 1L;

	public int registerEmployee(Employee employee)throws ClassNotFoundException{
		String INSERT_USERS_SQL = "INSERT INTO employee" +
				"(first_name, last_name, username, password, address, contact) VALUES " +
				"(?, ?, ?, ?, ?, ?;";
		int result = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bdd_exercice1?serverTimezone=UTC", "root", "Guinee1958.");
				PreparedStatement preparedStatement  = connection.prepareStatement(INSERT_USERS_SQL)
				){
			
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setString(3, employee.getUsername());
			preparedStatement.setString(4, employee.getPassword());
			preparedStatement.setString(5, employee.getAddress());
			preparedStatement.setString(6, employee.getContact());
			System.out.println(preparedStatement);
			result= preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}	
	private void printSQLExeception(SQLException ex) {
		for(Throwable e : ex) {
			if(e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLstate: " + ((SQLException)e).getSQLState());
				System.err.println("SQLstate: " + ((SQLException)e).getErrorCode());
				System.err.println("Message :"+e.getMessage());
				Throwable t = ex.getCause();
				while(t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
