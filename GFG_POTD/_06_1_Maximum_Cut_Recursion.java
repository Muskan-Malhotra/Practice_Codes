
class _06_1_Maximum_Cut_Recursion
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
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
       
       if(x != 0)
        c1 = maximizeCuts(n-x,x,y,z);
       if(y != 0)
        c2 = maximizeCuts(n-y, x,y,z);
       if(z != 0)
        c3 = maximizeCuts(n-z,x,y,z);
       
       int max = Math.max(c1, Math.max(c2,c3));
       //   System.out.println("n: " + n + " max: " + max);
       if(max == Integer.MIN_VALUE){
           return 0;
        }
       return max+1;
       
       
    }
}