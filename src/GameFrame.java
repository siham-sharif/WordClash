import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public Font font = new Font("Matura MT Script Capitals", Font.BOLD, 25);

    public GameFrame(String title){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        getContentPane().setBackground(Color.darkGray);
        setSize(600,700);
        setResizable(false);

    }

}
