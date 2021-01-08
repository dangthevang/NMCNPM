package GUI;

import subjects.Admin;
import subjects.Clint;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ScreenAdmin extends JFrame {
    Admin ad = new Admin();
    private JPanel panel1;
    private JButton thêmButton;
    private JButton nạpTiềnButton;
    private JButton xóaButton;
    private JTable table1;
    private JLabel Account;
    private JButton refreshButton;
    DefaultTableModel defaultTableModel;
    ScreenAdmin(){
        add(panel1);
        setSize(1000,700);
        setTitle("Admin");
        setLocationRelativeTo(null);
        TableStatusUser();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        thêmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ADD_Account add = new ADD_Account();
                add.setVisible(true);
            }
        });
        nạpTiềnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = getAcc();
                System.out.print(str);
                if ( str == ""){
                    UserSelectionMessage m = new UserSelectionMessage();
                    m.setVisible(true);
                }else{
                    Edit edit = new Edit(getAcc());
                    edit.setVisible(true);
                }
            }
        });
        xóaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = getAcc();
                System.out.print(str);
                if ( str == ""){
                    UserSelectionMessage m = new UserSelectionMessage();
                    m.setVisible(true);
                }else{
                    Delete del = new Delete(getAcc());
                    del.setVisible(true);
                }


            }
        });
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                defaultTableModel.setRowCount(0);
                List<Clint> clints = ad.getDataUser();
                setData(clints);
            }
        });
    }
    private void setData(List<Clint> clints){
        for(Clint clint: clints) {
            defaultTableModel.addRow(new Object[]{clint.getId_name(), clint.getMoney(), clint.getTime_use(), clint.getActive(), clint.getMessage()});
        }
    }
    private void TableStatusUser() {
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        defaultTableModel.addColumn("Tên người dùng");
        defaultTableModel.addColumn("Số tiền còn lại");
        defaultTableModel.addColumn("Thời gian còn lại");
        defaultTableModel.addColumn("Trang thái");
        defaultTableModel.addColumn("Lời nhắn");
        List<Clint> clints = ad.getDataUser();
        setData(clints);
        table1.setModel(defaultTableModel);
        ListSelectionModel listSelectionModel = table1.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int [] row = table1.getSelectedRows();
                String acc = String.valueOf(table1.getValueAt(row[0],0));
                Account.setText(acc);
            }
        });
    }
    private String getAcc(){
        return Account.getText();
    }
}
