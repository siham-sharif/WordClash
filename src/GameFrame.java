import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public Font font = new Font("Matura MT Script Capitals", Font.BOLD, 25);

    // learned menu bar from http://www.java2s.com/Tutorial/Java/0240__Swing/DisableMenuitem.htm
    private JMenuBar menuBar = new JMenuBar();

    public GameFrame(String title){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setJMenuBar(menuBar);
        JMenu gameMenu = new JMenu("Menu");
        JMenu exitMenu = new JMenu("Close Game");
        menuBar.add(gameMenu);
        menuBar.add(exitMenu);

        getContentPane().setBackground(Color.darkGray);
        setSize(600,700);
        setResizable(false);

    }

}
