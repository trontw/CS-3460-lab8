
public class Perm {
	private static int [] perm;
	private static int [] rem;
	private static final int n = 4;
	
	private static void permute(int f) {
		if (f == n) {
			//We have filled perm array and have a valid permutation
			for (int i = 0; i < n; ++i) 
				System.out.print(perm[i] + " ");
			System.out.println();
			return;
			
		}
		// Need to fill perm[f] with some item;
		for (int i = 0; i < n; ++i) {
			// Have we used item rem[i]?
			if (rem[i] != -1) {
				// Use item rem[i], put in perm[f]
				perm[f] = rem[i];
				rem[i] = -1;
				
				permute(f + 1);
			
				// Unuse item rem[i]
				rem[i] = perm[f];
				perm[f] = -1;
            } 
			
		}		
		
	}
		
	
	public static void main(String [] args) {
		perm = new int[n];
		rem = new int[n];
		for (int i = 0; i < n; ++i) {
			perm[i] = -1;
			rem[i] = i + 1;
			}
		permute(0);
	} // ends when perm is filled (when f == n)
}

