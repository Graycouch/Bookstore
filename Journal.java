package bookstore;

import java.util.ArrayList;

public class Journal extends Publication 
{
    private int volume;
    private int number;

    // This method is a parameterized constructor that initializes the value of the journal.
    public Journal(ArrayList<Author> Authors ,String Title , String Venue ,Publisher Publisher, int Volume, int Number , int StartingPage , int EndPage , int Year) 
    {
        super(Authors ,Title ,Venue ,Publisher ,StartingPage ,EndPage , Year);
        volume = Volume;
        number = Number;
    }
    
    // This method returns the values of the journal in a a specific format.
    @Override
    public String Cite()
    {
        return String.format("%s, %d(%d):%s-%s, %d\n" ,super.Cite() ,this.startingPage , this.endPage , this.volume, this.number , this.year);
    }
}
