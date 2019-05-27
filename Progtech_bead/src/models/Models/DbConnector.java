package models.models.models;

import java.sql.*;

public class DbConnector {
    public DbConnector() {
    }
    private static Connection conn;
    private static final String serverName = "localhost";
    private static final String dbName = "progtech_db";
    private static final String url = "jdbc:mysql://" + serverName + "/" + dbName;

    private static final String username = "balint";
    private static final String password = "balintapro98";

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
                conn = DriverManager.getConnection(url, username, password);
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
