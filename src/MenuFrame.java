import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame {

    public GameFrame menuFrame = new GameFrame("Menu");
    public Font font = new Font("Matura MT Script Capitals",Font.BOLD,20);

    public GameButton newGameBtn, rankListBtn, optionBtn, helpBtn, creditBtn, exitBtn;

    public JButton beginnerBtn, easyBtn, mediumBtn, hardBtn, profBtn;
    public JButton backBtn;

    public JFrame gameStageFrame = new JFrame("Game Stages");


    public MenuFrame(){

        // setting menu frame basic parameter

        menuFrame.setVisible(true);
        menuFrame.setLayout(null);
        menuFrame.getContentPane().setBackground(Color.darkGray);

        // new game button
        newGameBtn = new GameButton("New Game");
        newGameBtn.setBounds(145,100,300,50);

        menuFrame.add(newGameBtn);

        // Buttons under new game sections
        // beginner button
        beginnerBtn = new GameButton("Beginner");
        beginnerBtn.setBounds(160,160,200,50);
        //beginnerBtn.setBackground(Color.WHITE);
        //beginnerBtn.setFont(font);

        // easy button
        //easyBtn = new JButton("Easy");
        //easyBtn.setBounds(160,160,200,50);
        //easyBtn.setBackground(Color.WHITE);
        //easyBtn.setFont(font);

        // medium button
        mediumBtn = new GameButton("Medium");
        mediumBtn.setBounds(160,220,200,50);
        //mediumBtn.setBackground(Color.WHITE);
        //mediumBtn.setFont(font);

        // hard button
        hardBtn = new GameButton("Hard");
        hardBtn.setBounds(160,280,200,50);
        //hardBtn.setBackground(Color.WHITE);
        //hardBtn.setFont(font);


        // back button
        backBtn = new GameButton("Back");
        backBtn.setBounds(160,400,200,50);
        //backBtn.setBackground(Color.WHITE);
        //backBtn.setFont(font);

        // Rank List Button
        rankListBtn = new GameButton("Rank List");
        rankListBtn.setBounds(145, 160, 300, 50);
        menuFrame.add(rankListBtn);

        //
        optionBtn =new GameButton("Option");
        optionBtn.setBounds(145, 220, 300, 50);
        menuFrame.add(optionBtn);

        // help button
        helpBtn=new GameButton("Help");
        helpBtn.setBounds(145, 280, 300, 50);
        menuFrame.add(helpBtn);

        // credit button
        creditBtn=new GameButton("Credits");
        creditBtn.setBounds(145, 340, 300, 50);

        menuFrame.add(creditBtn);

        // exit button
        exitBtn=new GameButton("Exit");
        exitBtn.setBounds(145, 400, 300, 50);
        menuFrame.add(exitBtn);

        // adding listeners to buttons

        optionEvent optBtnClicked = new optionEvent();
        optionBtn.addActionListener(optBtnClicked);

        exitEvent exitBtnClicked = new exitEvent();
        exitBtn.addActionListener(exitBtnClicked);

        creditEvent creditBtnClicked = new creditEvent();
        creditBtn.addActionListener(creditBtnClicked);

        helpEvent helpBtnClicked = new helpEvent();
        helpBtn.addActionListener(helpBtnClicked);

        rankListEvent rankListBtnClicked = new rankListEvent();
        rankListBtn.addActionListener(rankListBtnClicked);


        // working with stages
        newGameStarter newGameBtnClicked = new newGameStarter();
        newGameBtn.addActionListener(newGameBtnClicked);

        //easy button event
        beginnerLevel beginnerBtnClicked = new beginnerLevel();
        beginnerBtn.addActionListener(beginnerBtnClicked);


    }

    //option event
    public class optionEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            new Options();
            menuFrame.setVisible(false);
        }
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

    public class newGameStarter implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            menuFrame.setVisible(false);
            // game stage frame basic skeleton
            gameStageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gameStageFrame.getContentPane().setBackground(Color.DARK_GRAY);
            gameStageFrame.setResizable(false);
            gameStageFrame.setLayout(null);
            gameStageFrame.setBounds(100,100,500,600);
            gameStageFrame.setVisible(true);


            // adding level button
            gameStageFrame.add(beginnerBtn);
            gameStageFrame.add(mediumBtn);
            gameStageFrame.add(hardBtn);

        }
    }

    public class beginnerLevel implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Beginner Button Clicked");
            new BeginnerLevel();
            gameStageFrame.setVisible(false);
            menuFrame.setVisible(false);

        }
    }
}
