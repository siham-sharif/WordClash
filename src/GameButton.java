import javax.swing.*;
import java.awt.*;

public class GameButton extends JButton{

    public GameButton(String buttonName){
        Font font = new Font("Matura MT Script Capitals",Font.BOLD,20);
        setText(buttonName);
        setBounds(125,340,150,50);
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setFont(font);
    }
}
