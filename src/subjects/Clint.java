package subjects;

import connect_database.JavaConnectSQL;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Clint extends Person {
    Boolean active;
    public Clint(String id_name, String password, Boolean active) {
        super(id_name, password);
        this.active = active;
    }

    public String[] check_Infor() {
        String[] List_Status = new String[5];
        try {
            Statement stmt = this.getConn().createStatement();
            ResultSet rs = stmt.executeQuery("select * from profile where name = '" + this.id_name + "'");
            while (rs.next()) {
                for (int col = 1; col <= 5; col++) {
                    List_Status[col - 1] = rs.getString(col);
                }
                ;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return List_Status;
    }
    
    public static void main(String [] args){
        Clint clint = new Clint("Yen","12345",false);
        clint.check_Infor();
    }
}
