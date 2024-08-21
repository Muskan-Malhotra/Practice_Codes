//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    class Pair implements Comparable<Pair>{
        int src;
        int wgt;
        
        Pair(int src,int wgt){
            this.src = src;
            this.wgt = wgt;
        }
        
        public int compareTo(Pair o){
            return this.wgt - o.wgt;
        }
    }
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // lets create a graph
        
        int[] ans = new int[n]; // i/p 2 1 ; 0 1 ; 1 0
        if( n == 1 && m == 0){
            ans[0] = m;
            return ans;
        }
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0;i<n;i++){   // depend on vertices
            graph.add(new ArrayList<>());
        }
        
        for(int i=0;i<m;i++){  //depend on edge
            int sr = edges[i][0];
            int nb = edges[i][1];
            
            graph.get(sr).add(nb);
            graph.get(nb).add(sr);
        }
        
        // for(int i=0;i<n;i++){
        //     for(Integer e : graph.get(i)){
        //         System.out.println(i + " - " + e);
        //     }
        // }
        
        Arrays.fill(ans,-1);
        boolean[] vis = new boolean[n];
        getShortestPath(graph, src,vis, ans);
        
        return ans;
    }

    public void getShortestPath( ArrayList<ArrayList<Integer>> graph, int src,boolean[] vis, int[] ans){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        pq.add(new Pair(src,0));
        
        while(pq.size()>0){
            Pair p = pq.remove();
            System.out.println(p.src + " - " + p.wgt);
            
            if(vis[p.src] == false){  // important if we don't want to overwrite the values even when vis is already true!!
                vis[p.src] = true;
                
                ans[p.src] = p.wgt; // have to keep it here can't keep inside !vis[e] coz may get misnmatch value!
                
                
                for(Integer e : graph.get(p.src)){
                    if(!vis[e]){ //unvisited is checked here but the wgt is still updated for vis nbr
                        System.out.println("nbr: " + src + " - " + e);
                        pq.add(new Pair(e,p.wgt+1));
                    }
                }
            }
        }
    }
    
}

/**
 * For Input
 * 9 10
0 1
0 3 
3 4 
4 5 
5 6 
1 2 
2 6 
6 7 
7 8 
6 8 
0
 * Output:
 * 0 - 0
nbr: 0 - 1
nbr: 0 - 3
1 - 1
nbr: 0 - 2
3 - 1
nbr: 0 - 4
2 - 2
nbr: 0 - 6
4 - 2
nbr: 0 - 5
6 - 3
nbr: 0 - 5
nbr: 0 - 7  //although 7 is enqueud first in Priority Quueu and 
nbr: 0 - 8
5 - 3
8 - 4  // still after 5-3; 8-4 is removed 1st;
       // this is due to the heapification in PQ where it may have rearraged the order of elements before dequeu
nbr: 0 - 7
7 - 4
5 - 4
7 - 5
0 1 2 1 2 4 3 5 4 // without line 88

// after adding if of line 88 : the output : 0 1 2 1 2 3 3 4 4
Expected Output: 
0 1 2 1 2 3 3 4 4
 * 
 */