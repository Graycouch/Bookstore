package bookstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList; 
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Collections;

//Enumeration with all allowed publisher names
enum Publisher{ELSEVIER, SPRINGER, IEEE, TAYLORFRANCIS, WILEY, ACM}; 

public class DigitalLibrary {
    
   private ArrayList<Publication> publications = new ArrayList<>();
   // This method reads the file and loads the publications into the scanner.
   public void loadPublications() throws FileNotFoundException
    {
        File input = new  File("publications.txt"); 
        Scanner in = new Scanner(input);
        
        while(in.hasNext())
        {
          String [] fields = in.nextLine().split(";");
          
          if(fields.length == 8) 
          {
            publications.add(new Proceeding(getAuthorNames(fields[0]) , fields[1] , fields[2] ,getPublisher(fields[3]) ,fields[4], Integer.parseInt(fields[5]) ,Integer.parseInt(fields[6]) , Integer.parseInt(fields[7])));
          }
          
          else 
          {
            publications.add(new Journal(getAuthorNames(fields[0])  , fields[1] , fields[2] , getPublisher(fields[3]) , Integer.parseInt(fields[4]) , Integer.parseInt(fields[5]) , Integer.parseInt(fields[6]) ,Integer.parseInt(fields[7]) , Integer.parseInt(fields[8])));
          }
        }
    }
   
   // This method gets the value of the publisher.
   private Publisher getPublisher(String pub)
   {
       try{return Publisher.valueOf(pub.toUpperCase());}
       catch(IllegalArgumentException e)
       {throw e;}
   }
   
   // This method seperates the author names and adds them to an ArrayList.
   private ArrayList<Author> getAuthorNames(String authors)
   {
       ArrayList<Author> authorNames = new ArrayList<>();
       
       String[] list = authors.split(",");
       
       for(String s : list)
       {
           authorNames.add(new Author(s.split(" ")[0] , s.split(" ")[1]));
       }
       
       return authorNames;
   }
   
   // This method lists all the publications
   public void listPublications()
   {
       Collections.sort(publications);
       int i = 1;
       for(Publication t : publications)
       {
           System.out.printf("[%d] " , i);
           i++;
           System.out.print(t.Cite());
       }
   }
   
   
   // This method saves all the publications into a file with a filename the user specified
   public void saveCitations(String fileName) throws FileNotFoundException
   {
       PrintWriter prw = new PrintWriter(fileName + ".txt");
       Collections.sort(publications);
       int i = 1;
       int number = 0;
       for(Publication t : publications)
       {
           prw.printf("[%d] " , i);
           i++;
           number++;
           prw.print(t.Cite());
       }
       prw.close();
       System.out.println(number + " citations have been saved to the file " + fileName);
       
   }
}
