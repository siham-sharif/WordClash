import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame {

    public JFrame menuFrame = new JFrame("Menu");
    public Font font = new Font("Matura MT Script Capitals",Font.BOLD,20);

    public JButton newGameBtn, rankListBtn, optionBtn, helpBtn, creditBtn, exitBtn;

    public JButton beginnerBtn, easyBtn, mediumBtn, hardBtn, profBtn;
    public JButton backBtn;


    public MenuFrame(){

        // setting menu frame basic parameter
        menuFrame.setResizable(false);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setVisible(true);
        menuFrame.setBounds(100,100, 500, 600);
        menuFrame.setLayout(null);

        menuFrame.getContentPane().setBackground(Color.darkGray);

        // new game button
        newGameBtn = new JButton("New Game");
        newGameBtn.setBounds(100,100,300,50);
        newGameBtn.setBackground(Color.WHITE);
        newGameBtn.setFont(font);

        menuFrame.add(newGameBtn);

        // Buttons under new game sections
        // beginner button
        beginnerBtn = new JButton("Beginner");
        beginnerBtn.setBounds(160,100,200,50);
        beginnerBtn.setBackground(Color.WHITE);
        beginnerBtn.setFont(font);

        // easy button
        easyBtn = new JButton("Easy");
        easyBtn.setBounds(160,160,200,50);
        easyBtn.setBackground(Color.WHITE);
        easyBtn.setFont(font);

        // medium button
        mediumBtn = new JButton("Medium");
        mediumBtn.setBounds(160,220,200,50);
        mediumBtn.setBackground(Color.WHITE);
        mediumBtn.setFont(font);

        // hard button
        hardBtn = new JButton("Hard");
        hardBtn.setBounds(160,280,200,50);
        hardBtn.setBackground(Color.WHITE);
        hardBtn.setFont(font);

        // proffesional button
        profBtn = new JButton("Professional");
        profBtn.setBounds(160,340,200,50);
        profBtn.setBackground(Color.WHITE);
        profBtn.setFont(font);

        // back button
        backBtn = new JButton("Back");
        backBtn.setBounds(160,400,200,50);
        backBtn.setBackground(Color.WHITE);
        backBtn.setFont(font);

        // Rank List Button
        rankListBtn = new JButton("Rank List");
        rankListBtn.setBounds(100, 160, 300, 50);
        rankListBtn.setBackground(Color.WHITE);
        rankListBtn.setFont(font);

        menuFrame.add(rankListBtn);

        //
        optionBtn =new JButton("Option");
        optionBtn.setBounds(100, 220, 300, 50);
        optionBtn.setBackground(Color.WHITE);
        optionBtn.setFont(font);

        menuFrame.add(optionBtn);

        // help button
        helpBtn=new JButton("Help");
        helpBtn.setBounds(100, 280, 300, 50);
        helpBtn.setBackground(Color.WHITE);
        helpBtn.setFont(font);

        menuFrame.add(helpBtn);

        // credit button
        creditBtn=new JButton("Credit's");
        creditBtn.setBounds(100, 340, 300, 50);
        creditBtn.setBackground(Color.WHITE);
        creditBtn.setFont(font);

        menuFrame.add(creditBtn);

        // exit button
        exitBtn=new JButton("Exit");
        exitBtn.setBounds(100, 400, 300, 50);
        exitBtn.setBackground(Color.WHITE);
        exitBtn.setFont(font);
        menuFrame.add(exitBtn);

        // adding listeners to buttons

        exitEvent exitBtnClicked = new exitEvent();
        exitBtn.addActionListener(exitBtnClicked);

        creditEvent creditBtnClicked = new creditEvent();
        creditBtn.addActionListener(creditBtnClicked);

        helpEvent helpBtnClicked = new helpEvent();
        helpBtn.addActionListener(helpBtnClicked);

        rankListEvent rankListBtnClicked = new rankListEvent();
        rankListBtn.addActionListener(rankListBtnClicked);
    }

    // exit event
    public class exitEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    // credit event
    public class creditEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            new Credits();
            menuFrame.setVisible(false);
        }
    }

    // help event
    public class helpEvent implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e) {
            new Help();
            menuFrame.setVisible(false);
        }
    }

    // rank list event
    public class rankListEvent implements ActionListener{

        @Override
        public void actionPerformed (ActionEvent e) {
            new RankList();
            menuFrame.setVisible(false);
        }
    }

}
