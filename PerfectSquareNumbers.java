//Name: Eddie Lemmon
//Course: Computer Science 4500 Introduction to the Software Profession
//Due Date: September 23, 2022
//Sources used: Javaatpoint
//Purpose of Program: To find positive squares of the formula (a^2 + b^2)/(ab + 1)
  import java.lang.*;
  import java.util.*;
  import java.io.*;
public class Main
{
	static boolean checkPerfectSquare(double number)  //Method's purpose is to check if a number is a perfect square. 
		//Method comes from here: https://www.javatpoint.com/java-program-to-check-if-a-given-number-is-perfect-square
{   
//calculating the square root of the given number  
double sqrt=Math.sqrt(number);   
//finds the floor value of the square root and comparing it with zero  
return ((sqrt - Math.floor(sqrt)) == 0);   
}   
  
	public static void main(String[] args) {
    double x; //Will be the number that the user enters.
    double a; //Will be one of the variables
    double b; //Will be the second variable.
    double r = (Math.pow(a, 2) + Math.pow(b, 2))/((a*b) + 1)); //The formula in a single variable.
    int total_int = 0; //Counts the number of integers.
    int perfect = 0; //Counts the number of perfect squares.
    Scanner sc = new Scanner(System.in);
    {
      System.out.println("Please enter an integer between 1 and 100000 (inclusive),");
      System.out.println("I will test values of the integers a and b to see which results of the formula r = (a^2 + b^2)/((a*b) + 1)) are integers");
      System.out.println("and of those integers, I will tell you which of those values are a perfect square. I will do this until a and b are equal to your integer.");
      x = sc.nextDouble();
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
		
      for(int i = 0; i < x; i++) //Recursive function tests numbers from 1 to X.
      {
	      a = 1 + i; //This is necessary so that all of the numbers will be tested and so a will never equal 0..
	      for(int j = 0; j < x; j++) //Second for loop adds a squared to all values of b squared to test the loop.
	      {
		      b = 1 + j;
		      if(r == (int)r)
	         { 
	          total_int++;
		  System.out.println("That is " + total_int " integers so far!");
		     		 if(checkPerfectSquare(r))
		     	 {
			    	        perfect++;
			      		System.out.println("Perfect square number "  + perfect);
					System.out.println("a = " + a);
					System.out.println("b = " + b);
					System.out.println("r = " + r);
					System.out.println("Square root of r is " + Math.sqrt(r));
					
		     	 }
         	 }			 
		      
	      }
      }
	}
}

