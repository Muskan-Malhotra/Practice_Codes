//{ Driver Code Starts
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");

            int[] arr = new int[s.length];
            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            boolean res = obj.canSplit(arr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public boolean canSplit(int arr[]) {
        // code here
        
        if(arr.length == 1){
            return false;
        }
        
        int i = 1;
        int j = arr.length-2;
        int sum1 = arr[0];
        int sum2 = arr[j+1];
        
        while(i<=j){
            
            if(sum1 <= sum2){
                sum1 += arr[i];
                i++;
            }else{
                sum2 += arr[j];
                j--;
            }
            // sum1 += arr[i];
            // sum2 += arr[j];
            
            // i++;
            // j--;
        }
        
        // System.out.println(sum1);
        // System.out.println(sum2);
        
        if(sum1 == sum2){
            return true;
        } else {
            return false;
        }
    }
}