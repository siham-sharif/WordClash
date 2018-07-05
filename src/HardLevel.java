import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HardLevel implements ActionListener{

    public GameFrame hardFrame = new GameFrame("Hard");
    public Font font = new Font("Matura MT Script Capitals", Font.BOLD, 20);

    public GameButton lvlOneBtn, lvlTwoBtn, lvlThreeBtn;
    public GameButton mainMenuBtn;

    public HardLevel(){

        hardFrame.setVisible(true);
        hardFrame.setLayout(null);

        hardFrame.getContentPane().setBackground(Color.DARK_GRAY);

        // three level button

        lvlOneBtn = new GameButton("Level One");
        lvlOneBtn.setBounds(180, 160, 200, 50);

        hardFrame.add(lvlOneBtn);

        lvlTwoBtn = new GameButton("Level Two");
        lvlTwoBtn.setBounds(180, 220, 200, 50);

        hardFrame.add(lvlTwoBtn);

        lvlThreeBtn = new GameButton("Level Three");
        lvlThreeBtn.setBounds(180, 280, 200, 50);


        hardFrame.add(lvlThreeBtn);

        mainMenuBtn = new GameButton("Main Menu");
        mainMenuBtn.setBounds(180, 400, 200, 50);

        hardFrame.add(mainMenuBtn);

        lvlOneBtn.addActionListener(this);
        lvlTwoBtn.addActionListener(this);
        lvlThreeBtn.addActionListener(this);
        mainMenuBtn.addActionListener(this);

    }

    @Override
    public void actionPerformed (ActionEvent actionTaken) {
        if(actionTaken.getSource() == mainMenuBtn){
            new MenuFrame();
            hardFrame.setVisible(false);
        }
        if (actionTaken.getSource() == lvlOneBtn) {
            new DifficultySetter("hard.one");
            hardFrame.setVisible(false);
        }
        if (actionTaken.getSource() == lvlTwoBtn) {
            new DifficultySetter("hard.two");
            hardFrame.setVisible(false);
        }
        if (actionTaken.getSource() == lvlThreeBtn) {
            new DifficultySetter("hard.three");
            hardFrame.setVisible(false);
        }


    }
}
