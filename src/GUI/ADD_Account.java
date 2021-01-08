package GUI;

import subjects.Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ADD_Account extends JFrame {
    Admin ad = new Admin();
    private JPanel panel1;
    private JTextField textField1;
    private JButton thêmButton;
    private JPasswordField passwordField1;
    private JLabel Label;
    ADD_Account(){
        add(panel1);
        setSize(500,400);
        setTitle("Login");
        setLocationRelativeTo(null);
        thêmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pasword = new String(passwordField1.getPassword());
                String user = new String(textField1.getText());
                if (ad.check_username(user)){
                    ad.createClint(user,pasword);
                    Label.setText("Tạo mới thành công");
                }else{
                Label.setText("Tên tài khoản đã tồn tại");}
            }
        });
    }
}
