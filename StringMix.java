//Names: Eddie Lemmon and Ted Laesch
//Course: Computer Science 4500 Introduction to the Software Profession
//Due date: September 16, 2022
//Purpose of program: To take a string of characters and see what words can be formed from said characters.
import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    String alphafile = "words_alpha.txt"; // The name of the file.
	    File f = new File(alphafile); //The actual file.
	    Scanner sc= new Scanner(System.in);
	    do
	    {
	       System.out.println("Enter a string that contains only letters and is no less than 3, and no greater ");
	       System.out.println("than 10");
	       String S = sc.nextLine(); //The string the user will enter.
	       if (S.length() > 3 || S.length() < 10) //Checking to see if the string length is between 3 and 10, inclusive.
	       {
		       if(S.matches("[a-zA-Z]+") == false) //Checking if string contains only letter characters.
			       System.out.println("Sorry, that string is not valid");
	       }
	       else 
		       System.out.println("Sorry, that string is not valid"); // if string does not between 3 and 10, inclusive
	    }
	    while(S.length() < 3 || 10 < S.length() || S.matches("[a-zA-Z]+") == false); // The string cannot be greater than 10, less than 3, 
											 //or contain a non-letter character.
	   
	}
}
