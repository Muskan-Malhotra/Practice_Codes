//{ Driver Code Starts
// Initial Template for Java

/** the time complexity is 
O(nlogn), and the space complexity is: O(n). */

import java.io.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to sort the array according to frequency of elements.
    class Pair implements Comparable<Pair>{
        int val;
        int freq;
        
        Pair(int val, int freq){
            this.val = val;
            this.freq = freq;
        }
        
        public int compareTo(Pair o){
            int res =  o.freq - this.freq;
            if(res == 0){
                return this.val - o.val;
            } 
            
            return res;
        }
    }
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        
        Map<Integer,Integer> hm = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        ArrayList<Integer> al = new ArrayList<>(arr.length);
        
        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(arr[i])){
                int freq = hm.get(arr[i]) + 1;
                hm.put(arr[i],freq);
            } else {
                hm.put(arr[i],1);
            }
        }
        
        for(Entry<Integer,Integer> ele : hm.entrySet()){
            Pair p = new Pair(ele.getKey(),ele.getValue());
            pq.add(p);
        }
        
        while(pq.size() > 0){
            Pair p = pq.remove();
            
            for(int i=0;i<p.freq;i++){
                al.add(p.val);
            }
            
            // System.out.println(p.val + " : " + p.freq);
        }
        
        // for (String name : gfg.keySet())  
        //     System.out.println("key: " + name); 
          
        // // using values() for iteration over values 
        // for (String url : gfg.values())  
        //     System.out.println("value: " + url); 
        
        
        return al;
    }
}

//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends

/* Test cases
 * 4 6 9 19 2 16 13 11 16 17 16 8 12 16 12 18
 */