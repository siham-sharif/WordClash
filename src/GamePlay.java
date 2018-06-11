import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

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
    public static int rowInPressBtn, clmInPressBtn;


    String letter[] = new String[ 100 ];
    JButton wordBtn[] = new JButton[ 100 ];


    public GamePlay(int buttonRow, int buttonClm, ArrayList<String> wordList, TreeSet<String> singleCharSet, int gamePlayRound) {

        System.out.println("Game Play Screen Activated");

        rowInPressBtn = buttonRow;
        clmInPressBtn = buttonClm;

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
        int tmp;

        int totalButton = buttonRow * buttonClm;

        // filling up the empty space of button
        while(singleCharSet.size() < totalButton){
            singleCharSet.add(str[ random.nextInt(25)]);
        }
        System.out.printf("Size of singleChatSet : %d\n", singleCharSet.size());
        System.out.printf("complete singleChatSet : %s\n", singleCharSet);

        ArrayList<String> singleCharList = new ArrayList<>(singleCharSet);

        int charPosition = 0;

        for (int rowStarter = 1; rowStarter <= buttonRow; rowStarter++){

            tmp = x-50;

            for(int clmStarter =1; clmStarter <= buttonClm; clmStarter++){

                if(singleCharList.size() > 1){
                    letter[charPosition] = singleCharList.get(random.nextInt(singleCharList.size()-1));
                }
                else{
                    letter[charPosition] = singleCharList.get(0);
                }
                singleCharList.remove(letter[charPosition]);

                wordBtn[charPosition] = new JButton(letter[ charPosition ]);
                wordBtn[charPosition].setFont(font);
                wordBtn[charPosition].setBackground(Color.WHITE);
                wordBtn[charPosition].setBounds(tmp, y, 100, 50);

                wordBtn[ charPosition ].addActionListener(this);
                gplayFrame.add(wordBtn[ charPosition ]);

                charPosition++;
                tmp += 100;

            }

            y += 50;
        }

        //x = width / 5;
        //y = y + 50;

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

                            gplayFrame.setVisible(false);
                            new DifficultySetter("easy.one"); /// this was j++
                        }

                    }

                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }

            if(actionTaken.getSource() == clearBtn){
                word = "WORD: ";
                wordLabel.setText(word);
            }
            if(actionTaken.getSource() == menuBtn){
                new MenuFrame();
                gplayFrame.setVisible(false);
            }
            else
                {

                    for (int i = 0; i < rowInPressBtn * clmInPressBtn; i++){
                        if(actionTaken.getSource() == wordBtn[ i ]){
                            word += letter[i];
                            wordLabel.setText(word);
                        }
                    }
                }
        }

}



