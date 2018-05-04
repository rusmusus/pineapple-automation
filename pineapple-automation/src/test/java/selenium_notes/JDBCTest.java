package selenium_notes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class JDBCTest {

	String URL = "jdbc:mysql://localhost:3306/hr";
	String username = "root";
	String password = "root";
	String query = "SELECT * FROM employees ORDER BY first_name DESC;";

	@Test
	public void connectToMySQL() throws SQLException {
		Connection connect = DriverManager.getConnection(URL, username, password);
		Statement state = connect.createStatement();
		ResultSet result = state.executeQuery(query);

		while (result.next()) {
			System.out.println(result.getString(2));

			// connect.close();
		}
	}

}
