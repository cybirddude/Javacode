public class Main
{
    public static long overflow1()
    {
        double gr = (1 + Math.sqrt(5)) / 2;
        long nmax = (long) Math.ceil(Math.log(Math.sqrt(5) * Long.MAX_VALUE) / Math.log(gr));
        
        return nmax;
    }
    public static long overflow2()
    {
        long n = 0;
        double gr = (1 + Math.sqrt(5)) / 2;
        double f1 = (1 / Math.sqrt(5));
        double f2 = Math.pow(gr, n);
        double f3 = (Math.pow(-1, n) / Math.pow(gr, n));
        long fn = (long) (f1 * (f2 - f3));
        while(fn < Long.MAX_VALUE)
        {
            n++;
            f2 = Math.pow(gr, n);
            f3 = (Math.pow(-1, n) / Math.pow(gr, n));
            fn = (long) (f1 * (f2 - f3));
        }
        return n;
        
    }
	public static void main(String[] args) {
		System.out.println(overflow1());
		System.out.println(overflow2());
	}
}
