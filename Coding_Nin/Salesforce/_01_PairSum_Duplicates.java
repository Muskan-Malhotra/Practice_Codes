package Coding_Nin.Salesforce;
import java.io.*;
import java.util.* ;

//https://www.naukri.com/code360/problems/pair-sum_697295?interviewBundleRedirection=true&leftPanelTabValue=PROBLEM&customSource=studio_nav

/*
 * Time : O(N) + O(nlogn)[for Arrays.sort] + O(nlogn)[for Arrays.reverse]
 * Space: O(N)
 */
public class _01_PairSum_Duplicates {

    public static List<int[]> pairSum(int[] arr, int s) {
        // Write your code here.
        
        List<int[]> al = new ArrayList<>();
        Arrays.sort(arr);
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            int ans = s - arr[i];

            int freq = hm.getOrDefault(ans, 0);

            if(freq > 0){
                while(freq > 0){
                    int[] ar = new int[2];
                    ar[0] = Math.min(arr[i],ans);
                    ar[1] = Math.max(arr[i],ans);
                    al.add(ar);
                    freq--;
                }
            }

            hm.put(arr[i],hm.getOrDefault(arr[i], 0)+1);

        }

        Collections.reverse(al);
        return al;
    }
    
}


/*
 * Sample Input 1:
5 5
1 2 3 4 5
Sample Output 1:
1 4
2 3
Explaination For Sample Output 1:
Here, 1 + 4 = 5
      2 + 3 = 5
Hence the output will be, (1,4) , (2,3).
Sample Input 2:
5 0
2 -3 3 3 -2
Sample Output 2:
-3 3
-3 3
-2 2

Sample Input 3 : -6 2 2 2 5
O/P : 2 2 
2 2 
2 2 
 */
