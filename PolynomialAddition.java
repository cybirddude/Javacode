//Name:Eddie Lemmon
//Course:CMP-SCI-3130
//Due Date: October 2, 2022
//Purpose of program: To compare the speed of three methods of comparing polynomials.
import java.util.*;
import java.io.*;
public class Main
{      public static double hardway(int poly[], int n, double x)//Uses direct multiplication to evaluate polynomials. Slowest of methods
	//poly is the array of constants, n is the length of the polynomial, x is the value of the x value. Other method uses same parameters in different ways.
                                               
        {
            double total = 0; //Wil be the value of the method
	        double result; //will hold the value of the current mononomial.
	        int exponent; //will hold the value of the current exponent.
	        for(int i = 0; i < (n + 1); i++) //Runs for length of n to ensure that all mononomials are evaluated.
	        {
	            exponent = i; //exponent is equal to value of current i for purposes of simulating the power function
	            result = 1; //Result will equal one by default for the exponent of 0. Every time for loop iterates, result will reset to 1.
	            while(exponent != 0)
	            {
	                result *= x; //Result will be multiplied by x until exponent equals 0.
	                exponent--; //Exponent will be decreased by 1 each iteration.
	            }
	            total += result * poly[i]; //After while loop iterates, the monomial is added to total.
	        }
	        return total;
        }
       public static double mediumway(int poly[], int n, double x)//Uses the power function to evaluate polynomials. Faster than hardway, slower than easyway.
	{
		double total = 0; //The value of the method
		double result; //The value of x^i
		for(int i = 0; i < (1 + n); i++)
		{
		    result = Math.pow(x, i);//Math.pow method is faster than manual exponents used in hardway
		    total += result * poly[i]; //Adds the value of array value times x^i to total.
		    
		}
		return total;
	}
       public static double easyway(int poly[], int n, double x) //Uses horner's method to evaluate polynomials. Fastest method. 		
	{
		double result = poly[n]; //The value of the method. Starts at poly[n] rather than 0.
		for (int i=n; i >= 1; i--) 
                 result = result * x + poly[i-1]; //Unlike previous methods, easyway does not evaluate each monomial before multiplying by the constant.
		return result;
	}
	public static void main(String[] args) {
		Random r = new Random(); //Will produce a random number for both the coefficients and the variable.
                int degree = 200000;//Degree of polynomial
		int choice; //User will choose a number from 1-3 in order to decide which method to use, or zero to quit the program.
		double x = r.nextDouble(); //Every coefficient will be multiplied by x, which will be between 0.0 and 1.0 exclusive.
		do//nextDouble method is normally 0 inclusive and 1 exclusive so to make sure x is never 0...
		{
                  x = r.nextDouble();// //x will be reassigned until it doesn't equal 0.
		} while (x == 0);//Do while loop runs as long as x is equal to 0.
		int[] c = new int[degree + 1];//array that will hold coefficients. The + 1 is to hold the monomial with x^0
		for (int i = 0; i < 200001; i++) // Loop will assign values to c.
		{
			c[i] = r.nextInt(101) + 1; //Coefficient elements will be random integers between 1 and 100, inclusive
		}
		System.out.println("Enter a value between 1-3, I will evaluate a 200000 degree polynomial via one of three methods, and I'll tell you how long it took:");
		System.out.println("Press 1 to evaluate using direct multiplication, the longest method");
		System.out.println("Press 2 to evaluate using the power function, the second longest method");
		System.out.println("Press 3 to evaluate using Horner's method, the shortest method");
	    System.out.println("Press 0 to quit");
		Scanner sc = new Scanner(System.in);
		do //Until the choice is 0, the user can run the program as much as they wish.
		{
		choice = sc.nextInt();
		
		
			switch(choice)//Switch statement for the options
			{ case 1: //For the first three cases, they follow the following pattern.
			 long start = System.currentTimeMillis(); //Will start the timer and measure in milliseconds
			 System.out.println(hardway(c, degree, x)); //Method is run.
			 long finish = System.currentTimeMillis(); //End of the timer.
			 long timeElapsed = finish - start; //The time the method took.
			 System.out.println("Elapsed time is:" + timeElapsed + "ms"); //Showing the elapsed time
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
			 default: //In case the user enters a non-valid value.
			 System.out.println("That is not a valid entry!");
			 System.out.println("Please enter 1 for direct multiplication, 2 for power, or 3 for horner's method");
			}
		}while(choice != 0);
	}
}
