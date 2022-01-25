package blackjack.cardcounter.strategy;

import blackjack.cardcounter.Card;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HiLo {

    public static int calcRunningCount(List<Card> cards) {

        List<Character> values = cards.stream().map(Card::getValue).toList();

        int runningCount = 0;
        for (Character value : values) {
            if (isLow(value)) {
                runningCount += 1;
            } else if (isHigh(value)) {
                runningCount -= 1;
            }
        }

        return runningCount;
    }

    private static boolean isLow(char value) {
        return (value >= '2' && value <= '6');
    }

    private static boolean isHigh(char value) {
        return Arrays.asList('t', 'j', 'q', 'k', 'a').contains(value);
    }

    private static boolean isNeutral(char value) {
        return (value >= '7' && value <= '9');
    }

    public static int calcTrueCount(int numDecks, List<Card> cards) {
        return calcRunningCount(cards)/numDecks;
    }

}
