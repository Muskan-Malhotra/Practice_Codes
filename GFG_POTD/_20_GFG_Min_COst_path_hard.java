//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class _20_GFG_Min_COst_path_hard
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
	class Node implements Comparable<Node>{
	    int i,j;
	    int dist;
	    
	    Node(int i,int j, int dist){
	        this.i = i;
	        this.j = j;
	        this.dist = dist;
	    }
	    
	    public int compareTo(Node o){
	        return this.dist - o.dist;
	    }
	    
	}
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int dist[][] = new int[n][n];
        for(int i=0; i<n; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        
        boolean visited[][] = new boolean[n][n];
        PriorityQueue<Node> q = new PriorityQueue<>();
        dist[0][0] = grid[0][0];
        q.offer(new Node(0, 0, dist[0][0]));
        while(!q.isEmpty()) {
            Node next = q.poll();
            //System.out.println(String.format("i: %d j: %d dist: %d", next.i, next.j, next.dist));
            if (next.i == n-1 && next.j == n-1) {
                return next.dist;
            } else {
                bfs(next, n, visited, dist, grid, q);
            }
        }
        return dist[n-1][n-1];
    }
    
    private void bfs(Node next, int n, boolean visited[][], int dist[][], int grid[][], PriorityQueue<Node> q) {
        int i = next.i;
        int j = next.j;
        if (visited[i][j]) {
            return;
        }
        
        visited[i][j] = true;
        
        if (j > 0) {
            dist[i][j-1] = Math.min(dist[i][j-1], next.dist+grid[i][j-1]);
            q.offer(new Node(i, j-1, dist[i][j-1]));
        }
        
        if (j < n-1) {
            dist[i][j+1] = Math.min(dist[i][j+1], next.dist+grid[i][j+1]);
            q.offer(new Node(i, j+1, dist[i][j+1]));
        }
        
        if (i > 0) {
            dist[i-1][j] = Math.min(dist[i-1][j], next.dist+grid[i-1][j]);
            q.offer(new Node(i-1, j, dist[i-1][j]));
        }
        
        if (i < n-1) {
            dist[i+1][j] = Math.min(dist[i+1][j], next.dist+grid[i+1][j]);
            q.offer(new Node(i+1, j, dist[i+1][j]));
        }
    }
}
