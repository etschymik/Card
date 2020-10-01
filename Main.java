public class Main {
    public static void main(String[] args) {
        Card c = new Card();
        Hand h1 = new Hand();
        Hand h2 = new Hand();
        Hand h3 = new Hand();
        Hand h4 = new Hand();
        c.fillDeck();
        c.shuffle();
        c.splitDeckIntoHands(h1, h2, h3, h4);
    }
}
