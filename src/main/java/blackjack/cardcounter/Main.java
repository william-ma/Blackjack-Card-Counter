package blackjack.cardcounter;

import blackjack.cardcounter.strategy.HiLo;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class Main {

    private final static String USE_STRING = "./BlackjackCardCounter [number of decks] [cards seen...]";

    public static void main(String[] args) {

        int numDecks;

        if (args.length < 2) {
            System.err.println(USE_STRING);
            return;
        }

        try {
            numDecks = Integer.parseInt(args[0]);
            System.out.println("numDecks: " + numDecks);
        } catch (NumberFormatException e) {
            System.err.println(USE_STRING);
            return;
        }

        String[] cardReps = Arrays.copyOfRange(args, 1, args.length);
        for (String s : cardReps) {
            if (!Card.isValidCard(s)) {
                System.err.println("Invalid card found: " + s);
                return;
            }
        }

        List<Card> cards = Arrays.stream(cardReps).map(Card::new).toList();
        System.out.println("The running count is: " + HiLo.calcRunningCount(cards));
        System.out.println("The true count is: " + HiLo.calcTrueCount(numDecks, cards));
    }
}
