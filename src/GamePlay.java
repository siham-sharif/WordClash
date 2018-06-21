import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

public class GamePlay extends JFrame implements ActionListener {

    public GameFrame gplayFrame = new GameFrame("Game ON!");
    public Font font = new Font("Viner Hand ITC", Font.BOLD, 15);

    public JButton doneBtn = new JButton("Done");
    private JButton clearBtn = new JButton("Clear");
    private JButton menuBtn = new JButton("Menu");

    public JLabel wordLabel;
    public String word = "WORD: ";

    public JLabel scoreLabel;
    public String score = "SCORE: ";
    public String textScore = "0";

    //frame
    static String str[] = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
    public static int rowInPressBtn, clmInPressBtn;


    String letter[] = new String[ 100 ];
    JButton wordBtn[] = new JButton[ 100 ];

    public int buttonRow;
    public int buttonClm;
    public ArrayList<String> wordList;
    public int gamePlayRound;
    public int numberScore;

    private String currentWord ="";


    public GamePlay(int buttonRow, int buttonClm, ArrayList<String> wordList, int gamePlayRound, int playerPrevScore) {


        System.out.println("Game Play Screen Activated");


        this.buttonRow=buttonRow;
        this.buttonClm=buttonClm;
        this.wordList=wordList;
        this.gamePlayRound=gamePlayRound;
        this.numberScore = playerPrevScore;

        this.rowInPressBtn = buttonRow;
        this.clmInPressBtn = buttonClm;

        gplayFrame.setLayout(null);
        gplayFrame.setVisible(true);
        gplayFrame.getContentPane().setBackground(Color.DARK_GRAY);

        // score label
        scoreLabel = new JLabel(score + Integer.toString(numberScore));
        scoreLabel.setFont(font);
        scoreLabel.setOpaque(true);
        scoreLabel.setBackground(Color.WHITE);
        scoreLabel.setForeground(Color.BLACK);
        scoreLabel.setBounds(330, 5, 120, 50);
        scoreLabel.setFont(scoreLabel.getFont().deriveFont(20.0f));

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

        // button height width x-y-axis position
        Random random = new Random();
        int width = 500;
        int height = 600;
        int buttonWidth = buttonRow * 100;
        int buttonHeight = buttonRow * 50;
        int x = (width - buttonWidth) / 2;
        int y = (height - buttonHeight) / 2;
        int tmp;

        int totalButton = buttonRow * buttonClm;

        // selecting and splitting the word
        String[] splittedChar;

        if (wordList.size() > 0 ) {
            currentWord = wordList.get(0); // taking one word and assigning to current word
            wordList.remove(currentWord);
        }

        TreeSet<String> singleCharSet = new TreeSet<String>();

            splittedChar = currentWord.split("");

            for(String singleChar : splittedChar){
                singleCharSet.add(singleChar.toUpperCase());
            }

        // filling up the empty space of button
        while(singleCharSet.size() < totalButton){
            singleCharSet.add(str[ random.nextInt(25)]);
        }
        System.out.printf("current word : %s", currentWord);
        System.out.printf("Size of singleChatSet : %d\n", singleCharSet.size());
        System.out.printf("complete singleChatSet : %s\n", singleCharSet);

        // placing the buttons according to splitted words
        ArrayList<String> singleCharList = new ArrayList<>(singleCharSet);

        int charPosition = 0;
        for (int rowStarter = 1; rowStarter <= buttonRow; rowStarter++){

            tmp = x-100;

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

        //done, clear, menu

        doneBtn.setBounds(130, 500, 100, 50);
        doneBtn.setBackground(Color.WHITE);
        doneBtn.setFont(font);
        doneBtn.addActionListener(this);
        gplayFrame.add(doneBtn);

        clearBtn.setBounds(230, 500, 100, 50);
        clearBtn.setBackground(Color.WHITE);
        clearBtn.setFont(font);
        clearBtn.addActionListener(this);
        gplayFrame.add(clearBtn);

        menuBtn.setBounds(330, 500, 100, 50);
        menuBtn.setBackground(Color.WHITE);
        menuBtn.setFont(font);
        menuBtn.addActionListener(this);
        gplayFrame.add(menuBtn);

    }

    public void actionPerformed(ActionEvent actionTaken) {

            if(actionTaken.getSource() == doneBtn){

                DbLayer dbLayer = new DbLayer();

                try{
                    // if matched logic
                    if (word.length() >= 2 && dbLayer.wordExist(word.toLowerCase())){
                        numberScore += word.length()-6; // -6 because of default --> "WORD: "
                        textScore = Integer.toString(numberScore);
                        scoreLabel.setText(textScore);

                        word = "";
                        if(gamePlayRound > 1){

                            --gamePlayRound;
                            gplayFrame.setVisible(false);
                            new GamePlay(buttonRow, buttonClm, wordList, gamePlayRound, numberScore);
                        }
                        else {
                            gplayFrame.setVisible(false);
                            dbLayer.updateScore(textScore);
                            new GameOverFrame("You Won!", textScore);
                        }

                    }
                    // if not matched logic
                    else{
                        textScore = Integer.toString(numberScore);
                        gplayFrame.setVisible(false);
                        dbLayer.updateScore(textScore);
                        new GameOverFrame("You Lost!", textScore);
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            // clear button work
            if(actionTaken.getSource() == clearBtn){
                word = "WORD: ";
                wordLabel.setText(word);
            }
            if(actionTaken.getSource() == menuBtn){
                new MenuFrame();
                gplayFrame.setVisible(false);
            }
            // clicking on single character button will set the upper label section to selected words
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



