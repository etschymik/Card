import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

public class Card {
    /*
        Hearts = 1      Diamonds = 2     Spades = 3      Clubs = 4
        A   2   3   4   5   6   7   8   9   10  J   Q   K   (cardValue)
        0   1   2   3   4   5   6   7   8   9   10  11  12 (value)

        card number = (suit * 13) + value
        suit = cardNumber / 13 (integer division)
        value = cardNumber % 13
    */
    public ArrayList<Integer> deck = new ArrayList<>();
    public int size = 52;
    Random rand = new Random();

    public void fillDeck() {
        for (int i = 0; i < size; i++) {
            deck.add(i, i);
        }
        System.out.println(Arrays.toString(deck.toArray()));
    }

    public void shuffle() {
        int lastCard = size-1; // 51
        for (int i = 0; i < size; i++) {
            int cardToSwitch = rand.nextInt(lastCard+1);
            int temp = deck.get(cardToSwitch);
            deck.set(cardToSwitch, deck.get(lastCard));
            deck.set(lastCard, temp);
            lastCard--;
        }
        System.out.println(Arrays.toString(deck.toArray()));
    }

    public void pickRandomCard() {
        // picks random card
        int randomCard = rand.nextInt(size);
        int cardNumber = deck.get(randomCard);
        displayCard(cardNumber);
    }

    public void displayCard(int cardNumber) {
        // prints card suit and value of random card
        String suit = "";
        int suitNumber = cardNumber / 13;
        switch(suitNumber) {
            case 0 -> suit = "Hearts";
            case 1 -> suit = "Diamonds";
            case 2 -> suit = "Spades";
            case 3 -> suit = "Clubs";
        }
        String cardValue = "";
        int value = cardNumber % 13;
        switch(value) {
            case 0 -> cardValue = "Ace";
            case 1 -> cardValue = "2";
            case 2 -> cardValue = "3";
            case 3 -> cardValue = "4";
            case 4 -> cardValue = "5";
            case 5 -> cardValue = "6";
            case 6 -> cardValue = "7";
            case 7 -> cardValue = "8";
            case 8 -> cardValue = "9";
            case 9 -> cardValue = "10";
            case 10 -> cardValue = "Jack";
            case 11 -> cardValue = "Queen";
            case 12 -> cardValue = "King";
        }
        System.out.printf("%s of %s", cardValue, suit);
    }

    public void splitDeckIntoHands(Hand ... a) {
        int numOfHands = a.length;
        while(deck.size() > 0) {
            for (int i = 0; i < numOfHands; i++) {
                a[i].hand.add(deck.get(0));
                deck.remove(0);
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i].hand.toArray()));
        }
    }
}