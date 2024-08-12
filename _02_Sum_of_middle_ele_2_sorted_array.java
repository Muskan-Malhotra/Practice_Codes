//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        // code here
        int lo = 0, hi = arr1.length;
        int n = arr1.length + arr2.length;
        
        // applying binary search to get the mid of arr1!        
        while(lo <= hi){
            int cut1 = lo + (hi-lo)/2;
            int cut2 = (n+1)/2 - cut1;
            
            int l1 = (cut1 == 0) ? Integer.MIN_VALUE
                                 : arr1[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE
                                 : arr2[cut2 - 1];
            int r1 = (cut1 == n) ? Integer.MAX_VALUE
                                 : arr1[cut1];
            int r2 = (cut2 == n) ? Integer.MAX_VALUE
                                 : arr2[cut2];
            
            // cut1 = mid-1;
            // cut2 = mid2 - 1;
            
            if(l1 > r2){    
                hi = cut1 - 1;
            } else if (l2 > r1){
                lo = cut1 + 1;
            } else {
             return Math.max(l1, l2) + Math.min(r1, r2);
            }
            
        }    
        
        
        
        return 0;
    }
}

//{ Driver Code Starts.
public class _02_Sum_of_middle_ele_2_sorted_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.SumofMiddleElements(arr, brr);
            System.out.println(res);
        }
        sc.close();
    }
}

// } Driver Code Ends


/**
 * What I did initially
 * 
 class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        // code here
        int lo = 0, hi = arr1.length;
        int totalEle = arr1.length + arr2.length;
        int cut1 = -1, cut2 = -1;
        
        // applying binary search to get the mid of arr1!        
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            
            cut1 = mid-1;
            int mid2 = (totalEle+1)/2 - mid;
            cut2 = mid2 - 1;
            
            if(arr1[cut1] > arr2[mid2]){
                hi = mid - 1;
            } else if (arr2[cut2] > arr1[mid]){
                lo = mid + 1;
            } else {
                return Math.max(arr1[cut1],arr2[cut2]) + Math.min(arr1[mid],arr2[mid2]);
            }
            
        }    
        
        
        
        return 0;
    }
 */