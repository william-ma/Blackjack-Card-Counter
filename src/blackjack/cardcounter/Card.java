package blackjack.cardcounter;

import java.util.Arrays;

public class Card {

    // Cards are represented in the format of "[value][suit]"
    // E.g. "2d" is 2 of diamonds
    String rep;

    public static boolean isValidCard(String rep) {
        if (rep.length() != 2) {
            return false;
        }

        String repLower = rep.toLowerCase();

        char value = repLower.charAt(0);
        boolean isValidValue = (value >= '2' && value <= '9') ||
                Arrays.asList('j', 'q', 'k', 'a').contains(value);
        if (!isValidValue) {
            return false;
        }

        char suit = repLower.charAt(1);
        boolean isValidSuit = Arrays.asList('d', 'c', 'h', 's').contains(suit);
        if (!isValidSuit) {
            return false;
        }

        return true;
    }
}
