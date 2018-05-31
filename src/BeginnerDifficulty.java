import java.util.ArrayList;

public class BeginnerDifficulty {

    public String wordsToMatch[] = {"AAM","ABACK","AAL","ABACATE", "BACK"};

    ArrayList<String> wordList = new ArrayList<String>();
    DbLayer dbLayer = new DbLayer();

    // fetch word from db
    // learn to slice it and create array of character using Set
    // https://www.quora.com/How-do-you-split-a-word-in-Java


    public BeginnerDifficulty(int difficulty){



        new GamePlay(2, wordsToMatch[difficulty], wordsToMatch[difficulty].length());

        }
}
