package bookstore;

import java.util.ArrayList;

public class Proceeding extends Publication
{
    private String city;

    // This method is a parameterized constructor that initializes the value of the proceeding.
    public Proceeding(ArrayList<Author> Authors ,String Title , String Venue ,Publisher Publisher, String City , int StartingPage , int EndPage , int Year) 
    {
        super(Authors ,Title ,Venue ,Publisher ,StartingPage ,EndPage , Year);
        city = City;
    }
    
    // This method returns the values of the proceeding in a a specific format
    @Override
    public String Cite()
    {
        return String.format("%s, %s, %d, pp:%d-%d\n" ,super.Cite(), this.city , this.year, this.startingPage , this.endPage );
    }
}
