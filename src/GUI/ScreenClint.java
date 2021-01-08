package GUI;

import subjects.Clint;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ScreenClint extends JFrame {
    Clint clint = new Clint();
    private JPanel panel1;
    private JButton tinNhắnButton;
    private JButton đăngXuấtButton;
    private JTable table1;
    private DefaultTableModel defaultTableModel;
    ScreenClint(String username){
        clint.setId_name(username);
        add(panel1);
        setSize(500,400);
        setTitle("Clint");
        TableStatusUser();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    private void TableStatusUser() {
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Clint clints = clint.get_Infor();

        defaultTableModel.addColumn("Tên người dùng");
        defaultTableModel.addColumn("Số tiền còn lại");
        defaultTableModel.addColumn("Thời gian còn lại");
        defaultTableModel.addRow(new Object[]{clint.getId_name(), clint.getMoney(), clint.getTime_use()});
        table1.setModel(defaultTableModel);
    }
}
