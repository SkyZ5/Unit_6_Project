import java.util.*;

public class CardClassifyUtility {
    // Direction
    // Ace,King,Queen,Jack,10,9,8,7,6,5,4,3,2
    // 14,13,12,11,10,9,8,7,6,5,4,3,2
    // 12,11,10,9,8,7,6,5,4,3,2,1,0
    private int[] labelAmounts; // example: [0, 1, 3, 1, 0, 0, 0...]
    private int[] hand;

    public CardClassifyUtility(int[] hand) {
        this.hand = hand;
        labelAmounts = new int[13];
        for (int i = 0; i < labelAmounts.length; i++) {
            labelAmounts[i] = 0;
        }
    }
    private void addLabelAmounts() {
        for(int i = 0; i < hand.length; i++){
            labelAmounts[(hand[i] - 2)] = labelAmounts[(hand[i] - 2)] + 1;
        }
    }
    public String classify(){
        addLabelAmounts();
        ArrayList<Integer> labelsCopy = new ArrayList<>();
        for (int i = 0; i < labelAmounts.length; i ++) {
            labelsCopy.add(labelAmounts[i]);
        }
        System.out.println(labelsCopy);
        if (labelsCopy.contains(5)) {
            return "5KIND";
        }
        else if (labelsCopy.contains(4)) {
            return "4KIND";
        }
        else if (labelsCopy.contains(3) && labelsCopy.contains(2)) {
            return "FULLHOUSE";
        }
        else if (labelsCopy.contains(3)) {
            return "3KIND";
        }
        else if (Collections.frequency(labelsCopy, 2) == 2) { // if 2 appears 2
            return "2PAIR";
        }
        else if (labelsCopy.contains(2))
            return "1PAIR";
        return "HIGHCARD";
    }

}
