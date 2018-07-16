import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Options extends JFrame implements ActionListener{

    public GameFrame optionFrame = new GameFrame("Options");
    public Font font = new Font("Matura MT Script Capitals",Font.BOLD,25);

    public GameButton backBtn;
    public JPanel optionPanel;
    public JLabel soundLabel = new JLabel("Sound");

    public JRadioButton soundON, soundOFF;

    SoundClip soundClip = new SoundClip();

    public Options(){

        ButtonGroup buttonGroup = new ButtonGroup();

        optionFrame.setVisible(true);
        optionPanel = new JPanel(new BorderLayout());

        soundLabel.setFont(new Font("Serif", Font.BOLD, 20));
        soundLabel.setBounds(50, 50, 120, 50);
        //optionPanel.add(soundLabel);
        optionFrame.add(soundLabel);

        // radio button
        soundON = new JRadioButton("On");
        soundOFF = new JRadioButton("Off");

        soundON.setBounds(50, 105, 100, 30);
        soundOFF.setBounds(50, 140, 100, 30);

        soundON.addActionListener(this);
        soundOFF.addActionListener(this);

        buttonGroup.add(soundON);
        buttonGroup.add(soundOFF);

        optionFrame.add(soundON);
        optionFrame.add(soundOFF);

        // adding back button
        backBtn = new GameButton("Back to Menu");
        backBtn.setSize(200,100);

        // setting back button to bottom
        optionPanel.add(backBtn, BorderLayout.SOUTH);
        optionFrame.add(optionPanel);

        backToMenu backBtnClicked = new backToMenu();
        backBtn.addActionListener(backBtnClicked);
        optionFrame.setVisible(true);
    }

    @Override
    public void actionPerformed (ActionEvent e) {

        if(soundON.isSelected()){
            System.out.println("sound on is selected!");
            soundClip.themeSongStatus(true);

        }
        if(soundOFF.isSelected()){
            System.out.println("sound off is selected!");
            soundClip.themeSongStatus(false);
        }

    }

    public class backToMenu implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent backBtnClicked) {
            new MenuFrame();
            optionFrame.setVisible(false);
        }
    }


}
