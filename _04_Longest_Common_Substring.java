
import java.io.*;
import java.util.*;

/**
 * time : O(M*N)
 * Space : O(M*N)
 */

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob._04_Longest_Common_Substring(S1, S2));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int _04_Longest_Common_Substring(String str1, String str2) {
        // code here
        
       int max = 0;
       int[][] dp = new int[str1.length()+1][str2.length()+1];
       
       for(int i=1;i<dp.length;i++){
           for(int j=1;j<dp[0].length;j++){
               
               char ch = str1.charAt(i-1);
               char ch2 = str2.charAt(j-1);
               
               if(ch == ch2){
                   dp[i][j] = dp[i-1][j-1]+1;
               } else{
                   dp[i][j] = 0;
               }
               
               if(dp[i][j] > max){
                   max = dp[i][j];
               }
           }
       }
       
       
        return max;
    }
}

/**
 * Test Case:
 * 
 * 1) Input: str1 = "ABCDGH", str2 = "ACDGHR"
      Output: 4

   2) I/P : "A" : "A" ==> O/P = 1

   3) Input: str1 = "ABC", str2 = "ACB"
      Output: 1
      Explanation: The longest common substrings are "A", "B", "C" all having length 1.

    Edge Case 1: Empty Strings
    Input:
    String 1: ""
    String 2: ""
    Expected Output: "" (empty string)
    ==========================================================================================
    Edge Case 2: One Empty String
    Input:
    String 1: "abcd"
    String 2: ""
    Expected Output: "" (empty string)
    ==========================================================================================
    Edge Case 3: Identical Strings
    Input:
    String 1: "abcdefgh"
    String 2: "abcdefgh"
    Expected Output: "abcdefgh"
    ==========================================================================================
    Edge Case 4: Single Character Strings
    Input:
    String 1: "a"
    String 2: "a"
    Expected Output: "a"
    ==========================================================================================
    Edge Case 5: Strings with Different Lengths
    Input:
    String 1: "abcdef"
    String 2: "abcd"
    Expected Output: "abcd"
    ==========================================================================================
    Edge Case 6: Case Sensitivity
    Input:
    String 1: "abc"
    String 2: "ABC"
    Expected Output: "" (no common substring if case-sensitive)
    ==========================================================================================
    Edge Case 7: Long Strings with Small Substrings
    Input:
    String 1: "a" * 10000 + "b"
    String 2: "b" + "a" * 10000
    Expected Output: "a" (short common substring among very long strings)
    ==========================================================================================
 * 
 */
