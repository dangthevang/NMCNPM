package GUI;
import java.awt.*;
import subjects.Admin;

import javax.swing.*;
public class Screen_Admin_Main extends JFrame {
    Admin ad = new Admin("Vang","12345");
    private JLabel header;
    private JPanel control;
    private JPanel body;
    public static void main(String[] args)  {
        Screen_Admin_Main mainWindow = new Screen_Admin_Main();
    }
    public Screen_Admin_Main(){
        CreateScreen();
        ButtonEditer();
        TableStatusUser();
    }

    private void CreateScreen() {
        this.setTitle("Admin");
        this.setSize(1000,700);
        this.setLayout(new GridLayout(3,1));
        GridBagConstraints gbc = new GridBagConstraints();
        header = new JLabel("Quan ly quan net");
        body = new JPanel();
        control = new JPanel();
        this.add(header);
        this.add(control);
        this.add(body);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void TableStatusUser() {
        String data[][] = ad.getDataUser();
        String column[] = { "Ten", "Tien con lai", "Tin nhan","Thoi gian con lai","Trang thai" };
        JTable jt = new JTable(data, column);
        JScrollPane sp = new JScrollPane(jt);
        sp.setSize(1000,300);
        body.add(sp);
        this.setVisible(true);
    }

    private void ButtonEditer() {
        JPanel button_edit = new JPanel();
        button_edit.setBackground(Color.lightGray);
        button_edit.setSize(1000,200);
        button_edit.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton add_user = new JButton("Them");
        JButton edit_user = new JButton("Sua");
        JButton delete_user = new JButton("Xoa");
        JButton message_user = new JButton("Message");
        button_edit.add(add_user);
        button_edit.add(edit_user);
        button_edit.add(delete_user);
        button_edit.add(message_user);
        control.add(button_edit);
        this.setVisible(true);
    }
}

