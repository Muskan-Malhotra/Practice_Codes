import java.io.*;
import java.util.*;

class _23_missing_in_array {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            System.out.println(sln.missingNumber(n, arr));
        }
        
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {

    // Note that the size of the array is n-1
    int missingNumber(int n, int arr[]) {
        
        int idx = 0;

        // Your Code Here
        Arrays.sort(arr);
        
        // System.out.println(arr.length-1);
        
        for(int i=0;i<n-1;i++){
            if(arr[i] != i+1){
                // System.out.println(i+1);
                return i+1;
            }
            
            idx = i+1;
            
            // System.out.print(arr[i] + " ");
        }
        
        if(arr[n-2] != idx+1){
            return n;
        }
        
        return 0;
    }
}
