import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Help extends JFrame{


    public JFrame helpFrame = new JFrame("Help");
    public Font font = new Font("Matura MT Script Capitals",Font.BOLD,25);

    public JButton backBtn;
    public JLabel creditWordsLabel;
    public JPanel creditsPanel;

    public Help(){

        // basic skeleton of credit frame
        helpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        helpFrame.setSize(500,600);
        helpFrame.setTitle("Credit's");
        helpFrame.setVisible(true);
        helpFrame.setResizable(false);

        // ****************************
        // practise Jlabel and Jpanel
        // ****************************

        creditsPanel = new JPanel(new BorderLayout()); // whats happening ???

        creditWordsLabel = new JLabel();
        creditWordsLabel.setText("Help Text");

        creditWordsLabel.setFont(font);
        creditWordsLabel.setForeground(Color.DARK_GRAY);

        creditsPanel.add(creditWordsLabel, BorderLayout.NORTH);
        helpFrame.add(creditsPanel);

        // adding back button
        backBtn = new JButton("Back to Menu");
        backBtn.setSize(200,100);
        backBtn.setBackground(Color.DARK_GRAY);
        backBtn.setForeground(Color.WHITE);
        backBtn.setFont(font);

        // setting back button to bottom
        creditsPanel.add(backBtn, BorderLayout.SOUTH);

        backToMenu backBtnClicked = new backToMenu();
        backBtn.addActionListener(backBtnClicked);
    }

    public class backToMenu implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent backBtnClicked) {
            new MenuFrame();
            helpFrame.setVisible(false);
        }
    }


}
