import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Help{


    public GameFrame helpFrame = new GameFrame("Help");
    public Font font = new Font("Matura MT Script Capitals",Font.BOLD,25);

    public GameButton backBtn;
    public JLabel creditWordsLabel;
    public JPanel creditsPanel;

    public Help(){

        helpFrame.setVisible(true);

        creditsPanel = new JPanel(new BorderLayout());

        creditWordsLabel = new JLabel();
        creditWordsLabel.setText("<html>"
                + "<h1>“Word Clash” is an awesome puzzle game.<h1>"
                + "<h3>This game is slightly different from "
                + "other puzzle games because in here player "
                + "need to play the game using the words. So, "
                + "player feel it very much interesting and "
                + "challenging to play “Word Clash”. “Word "
                + "Clash” is being divided into several "
                + "difficulty levels. Each level has been "
                + "into several stages. In each stages divided, "
                + "there are some puzzle words are being placed. "
                + "Player needs to make a meaningful word using "
                + "those puzzle words. In a word, the main "
                + "objective of the game is to make a "
                + "meaningful word using the given puzzle "
                + "words. Player needs to match and make a "
                + " meaning full words as requested in each "
                + " levels. At first all the levels as well "
                + "as the stages will be locked except the first "
                + " one. If player successfully finished first stage, "
                + " then the next stage will be unlocked. Players "
                + "need to play to unlock the all stages of all the "
                + "levels.</h3> "
                + "<p>      </p>"
                + "<p>      </p>"
                + "<p>      </p>"
                + " </html>"
        );

        creditWordsLabel.setFont(font);
        creditWordsLabel.setForeground(Color.DARK_GRAY);

        creditsPanel.add(creditWordsLabel, BorderLayout.NORTH);
        helpFrame.add(creditsPanel);

        // adding back button
        backBtn = new GameButton("Back to Menu");
        backBtn.setSize(200,100);

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
