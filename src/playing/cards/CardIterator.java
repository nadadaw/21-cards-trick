package playing.cards;

import java.util.ArrayList;
import java.util.Iterator;

public class CardIterator implements Iterator<Card>
{
    private final ArrayList<Card> cardList;
    private int nextIndex=0;
    private int lastIndex=-1;

    public CardIterator(ArrayList<Card> cardList)
    {
        this.cardList=cardList;
    }

    public boolean hasNext() {
        return nextIndex!=cardList.size();
    }

    public Card next() {
        lastIndex=nextIndex;
        nextIndex++;
        return cardList.get(lastIndex);
    }
}
