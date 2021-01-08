package GUI;

import subjects.Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delete extends JFrame {
    Admin ad = new Admin();
    private JPanel panel1;
    private JPanel panel2;
    private JButton yesButton;
    private JButton noButton;
    private JLabel Label;
    Delete(String user){
        add(panel1);
        setSize(500,400);
        Label.setText("Bạn muốn xóa tài khoản: "+ user+" ?");
        setTitle("Xóa");
        setLocationRelativeTo(null);
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ad.deleteClint(user);
            };
        });
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.setVisible(false);
    }
}
