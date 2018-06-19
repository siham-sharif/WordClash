import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BeginnerLevel implements ActionListener {

    public JFrame beginnerFrame = new JFrame("Beginner");
    public Font font = new Font("Matura MT Script Capitals", Font.BOLD, 20);

    public GameButton lvlOneBtn, lvlTwoBtn, lvlThreeBtn;
    public GameButton mainMenuBtn;


    public BeginnerLevel () {

        //basic frame skeleton
        beginnerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        beginnerFrame.setResizable(false);
        beginnerFrame.setVisible(true);
        beginnerFrame.setBounds(100, 200, 500, 600);
        beginnerFrame.setLayout(null);

        beginnerFrame.getContentPane().setBackground(Color.DARK_GRAY);

        // three level button

        lvlOneBtn = new GameButton("Level One");
        lvlOneBtn.setBounds(160, 100, 200, 50);
        //lvlOneBtn.setBackground(Color.WHITE);
        //lvlOneBtn.setFont(font);

        beginnerFrame.add(lvlOneBtn);

        lvlTwoBtn = new GameButton("Level Two");
        lvlTwoBtn.setBounds(160, 160, 200, 50);
        //lvlTwoBtn.setBackground(Color.WHITE);
        //lvlTwoBtn.setFont(font);

        beginnerFrame.add(lvlTwoBtn);

        lvlThreeBtn = new GameButton("Level Three");
        lvlThreeBtn.setBounds(160, 220, 200, 50);
        //lvlThreeBtn.setBackground(Color.WHITE);
        //lvlThreeBtn.setFont(font);

        beginnerFrame.add(lvlThreeBtn);

        mainMenuBtn = new GameButton("Main Menu");
        mainMenuBtn.setBounds(160, 400, 200, 50);
        //mainMenuBtn.setBackground(Color.WHITE);
        //mainMenuBtn.setFont(font);


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
