package generics;

import java.util.ArrayList;

public class Queue<T>
{
    public ArrayList<T> qList;
    public Queue ()
    {
        qList= new ArrayList<> ();
    }

    public void enQ (T element)
    {
        qList.add (element);
    }

    public T deQ ()
    {
        T item= null;

        if (this.size () > 0)
            item= qList.remove (0);

        return item;
    }

    public int size ()
    {
        return qList.size ();
    }

    public void clear() { qList.clear(); }

}
