package GUI;

import subjects.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Screen_Login{
    Person person = new Person("New","new");
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    public static void main(String[] args)  {
        Screen_Login mainWindow = new Screen_Login();
    }
    public Screen_Login(){
        CreateScreen();
        TextFildLogin();
    }

    private void CreateScreen() {
        mainFrame = new JFrame("Đăng nhập");
        mainFrame.setSize(400, 300);
        mainFrame.setLayout(new GridLayout(3, 1));
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private void TextFildLogin() {
        headerLabel.setText("Quán game thiên đường");
        JLabel namelabel = new JLabel("Tên đăng nhập: ", JLabel.RIGHT);
        JLabel passwordLabel = new JLabel("Mật khẩu: ", JLabel.CENTER);
        final JTextField userText = new JTextField(6);
        final JPasswordField passwordText = new JPasswordField(6);
        JButton loginButton = new JButton("Đăng nhập");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pasword = new String(passwordText.getPassword());
                Person clint = new Person(userText.getText(),pasword);
                if (clint.Login(clint.getId_name(),clint.getPassword())){
                    statusLabel.setText("Dang nhap thanh cong");
                }else {
                    statusLabel.setText("Sai ten tai khoan hoac mat khau");
                }
            }
        });
        controlPanel.add(namelabel);
        controlPanel.add(userText);
        controlPanel.add(passwordLabel);
        controlPanel.add(passwordText);
        controlPanel.add(loginButton);
        mainFrame.setVisible(true);
    }
}
