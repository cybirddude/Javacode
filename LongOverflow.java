//Name: Eddie Lemmon
//Course: CMP-SCI 3130-002
//Due Date: December 11, 2022
//Purpose of Program, to show the maximum long Fibonacci number via two algorithms.
public class Main
{
    public static long overflow1() //This algorithm uses a simple formula to find the number.
    {
        final double gr = (1 + Math.sqrt(5)) / 2; //Golden ratio formula
        long nmax = (long) Math.ceil(Math.log(Math.sqrt(5) * Long.MAX_VALUE) / Math.log(gr)); //nmax gives value of maximum fibonacci number.
        
        return nmax;
    }
    public static long overflow2() //This algorithm uses elements of overflow to find the number.
    {
        long n = 0; //Holds the value of the number.
        final double gr = (1 + Math.sqrt(5)) / 2; //Golden ratio formula.
	//Next three lines are pieces of fibonacci number formula. I did this to make reading it easier.
        final double f1 = (1 / Math.sqrt(5));
        double f2 = Math.pow(gr, n);
        double f3 = (Math.pow(-1, n) / Math.pow(gr, n));
        long fn = (long) (f1 * (f2 - f3)); //Fibonacci number formula
        while(fn < Long.MAX_VALUE) //For loop continues until fn overflows.
        {
            n++; //n increases until loop stops
	    //f2, f3, and fn all have to be redefined so that it uses value of current n and not 0.
            f2 = Math.pow(gr, n);
            f3 = (Math.pow(-1, n) / Math.pow(gr, n));
            fn = (long) (f1 * (f2 - f3));
        }
        return n;
        
    }
	public static void main(String[] args) {
		System.out.println("I am going to show the maximum fibonacci number that java can give using the long variable type.");
		System.out.println("To prove that this variable is true, I will be using two algorithms: one that uses a formula, and the other a loop.");
		System.out.println("The maximum long fibonacci number using the formula is " + overflow1());
		System.out.println("The maximum long fibonacci number using the loop is " + overflow2());
	}
}
