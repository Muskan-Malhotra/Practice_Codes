//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _14_Maximum_Difference {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findMaxDiff(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    public int findMaxDiff(int[] arr) {
        // code here
        
        int[] lsArr = new int[arr.length];
        int[] rsArr = new int[arr.length];
        
        int max = Integer.MIN_VALUE;
        
        leftSmallest(arr,lsArr);
        // for(int ele : lsArr){
        //         System.out.print(ele + " ");
        // }
        // System.out.println();
        
        rightSmallest(arr,rsArr);
        // for(int ele : rsArr){
        //         System.out.print(ele + " ");
        // }
        
        // System.out.println();
        
        for(int i=0;i<arr.length;i++){
            int val = Math.abs(lsArr[i] - rsArr[i]);
            max = val > max ? val : max;
        }
        
        return max;
    }
    
    public void leftSmallest(int[] arr, int[] lsArr){
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            // int peek = st.size() > 0 ? st.peek() : 0;
            // System.out.println("st.peek(): " + peek);
            // if( st.size() > 0 && arr[i] < st.peek()){
                
                while(st.size() > 0 && st.peek() >= arr[i]){ //this equal to is most important check test cases
                    st.pop();
                }
                lsArr[i] = st.size() == 0  ? 0 : st.peek();
            // } else { //arr[i] > st.peek()
            //     lsArr[i] = st.size() == 0 ? 0 : st.peek();
            // }
            
            st.push(arr[i]);
        }
    }
    
     public void rightSmallest(int[] arr, int[] rsArr){
        Stack<Integer> st = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            // if( st.size() > 0 && arr[i] < st.peek()){
                while(st.size() > 0 && st.peek() >= arr[i]){
                    st.pop();
                }
                rsArr[i] = st.size() == 0  ? 0 : st.peek();
            // } else { //arr[i] > st.peek()
            //     rsArr[i] = st.size() == 0  ? 0 : st.peek();
 
            // }
            
            st.push(arr[i]);
        }
    }
}

/* test cases
 * 
 * 55 99 94 27 12 75 71 82 35 44
3 8 3 4 1
1 2 3 4 5 6 5 4 3 2 1
5 5 5 5 5 5
 */
