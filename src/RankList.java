import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RankList extends JFrame {

    public JFrame ranklistFrame = new JFrame("Rank List");
    public Font font = new Font("Matura MT Script Capitals", Font.BOLD, 25);

    public JButton backBtn;
    public JLabel rankListLabel;


    private class Users {

        private String userName;
        private String userScore;

        public Users (String userName, String userScore) {
            this.userName = userName;
            this.userScore = userScore;
        }

        public String getUserName(){
            return this.userName;
        }

        public String getUserScore(){
            return this.userScore;
        }
    }


    public RankList(){

        //
        System.out.println("RankList Page hit!");
        // basic skeleton of credit frame
        ranklistFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ranklistFrame.setSize(500,600);
        ranklistFrame.setVisible(true);
        ranklistFrame.setResizable(false);

        rankListLabel = new JLabel();
        rankListLabel.setText("Rank List table");
        rankListLabel.setFont(font);
        rankListLabel.setForeground(Color.DARK_GRAY);

        ranklistFrame.add(rankListLabel, BorderLayout.NORTH);











        // adding back button
        backBtn = new JButton("Back to Menu");
        backBtn.setSize(200,100);
        backBtn.setBackground(Color.DARK_GRAY);
        backBtn.setForeground(Color.WHITE);
        backBtn.setFont(font);

        // setting back button to bottom
        //rankListPanel.add(backBtn, BorderLayout.SOUTH);
        ranklistFrame.add(backBtn, BorderLayout.SOUTH);

        backToMenu backBtnClicked = new backToMenu();
        backBtn.addActionListener(backBtnClicked);
    }

    public class backToMenu implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent backBtnClicked) {
            new MenuFrame();
            ranklistFrame.setVisible(false);
        }
    }

}
