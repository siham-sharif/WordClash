import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameOverFrame extends JFrame implements ActionListener{

    private JFrame gameOverFrame;
    private GameButton gotoMenuBtn;
    private String gameStatusImage;

    SoundClip soundClip = new SoundClip();


    public GameOverFrame(String gameResult, String score) throws IOException{

        System.out.println("In Game Over Frame");

        gameOverFrame = new JFrame(gameResult);
        gameOverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameOverFrame.setSize(500, 600);
        gameOverFrame.setVisible(true);
        gameOverFrame.setLayout(null);
        gameOverFrame.getContentPane().setBackground(Color.WHITE);

        String gameStatusPathDir = System.getProperty("user.dir");
        //System.out.println(splashPathDir);
        if(gameResult.matches("You Won!")) {
            //gameStatusImage = "src/youWon.jpg";
            gameStatusImage = "resource/images/youWon.jpg";
            soundClip.winingSound();
        }
        else
        {
            gameStatusImage = "resource/images/youLose.jpg";
            soundClip.losingSound();
        }

        File gameResultFile = new File(gameStatusPathDir,gameStatusImage);
        BufferedImage resultIcon = ImageIO.read(gameResultFile);

        JLabel gameStatusLbl = new JLabel(new ImageIcon(resultIcon));
        gameStatusLbl.setBounds(-25,100,525,220);
        gameOverFrame.add(gameStatusLbl);

        JLabel gameScoreLbl = new JLabel("Your Score : " + score);
        gameScoreLbl.setBounds(140,300, 300,100);
        gameScoreLbl.setFont(new Font("Sherif", Font.BOLD, 25));
        gameScoreLbl.setForeground(Color.RED);
        gameOverFrame.add(gameScoreLbl);


        gotoMenuBtn = new GameButton("Go to Menu");
        gotoMenuBtn.setBounds(140,500,200,50);
        //gotoMenuBtn.setBackground(Color.WHITE);
        //gotoMenuBtn.setForeground(Color.BLACK);
        gotoMenuBtn.setFont(new Font("Arial", Font.BOLD,25));
        gotoMenuBtn.addActionListener(this);
        gameOverFrame.add(gotoMenuBtn);

    }

    @Override
    public void actionPerformed (ActionEvent buttonClicked) {
        if(buttonClicked.getSource() == gotoMenuBtn ){
            gameOverFrame.setVisible(false);
            new MenuFrame();
        }

    }
}
