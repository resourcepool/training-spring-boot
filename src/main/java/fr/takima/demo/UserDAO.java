package fr.takima.demo;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Repository
public class UserDAO {

  public UserDAO() {

  }

  public void add(User u) {
    Connection conn = null;
    PreparedStatement ps = null;
    try {
      conn = getConnection();
      ps = conn.prepareStatement("INSERT INTO users(first_name, last_name, age) VALUES (?, ?, ?)");
      ps.setString(1, u.getFirstName());
      ps.setString(2, u.getLastName());
      ps.setInt(3, u.getAge());
      ps.executeUpdate();
    } catch (SQLException e) {
      System.err.println("Error occurred during SQL Query");
      throw new IllegalStateException(e);
    } finally {
      closeObjects(conn, ps);
    }
  }

  public List<User> findAll() {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      conn = getConnection();
      ps = conn.prepareStatement("SELECT * FROM users");
      rs = ps.executeQuery();
      return mapResults(rs);
    } catch (SQLException e) {
      System.err.println("Error occurred during SQL Query");
      throw new IllegalStateException(e);
    } finally {
      closeObjects(rs, conn);
    }
  }

  private void closeObjects(AutoCloseable... objs) {
    try {
      for (AutoCloseable ac : objs) {
        ac.close();
      }
    } catch (Exception e) {
      System.err.println("Error occurred while closing objects");
      throw new IllegalStateException(e);
    }
  }

  private List<User> mapResults(ResultSet rs) throws SQLException {
    List<User> users = new ArrayList<>(rs.getFetchSize());
    while (rs.next()) {
      Long id = rs.getLong("id");
      String firstName = rs.getString("first_name");
      String lastName = rs.getString("last_name");
      Integer age = rs.getInt("age");
      users.add(new User(id, firstName, lastName, age));
    }
    return users;
  }

  private Connection getConnection() throws SQLException {
    return DriverManager.getConnection("jdbc:mariadb://localhost/defaultdb?user=root&password=toor");
  }
}
