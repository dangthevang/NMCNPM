package GUI;

import javax.swing.*;
import java.awt.*;

public class Screen_Clint extends JFrame{
    private JFrame mainFrame;
    private JLabel header;
    private JPanel control;
    private JPanel body;
    public static void main(String[] args)  {
        Screen_Clint mainWindow = new Screen_Clint();
    }
    public Screen_Clint(){
        CreateScreen();
        Infor();
        ButtonLogout();
    }
    private void CreateScreen() {
        mainFrame = new JFrame("Clint");
        mainFrame.setSize(300,500);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
    private void ButtonLogout() {
    }

    private void Infor() {

    }


}
