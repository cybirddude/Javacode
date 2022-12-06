//Name: Eddie Lemmon
//Course: CMP-SCI-3130
//Due Date: December 11, 2022
//Purpose of Program:Compare the speed of three methods of finding fibonacci numbers.
import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main
{
  public static long rfibo(long n)
  {
    if (n <= 0) return 0;
    if (n <= 1) return 1;
    return rfibo(n - 1) + rfibo(n - 2);
  }
  public static BigInteger afibo(int n)
  {
    BigInteger F[] = new BigInteger[n + 2];
    F[0] = BigInteger.ZERO;
    F[1] = BigInteger.ONE;
    for(int i = 2; i <= n; i++)
        F[i] = F[i-1].add(F[i-2]);
    return F[n];
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
    squaring(F, n.shiftRight(1));
    multiply(F,F);
    if(n.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE))
      multiply(F, M);
  }
    
  public static void main(String[] args){
    long n;
    Scanner sc = new Scanner(System.in);
    do
    {
        n = sc.nextLong();
    }while(n < 0 || n > 94);
    long go = System.currentTimeMillis();
    System.out.println("The fibonacci number for " + n + " using the recursive algorithm is:" + rfibo(n));
    long stop = System.currentTimeMillis();
    float middle = (stop - go)/1000F;
    System.out.println("It took + " + middle + " seconds using the recursive method.");
    System.out.println("The fibonacci number for " + n + " using the iterative algorithm is:" + afibo((int) n));
  }
}
