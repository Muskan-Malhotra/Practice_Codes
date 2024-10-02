//{ Driver Code Starts
import java.util.*;

public class _19_Max_Sum_Path_In_2_Arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the remaining newline

        for (int k = 0; k < t; k++) {
            List<Integer> arr1 = new ArrayList<>();
            String input = sc.nextLine();
            Scanner lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr1.add(lineScanner.nextInt());
            }
            lineScanner.close();

            List<Integer> arr2 = new ArrayList<>();
            input = sc.nextLine();
            lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr2.add(lineScanner.nextInt());
            }
            lineScanner.close();

            Solution ob = new Solution();
            int ans = ob.maxPathSum(arr1, arr2);
            System.out.println(ans);
        }

        sc.close();
    }
}

// } Driver Code Ends



class Solution {
   
    public int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        // code here4
        int n = arr1.size(), m = arr2.size();
        
        int sum1 = 0;
        int sum2 = 0;
        int maxSum = 0;
        int i=0,j=0;
        while(i < n && j < m){
            if(arr1.get(i) < arr2.get(j)){
                sum1 += arr1.get(i);
                i++;
            } else if( arr2.get(j) < arr1.get(i)){
                sum2 += arr2.get(j);
                j++;
            } else {
                //if arr1[i] == arr2[j] 
                maxSum += Math.max(sum1, sum2) + arr1.get(i);
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }
        
        while( i < n ){
            sum1 += arr1.get(i);
            i++;
        } 
        while( j < m ){
            sum2 += arr2.get(j);
            j++;
        } 
        
        return Math.max(sum1, sum2) + maxSum;
    }
}

/**
 * Test case
 * 2 3 7 10 12
1 5 7 8 10 10

2 3 7 10 12
1 5 7 8 

//check from chatgpt more tet cases
 */