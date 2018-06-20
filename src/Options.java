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

    public Options(){

        optionFrame.setVisible(true);
        optionPanel = new JPanel(new BorderLayout());


        soundLabel.setFont(new Font("Serif", Font.BOLD, 20));
        soundLabel.setBounds(30, 20, 120, 50);
        //optionPanel.add(soundLabel);
        optionFrame.add(soundLabel);

        // radio button
        soundON = new JRadioButton("On");
        soundOFF = new JRadioButton("Off");

        soundON.setBounds(30, 70, 100, 30);
        soundOFF.setBounds(30, 120, 100, 30);

        soundON.addActionListener(this);
        soundOFF.addActionListener(this);

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
    }

    @Override
    public void actionPerformed (ActionEvent e) {

        if(soundON.isSelected()){
            soundOFF.clearSe;
            soundON.setSelected(true);
        }
        if(soundOFF.isSelected()){
            soundON.setSelected(false);
           soundOFF.setSelected(true);
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
