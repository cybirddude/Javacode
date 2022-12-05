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
    long gr = (1 + sqrt(5)) / 2; //Golden ratio formula
    long n = 0;
    long fibo = 0;
    while(fibo >= 0;) //While loop runs while
    {
      fibo = (1 / sqrt(5)) * (Math.pow(gr, n)) - (Math.pow(-1, n)/Math.pow(gr, n)); //Fibonacci number formula using golden ratio.
        n++;
    }
    return n;
  }
  public static long maxoverflow()
    {
       long n = 0;
       long fibo = 0;
       while(fibo >= 0 && fibo < Long.MAX_VALUE) //While loop runs while fibo is positive and less than the maximum long value.
       {
         fibo = rfibo(n);
         n++;
       }
    return n;
    }
  public static BigInteger afibo(BigInteger n)
  {
    BigInteger[] F = new BigInteger[n];
    F[0] = BigInteger.ZERO;
    F[1] = BigInteger.ONE;
    for(i = 2; i <= n; i++)
      F[i] = F[i-1].add(F[i-2]);
    return F[n - 1];
  }
  //Next four methods are related to the extra credit method.
  public static BigInteger exfig(BigInteger n)
  {
    BigInteger F[][] = new BigInteger[][]{{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};
    if(n.equals(BigInteger.ZERO))
      return BigInteger.ZERO;
    else
    {
      squaring(F, n.subtract(BigInteger.ONE));
      multiply2(F);
      
      return F[0][0];
    }
  }
  public static void multiply(BigInteger F[][], BigInteger M[][]) //Alternate version of the BigInteger's multiply method designed for matrices.
  {
    BigInteger x = (F[0][0].multiply(M[0][0])).add(F[0][1].multiply(M[1][0]));
    BigInteger y = (F[0][0].multiply(M[0][0])).add(F[1][1].multiply(M[1][0]));
    BigInteger z = (F[1][0].multiply(M[0][0])).add(F[0][1].multiply(M[1][0]));
    BigInteger w = (F[1][0].multiply(M[0][1])).add(F[1][1].multiply(M[1][1]));
    
    F[0][0] = x;
    F[0][1] = y;
    F[1][0] = z;
    F[1][1] = w;
  }
  public static void multiply2(BigInteger F[][])
  {
    BigInteger x = (F[0][0].multiply(BigInteger.ONE)).add(F[0][1].multiply(BigInteger.ZERO));
    BigInteger y = (F[1][0].multiply(BigInteger.ONE)).add(F[1][1].multiply(BigInteger.ZERO));
    
    F[0][0] = x;
    F[0][1] = y;
  }
  public static void squaring(BigInteger F[][], BigInteger n)
  {
    if(n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE))
      return;
    BigInteger M[][] = new BigInteger[][]{{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};
    squaring(F, n.shiftright(1));
    multiply(F,F);
    if(n.mod(BigInteger.valueof(2)).equals(BigInteger.ONE))
      multiply(F, M);
  }
    
  public static void main(String[] args){
    long n;
  }
}
