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
    double a = 0; //Will be one of the variables
    double b = 0; //Will be the second variable.
    double r; //The formula in a single variable. It is important that the formula is not defined yet, in order to prevent complications later.
    int total_int = 0; //Counts the number of integers.
    int perfect = 0; //Counts the number of perfect squares.
    Scanner sc = new Scanner(System.in);
    do
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
              b = 0; //This is necessary in order to reset b after the second loop finishes.
	      a++; //This is necessary so that all of the numbers will be tested and so a will never equal 0..
	      for(int j = 0; j < x; j++) //Second for loop adds a squared to all values of b squared to test the loop.
	      {
		      b++;
		      r = (Math.pow(a, 2) + Math.pow(b, 2))/((a*b) + 1); //The formula is defined in the loop to prevent errors.
		      if(r == (int)r)
	         { 
	          total_int++;
		  System.out.println("That is " + total_int + " integers so far!");
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
		//Second part of the program will perform the same tasks, only it will display the time it took to do the work instead of the math data.
		//reseting perfect, a, b, and total_int to 0 in order to use them again for the next part of the program.
		perfect = 0; 
		a = 0;
		b = 0;
		total_int = 0;
		long start = currentTimeMillis(); //Start of the timer
	 for(int i = 0; i < x; i++) //Second recusive function is like the first, only without displaying information.
      {
              b = 0; //This is necessary in order to reset b after the second loop finishes.
	      a++; //This is necessary so that all of the numbers will be tested and so a will never equal 0.
	      for(int j = 0; j < x; j++) //Second for loop adds a squared to all values of b squared to test the loop.
	      {
		      b++;
		      r = (Math.pow(a, 2) + Math.pow(b, 2))/((a*b) + 1); //The formula is defined in the loop to prevent errors.
		      if(r == (int)r)
	         { 
	          total_int++;
		     		 if(checkPerfectSquare(r))
		     	 {
			    	        perfect++;
					System.out.println("a = " + a);
					System.out.println("b = " + b);
					System.out.println("r = " + r);
					
		     	 }
         	 }			 
		      
	      }
      }
		long end = currentTimeMillis(); //End of the timer
		long middle = end - start; //The time it took to perform the work in the for loop
		//Final five lines are a summary of the loops
		System.out.println("The largest number for a and b was " + x);
		System.out.println("The number of pairs tested was " + (x * x));
		System.out.println("There were " + total_int + " integers in total.");
		System.out.println("There were " + perfect + "perfect squares in total.");
		System.out.println("It took " + middle "ms to do the work.");
	}
}
