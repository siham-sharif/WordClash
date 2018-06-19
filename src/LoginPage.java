import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginPage extends JFrame{

    public GameFrame loginFrame = new GameFrame("User Login");
    public JLabel playerNameLabel;
    public static JTextField playerNameTextField;
    //public JButton submitButton;
    public GameButton submitButton;

    public LoginPage(){

        loginFrame.getContentPane().setBackground(Color.darkGray);
        loginFrame.setVisible(true);
        loginFrame.setLayout(null);

        Font font = new Font("Matura MT Script Capitals",Font.BOLD,30);

        playerNameLabel = new JLabel("Player Name");
        playerNameLabel.setBounds(170,170,200,100);
        playerNameLabel.setForeground(Color.LIGHT_GRAY);
        playerNameLabel.setFont(font);

        playerNameTextField = new JTextField(20);
        playerNameTextField.setBounds(170,255,200,50);
        playerNameTextField.setForeground(Color.BLACK);
        playerNameTextField.setFont(font);

        submitButton = new GameButton("Submit");
        submitButton.setBounds(170,360,200,50);

        // adding everything to Frame
        loginFrame.add(playerNameLabel);
        loginFrame.add(playerNameTextField);
        loginFrame.add(submitButton, BorderLayout.CENTER);

        userVerification submitButtonClicked = new userVerification();
        submitButton.addActionListener(submitButtonClicked);

    }

    public class userVerification implements ActionListener{

        @Override
        public void actionPerformed (ActionEvent submitButtonClicked) {
            System.out.println("Clicked on Submit button in login page");

            DbLayer dbObject = new DbLayer();
            dbObject.checkLogin(playerNameTextField.getText());

            loginFrame.setVisible(false);
        }
    }

}
