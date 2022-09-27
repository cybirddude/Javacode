//Name:Eddie Lemmon
//Course:CMP-SCI-3130
//Due Date: October 2, 2022
//Purpose of program: To compare the speed of three methods of comparing polynomials.
import java.util.*;
import java.io.*;
public class Main
{      public static double hardway(int poly[], int n, double x)//Uses direct multiplication to evaluate polynomials.
                                               
        {
            double total = 0;
            double [] stand_in = new double[poly.length]; //Double array is for converting poly elements to doubles for math purposes
	        double result; //will hold the result of the polynomial
	        int exponent; //will hold the value of the current exponent.
	        for(int i = 0; i < (n + 1); i++)
	        {
	            exponent = i;
	            result = 1; //Result will equal one by default for the exponent of 0.
	            while(exponent != 0)
	            {
	                result *= x;
	                exponent--; 
	            }
	            total += result * poly[i];
	        }
	        return total;
        }
       public static double mediumway(int poly[], int n, double x)//Uses the power function to evaluate polynomials.
	{
		double total = 0; //Like 
		double result;
		for(int i = 0; i < (1 + n); i++)
		{
		    result = Math.pow(x, i);
		    total += result * poly[i];
		    
		}
		return total;
	}
       public static double easyway(int poly[], int n, double x)
        //Uses horner's method to evaluate polynomials.
        //Modified version of another method: https://www.geeksforgeeks.org/horners-method-polynomial-evaluation/		
	{
		double result = poly[n]; //The result of the method
		 for (int i=n; i >= 1; i--) //Unlike previous methods, loop runs for the length of n, rather than poly.
                result = result * x + poly[i-1];
		
		return result;
	}
	public static void main(String[] args) {
		Random r = new Random(); //Will produce a random number for both the coefficients and the variable.
                int degree = 200000;//Degree of polynomial
		int choice; //User will choose a number from 1-3 in order to decide which method to use, or zero to quit the program.
		double x = r.nextDouble(); //Every coefficient will be multiplied by x, which will be between 0.0 and 1.0 exclusive.
		do//nextDouble method is normally 0 inclusive and 1 exclusive so to make sure x is never 0...
		{
                  x = r.nextDouble();// //x will be reassigned until x doesn't equal 0.
		} while (x == 0);//Do while loop runs as long as x is equal to 0.
		int[] c = new int[degree + 1];//array that will hold coefficients. The + 1 is to hold the monomial with x^0
		for (int i = 0; i < 200001; i++) // Loop will assign values to c.
		{
			c[i] = r.nextInt(101) + 1; //Coefficient elements will be random integers between 1 and 100, inclusive
		}
		System.out.println("Please press a number between 1-3, I will evaluate a 200000 degree polynomial via 1 of 3 different methods, and tell you how long it took me:");
		System.out.println("Press 1 to evaluate using direct multiplication");
		System.out.println("Press 2 to evaluate using the power function");
		System.out.println("Press 3 to evaluate using Horner's method");
	    System.out.println("Press 0 to quit");
		Scanner sc = new Scanner(System.in);
		do
		{
		choice = sc.nextInt();
		
		
			switch(choice)
			{ case 1:
			 long start = System.currentTimeMillis(); //Will start the timer and measure in milliseconds
			 System.out.println(hardway(c, degree, x));
			 long finish = System.currentTimeMillis(); //End of the timer.
			 long timeElapsed = finish - start; //The time the method took.
			 System.out.println("Elapsed time is:" + timeElapsed + "ms");
			 break;
			  case 2:
			 long begin = System.currentTimeMillis();
			 System.out.println(mediumway(c, degree, x));
			 long end = System.currentTimeMillis();
			 long middle = end - begin;
			 System.out.println("Elapsed time is:" + middle + "ms");
			 break;
			  case 3:
			 long go = System.currentTimeMillis();
			 System.out.println(easyway(c, degree, x));
			 long stop = System.currentTimeMillis();
			 long results = stop - go;
			 System.out.println("Elapsed time is:" + results + "ms");
			 break;
			  case 0:
			 System.out.println("Bye!");
			     break;
			 default:
			 System.out.println("That is not a valid entry!");
			}
		}while(choice != 0);
	}
}
