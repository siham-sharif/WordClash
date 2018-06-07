import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

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
    public String textScore = "0";
    public int numberScore = 0;

    public static int j;

    //frame
    static String str[] = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
    public static int rowInPressBtn;
    String letter[] = new String[ 100 ];
    JButton wordBtn[] = new JButton[ 100 ];


    public GamePlay(int buttonRow, String singleWord, int stringLength) {

        System.out.println("Game Play Screen Activated");

        rowInPressBtn = buttonRow;

        gplayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gplayFrame.setSize(500, 600);
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
        scoreLabel.setBounds(330, 5, 80, 50);
        scoreLabel.setFont(scoreLabel.getFont().deriveFont(18.0f));

        gplayFrame.add(scoreLabel);

        //word label
        wordLabel = new JLabel(word);
        wordLabel.setFont(font);
        wordLabel.setOpaque(true);
        wordLabel.setBackground(Color.WHITE);
        wordLabel.setForeground(Color.BLUE);
        wordLabel.setBounds(10, 5, 250, 50);
        wordLabel.setFont(scoreLabel.getFont().deriveFont(18.0f));

        gplayFrame.add(wordLabel);

        // frame
        Random random = new Random();
        int width = 500;
        int height = 600;
        int buttonWidth = buttonRow * 100;
        int buttonHeight = buttonRow * 50;
        int x = (width - buttonWidth) / 2;
        int y = (height - buttonHeight) / 2;
        int tmp = x;
        //int tmp2 = y;
        int i, j, cnt = 0, ind2 = singleWord.length() - 1;
        for (i = 1; i <= buttonRow; i++) {
            tmp = x;
            for (j = 1; j <= buttonRow + 1; j++) {
                if (cnt < stringLength) {
                    letter[ cnt ] = singleWord.substring(ind2, ind2 + 1);
                    wordBtn[ cnt ] = new JButton(letter[ cnt ]);
                    wordBtn[ cnt ].setFont(font);
                } else {
                    letter[ cnt ] = str[ random.nextInt(25) ];
                    wordBtn[ cnt ] = new JButton(letter[ cnt ]);
                    wordBtn[ cnt ].setFont(font);
                }
                wordBtn[ cnt ].setBackground(Color.WHITE);
                wordBtn[ cnt ].setBounds(tmp, y, 100, 50);
                wordBtn[ cnt ].addActionListener(this);
                gplayFrame.add(wordBtn[ cnt ]);
                tmp += 100;
                cnt++;
                ind2--;
            }
            y += 50;
        }

        x = width / 5;
        y = y + 50;

        //done, clear, menu

        doneBtn.setBounds(100, 500, 100, 50);
        doneBtn.setBackground(Color.WHITE);
        doneBtn.setFont(font);
        doneBtn.addActionListener(this);
        gplayFrame.add(doneBtn);

        clearBtn.setBounds(200, 500, 100, 50);
        clearBtn.setBackground(Color.WHITE);
        clearBtn.setFont(font);
        clearBtn.addActionListener(this);
        gplayFrame.add(clearBtn);

        menuBtn.setBounds(300, 500, 100, 50);
        menuBtn.setBackground(Color.WHITE);
        menuBtn.setFont(font);
        gplayFrame.add(menuBtn);


    }
        public void actionPerformed(ActionEvent actionTaken) {

            if(actionTaken.getSource() == doneBtn){

                DbLayer dbLayer = new DbLayer();

                try{
                    if (word.length() > 2 && dbLayer.wordExist(word.toLowerCase())){
                        numberScore += word.length();
                        textScore = Integer.toString(numberScore);
                        scoreLabel.setText(textScore);

                        word = "";
                        if(rowInPressBtn == 2 ){
                            ++j;
                            gplayFrame.setVisible(false);
                            new BeginnerDifficulty(j);
                            //new BeginnerLevel(j);
                        }

                    }

                }
                catch(Exception excep)
                {

                }
            }

            if(actionTaken.getSource() == clearBtn){
                word = "WORD: ";
                wordLabel.setText(word);
            }
            else
                {

                    for (int i = 0; i < rowInPressBtn * rowInPressBtn; i++){
                        if(actionTaken.getSource() == wordBtn[ i ]){
                            word += letter[i];
                            wordLabel.setText(word);
                        }
                    }
                }
        }

}



