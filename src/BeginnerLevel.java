import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BeginnerLevel {

    public JFrame beginnerFrame = new JFrame("Beginner");
    public Font font = new Font("Matura MT Script Capitals",Font.BOLD,20);

    public JButton lvlOneBtn, lvlTwoBtn, lvlThreeBtn;
    public JButton mainMenuBtn;


    public BeginnerLevel(){

        //basic frame skeleton
        beginnerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        beginnerFrame.setResizable(false);
        beginnerFrame.setVisible(true);
        beginnerFrame.setBounds(100,200,500,600);
        beginnerFrame.setLayout(null);

        beginnerFrame.getContentPane().setBackground(Color.DARK_GRAY);

        // three level button

        lvlOneBtn = new JButton("Level One");
        lvlOneBtn.setBounds(160,100,200,50);
        lvlOneBtn.setBackground(Color.WHITE);
        lvlOneBtn.setFont(font);

        beginnerFrame.add(lvlOneBtn);

        lvlTwoBtn = new JButton("Level Two");
        lvlTwoBtn.setBounds(160,160,200,50);
        lvlTwoBtn.setBackground(Color.WHITE);
        lvlTwoBtn.setFont(font);

        beginnerFrame.add(lvlTwoBtn);

        lvlThreeBtn = new JButton("Level Three");
        lvlThreeBtn.setBounds(160,220,200,50);
        lvlThreeBtn.setBackground(Color.WHITE);
        lvlThreeBtn.setFont(font);

        beginnerFrame.add(lvlThreeBtn);

        mainMenuBtn = new JButton("Main Menu");
        mainMenuBtn.setBounds(160,400,200,50);
        mainMenuBtn.setBackground(Color.WHITE);
        mainMenuBtn.setFont(font);

        beginnerFrame.add(mainMenuBtn);

        // adding event listener to level button
        levelOne lvlOneClicked = new levelOne();
        lvlOneBtn.addActionListener(lvlOneClicked);



    }

    // go back to main main
    public class mainMain implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new MenuFrame();
            beginnerFrame.setVisible(false);
        }
    }

    // level one
    public class levelOne implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // setting difficuly for beginner level
            new BeginnerDifficulty(0);
            beginnerFrame.setVisible(false);

        }
    }


}
