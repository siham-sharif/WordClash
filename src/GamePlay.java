import com.sun.javaws.util.JfxHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePlay extends JFrame implements ActionListener {

    public JFrame gplayFrame = new JFrame("Game ON!");
    public Font font = new Font("Viner Hand ITC", Font.BOLD, 15);

    public JButton doneBtn = new JButton("Done");
    private JButton clearBtn = new JButton("Clear");
    private JButton menuBtn = new JButton("Menu");

    public JLabel wordLabel;
    public String word = "WORD: ";

    public JLabel scoreLabel;
    public String score = "SCORE: ";

    public GamePlay(int length, String wordList, int stringLength){

        System.out.println("Game Play Screen Activated");

        gplayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gplayFrame.setSize(500,600);
        gplayFrame.setResizable(false);
        gplayFrame.setLayout(null);
        gplayFrame.setVisible(true);

        gplayFrame.getContentPane().setBackground(Color.DARK_GRAY);

        // score label
        scoreLabel = new JLabel(score);
        scoreLabel.setFont(font);
        scoreLabel.setOpaque(true);
        scoreLabel.setBackground(Color.WHITE);
        scoreLabel.setForeground(Color.BLACK);
        scoreLabel.setBounds(330,5,80,50);
        scoreLabel.setFont(scoreLabel.getFont().deriveFont(18.0f));

        gplayFrame.add(scoreLabel);

        //word label
        wordLabel = new JLabel(word);
        wordLabel.setFont(font);
        wordLabel.setOpaque(true);
        wordLabel.setBackground(Color.WHITE);
        wordLabel.setForeground(Color.BLUE);
        wordLabel.setBounds(10,5,250,50);
        wordLabel.setFont(scoreLabel.getFont().deriveFont(18.0f));

        gplayFrame.add(wordLabel);

        //done, clear, menu

        doneBtn.setBounds(100,500,100,50);
        doneBtn.setBackground(Color.WHITE);
        doneBtn.setFont(font);
        gplayFrame.add(doneBtn);

        clearBtn.setBounds(200,500,100,50);
        clearBtn.setBackground(Color.WHITE);
        clearBtn.setFont(font);
        gplayFrame.add(clearBtn);

        menuBtn.setBounds(300,500,100,50);
        menuBtn.setBackground(Color.WHITE);
        menuBtn.setFont(font);
        gplayFrame.add(menuBtn);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
