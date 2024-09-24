package PeP.BinaryTree;

import java.util.Stack;
/*
 * changes made to the OG tree via function CloneLftTree will have the transformed tree
 */

public class _02_cloneLeftTree {
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
    
    String str = "";
    
    if(root == null){
        return;
    }
    
    str += root.left == null ? "." : root.left.data;
    str += " < --- " + root.data + " ---> ";
    str += root.right == null ? "." : root.right.data;
    
    
    System.out.println(str);
    
    display(root.left);
    display(root.right);
    }
    
    public static void cloneLtTree(Node root){
        Node leftChild = null;
        
        if(root == null){
          return;
        }
        
        leftChild = root.left == null ? null : root.left;
        
        Node newNode = new Node(root.data,null,null);
        root.left = newNode;
        newNode.left = leftChild;
        
        cloneLtTree(leftChild);
        cloneLtTree(root.right);
      }



      /** Driver code  */

      public static void main(String[] args) {
      Integer[] ar = {1, 2, null,null,3,null,null};
      //{50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
      
      Node root = new Node(ar[0],null,null);
      Stack<Pair> st = new Stack<>();
      
      st.push(new Pair(root,0));
      int idx = 0;
      while(st.size()>0){
        
        Pair p = st.peek();
        
        if(p.state == 0){
          idx++;
          if(ar[idx] != null){
            
            Node n = new Node(ar[idx],null,null);
            p.node.left = n;
            st.push(new Pair(p.node.left, 0));
            p.state++;
          } else {
            p.state++;
          }
        } else if(p.state == 1){
          idx++;
          if(ar[idx] != null){
            
            Node n = new Node(ar[idx],null,null);
            p.node.right = n;
            st.push(new Pair(p.node.right, 0));
            p.state++;
          } else {
            p.state++;
          }
        } else {
          st.pop();
        }
        
      }
      cloneLtTree(root);
      display(root);
      
      
      
  }
}
