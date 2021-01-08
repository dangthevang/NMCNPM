package subjects;
import connect_database.JavaConnectSQL;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class Admin extends Person{
    public Admin(String id_name, String password) {
        }

    public Admin() {
        super();
    }

    public Boolean check_username(String user) {
        var sql ="select name from user_password";
        boolean check = true;
        try{
            Statement stmt = this.getConn().createStatement();
            var rs = stmt.executeQuery(sql);
            while (rs.next()){
                String r_s = rs.getString(1).replaceAll("\\s","");
                if (user.equals(r_s)) {
                    check = false;
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return check;
    }
    public void controlPC(String status, Integer computer) {
        String sql = "UPDATE Computer SET status = ? WHERE computer = ?";
        try {
            PreparedStatement stmt = this.getConn().prepareStatement(sql);
            stmt.setString(1,status);
            stmt.setInt(2, computer);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public String getMessage(String user) {
        String sql = "Select message from profile where name ='"+user+"'";
        try {
            Statement stmt = this.getConn().createStatement();;
            var rs = stmt.executeQuery(sql);
            while (rs.next()){
                return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }return "";
    }
    public Integer getMoney(String user) {
        String sql = "Select money from profile where name ='"+user+"'";
        try {
            Statement stmt = this.getConn().createStatement();
            var rs = stmt.executeQuery(sql);
            while (rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public Float caculate(Integer money){
        return (float) money/10000;
    }

    public void createClint(String user, String password) {
        try{
            var sql ="INSERT INTO profile VALUES (?,?,?,?,?); ";
            PreparedStatement stmt = this.getConn().prepareStatement(sql);
            stmt.setString(1, user);
            stmt.setInt(2, 0);
            stmt.setString(3, "");
            stmt.setFloat(4, 0);
            stmt.setString(5, "0");
            stmt.execute();

            sql ="INSERT INTO user_password VALUES (?,?,?); ";
            stmt = this.getConn().prepareStatement(sql);
            stmt.setString(1, user);
            stmt.setString(2, password);
            stmt.setString(3, "");
            stmt.execute();
        } catch (SQLException e){
        e.printStackTrace();
    }
    }

    public void deleteClint(String user) {
        try {
            String sql = "delete from user_password where name=?";
            PreparedStatement stmt = this.getConn().prepareStatement(sql);
            stmt.setString(1,user);
            stmt.executeUpdate();
            sql = "delete from history where name=?";
            stmt = this.getConn().prepareStatement(sql);
            stmt.setString(1,user);
            stmt.executeUpdate();
            sql = "delete from profile where name=?";
            stmt = this.getConn().prepareStatement(sql);
            stmt.setString(1,user);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateClint(String user, Integer money) {
        String sql = "UPDATE profile SET money = ? ,time_use = ? WHERE name = ?";
        float time = this.caculate(money);
        try {
            PreparedStatement stmt = this.getConn().prepareStatement(sql);
            stmt.setInt(1,money);
            stmt.setFloat(2,time);
            stmt.setString(3,user);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void iBoxClint(String messgage, String user) {
        messgage = " Admin: " + this.getMessage(user) + messgage;
        try {
            String sql = "UPDATE profile SET message = ? WHERE name = ?";
            PreparedStatement stmt = this.getConn().prepareStatement(sql);
            stmt.setString(1,messgage);
            stmt.setString(2,user);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public List<Clint> getDataUser(){
        List<Clint> clints = new ArrayList<Clint>();
        var sql ="select * from profile";
        try{
            Clint clint = new Clint();
            clints.add(clint);
            clint.setId_name("Admin");
            Statement stmt = this.getConn().createStatement();
            var rs = stmt.executeQuery(sql);
            while (rs.next()){
                clint = new Clint();
                clint.setId_name(rs.getString("name"));
                clint.setMoney(rs.getInt("money"));
                clint.setActive(rs.getString("active_user"));
                clint.setTime_use(rs.getFloat("time_use"));
                clint.setMessage(rs.getNString("message"));
                clints.add(clint);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return clints;
    };
    public static void main(String [] args){
        Admin ad = new Admin();
        System.out.print(ad.getDataUser());
        System.out.print("Done");
    }
}
