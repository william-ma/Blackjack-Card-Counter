package blackjack.cardcounter.strategy;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class Red7 {

    private static final Map<Character, Integer> map = Map.ofEntries(
            new AbstractMap.SimpleEntry<>('2', 0),
            new AbstractMap.SimpleEntry<>('3', 1),
            new AbstractMap.SimpleEntry<>('4', 1),
            new AbstractMap.SimpleEntry<>('5', 1),
            new AbstractMap.SimpleEntry<>('6', 1),
            new AbstractMap.SimpleEntry<>('7', 1),
            new AbstractMap.SimpleEntry<>('8', 0),
            new AbstractMap.SimpleEntry<>('9', 0),
            new AbstractMap.SimpleEntry<>('t', -1),
            new AbstractMap.SimpleEntry<>('j', -1),
            new AbstractMap.SimpleEntry<>('q', -1),
            new AbstractMap.SimpleEntry<>('k', -1),
            new AbstractMap.SimpleEntry<>('a', -1)
    );

    public static int getRunningCount(List<Character> values) {

        int runningCount = 0;

        for (Character value : values) {
            if (map.containsKey(value)) {
                runningCount += map.get(value);
            } else {
                System.err.println("Error: key not found '" + value + "'");
            }
        }

        return runningCount;
    }

    public static int getTrueCount(int numDecks, List<Character> values) {
        return getRunningCount(values) / numDecks;
    }
}
