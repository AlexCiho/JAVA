package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

	try {
                PersonController persons = new PersonController();
     //           MovieController movies = new MovieController();

                persons.create("Francis Ford Coppola");
                persons.create("Marlon Brando");
                persons.create("Al Pacino");
                Database.commit();

//                movies.create("The Godfather", persons.findByName("Coppola"));

                Database.commit();

                Database.closeConnection();
            } catch (SQLException e) {
                System.err.println(e);
                Database.rollback();
            }
    }
}
