import java.util.*;

public class Main {
  
    static class Node{
      int data;
      Node left;
      Node right;
      
      Node(int data, Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
      }
      
    }
    
    static class Pair{
      Node node;
      int state;
      
      Pair(Node node, int state){
        this.node = node;
        this.state = state;
      }
      
    }
    
    public static void display(Node root){
      
      if(root == null){
        return;
      }
      
      String str = "";
      
      String left = root.left == null ? "." : root.left.data+"";
      String right = root.right == null ? "." : root.right.data+"";
    
      System.out.println(left + "<--" + root.data + "-->" + right);
      
      display(root.left);
      display(root.right);
      
    }
    
    public static ArrayList<Integer> Node2RootPath(Node n, int key){
      
      
      if(n == null){
        return new ArrayList<>();
      }
      
      if(n.data == key){
        ArrayList<Integer> bl = new ArrayList<>();
        bl.add(key);
        return bl;
      }
      
      ArrayList<Integer> ln = Node2RootPath(n.left,key);
      if(ln.size()>0){
        System.out.println(ln+" root: " + n.data);
        ln.add(n.data);
        return ln;
      }
      ArrayList<Integer> rn = Node2RootPath(n.right,key);
      if(rn.size()>0){
        rn.add(n.data);
        return rn;
      }
      
      return new ArrayList<>();
      
    } 
    
    public static void main(String[] args) {
      Integer[] ar = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
      Node root = new Node(ar[0],null,null);
      Stack<Pair> st = new Stack<>();
      st.push(new Pair(root,0));
      
      int idx = 0;
      while(st.size()>0){
        
        Pair top = st.peek();
        
        if(top.state == 0){
          idx++;
          if(ar[idx] != null){
            top.node.left = new Node(ar[idx],null,null);
            st.push(new Pair(top.node.left,0));
          }else{
            top.node.left = null;
          }
          top.state++;
          
        } else if(top.state == 1){
            idx++;
            if(ar[idx] != null){
              top.node.right = new Node(ar[idx],null,null);
              st.push(new Pair(top.node.right,0));
              
            }else{
              top.node.right = null;
            }
            top.state++;
          
        } else {
          st.pop();
        }
        
      }
      
      display(root);
      ArrayList<Integer> al = Node2RootPath(root, 30);
      System.out.println(al);
  }
}