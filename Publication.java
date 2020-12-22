package bookstore;

import java.util.ArrayList;
import java.util.Collections;

public class Publication implements Citable,Comparable<Publication>
{
    private ArrayList<Author> authors = new ArrayList<>();
    private Publisher publisher;
    private String venue;
    private String title;
    protected int startingPage;
    protected int endPage;
    protected int year;

    // This method is a parameterized constructor that initializes the value of the publication.
    public Publication(ArrayList<Author> Authors ,String Title , String Venue ,Publisher Publisher , int StartingPage , int EndPage , int Year)
    {
        this.authors.addAll(Authors);
        this.publisher = Publisher;
        this.venue = Venue;
        this.title = Title;
        this.startingPage = StartingPage;
        this.endPage = EndPage;
        this.year = Year;
    }
    
    // This method is used so that the program knows how to sort the arraylist "publications".       
    @Override
    public int compareTo(Publication Other)
    {
        if(this.authors.get(0).lastName.compareTo(Other.authors.get(0).lastName) != 0)
            return this.authors.get(0).lastName.compareTo(Other.authors.get(0).lastName);
        if(this.venue.compareTo(Other.venue) != 0)
            return this.venue.compareTo(Other.venue);
        else
            return Integer.compare(this.year,Other.year);
    }
    
    // This method returns the values of the publication in a a specific format.
    @Override
    public String Cite()
    {
        Collections.sort(authors);
        
        String names = "";
        for(Author t : authors)
        {
           names += t.firstName.substring(0, 1) + ". "+ t.lastName + ", ";
        }
        
        return String.format("%s" + "\"%s\", %s(%s), %s" , names ,  this.title , this.venue , getAcronym() , this.publisher );
    }
    
    // This method gets the acronym of the venue.
    private String getAcronym()
    {
        String acronym = "";
        String[] venueArray = venue.split(" ");
        
        for(String s : venueArray)
        {
            acronym += s.toUpperCase().charAt(0);
        }
        
        return acronym;
        
    }
}
