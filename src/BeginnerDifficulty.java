import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class BeginnerDifficulty {

    //public String wordsToMatch[] = {"AAM","ABACK","AAL","ABACATE", "BACK"};
    public String wordsToMatch[] = {"ABLE","GOOD","FINE","CAT"};
    ArrayList<String> wordList = new ArrayList<String>();
    DbLayer dbLayer = new DbLayer();
    String[] alphabets;
    TreeSet<String> singleCharSet = new TreeSet<String>();

    // fetch word from db
    // learn to slice it and create array of character using Set
    // TreeSet https://www.javatpoint.com/java-treeset
    // https://www.quora.com/How-do-you-split-a-word-in-Java


    public BeginnerDifficulty(int difficulty){

        wordList = dbLayer.wordFetcher();

        for(String word : wordList){
            alphabets = word.split("");

            for(String alphabet : alphabets){
                singleCharSet.add(alphabet);
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

        new GamePlay(2, 3, wordList, singleCharSet);

        }
}
