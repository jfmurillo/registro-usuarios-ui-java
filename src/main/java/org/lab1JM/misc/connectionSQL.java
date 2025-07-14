package org.lab1JM.misc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionSQL {
    private static final String URL = "jdbc:mysql://srv863.hstgr.io:3306/u484426513_dsc225";
    private static final String USER = "u484426513_dsc225";
    private static final String PASSWORD = "/Nv0[f7U";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos" + e.getMessage() );
            return null;
        }
    }
}
