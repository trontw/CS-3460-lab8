//Recursion
//Coin change problem
//common Coin sizes = 1, 5, 10 25
//return minimum number of coins to make change
//
// how many coins to get:
// 72 - (5: 25, 25, 10, 10, 1, 1)
//
//Use the Greedy Algo.
//
// 72 - 25, repeat, 47 - 25, 22 - 10\
public class Coins {

	private static int [] coins;
	private static final int n = 3;
	private static final int INF = 1000000000;
	
	private static int change(int c){
		if (c < 0) return INF;
		if (c == 0) return 0;
		//base case
		for (int i = 0; i < n; ++i) {
			if (c == coins[i])
				return 1;
		}
		int min = INF;
		for (int i = 0; i < n; ++i) {
			int x = change(c - coins[i]);
			if (x < min)
				min = x;
		}
		return min;
	}

	public static void main(String [] args) {
		coins = new int[n];
		coins [0] = 1;
		coins [1] = 6;
		coins [2] = 10;
		int c = 12;
		int x = change(c);
		System.out.println("Your change is "+x);
		
	}
}	