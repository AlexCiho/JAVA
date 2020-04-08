package com.company;

import java.sql.*;

public class PersonController {
    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("insert into persons (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

        public Integer findByName(String name) throws SQLException {
            Connection con = Database.getConnection();
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery("select id from countries where name like '" + name + "'")) {
                return rs.next() ? rs.getInt(1) : null;
              }
          }

    }
