package blackjack.cardcounter.strategy;

import java.util.List;


/*
    TODO: code can be improved by having an abstract subclass that has static methods...
    and an empty unpopulated Map... then when the variable is instatianted...
    if i want to instantiate or not... not much point because it holds nothing?
    unless i want to change it to hold the cards and just add... new cards in?
    i suppose i could populate the static map if it's unpopulated... extra logic... but doable...
 */

public interface Strategy {
    int getRunningCount(List<Character> values);
    int getTrueCount(int numDecks, List<Character> values);
}
