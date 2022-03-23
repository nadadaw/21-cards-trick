package playing.cards.pack;

import generics.Queue;
import playing.cards.Card;
import playing.cards.CardIterator;
import playing.cards.Dealer;

import java.util.Collections;
import java.util.Iterator;

public class CardColumn extends Queue<Card> implements Iterable<Card>, Dealer {
    private final int columnSize;
    private final int columnNumber;
    public CardColumn(int columnNumber) {
        columnSize=7;
        this.columnNumber=columnNumber;
    }

    public Iterator<Card> iterator() {
        return new CardIterator(qList);
    }

    public int getColumnSize() {
        return columnSize;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    @Override
    public void shuffleCards() {
        Collections.shuffle(qList);
    }

    @Override
    public void flipCards() {
        Collections.reverse(qList);
    }

    @Override
    public Card getCardByItsNumber(int index) {
        return qList.get(index-1);
    }

    @Override
    public void showCards() {
        System.out.println("--- COLUMN " + this.getColumnNumber() + " --- ");

        Iterator<Card> columnIterator = this.iterator();
        int printCounter = 1;
        while (columnIterator.hasNext()) {
            System.out.print("Card #" + printCounter + ": ");
            System.out.println(columnIterator.next());
            printCounter++;
        }
    }


}
