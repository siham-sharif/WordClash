import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BeginnerLevel implements ActionListener {

    public GameFrame beginnerFrame = new GameFrame("Beginner");
    public Font font = new Font("Matura MT Script Capitals", Font.BOLD, 20);

    public GameButton lvlOneBtn, lvlTwoBtn, lvlThreeBtn;
    public GameButton mainMenuBtn;


    public BeginnerLevel () {

        //basic frame skeleton
        beginnerFrame.setVisible(true);
        beginnerFrame.setLayout(null);

        beginnerFrame.getContentPane().setBackground(Color.DARK_GRAY);

        // three level button

        lvlOneBtn = new GameButton("Level One");
        lvlOneBtn.setBounds(180, 160, 200, 50);

        beginnerFrame.add(lvlOneBtn);

        lvlTwoBtn = new GameButton("Level Two");
        lvlTwoBtn.setBounds(180, 220, 200, 50);
        beginnerFrame.add(lvlTwoBtn);

        lvlThreeBtn = new GameButton("Level Three");
        lvlThreeBtn.setBounds(180, 280, 200, 50);
        beginnerFrame.add(lvlThreeBtn);

        mainMenuBtn = new GameButton("Main Menu");
        mainMenuBtn.setBounds(180, 400, 200, 50);
        beginnerFrame.add(mainMenuBtn);

        lvlOneBtn.addActionListener(this);
        lvlTwoBtn.addActionListener(this);
        lvlThreeBtn.addActionListener(this);
        mainMenuBtn.addActionListener(this);

    }

    @Override
    public void actionPerformed (ActionEvent actionTaken) {

        if(actionTaken.getSource() == mainMenuBtn){
            new MenuFrame();
            beginnerFrame.setVisible(false);
        }
        if (actionTaken.getSource() == lvlOneBtn) {
            new DifficultySetter("easy.one");
            beginnerFrame.setVisible(false);
        }
        if (actionTaken.getSource() == lvlTwoBtn) {
            new DifficultySetter("easy.two");
            beginnerFrame.setVisible(false);
        }
        if (actionTaken.getSource() == lvlThreeBtn) {
            new DifficultySetter("easy.three");
            beginnerFrame.setVisible(false);
        }


    }

}
