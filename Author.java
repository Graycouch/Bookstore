package bookstore;

public class Author implements Comparable<Author>
{
    protected String firstName;
    protected String lastName;
    protected String institution;
    
    // This method is a parameterized constructor that initializes the values of the author.
    public Author(String FirstName , String LastName)
    {
        this.firstName = FirstName;
        this.lastName = LastName;
    }
    
    // This is a mutator that is used to change the value of the institution.
    public void setInstitution(String Institution)
    {
        this.institution = Institution;
    }
    
    // This method is used so that the program knows how to sort the arraylist "authors".
    @Override
        public int compareTo(Author other)
    {
        return this.lastName.compareTo(other.lastName);
    }
}
