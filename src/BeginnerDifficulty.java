import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class BeginnerDifficulty {

    static String str[] = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

    ArrayList<String> wordList = new ArrayList<String>();
    DbLayer dbLayer = new DbLayer();
    String[] alphabets;
    TreeSet<String> singleCharSet = new TreeSet<String>();

    // fetch word from db
    // learn to slice it and create array of character using Set
    // TreeSet https://www.javatpoint.com/java-treeset
    // https://www.quora.com/How-do-you-split-a-word-in-Java


    public BeginnerDifficulty(String difficulty){

        int buttonRow, buttonClm, gamePlayRound=0;

        switch (difficulty) {
            case "easy.one":  buttonRow = 1; buttonClm = 3; gamePlayRound = 5;
                break;
            case "easy.two":  buttonRow = 1; buttonClm = 4; gamePlayRound = 8;
                break;
            case "easy.three":  buttonRow = 2; buttonClm = 2; gamePlayRound = 10;
                break;
            default: buttonRow = 2; buttonClm = 2;
                break;
        }

        wordList = dbLayer.wordFetcher(difficulty);

        for(String word : wordList){
            alphabets = word.split("");

            for(String alphabet : alphabets){
                singleCharSet.add(alphabet.toUpperCase());
            }
        }

        System.out.println("Printing fetched words");
        Iterator<String> itr = wordList.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

        // printing single character set
        //Iterator<String> itr = singleCharSet.iterator();
        //while (itr.hasNext()){
        //    System.out.println(itr.next());
        //}

        // setting button and column number

        new GamePlay(buttonRow, buttonClm, wordList, singleCharSet, gamePlayRound);

        }
}
