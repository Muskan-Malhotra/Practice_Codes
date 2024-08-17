/**
 * _07_Product_Arr_Brute_Optim
 * Brute force Approach(Accepted):
 * Intuition:
 * The idea in this is to create two extra spaces, i.e. two extra arrays to store the product of all the array elements from the start, 
 * up to that index, and another array to store the product of all the array elements from the end of the array to that index. 
 * To get the product excluding that index i, multiply the prefix product up to index i-1 with the suffix product up to index i+1.
 * 
 * Time : O(N^2)
 * Space: O(N)
 */


/**
 * Expected Approach:
 * Intution:
 * In the above approach, two extra arrays were created to store the prefix and suffix, 
 * in this solution store the prefix and suffix product in the output array (i.e. array vec) itself. 
 * Thus reducing the space required.
 * 
 * Time: O(N)
 * Space: O(N)
 */

class _07_Product_Arr_Brute_Optim {
    public static long[] productExceptSelf(int nums[]) {
        // code here
        long[] ans = new long[nums.length];
        long[] pref = new long[nums.length];
        
        long prod = 1;
        
        pref[0] = 1;
        
        for(int i=1;i<nums.length;i++){
            
            pref[i] = nums[i-1]*pref[i-1];
        }
        
        // for(long ele : pref){
        //     System.out.print(ele + " ");
        // }
        
        // System.out.println();
        
        for(int i=nums.length-1;i>=0;i--){
            ans[i] =  prod*pref[i];
            
            prod *= nums[i];
        }
        
        return ans;
    }
}