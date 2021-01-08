package subjects;
import connect_database.JavaConnectSQL;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Clint{
    String id_name = "Trang";
    String active;
    Integer money = 0;
    Float time_use;
    String message;
    private Connection conn;
    JavaConnectSQL connect = new JavaConnectSQL();
    public Clint() {
        this.conn = connect.ConnectSQL();
    }
    public Connection getConn(){ return conn; }
    public String getId_name() {
        return id_name;
    }

    public void setId_name(String id_name) {
        this.id_name = id_name;
    }
    public Integer getMoney() {
        return money;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Float getTime_use() {
        return time_use;
    }

    public void setTime_use(Float time_use) {
        this.time_use = time_use;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public Clint get_Infor() {
        Clint clint = new Clint();
        var sql ="select * from profile where name = '" + id_name + "'";
        try{
            Statement stmt = this.getConn().createStatement();
            var rs = stmt.executeQuery(sql);
            while (rs.next()){
                clint.setId_name(rs.getString("name"));
                clint.setMoney(rs.getInt("money"));
                clint.setActive(rs.getString("active_user"));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return clint;
    }
}
