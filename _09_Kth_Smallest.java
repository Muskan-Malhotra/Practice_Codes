/**
 * Input: arr[] = [7, 10, 4, 3, 20, 15], k = 3
 * Output:  7
 * Explanation: 3rd smallest element in the given array is 7.
 */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            out.println(ob.kthSmallest(arr, key));
        }
        out.flush();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int kthSmallest(int[] arr, int k) {
        // Your code here
        if(k > arr.length){
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<arr.length;i++){  //need to add all the elemnts coz pq will then have the correct peek!
            pq.add(arr[i]);
        }
        
        for(int i=1;i<k;i++){   //started with 1 coz if k=1 and i=0; i<k and 1st element will be removed from pq!!
            
            pq.remove();
               
        }
        
        return pq.peek();


        // for(int ele : pq){
        //     System.out.print(ele+" ");
        // }
        
        // System.out.println();
        // System.out.println("pq.peek(): " + pq.peek());
        
    }
}
