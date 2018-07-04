import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class DifficultySetter {

    static String str[] = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

    ArrayList<String> wordList = new ArrayList<String>();
    DbLayer dbLayer = new DbLayer();


    //String[] alphabets;
    //TreeSet<String> singleCharSet = new TreeSet<String>();

    // fetch word from db
    // learn to slice it and create array of character using Set
    // TreeSet https://www.javatpoint.com/java-treeset
    // https://www.quora.com/How-do-you-split-a-word-in-Java


    public DifficultySetter (String difficulty){

        int buttonRow, buttonClm, gamePlayRound=0;

        switch (difficulty) {
            case "easy.one":  buttonRow = 1; buttonClm = 3; gamePlayRound = 3;
                break;
            case "easy.two":  buttonRow = 1; buttonClm = 4; gamePlayRound = 8;
                break;
            case "easy.three":  buttonRow = 2; buttonClm = 3; gamePlayRound = 10;
                break;
            case "medium.one":  buttonRow = 2; buttonClm = 3; gamePlayRound = 3;
                break;
            case "medium.two":  buttonRow = 2; buttonClm = 4; gamePlayRound = 8;
                break;
            case "medium.three":  buttonRow = 3; buttonClm = 4; gamePlayRound = 10;
                break;
            case "hard.one":  buttonRow = 3; buttonClm = 4; gamePlayRound = 5;
                break;
            case "hard.two":  buttonRow = 3; buttonClm = 4; gamePlayRound = 8;
                break;
            case "hard.three":  buttonRow = 4; buttonClm = 4; gamePlayRound = 15;
                break;
            default: buttonRow = 2; buttonClm = 2;
                break;
        }

        //sending difficulty level and how many round of game will be played
        wordList = dbLayer.wordFetcher(difficulty, gamePlayRound);

        System.out.println("Printing fetched words");
        Iterator<String> itr = wordList.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

        // setting button and column number, passing fetched words, how many rounds and initial score and difficulty
        new GamePlay(buttonRow, buttonClm, wordList, gamePlayRound, 0, difficulty);

        }
}
