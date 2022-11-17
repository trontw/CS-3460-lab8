
public class Perm {
	private static int [] perm;
	private static int [] temp;
	private static final int n = 4;
	
	private static void permute(int f) {
		//if (f == n) {
		if (f >= n) {
			//We have filled perm array and have a valid permutation
			for (int i = 0; i < n; ++i) 
				System.out.print(perm[i] + " ");
			System.out.println();
			return;
			
		}
		// Need to fill perm[f] with some item;
		for (int i = 0; i < n; ++i) {
			// Have we used item rem[i]?
			//If -1, item is being used.
			if (temp[i] != -1) {
				//Use item items[i], put in perm[f]
				perm[f] = temp[i];//replaces -1
				temp[i] = -1;//backfill with -1
				
				permute(f + 1);
			
				// Unuse item items[i]
				temp[i] = perm[f];
				perm[f] = -1;
            } 
			
		}		
		
	}
		
	
	public static void main(String [] args) {
		//perm = new int[n + 1];
		//rem = new int[n + 1];
		perm = new int[n];
		temp = new int[n];
		//Initialize: 
		//items becomes array [0, 1, 2, 3, ...n]
		//perm  becomes array [-1, -1, -1, ..-1]
		for (int i = 0; i < n; ++i) {
			temp[i] = i + 1;
			perm[i] = -1;
			}
		permute(0);
	} // ends when perm is filled (when f == n)
}

