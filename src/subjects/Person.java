package subjects;
import connect_database.JavaConnectSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Person {
    private final Connection conn;
    String id_name, password;
    JavaConnectSQL connect = new JavaConnectSQL();
    public Person(String id_name, String password){
        this.id_name = id_name;
        this.password = password;
        this.conn = connect.ConnectSQL();
    }

    public Person() {
        this.conn = connect.ConnectSQL();
    }

    public String getId_name() {
        return id_name;
    }

    public String getPassword() {
        return password;
    }

    public Connection getConn(){ return conn; }


    public void setId_name(String id_name) {
        this.id_name = id_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Boolean Login(String id_name, String Password) {
        var sql ="select name,password from user_password";
        try{
            Statement stmt = this.getConn().createStatement();
            var rs = stmt.executeQuery(sql);
            while (rs.next()){
                String r_name = rs.getString(1).replaceAll("\\s","");
                String r_password = rs.getString(2).replaceAll("\\s","");
                if (id_name.equals(r_name)&& (Password.equals(r_password))) {
                    return true;
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public Boolean checkAdmin(String id_name) {
        var sql ="select admin from user_password WHERE name = '" + id_name +"'";
        try{
            Statement stmt = this.getConn().createStatement();
            var rs = stmt.executeQuery(sql);
            while (rs.next()){
                String check = rs.getString(1).replaceAll("\\s","");
                if (check.equals("1")) {
                    return true;
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean Logout(String active, String user) {
        String sql = "UPDATE Computer SET active = ? WHERE user = ?";
        try {
            PreparedStatement stmt = this.getConn().prepareStatement(sql);
            stmt.setString(1,"0");
            stmt.setString(2, user);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
    public static void main(String [] args){
        Person p = new Person("Vang", "12345");
        System.out.print(p.checkAdmin(p.getId_name()));
    }
}
