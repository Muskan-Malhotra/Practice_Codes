/**
 * 
 * Best solution in prime Number video of pepcoding
 * https://www.youtube.com/watch?v=HXSfAyjWM8A
 */


//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            long a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends


// Time Complexity :  O(log(n)) --> Using Binary search
// Time Complexity: O(log n), binary search approach takes O(log n)
// Space Complexity: O(1), there is no required any extra space for binary search.


/*
Intuition
The idea is to reduce the search area and avoid checking for all the numbers instead we can use the binary search approach here. With the help of binary search check if square of mid is equal to x, if it is then return mid.

Dry Run:
n=9

start=1 , end=9
mid=5, but 5*5=25 and 25>9, we have to reduce the upper limit so end= mid-1 that is 4.
start=1 , end=4
mid=2, now 2*2=4 but 4<9, so we have to increase our lower limit, so start = mid that is 2 .
start=2, end=4
mid=3, now 3*3=9 hence return 3.

*/

class Solution

{
    long floorSqrt(long n) {
        // base case
        if (n == 0 || n == 1) return n;

        long start = 1, end = n, ans = 0;

        // binary search to find square root of a number
        while (start <= end) {
            long mid = (start + end) / 2;

            // if mid*mid == n, then mid is the required element
            if (mid * mid == n) return mid;

            // if mid*mid < n, then iterate for upper half
            if (mid * mid < n) {
                start = mid + 1;
                ans = mid;
            }
            // else, iterate for lower half
            else
                end = mid - 1;
        }
        return ans;
    }
}

// Function to find square root
// x: element to find square root

//brute force! : O(sqrt(n))
class _03_Sqrt_of_Num {
    long floorSqrt(long n) {
        // Your code here
        if(n == 0){
            return n;
        }
        long ans = 0;
        //remainder can be anything b/w 0 to i !! so no need to apply check for reaminder 0 or 1!
        for(int i=1; i*i<=n; i++){
            ans = i;
        }
        
        return ans;
    }
    /**
     * Case:
     * 0) 1 
     * *) 2
     * **) 0
     * 1) 36 --> 2x36, 3x12, 4x9, 6x6
     * 2) 17 --> 2x9, 4x4(1)
     * 3) 24 --> 2x12, 3x8, 4x6
     * 4) 123456789
     * */
}

