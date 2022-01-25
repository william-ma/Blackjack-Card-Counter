package blackjack.cardcounter;

public class Main {

    private final static String USE_STRING = "./BlackjackCardCounter [number of decks] [cards seen...]";

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println(USE_STRING);
            return;
        }

//        StringUtils.
        System.out.println(args);
        try {
            int numDecks = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println(USE_STRING);
            return;
        }


    }
}
