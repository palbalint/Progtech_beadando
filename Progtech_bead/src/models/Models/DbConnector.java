package com.models.Models;

import java.sql.*;

public class DbConnector {
    public DbConnector() {
    }
    private static Connection conn;
    private static final String SERVERNAME = "localhost:3308";
    private static final String DBNAME = "progtech_db";
    private static final String URL = "jdbc:mysql://" + SERVERNAME + "/" + DBNAME;

    private static final String USERNAME = "balint";
    private static final String PASSWORD = "balintapro98";

    /**
     * Létrejön az adatbáziskapcsolat
     * @return Connection
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if(conn == null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }catch (SQLException e){
                e.printStackTrace();
                throw e;
            } catch (ClassNotFoundException e){
                throw e;
            }
        }
        return conn;
    }
}
