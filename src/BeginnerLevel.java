import javax.swing.*;
import java.awt.*;

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
        mainMenuBtn.add(mainMenuBtn);

    }




}
