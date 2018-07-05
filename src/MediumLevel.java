import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediumLevel implements ActionListener {
    public GameFrame mediumFrame = new GameFrame("Medium");
    public Font font = new Font("Matura MT Script Capitals", Font.BOLD, 20);

    public GameButton lvlOneBtn, lvlTwoBtn, lvlThreeBtn;
    public GameButton mainMenuBtn;

    public MediumLevel(){
        mediumFrame.setVisible(true);
        mediumFrame.setLayout(null);

        mediumFrame.getContentPane().setBackground(Color.DARK_GRAY);

        // three level button

        lvlOneBtn = new GameButton("Level One");
        lvlOneBtn.setBounds(180, 160, 200, 50);
        mediumFrame.add(lvlOneBtn);

        lvlTwoBtn = new GameButton("Level Two");
        lvlTwoBtn.setBounds(180, 220, 200, 50);
        mediumFrame.add(lvlTwoBtn);

        lvlThreeBtn = new GameButton("Level Three");
        lvlThreeBtn.setBounds(180, 280, 200, 50);
        mediumFrame.add(lvlThreeBtn);

        mainMenuBtn = new GameButton("Main Menu");
        mainMenuBtn.setBounds(180, 400, 200, 50);
        mediumFrame.add(mainMenuBtn);

        lvlOneBtn.addActionListener(this);
        lvlTwoBtn.addActionListener(this);
        lvlThreeBtn.addActionListener(this);
        mainMenuBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed (ActionEvent actionTaken) {
        if(actionTaken.getSource() == mainMenuBtn){
            new MenuFrame();
            mediumFrame.setVisible(false);
        }
        if (actionTaken.getSource() == lvlOneBtn) {
            new DifficultySetter("medium.one");
            mediumFrame.setVisible(false);
        }
        if (actionTaken.getSource() == lvlTwoBtn) {
            new DifficultySetter("medium.two");
            mediumFrame.setVisible(false);
        }
        if (actionTaken.getSource() == lvlThreeBtn) {
            new DifficultySetter("medium.three");
            mediumFrame.setVisible(false);
        }
    }
}
