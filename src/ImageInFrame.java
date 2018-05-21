import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageInFrame extends JFrame{

    public JFrame jFrame = new JFrame();

    public ImageInFrame() throws IOException{

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        String splashPathDir = System.getProperty("user.dir");
        System.out.println(splashPathDir);
        String splashLocation = "src/splash.jpg";

        File splashFile = new File(splashPathDir,splashLocation);
        BufferedImage splashImage = ImageIO.read(splashFile);

        JLabel splashLabel = new JLabel(new ImageIcon(splashImage));

        jFrame.getContentPane().add(splashLabel);
        jFrame.setLocation(100,100);
        jFrame.setVisible(true);

    }

}
