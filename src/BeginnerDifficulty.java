public class BeginnerDifficulty {

    public String wordsToMatch[] = {"AAM","ABACK","AAL","ABACATE", "BACK"};

    public BeginnerDifficulty(int difficulty){

        new GamePlay(2, wordsToMatch[difficulty], wordsToMatch[difficulty].length());

        }
}
