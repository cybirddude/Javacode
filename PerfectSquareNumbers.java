//Name: Eddie Lemmon
//Course: Computer Science 4500 Introduction to the Software Profession
//Due Date: N/A
//Sources used: None
//Purpose of Program: To find positive squares of the formula (a^2 + b^2)/(ab + 1)
  import java.lang.*;
  import java.util.*;
  import java.io.*;
public class Main
{
  
	public static void main(String[] args) {
    double x;
    double a;
    double b;
    double r = (Math.pow(a, 2) + Math.pow(b, 2))/((a*b) + 1));
    Scanner sc = new Scanner(System.in);
    do
    {
      System.out.println("Please enter an integer between 1 and 100000: ");
      x = sc.nextLine();
      if(x%1 != 0)
      {
	      System.out.println("Number must be an integer!");
      }
      else
      {
	      if (x < 1 || x > 100000)
		  System.out.println("Number must be no less than 1, and no greater than 100000!");
      }
    
    }while(x < 1 || x > 100000 || x%1 != 0);
		
      
	}
}

