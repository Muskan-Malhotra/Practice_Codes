
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class _25_GFG_Nth_Natural_no {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        int t = ob.nextInt();
        while (t-- > 0) {
            long n = ob.nextLong();
            Solution ab = new Solution();
            long k = ab.findNth(n);
            System.out.println(k);
        }

        ob.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    long findNth(long N) {
        // Stores the Nth number
    long result = 0;

    long p = 1;

    // Iterate while N is
    // greater than 0
    while (N > 0) {

      // Update result
      result += (p * (N % 9));

      // Divide N by 9
      N = N / 9;

      // Multiply p by 10
      p = p * 10;
    }

    // Return result
    return result;
    }
}
