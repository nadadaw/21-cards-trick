import playing.cards.*;
import playing.cards.pack.CardColumn;
import playing.cards.pack.Deck;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello! Let's play a game!");
        BufferedWriter out;
        final String fileName = String.valueOf(System.currentTimeMillis());
        Scanner input = new Scanner(System.in);

        Deck myDeck = Deck.getCardDeck();
        myDeck.shuffleCards();

        CardColumn firstCardColumn = new CardColumn(1);
        CardColumn secondCardColumn = new CardColumn(2);
        CardColumn thirdCardColumn = new CardColumn(3);

        int count=1;
        int writeToFileCounter = 1;
        Iterator<Card> deckIterator= myDeck.iterator();
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
            while (deckIterator.hasNext() && count != 8) {
                out.write("Card #" + writeToFileCounter++ + ": " + myDeck.peek() + "\n");
                firstCardColumn.enQ(myDeck.pop());
                out.write("Card #" + writeToFileCounter++ + ": " + myDeck.peek() + "\n");
                secondCardColumn.enQ(myDeck.pop());
                out.write("Card #" + writeToFileCounter++ + ": " + myDeck.peek() + "\n");
                thirdCardColumn.enQ(myDeck.pop());
                count++;
            }
            out.close();
        }
        catch(IOException E)
        {
            //System.out.println(E);
            System.out.println("A file related error has occurred.");
        }

        System.out.println("Pick a card from one of the following columns: ");
        System.out.println("And don't forget it! ");
        printAllColumns(firstCardColumn,secondCardColumn,thirdCardColumn);
        System.out.println("Which column is your card in? Enter either 1, 2, or 3: ");

        writeColumnToFile(firstCardColumn,fileName);
        writeColumnToFile(secondCardColumn,fileName);
        writeColumnToFile(thirdCardColumn,fileName);

        int selectedColumn;
        boolean validInput = false;
        do {
            selectedColumn = input.nextInt();
            myDeck.clear();
            switch (selectedColumn) {
                case 1: {
                    myDeck.restoreCards(secondCardColumn); // Column 2
                    myDeck.restoreCards(firstCardColumn); // Column 1
                    myDeck.restoreCards(thirdCardColumn); // Column 3
                    validInput = true;
                    break;
                }
                case 2: {
                    myDeck.restoreCards(firstCardColumn); // Column 1
                    myDeck.restoreCards(secondCardColumn); // Column 2
                    myDeck.restoreCards(thirdCardColumn); // Column 3
                    validInput = true;
                    break;
                }
                case 3: {
                    myDeck.restoreCards(firstCardColumn); // Column 1
                    myDeck.restoreCards(thirdCardColumn); // Column 3
                    myDeck.restoreCards(secondCardColumn); // Column 2
                    validInput = true;
                    break;
                }
                default: {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        } while(!validInput);

        writeChoiceToFile(selectedColumn, fileName);
        myDeck.flipCards();
       // myDeck.printDeck();

        firstCardColumn.clear();
        secondCardColumn.clear();
        thirdCardColumn.clear();

        count=1;
        while(deckIterator.hasNext() && count!=8)
        {
            firstCardColumn.enQ(myDeck.pop());
            secondCardColumn.enQ(myDeck.pop());
            thirdCardColumn.enQ(myDeck.pop());
            count++;
        }

        System.out.println("Again - Which column is your card in? Enter either 1, 2, or 3: ");
        printAllColumns(firstCardColumn,secondCardColumn,thirdCardColumn);

        writeColumnToFile(firstCardColumn,fileName);
        writeColumnToFile(secondCardColumn,fileName);
        writeColumnToFile(thirdCardColumn,fileName);

        validInput=false;
        myDeck.clear();
        do {
            selectedColumn = input.nextInt();
            switch (selectedColumn) {
                case 1: {
                    myDeck.restoreCards(secondCardColumn); // Column 2
                    myDeck.restoreCards(firstCardColumn); // Column 1
                    myDeck.restoreCards(thirdCardColumn); // Column 3
                    validInput=true;
                    break;
                }
                case 2: {
                    myDeck.restoreCards(firstCardColumn); // Column 1
                    myDeck.restoreCards(secondCardColumn); // Column 2
                    myDeck.restoreCards(thirdCardColumn); // Column 3
                    validInput=true;
                    break;
                }
                case 3: {
                    myDeck.restoreCards(firstCardColumn); // Column 1
                    myDeck.restoreCards(thirdCardColumn); // Column 3
                    myDeck.restoreCards(secondCardColumn); // Column 2
                    validInput=true;
                    break;
                }
                default: {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        } while(!validInput);
        writeChoiceToFile(selectedColumn,fileName);
        myDeck.flipCards();
       // myDeck.printDeck();

        firstCardColumn.clear();
        secondCardColumn.clear();
        thirdCardColumn.clear();

        count=1;
        while(deckIterator.hasNext() && count!=8)
        {
            firstCardColumn.enQ(myDeck.pop());
            secondCardColumn.enQ(myDeck.pop());
            thirdCardColumn.enQ(myDeck.pop());
            count++;
        }

        System.out.println("For the last time - Which column is your card in? Enter either 1, 2, or 3: ");
        printAllColumns(firstCardColumn,secondCardColumn,thirdCardColumn);

        writeColumnToFile(firstCardColumn,fileName);
        writeColumnToFile(secondCardColumn,fileName);
        writeColumnToFile(thirdCardColumn,fileName);

        validInput=false;
        myDeck.clear();
        do {
            selectedColumn=input.nextInt();
            switch (selectedColumn) {
                case 1: {
                    myDeck.restoreCards(secondCardColumn); // Column 2
                    myDeck.restoreCards(firstCardColumn); // Column 1
                    myDeck.restoreCards(thirdCardColumn); // Column 3
                    validInput=true;
                    break;
                }
                case 2: {
                    myDeck.restoreCards(firstCardColumn); // Column 1
                    myDeck.restoreCards(secondCardColumn); // Column 2
                    myDeck.restoreCards(thirdCardColumn); // Column 3
                    validInput=true;
                    break;
                }
                case 3: {
                    myDeck.restoreCards(firstCardColumn); // Column 1
                    myDeck.restoreCards(thirdCardColumn); // Column 3
                    myDeck.restoreCards(secondCardColumn); // Column 2
                    validInput=true;
                    break;
                }
                default: {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        } while(!validInput);

        writeChoiceToFile(selectedColumn,fileName);
        myDeck.flipCards();

        // System.out.println("I read your mind! Your chosen card was: " + myDeck.getCardByItsNumber(11));

        for(int i=0;i<10;i++)
        {
           myDeck.pop();
        }
        System.out.println("I read your mind! Your chosen card was: " + myDeck.peek());
        System.out.println("Thank you for playing!");

        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)));
            out.write("The player's card: " + myDeck.peek() + "\n");
            out.close();
        }

        catch(IOException E)
        {
            System.out.println("A file related error has occurred.");
        }

    }

    public static void writeColumnToFile(CardColumn cardColumn, String fileName) {
        BufferedWriter out;
        try
        {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)));
            out.write(" --- COLUMN " + cardColumn.getColumnNumber() + " --- \n");
            Iterator<Card> columnIterator = cardColumn.iterator();
            int printCounter = 1;
           while (columnIterator.hasNext()) {
               out.write("Card #" + printCounter + ": ");
               out.write(columnIterator.next() + "\n");
               printCounter++;
           }
           out.close();
        }

        catch(IOException E)
        {
            System.out.println("A file related occur has occurred.");
        }

    }

    public static void writeChoiceToFile(int selectedColumn, String fileName)
    {
        BufferedWriter out;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)));
            out.write("\nPlayer's choice: " + selectedColumn + "\n");
            out.close();
        }

       catch(IOException E)
        {
            System.out.println("A file related error has occurred.");
        }
    }

    public static void printAllColumns(CardColumn firstCardColumn, CardColumn secondCardColumn, CardColumn thirdCardColumn)
    {
        Iterator<Card> columnIterator1 = firstCardColumn.iterator();
        Iterator<Card> columnIterator2 = secondCardColumn.iterator();
        Iterator<Card> columnIterator3 = thirdCardColumn.iterator();

        System.out.printf("%-35s %-35s %-35s\n", " ----- COLUMN 1 ----- ", " ----- COLUMN 2 ----- ", " ----- COLUMN 3 ----- " );
        int printCounter = 1;
        while (printCounter != 8)
        {
            String first = "Card #" + printCounter + ": " + columnIterator1.next();
            String second = "Card #" + printCounter + ": " + columnIterator2.next();
            String third = "Card #" + printCounter + ": " + columnIterator3.next();
            System.out.printf("%-35s %-35s %-35s \n",first,second,third);
            printCounter++;
        }

    }
}
