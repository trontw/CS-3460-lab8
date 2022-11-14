//Finding the Nth Fibinacci Sequence number:
import java.util.Scanner;
	/* 
	//As is, very slow because 
	
	//private static int fib(int n) {
	//	if (n < 0) return 0;
	//	if (n == 0 || n == 1) return n;//capture base case
	//	return fib(n-1)+(n-2);//calling a smaller size sub problem - trust recursion
	//}
	
	//public static void main(String [] args) {
	//	Scanner kb = new Scanner(System.in);
	//	int n = kb.nextInt();
	//	int x = fib(n);
	//	System.out.println("The "+n+"the Fib number is "+x);
		
	Fibonacci Eq:	//F(n) = F(n-1)+F(n-2);
===========================================================================
Below, is a very good example of Memoization: Storing previous results into
an Array, where they can be retrieved more easily than recreating them.
=========================================================================== */
public class Fib {
	private static int [] table;

	//change all int to bigInteger (or at least long)
	private static int fib(int n) {
		if (n < 0) return 0;
		if (n == 0 || n == 1 || table[n] != 0) return table[n];//capture base case
		table [n] = fib(n-1) + fib(n-2);
		return table [n];//calling a smaller size sub problem - trust recursion
	}
	
	public static void main(String [] args) {
		System.out.println("Enter a number to find the nth Fibanacci number.");
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		table = new int[n + 1];
		table [0] = 0;
		table[1] = 1;
		
		int x = fib(n);
		System.out.println("The "+n+"th Fib number is "+x);
	}
}