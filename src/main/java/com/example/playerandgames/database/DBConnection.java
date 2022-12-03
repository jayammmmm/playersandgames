package com.example.playerandgames.database;

import java.sql.*;

// This code is for establishing connection with MySQL
// database and retrieving data
// from db Java Database connectivity

/*
 *1. import --->java.sql
 *2. load and register the driver ---> com.jdbc.
 *3. create connection
 *4. create a statement
 *5. execute the query
 *6. process the results
 *7. close
 */

public class DBConnection {

  public static Connection con;

  public Connection getCon() {
    return con;
  }

  public void setConnection() throws Exception
  {
    String url
      = "jdbc:postgresql://localhost:5432/playersgames"; // table details
    String username = "postgres"; // MySQL credentials
    String password = "root";
    Class.forName("org.postgresql.Driver"); // Driver name
    this.con = DriverManager.getConnection(
      url, username, password);
    System.out.println(
      "Connection Established successfully");
  }

  public void closeConnection() throws SQLException {
    if (isEmpty(this.con) && !this.con.isClosed()) {
      this.con.close();
      System.out.println(
        "Connection Closed successfully");
    }
  }

  private boolean isEmpty(Connection con) {
    return con == null;
  }
}
