package playing.cards;

public interface Dealer {
    void shuffleCards();
    void flipCards();
    Card getCardByItsNumber(int index);
    void showCards();
}
