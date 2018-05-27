import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Credits extends JFrame {

    public JFrame creditFrame = new JFrame("Credits");
    public Font font = new Font("Matura MT Script Capitals",Font.BOLD,25);

    public JButton backBtn;
    public JLabel creditWordsLabel;
    public JPanel creditsPanel;

    public Credits(){

        // basic skeleton of credit frame
        creditFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        creditFrame.setSize(500,600);
        creditFrame.setVisible(true);
        creditFrame.setResizable(false);

        creditsPanel = new JPanel(new BorderLayout());

        creditWordsLabel = new JLabel();
        creditWordsLabel.setText("<html>"
                + "<h2>Team Details: </h2>"
                + "<h2>Siham Sharif</h2>"
                + "<h2>Reg No : 2009331049</h2>"
                + "<h2>Noor Mohammed Nadim Hossain</h2>"
                + "<h2>Reg No : 2009331044</h2>"
                +"</html>"
        );

        creditWordsLabel.setFont(font);
        creditWordsLabel.setForeground(Color.DARK_GRAY);

        creditsPanel.add(creditWordsLabel, BorderLayout.NORTH);
        creditFrame.add(creditsPanel);

        // adding back button
        backBtn = new JButton("Back to Menu");
        backBtn.setSize(200,100);
        backBtn.setBackground(Color.DARK_GRAY);
        backBtn.setForeground(Color.WHITE);
        backBtn.setFont(font);

        // setting back button to bottom
        creditsPanel.add(backBtn, BorderLayout.SOUTH);

        backToMenu backToMenu = new backToMenu();
        backBtn.addActionListener(backToMenu);
    }

    public class backToMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent backBtnClicked) {
            new MenuFrame();
            creditFrame.setVisible(false);
        }
    }

}
