import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RankList extends JFrame {

    public JFrame ranklistFrame = new JFrame("Help");
    public Font font = new Font("Matura MT Script Capitals",Font.BOLD,25);

    public JButton backBtn;
    public JLabel rankListLabel;
    public JPanel rankListPanel;

    public RankList(){

        //
        System.out.println("RankList Page hit!");
        // basic skeleton of credit frame
        ranklistFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ranklistFrame.setSize(500,600);
        ranklistFrame.setTitle("Credit's");
        ranklistFrame.setVisible(true);
        ranklistFrame.setResizable(false);

        // ****************************
        // practise Jlabel and Jpanel
        // ****************************

        rankListPanel = new JPanel(new BorderLayout()); // whats happening ???

        rankListLabel = new JLabel();
        rankListLabel.setText("Rank List table");
        rankListLabel.setFont(font);
        rankListLabel.setForeground(Color.DARK_GRAY);

        //rankListPanel.add(rankListLabel, BorderLayout.NORTH);
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
