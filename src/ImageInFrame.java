import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageInFrame extends JFrame{

    public Timer timer;

    public JFrame jFrame = new JFrame("Word Clash");

    public ImageInFrame() throws IOException{

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(600,700);
        jFrame.setResizable(false);

        String splashPathDir = System.getProperty("user.dir");
        //System.out.println(splashPathDir);
        String splashLocation = "resource/images/splash.jpg";

        File splashFile = new File(splashPathDir,splashLocation);
        BufferedImage splashImage = ImageIO.read(splashFile);

        JLabel splashLabel = new JLabel(new ImageIcon(splashImage));

        jFrame.getContentPane().add(splashLabel);
        jFrame.setVisible(true);

        splashTimer();
    }

    public void splashTimer()
    {
        int counter = 3;
        TimeClass timeClass = new TimeClass(counter);
        timer = new Timer(1000, timeClass);
        timer.start();

    }

    public class TimeClass implements ActionListener{
        int counter;

        public TimeClass(int counter){
            this.counter = counter;
        }


        @Override
        public void actionPerformed (ActionEvent e)
        {
            counter--;

            if(counter<=0){
                jFrame.setVisible(false);
                new LoginPage();
                if(timer.isRunning()){
                    timer.stop();
                }
            }
        }
    }

}
