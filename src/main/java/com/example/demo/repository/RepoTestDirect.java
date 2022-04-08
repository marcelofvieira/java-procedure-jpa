package com.example.demo.repository;

import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class RepoTestDirect {

  public void removeUnresolvedUtility (BigInteger startId, BigInteger finalId) throws Exception {

    Connection conn = null;

      try {

        conn = getConnection();

        CallableStatement stmt = conn.prepareCall("{call removeUnresolvedUtility(?, ?) }");

        stmt.setLong(1, startId.longValue());
        stmt.setLong(2, finalId.longValue());

        stmt.executeQuery();

      } catch (Exception e) {
        throw new Exception(e.getMessage());
      } finally {

        if ( !conn.isClosed() ) {
          conn.close();
        }
      }

  }

  private Connection getConnection() throws Exception {

    try {

      Class.forName("com.mysql.cj.jdbc.Driver");

      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/utilities-api", "root", "");

      return conn;

    } catch (Exception e) {

      throw new Exception(e.getMessage());

    }

  }

}
