//Name: Eddie Lemmon
//Course: CMP-SCI-3130
//Due Date: December 11, 2022
//Purpose of Program:Compare the speed of three methods of finding fibonacci numbers.
import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main
{
  public static long rfibo(long n) //Finds the fibonacci number via the recursive algorithm. The slowest of the three  methods.
  {
    if (n <= 0) return 0; //The 0th fibonacci number is 0.
    if (n <= 1) return 1; //The 1st fibonacci number is 1.
    return rfibo(n - 1) + rfibo(n - 2); //A fibonacci number is the sum of the two previous numbers that came before.
  }
  public static BigInteger afibo(int n) //Finds the fibonacci number via the iterative algorithm. The second fastest of the three algorithms.
  {
    BigInteger F[] = new BigInteger[n + 2]; //This array holds all of the fibonacci numbers. Size is "n + 2" in order to hold zero and one. Otherwise there would be an error.
    //The following two lines contain the first two fibonacci numbers.
    F[0] = BigInteger.ZERO; 
    F[1] = BigInteger.ONE;
    for(int i = 2; i <= n; i++) //For loop stores fibonacci numbers in each index of array.
        F[i] = F[i-1].add(F[i-2]);
    return F[n]; //F[n] is the final fibonacci number.
  }
  //Next four methods are related to the extra credit method.
  public static BigInteger exfig(BigInteger n) //The method that is actually called. Finds fibonacci numbers via powers of matrices. The fastest of the three methods.
  {
    BigInteger F[][] = new BigInteger[][]{{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}}; //Matrice contains 3 ones and one zero.
    if(n.equals(BigInteger.ZERO)) //If input is 0
      return BigInteger.ZERO; //Result is zero.
    else
    {
      squaring(F, n.subtract(BigInteger.ONE)); //Calculates the value of fibonacci number.
      multiply2(F); //Stores fibonacci number in F.
      
      return F[0][0]; //First index contains the fibonacci number of input.
    }
  }
  public static void multiply(BigInteger F[][], BigInteger M[][]) //Alternate version of the BigInteger's multiply method designed for 2x2 matrices.
  {
    //First four lines perform the steps of matrix multiplications.
    BigInteger x = (F[0][0].multiply(M[0][0])).add(F[0][1].multiply(M[1][0]));
    BigInteger y = (F[0][0].multiply(M[0][1])).add(F[0][1].multiply(M[1][1]));
    BigInteger z = (F[1][0].multiply(M[0][0])).add(F[1][1].multiply(M[1][0]));
    BigInteger w = (F[1][0].multiply(M[0][1])).add(F[1][1].multiply(M[1][1]));
    //Last four lines assign values of products to F's indeces.
    F[0][0] = x;
    F[0][1] = y;
    F[1][0] = z;
    F[1][1] = w;
  }
  public static void multiply2(BigInteger F[][]) //Multiplies elements of a single 2x2 matrice .
  {
    BigInteger x = (F[0][0].multiply(BigInteger.ONE)).add(F[0][1].multiply(BigInteger.ZERO)); //Multiplies elements of the first column
    BigInteger y = (F[1][0].multiply(BigInteger.ONE)).add(F[1][1].multiply(BigInteger.ZERO)); //Multiplies elements of the second column
    //Last two lines assign values of products to indeces.
    F[0][0] = x;
    F[0][1] = y;
  }
  public static void squaring(BigInteger F[][], BigInteger n) //Performs multiplications according to input number "n".
  {
    if(n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE))//If power is 0 or 1, returns nothing.
      return;
    BigInteger M[][] = new BigInteger[][]{{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}}; //Second matrix for odd numbered powers.
    squaring(F, n.shiftRight(1)); //Recursively calls algorithm on a right shifted array. Without it, multplication would only be performed once or twice.
    multiply(F,F); //Multiplies F by itself and stores new values.
    if(n.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE)) //If power is odd numbered, extra multiplication and storage will be performed.
      multiply(F, M);
  }
    
  public static void main(String[] args){
    long n; //Input of the user.
    Scanner sc = new Scanner(System.in);
    System.out.println("In this program, I am going to output a fibonacci number based on your input using three different algorithms.");
    System.out.println("From slowest to fastest, the three algorithms are recurssive, iterative, and logarithmic.");
    System.out.println("To prove it, I will show how much time it took for each algorithm.");
    System.out.println("The differences in speed are negligible at low inputs, higher inputs give more meaningful differnces.");
    System.out.println("According to the LongOverflow.java program, the maximum long variable that outputs a fibonacci variable is 93.");
    do
    {
        System.out.println("Enter a whole number between 1 and 93, inclusive:");
        n = (long) sc.nextLong();
    }while(n < 0 || n > 94); //"n" can only be between 0 and 93 inclusive.
    long go = System.currentTimeMillis(); //Start time in milliseconds.
    System.out.println("The fibonacci number for " + n + " using the recursive algorithm is:" + rfibo(n));
    long stop = System.currentTimeMillis(); //End time in milliseconds.
    float middle = (stop - go)/1000F; //Total calculation time in seconds.
    System.out.println("It took " + middle + " seconds using the recursive method.");
    System.out.println("(Fun fact: it takes the recussive method around half a minute to calculate using an input of 48 or 49. )");
    go = System.currentTimeMillis(); //Resets go.
    System.out.println("The fibonacci number for " + n + " using the iterative algorithm is:" + afibo((int) n));
    stop = System.currentTimeMillis(); //Resets stop.
    middle = (stop - go)/1000F; //Resets middle.
    System.out.println("It took " + middle + " seconds using the iterative method.");
    go = System.currentTimeMillis();
    System.out.println("The fibonacci number for " + n + " using the logarithmic algorithm is " + exfig(BigInteger.valueOf(n)));
    stop = System.currentTimeMillis();
    middle = (stop - go)/1000F;
    System.out.println("It took " + middle + "seconds using the logarithmic method.");
  }
}
