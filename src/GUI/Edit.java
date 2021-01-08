package GUI;

import subjects.Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Edit extends JFrame{
    Admin ad = new Admin();
    private JPanel panel1;
    private JTextField textField1;
    private JButton nạpButton;
    private JLabel Label;
    private JLabel Label_status;
    Edit(String user){
        add(panel1);
        setSize(500,400);
        Label.setText("Người nạp: " + user);
        setTitle("Nạp tiền");
        setLocationRelativeTo(null);
        nạpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int money_cur = ad.getMoney(user);
                Integer money_add = Integer.valueOf(textField1.getText());
                int money = money_cur + money_add;
                ad.updateClint(user,money);
                Label_status.setText("Nạp thành công");
            }
        });
    }
}
