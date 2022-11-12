import java.lang.reflect.Array;
import java.util.*;

public class Collatz {
    
    private static int [] sol;//Array of solutions
    private static int x = 0;
    private static Random rand = new Random();
    /*
     * To build a table of solutions, use the formulas below
     * and then feed into them numbers iteratively, and store
     * the output to an array indexed by the interative input.
     * 
     * Then, instead of calling the collatzLength, you can simply 
     * input the "range", find it by its index into the table and then return
     * the corresponding output "length"
     */
    public static int collatzCrunch(int n) {
        if (n == 1)
            return n;
        else if (n%2 == 0)
            n = n/2;
        else if (n%2 == 1)
            n = 3*n + 1;
        else
            return collatzCrunch(n);
        return n;
    }
    //Build the table here
    int ans = 0;
    public void collatzTable(int index){
        for (int i = 0; i < index; ++i)
            ans = collatzCrunch(i);
        // Now with this index, build an array using the answer (ans)
        // to the problem pointed to by the index.
        //Array table = new Array(index);
    }
    // Call the length by its index into the Table
    public static int collatzLength(int n){
        return n;
    }

    public static int collatzRange(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }
    /*
     * A program that accepts two positive integers a, b,
     * wiht 1 <= a <= b <= 100,000,000 and prints the number x
     * in the range (a, b), both inclusive with the maximum Collatz length.
     */
	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter the range: 1 1000000");
        //Need to grab to numbers from the input
		int a = kb.nextInt();
        int b = kb.nextInt();
        //System.out.println("a is "+a);
        //System.out.println("b is "+b);
        // Randomly print a number in the range of (a, b), then use that number
        // to get the Collatz length.
        int range = collatzRange(a, b);
		System.out.print("The number with the maximum Collatz length in the range: "+range);
		
        int test = 837799;
		int length = collatzLength(range);
		System.out.println("\nIts Collatz length: "+ length);
	}


}