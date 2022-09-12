//Name: Eddie Lemmon
//Partner: Ted Laesch
//Course: Computer Science 4500 Introduction to the Software Profession
//Due date: September 16, 2022
//Purpose of program: To take a string of characters and see what words can be formed from said characters.
import java.io.*;
public class Main
{
	public static void main(String[] args) {
	    String alphafile = "words_alpha.txt"; // The name of the file.
	    File f = new File(alphafile); //The actual file.
	    String S; //The string the user will enter.
	    do
	    {
	       System.out.println("Enter a string that contains only letters and is no less than 3, and no greater ");
	       System.out.println("than 10");
	       
	       System.out.println("Sorry, that string is not valid");
	        
	    }
	    while(S.length() < 3 || 10 < S.length());
	}
}
