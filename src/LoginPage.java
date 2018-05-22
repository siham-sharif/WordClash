import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginPage extends JFrame{

    public JFrame loginFrame = new JFrame("User Login");
    public JLabel playerNameLabel;
    public static JTextField playerNameTextField;
    public JButton submitButton;

    public LoginPage(){

        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.getContentPane().setBackground(Color.darkGray);
        loginFrame.setSize(350,500);
        loginFrame.setVisible(true);
        loginFrame.setLayout(null);

        Font playerNameFont = new Font("Matura MT Script Capitals",Font.BOLD,20);

        playerNameLabel = new JLabel("Player Name");
        playerNameLabel.setBounds(150,150,200,100);
        playerNameLabel.setForeground(Color.LIGHT_GRAY);
        playerNameLabel.setFont(playerNameFont);

        playerNameTextField = new JTextField(20);
        playerNameTextField.setBounds(100,220,200,50);
        playerNameTextField.setForeground(Color.LIGHT_GRAY);
        playerNameTextField.setFont(playerNameFont);

        submitButton = new JButton("Submit");
        submitButton.setBounds(150,340,150,50);
        submitButton.setBackground(Color.WHITE);
        submitButton.setForeground(Color.BLACK);
        submitButton.setFont(playerNameFont);

        // adding everything to Frame
        loginFrame.add(playerNameLabel);
        loginFrame.add(playerNameTextField);
        loginFrame.add(submitButton);

        userVerification submitButtonClicked = new userVerification();
        submitButton.addActionListener(submitButtonClicked);

    }

    public class userVerification implements ActionListener{

        @Override
        public void actionPerformed (ActionEvent submitButtonClicked) {
            //System.out.println("Clicked on Submit button in login page");
            Toolkit.getDefaultToolkit().beep();

            DbLayer dbObject = new DbLayer();
            dbObject.checkLogin(playerNameTextField.getText());

        }
    }

}
