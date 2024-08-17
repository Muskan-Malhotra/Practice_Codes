/**
 * _07_Product_Array_Puzzle
 * 
 * TIME : O(N)
 * SPACE: O(1);
 */
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            t--;
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long[] productExceptSelf(int nums[]) {
        // code here
        long[] ans = new long[nums.length];
        long prod = 1;
        long prodW0 = 1;
        boolean flag = false;
        int idx = -1;
        
        for(int i=0;i<nums.length;i++){
            prod *= nums[i]; 
            
            if(nums[i] != 0){
                prodW0 *= nums[i];
            }
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0)
                ans[i] = prod/nums[i];
            else if(!flag){
                flag = true;
                ans[i] = prodW0;
                idx = i; 
            } else if(flag){
                ans[i] = 0;
                ans[idx] = 0;
            }
                
        }
        
        return ans;
    }
}

/*
 * 
 * 
2
0 12 ==> 12 0

5
10 3 5 6 2 ==> 180 600 360 300 900

5
10 15 0 13 12 ==> 0 0 23400 0 0

5
10 15 0 13 0 ==> 0 0 0 0 0


 */
