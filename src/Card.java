import java.util.Arrays;

public class Card {
    private int[] hand;
    private String highestHand;

    public Card(String[] hand){
        TranslationUtility trans = new TranslationUtility();
        this.hand = trans.toNumbers(hand);
        CardClassifyUtility cardClassifyUtility = new CardClassifyUtility(this.hand);
        highestHand = cardClassifyUtility.classify();
    }

    public String getHighestHand() {
        return highestHand;
    }

    public String toString(){
        return "\nHand: " + Arrays.toString(hand) + " Highest Hand: " + highestHand;

    }
    public int[] getHand(){
        return hand;
    }
}
