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
    private static int [] perm;
    private static int [][] answr;
    private static int [][] curr;
    private static int [][] table;
    static int count = 0;
    //private static final int n = 4;

    static void printQTable(int table[][], int n){
        for (int i = 0; i < n; ++i){
            for (int j = 0; j < n; ++j){
                System.out.print(" " + table[i][j]+" ");    
            }
            System.out.println();
        }
        System.out.println("Solutions = "+count);
    }

    //Method to look for existing solutions in Solution table
   // check_row(row, size)
    private static int check_row(int temp[][], int r, int n) {
        if (r <= n) {
            for (int i = 0; i < n; ++i) {
                System.out.println("check_row r = "+r);
                System.out.println("check_row col = "+i);
                System.out.println("check_row temp[r][i] = "+temp[r][i]);
                printQTable(temp, n);
                //First Row only:
                if((temp != null) && (temp[r][i] == 0)){
                    //Fill element [1][1] with the first 1
                    System.out.println("Before setting to 1");
                    temp [r][i] = 1;
                    printQTable(temp, n);
                    placeQ(temp, r, i, n);
                    System.out.println("AFTER Placement");
                    printQTable(temp, n);
                } else if (r > n) {
                    System.out.println("Inside check_row r >= n");
                    return count;
                }
            }
        }
        return count;
    }
    //Method to build the array of solutions to n-Queens
    private static void placeQ(int temp[][], int r, int c, int n){
        int i, j;
        if (c < 0) return;
        //Now we will start creating solutions
        //Horizontal ---- i, j+1
        //if (c < n) {
        for (j = (c+1); j < n; ++j) {
            if (temp[r][j] != 1)
                temp[r][j] = -1;
            //temp[r][c+2] = -1;
            //temp[r][c+3] = -1;
        }
        //Vertical |      i+1, j
        //if (r < n) {
        for (i = (r+1); i < n; ++i) {
            if (temp[r][j] != 1)
                temp[i][c] = -1;
            //temp[r+2][c] = -1;
            //temp[r+3][c] = -1;
        }
        //Diagonal to the - Right \
        //if (r < n && c < n) {
        for (i = (r+1), j = (c+1); i < n && j < n; ++i, ++j) {
            if (temp[r][j] != 1)
                temp[i][j] = -1;
            //temp[r+2][c+2] = -1;
            //temp[r+3][c+3] = -1;
        }
        //Diagonal to the - Left /
        //if (r < n && c > 0)
        for (i = (r+1), j = (c-1); i < n && j > 0; ++i, --j) {
            if (temp[r][j] != 1)
                temp[i][j] = -1;
        }
        //increment to next row
        
        //if (c < n && r < n)
            //placeQ(temp, r, c, n);
        System.out.println("row after first element insert is "+r);
        
    }
    public static void main(String [] args) {
        int i, output = 0;
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the number of Queens: ");
        //The input will be the number of n x n, or # of Queens
        int n = kb.nextInt();
        int[][] temp = new int[n+1][n+1];
        answr = new int[n+1][n+1];//Increment by 1 so col's start at 1, not 0
        curr = new int[n][n];
        int[][] Solution = new int[n+1][n+1];
        //Initialize the arrays
        for (i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                temp[i][j] = 0;
                Solution[i][j] = -1;
            }
            //Now we will start creating solution
        }
        for (i = 0; i < n; ++i)
            output =  check_row(temp, i, n);
        Solution = temp;
        System.out.println("Number of N-Queens is = "+output);
        //printQTable(Solution, n);
  
    }


}