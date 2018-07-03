import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediumLevel implements ActionListener {
    public JFrame mediumFrame = new JFrame("Medium");
    public Font font = new Font("Matura MT Script Capitals", Font.BOLD, 20);

    public GameButton lvlOneBtn, lvlTwoBtn, lvlThreeBtn;
    public GameButton mainMenuBtn;

    public MediumLevel(){
        mediumFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mediumFrame.setResizable(false);
        mediumFrame.setVisible(true);
        mediumFrame.setBounds(100, 200, 500, 600);
        mediumFrame.setLayout(null);

        mediumFrame.getContentPane().setBackground(Color.DARK_GRAY);

        // three level button

        lvlOneBtn = new GameButton("Level One");
        lvlOneBtn.setBounds(160, 100, 200, 50);
        //lvlOneBtn.setBackground(Color.WHITE);
        //lvlOneBtn.setFont(font);

        mediumFrame.add(lvlOneBtn);

        lvlTwoBtn = new GameButton("Level Two");
        lvlTwoBtn.setBounds(160, 160, 200, 50);
        //lvlTwoBtn.setBackground(Color.WHITE);
        //lvlTwoBtn.setFont(font);

        mediumFrame.add(lvlTwoBtn);

        lvlThreeBtn = new GameButton("Level Three");
        lvlThreeBtn.setBounds(160, 220, 200, 50);
        //lvlThreeBtn.setBackground(Color.WHITE);
        //lvlThreeBtn.setFont(font);

        mediumFrame.add(lvlThreeBtn);

        mainMenuBtn = new GameButton("Main Menu");
        mainMenuBtn.setBounds(160, 400, 200, 50);
        //mainMenuBtn.setBackground(Color.WHITE);
        //mainMenuBtn.setFont(font);


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
