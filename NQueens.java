/* ----------------------------------------------------------------
 * N-Queens: h08
 * 
 * by Timothy W. Tron
 * 
 * A program that takes a small integer input, and finds the total
 * possible number of valid arrangements for an N-Queen problem.
 * ----------------------------------------------------------------
 */

import java.util.Scanner;

public class NQueens {

    private static int [][] Solution;
    private static int [][] temp;
    private static int [][] table;
    static int count = 0;
    static int r;
    static int test = 0;
    //private static final int n = 4;

    static void printQTable(int table[][], int n){
        for (int i = 0; i < n; ++i){
            for (int j = 0; j < n; ++j){
                System.out.print(" " + table[i][j]+" ");    
            }
            System.out.println();
        }
        System.out.println("----------------");
        //System.out.println("Solutions = "+count);
    }

    //Method to look for existing solutions in Solution table
   // check_row(row, size)
    private static void check_row(int temp[][], int r, int n) {
        int c = 0;
        if (r >= n && c >= n) {
            return;
        } else if (r >= n && c < n) {
            r = 0;
            ++test;
        }
    
        for (int i = 0; i < n; ++i) {
            //Check to see if can place on board
            if((temp != null) && (temp[r][i] == 0)) {

                //Place Queen
                temp [r][i] = 1;
                //System.out.println("temp Table: ");
                //printQTable(temp, n);

                //Increment cell by 1 to show how many Queens are attacking
                //that particular position: which we will check before inserting
                placeQ(temp, r, i, n);
                //System.out.println("temp table AFTER Placement");
                //printQTable(temp, n);
                c = i;
                //Call recursively (if not zero will go r0 r1 r2 r3 the fail)
                //when it fails, then it passes the check_row and continues.
                check_row(temp, r + 1, n); 
                
                //Reset last Queen's spot to zero
                //System.out.println("Reset last Queen's spot ["+r+"]]"+i+"] to zero");
                temp[r][i] = 0;
                //Backtrack since we have come out of an unsuccessful row
                backtraxQ(temp, r, i, n);
            } 
            if (temp[r][i] == n)
                ++count;
        }
        //Queen won't fit into any row, return false;
        return;
    }

    //Method to build the array of solutions to n-Queens
    private static void backtraxQ(int temp[][], int r, int c, int n){
        int i, j;
        if((temp != null) && (temp[r][c] == 0)){
            //Now we will start creating solutions
            //Horizontal - Right ---> i, j+1
            //if (c < n) {
            for (j = (c+1); j < n; ++j) {
                //if (temp[r][j] != 1)
                    --temp[r][j];
            }
            //Now we will start creating solutions
            //Horizontal - Left <-- i, j-1
            //if (c < n) {
                for (j = (c-1); j >= 0; --j) {
                    //if (temp[r][j] != 1)
                        --temp[r][j];
                }
            //Vertical - Up |  i-1, j
            //if (r < n) {
                for (i = (r-1); i >= 0; --i) {
                    //if (temp[i][c] != 1)
                        --temp[i][c];
                }
            //Vertical - Down |  i+1, j
            //if (r < n) {
            for (i = (r+1); i < n; ++i) {
                //if (temp[i][c] != 1)
                    --temp[i][c];
            }
            //Diagonal to the - Right Up \
            //if (r < n && c < n) {
            for (i = (r-1), j = (c-1); i >= 0 && j >= 0; --i, --j) {
                //if (temp[i][j] != 1)
                    --temp[i][j];
            }
            //Diagonal to the - Right Down \
            //if (r < n && c < n) {
            for (i = (r+1), j = (c+1); i < n && j < n; ++i, ++j) {
                //if (temp[i][j] != 1)
                    --temp[i][j];
            }
            //Diagonal to the - Left Up /
            //if (r < n && c > 0)
            for (i = (r-1), j = (c+1); i >= 0 && j < n; --i, ++j) {
                //if (temp[i][j] != 1){
                    --temp[i][j];
                //}
            }
            //Diagonal to the - Left Down /
            //if (r < n && c > 0)
            for (i = (r+1), j = (c-1); i < n && j >= 0; ++i, --j) {
                //if (temp[i][j] != 1){
                    --temp[i][j];
                //}
            }
        }
    } 

    //Method to build the array of solutions to n-Queens
    private static void placeQ(int temp[][], int r, int c, int n){
        int i, j;
        if (c < 0) return;
        //Now we will start creating solutions
        //Horizontal - Right ---> i, j+1
        //if (c < n) {
        for (j = (c+1); j < n; ++j) {
            //if (temp[r][j] != 1)
                ++temp[r][j];
        }
        //Now we will start creating solutions
        //Horizontal - Left <-- i, j-1
        //if (c < n) {
            for (j = (c-1); j >= 0; --j) {
                //if (temp[r][j] != 1)
                    ++temp[r][j];
            }
        //Vertical - Up |  i-1, j
        //if (r < n) {
        for (i = (r-1); i >= 0; --i) {
            //if (temp[i][c] != 1)
                ++temp[i][c];
        }
        //Vertical - Down |  i+1, j
        //if (r < n) {
        for (i = (r+1); i < n; ++i) {
            //if (temp[i][c] != 1)
                ++temp[i][c];
        }
        //Diagonal to the - Right Up \
        //if (r < n && c < n) {
            for (i = (r-1), j = (c-1); i >= 0 && j >= 0; --i, --j) {
                //if (temp[i][j] != 1)
                    ++temp[i][j];
            }
        //Diagonal to the - Right Down \
        //if (r < n && c < n) {
        for (i = (r+1), j = (c+1); i < n && j < n; ++i, ++j) {
            //if (temp[i][j] != 1)
                ++temp[i][j];
        }
        //Diagonal to the - Left Up /
        //if (r < n && c > 0)
        for (i = (r-1), j = (c+1); i >= 0 && j < n; --i, ++j) {
            //if (temp[i][j] != 1){
                ++temp[i][j];
            //}
        }
        //Diagonal to the - Left Down /
        //if (r < n && c > 0)
        for (i = (r+1), j = (c-1); i < n && j >= 0; ++i, --j) {
            //if (temp[i][j] != 1){
                ++temp[i][j];
            //}
        }
        
    }
    public static void main(String [] args) {
        int i; 
        int output = 0;
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the number of queens: ");
        //The input will be the number of n x n, or # of Queens
        int n = kb.nextInt();
        temp = new int[n+1][n+1];
        Solution = new int[n+1][n+1];
        //Initialize the arrays
        for (i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                temp[i][j] = 0;
                Solution[i][j] = -1;
            }
            //Now we will start creating solution
        }
        //Call check_row to start recursive function
        check_row(temp, 0, n);
        //Print output to screen
        System.out.println("The number of valid arrangements is "+test);
    }
}