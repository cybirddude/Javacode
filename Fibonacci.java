//Name: Eddie Lemmon
//Course: CMP-SCI-3130
//Due Date: December 11, 2022
//Purpose of Program:Compare the speed of three methods of finding fibonacci numbers.
import java.util.*;
import java.io.*;
import java.lang.*;
public class Main
{
  public static long rfibo(int n)
  {
    if (n <= 0) return 0;
    if (n <= 1) return 1;
    return rfibo(n - 1) + rfibo(n - 2);
  }
  public static long maxformula()
  {
    int gr = (1 + sqrt(5)) / 2; //Golden ratio formula
    int n = 0;
    long fibo;
    while(fibo > 0;) //While loop runs while
    {
      fibo = (1 / sqrt(5)) * (Math.pow(gr, n)) - (Math.pow(-1, n)/Math.pow(gr, n)); //Fibonacci number formula using golden ratio.
        n++;
    }
    return n;
  }
  public static long maxoverflow()
    {
       int n = 0;
       long fibo;
       while(fibo > 0 || fibo < Long.MAX_VALUE) //While loop runs while fibo is positive and less than the maximum long value.
       {
         fibo = rfibo(n);
         n++;
       }
    return n;
    }
  public static BigInteger afibo(int n)
  {
    int[] F = new int[n];
    F[0] = 0;
    F[1] = 1;
    for(i = 2; i <= n; i++)
      F[i] = F[i - 1] + F[i - 2];
    return F[n - 1];
  }
  public static void main(String[] args){
    int n;
  }
}
