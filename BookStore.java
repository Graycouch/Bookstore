package bookstore;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class BookStore {
    
     public static void main(String[] args) throws FileNotFoundException{
         
         DigitalLibrary DL = new DigitalLibrary();
         Scanner in = new Scanner(System.in);
         
         int choice;
         
         while(true)
         {
            System.out.print("Please select one of the following:\n\t 1- Load all publications\n\t 2- Save publications\n\t 3- List publications\n\t\n");
            choice = in.nextInt();
            
            switch(choice)
            {
                //Loads the list of publications from the file publications.txt into the ArrayList publications
                case 1: 
                { 
                    DL.loadPublications(); 
                    break;
                } 
                
                //Saves the citations into a file. The file's name is supplied by the user
                case 2: 
                {
                       System.out.println("Please enter your file name");  
                       String fileName = in.next(); 
                       DL.saveCitations(fileName); 
                       break;
                }

                //Prints all the publications in their scientific citation format
                case 3: 
                {
                    DL.listPublications(); 
                    break;
                } 

                default: {System.out.println("Invalid choice. Please pick a number between 1 - 4."); break;}    
            }
            
            
            System.out.println("Press 0 to exit. Press any other number to continue");
            if(in.next().charAt(0) == '0')
                break; 

         }

        }
         
     }
