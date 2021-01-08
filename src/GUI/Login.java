package GUI;

import subjects.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JPanel panel1;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JButton đăngNhậpButton;
    private JLabel Label;

    public Login(){
        add(panel1);
        setSize(500,400);
        setTitle("Login");
        setLocationRelativeTo(null);
        đăngNhậpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pasword = new String(passwordField1.getPassword());
                Person clint = new Person(textField1.getText(),pasword);
                if (clint.Login(clint.getId_name(),clint.getPassword())){
                    Label.setText("Dang nhap thanh cong");
                    if(clint.checkAdmin(clint.getId_name())){
                        ScreenAdmin ad = new ScreenAdmin();
                        ad.setVisible(true);
                    }else{
                        ScreenClint cl = new ScreenClint(textField1.getText());
                        cl.setVisible(true);
                    }
                }else {
                    Label.setText("Sai ten tai khoan hoac mat khau");
                }
            }
        });
    }
}
