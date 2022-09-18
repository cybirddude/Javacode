//Name:Eddie Lemmon
//Course:CMP-SCI-3130
//Due Date: October 2, 2022
//Purpose of program: To compare the speed of three methods of comparing polynomials.
import java.util.*;
import java.io.*;
public class Main
{      public static double hardway(int poly[], int n, double x)//Uses direct multiplication to evaluate polynomials.
                                               {
	double total = 0; //The result of the polynomial.
    double [] stand_in = new double[poly.length]; //Double array is for converting poly elements to doubles for math purposes
    
    for(int i=0; i<poly.length; i++) //converting poly to doubles
    {
    stand_in[i] = poly[i];
    }
	for(int i = 0; i < poly.length; i++) //Nested loop that evaluates the polynomial. 
	{ //First loop runs for each element in the polynomial, second runs for length of n
	    if(n > 0) //If the degree is 
		{
		for(int j = 0; j < n; j++) //In order to insure that x is multiplied by poly[i] n times...
		    {
			  stand_in[i] = poly[i] * x; //A nested loop is necessary to multiply each element of poly by x^n.
			  total += stand_in[i]; //adds value of poly[i] * x^n to total.
		    }
		n = n - 1; //Method is designed for polynomials of decreasing degree order, so it is necessary to decrease the value of n.
		}
		else
			total += poly[i]; //For coefficient without variable.
	}
       return total;
        }
       public static double mediumway(int poly[], int n, double x)//Uses the power function to evaluate polynomials.
	{
		double total = 0; //Like 
		for (int i = 0; i < poly.length; i++)
		{
			if(n > 0)
			{
			total += poly[i] * Math.pow(x, n); //Uses the power function to evaluate polynomials, which is faster than direct multiplication
			n = n - 1; //Method is design for polynomials of decreasing degrees, this is necessary.
			}
			else
				total += poly[i];
		}
		return total;
	}
       public static double easyway(int poly[], int n, double x)
        //Uses horner's method to evaluate polynomials.
        //Modified version of another method: https://www.geeksforgeeks.org/horners-method-polynomial-evaluation/		
	{
		double result = poly[0]; //The result of the method
		 for (int i=1; i<n; i++) //Unlike previous methods, loop runs for the length of n, rather than poly.
                      result = result*x + poly[i]; //Unlike previous methods, for loop is a single line, and no code is needed to decrement n.
		
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
		int[] c = new int[degree + 1];//array that will hold coefficients.
		for (int i = 0; i < 200001; i++) // Loop will assign values to c.
		{
			c[i] = r.nextInt(101) + 1; //Coefficient elements will be random integers between 1 and 100, inclusive
		}
		System.out.println("Please press a number between 1-3, I will evaluate a polynomial via 1 of 3 different methods, and tell you how long it took me:");
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
			 System.out.println("Elapsed time is:" + go + "ms");
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
