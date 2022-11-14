import java.util.*;

public class Collatz {
    
    private static int [] table;//Array of solutions
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

    public static int collatzTable(int n){
        if (n< 0) return 0;
        if (table[n] != 0) return table[n];
        table [n] = collatzTable(n);
        return table [n];
    }

    //Fill the table here
    public static void collatzFill(int index) {
        //System.out.println("index INPUT is "+index);
        if (index < 0) return; 
        //if (index == 0 || index == 1) table = new int[collatzCrunch(index)];
        try {
        for (int i = 2; i < table.length; ++i){
                // Collatz for 15 is length 46, means need to loop and count
                // from the number calling collatzCrunch until zero
                table[i] = countCrunches(i);
                //need to call collatzCrunch until the output is zero, counting each loop
                //System.out.println("Collatz for "+i+" is length "+table[i]);
            }
        }
        catch (Exception e) {
            System.out.println("\nException caught");
        }
        
    }

    public static int countCrunches(int i) {
        int count = 1;
        //System.out.println("input is i = "+i);
        while (i > 1) {
            int t = collatzCrunch(i);
            i = t;
            //System.out.println("Collatz for i is = "+t);
            ++count;
            //System.out.println("Count in loop is "+count);
        }
        return count;
    }
        // Now with this index, build an array using the answer (ans)
        // to the problem pointed to by the index.
        //Array table = new Array(index);
    
    // Call the length by its index into the Table
    public static int collatzLength(int n){
        if (n < 0) return 0;
        if (n != 0 || n != 1 && table[n] != 0) return table[n];
        //for (int i = 2;i < table.length; ++i) {
            //if (table[i] == n)
        return table[n];
        //}
        //return 0;
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
		//Create Collatz Table
        table = new int[range + 1];//Array of solutions
        table [0] = 0;
        table [1] = 1;
        collatzFill(range);


        //int test = 837799;
        //int test = 15;
		int result = collatzLength(range);
		System.out.println("\nIts Collatz length: "+ result);
	}


}