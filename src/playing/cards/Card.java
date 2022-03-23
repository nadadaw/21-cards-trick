package playing.cards;
import playing.cards.components.*;

public class Card {
    Suit suit;
    Rank rank;

    public Card(Rank rank, Suit suit) {
        this.rank=rank;
        this.suit=suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }


}
