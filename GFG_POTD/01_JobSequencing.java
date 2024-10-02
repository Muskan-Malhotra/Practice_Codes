//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * 
 * test cases
 * [[1,4,20],[2,1,1],[3,1,40],[4,1,30]]
 *  [[1,2,100],[2,1,19],[3,2,27],[4,1,25],[5,1,15]]
 * [[1,2,0],[2,1,19],[3,2,27],[4,1,25],[5,1,15]]
 */

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr, (a,b) -> (b.profit-a.profit));
        int max = 0; //deadline can never be -ve!
        for(Job ele : arr){
            if(ele.deadline > max){ 
                
                max = ele.deadline;
            }
            // System.out.println(ele.id+ " " + ele.deadline + " " + ele.profit);
        }
        int sum = 0;
        int count = 0;
        int[] res = new int[2];
        int[] his = new int[max+1];
        
        Arrays.fill(his,-1);
        
        for(int i=0;i<arr.length ; i++){
            Job ele = arr[i];
            
            
            for(int j = ele.deadline; j >= 1; j--){
                if(his[j] == -1){
                    
                    res[0] = ++count;
                    his[j] = ele.id;
                    sum += ele.profit;
                    break; // this is important or else the array will be filled till it reaches 1
                }
            }

        }
        
        // for(int ele : his){
        //     System.out.print(ele+ " ");
        // }
        // System.out.println();
        
        res[1] = sum;
        
        
        return res;
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/