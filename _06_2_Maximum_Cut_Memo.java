
import java.util.*;
import java.io.*;

// time: O(N) :: Thus, the time complexity of the code is O(n) because each subproblem is solved once due to memoization, 
// and there are n+1 subproblems to solve.
//Space: O(N)

class _06_2_Maximum_Cut_Memo
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading length of line segment
            int n = Integer.parseInt(read.readLine().trim());
            
            
            //reading 3 segment lengths
            String str[] = read.readLine().trim().split(" ");
            
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int z = Integer.parseInt(str[2]);
            
            
            //calling method maximizeCuts() of class Solution()
            //and printinting the result
            System.out.println(new Solution().maximizeCuts(n, x, y, z));
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       int[] qb = new int[n+1];
       
       Arrays.fill(qb,-1);
       
       int ans = maxCut(n,x,y,z,qb);
       if(ans < 0){return 0;}
       return ans;
       
    }
    
    public int maxCut(int n, int x, int y, int z, int[] qb){
        
       // to handle the 0 case;
       
       int c1 = x!= 0 ? 0 : 1;
       int c2 = y!= 0 ? 0 : 1;
       int c3 = z!= 0 ? 0 : 1;
       
       //time complexity: O(3^n);
       //spce: O(n)
       
       if (n == 0){
           return 0;
       } 
       
       if( n<0 ){
           return Integer.MIN_VALUE;
       }
       
       if(qb[n] != -1){
           return qb[n];
       }
       
       if(x != 0)  // to handle 0 cases
        c1 = maxCut(n-x,x,y,z, qb);
       if(y != 0)
        c2 = maxCut(n-y, x,y,z, qb);
       if(z != 0)
        c3 = maxCut(n-z,x,y,z, qb);
       
       int max = Math.max(c1, Math.max(c2,c3));
       //   System.out.println("n: " + n + " max: " + max);
       if(max == Integer.MIN_VALUE){
           qb[n] = 0;
        }
        
       qb[n] = max+1;
       return qb[n];
       
       
    }
}

/**
 * test cases:
 * 
 * 
3
5 6 7

7
2 5 5

11
2 3 5

4
1 0 1

11
2 2 2

 */
