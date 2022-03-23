package playing.cards.pack;

import generics.Stack;
import playing.cards.Card;
import playing.cards.CardIterator;
import playing.cards.Dealer;
import playing.cards.components.*;

import java.util.*;

public class Deck extends Stack<Card> implements Dealer,Iterable<Card> {
    private static Deck cardDeck = null;
    private final int deckSize;

    private Deck()
    {
        deckSize=52;
    }

    public static Deck getCardDeck()
    {
        if(cardDeck==null) {
            cardDeck = new Deck();
        for(int i=0;i<cardDeck.getDeckSize();i++)
        {
            Card myCard = new Card(Rank.values()[i%13], Suit.values()[i/13]);
            cardDeck.push(myCard);
        }
        }
        else
            System.out.println("There should be only one card deck in the game.");

        return cardDeck;
    }

    public int getDeckSize() {
        return deckSize;
    }

    public void shuffleCards()
    {
        Collections.shuffle(sList);
    }

    public Card getCardByItsNumber(int index)
    {
        return sList.get(index-1);
    }

    public void flipCards() { Collections.reverse(sList); }

    public Iterator<Card> iterator() {
        return new CardIterator(sList);
    }

    public void restoreCards(CardColumn cardColumn)
    {
        /*
        Iterator<Card> columnIterator = cardColumn.iterator();
        while(columnIterator.hasNext())
        {
            cardDeck.push(cardColumn.deQ());
        }
        */
        for(Card card : cardColumn)
            cardDeck.push(card);
    }

    // For tracing purposes
    public void showCards()
    {
        Iterator<Card> deckIterator= getCardDeck().iterator();
        int printCounter = 1;
        System.out.println(" --- PRINTING DECK --- ");
        while(deckIterator.hasNext()) {
            System.out.print("Card #" + printCounter + ": ");
            System.out.println(deckIterator.next());
            printCounter++;
        }
    }

}
