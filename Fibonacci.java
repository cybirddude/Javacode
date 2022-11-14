//Name: Eddie Lemmon
//Course: CMP-SCI-3130
//Due Date: December 11, 2022
//Purpose of Program:Compare the speed of four methods of finding fibonacci numbers.
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
