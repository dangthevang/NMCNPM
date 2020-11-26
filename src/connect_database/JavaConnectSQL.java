package connect_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JavaConnectSQL implements ConnectDatabase{
    public Connection ConnectSQL(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=manage_net";
            String user="vang";
            String password="12345";
            Connection conn = DriverManager.getConnection(url, user, password);
            if(conn != null){
                System.out.println("Connect success!");
            }
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }catch (SQLException e){
            e.printStackTrace();
        return null;}
    }


    }
