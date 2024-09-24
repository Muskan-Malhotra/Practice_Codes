package PeP.BinaryTree;
//binary tree

import java.util.*;

public  class _01_BinaryTreeConstuction {
    public static class Node{
      int data;
      Node left;
      Node right;
      
      Node(int data, Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
      }
    }
    
    public static class Pair{  //Pair is to add data in Pair form in Stack
      Node node;
      int state;
      
      Pair(Node n, int state){
        this.node = n;
        this.state = state;
      }
    }
    
    
    // code for display in binary tree
    
    public static void display(Node root){
      String str = "";
      if(root == null){
        return;
      }
      
      str += root.left != null ? root.left.data + "" : ".";
      str += " ---> " + root.data + " < ----- ";
      str += root.right != null ? root.right.data + "" : ".";
      
      System.out.println(str);
      
      display(root.left);
      display(root.right);
      
      
    }
    public static void main(String[] args) {
      Integer[] arr  = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
      // state 0 = push left node in stack, state 1 = push right node in stack, state 2 = pop()
      Node nod = new Node(arr[0], null, null);
      Pair p = new Pair(nod,0);
      
      Stack<Pair> st = new Stack<>();
      st.push(p);
      
      int idx = 0;
      
      while(st.size() > 0){
        Pair top = st.peek();
        // System.out.println("Stack top : " + top.node.data);
        try {
        //top ki state 0 means left pe lagne ka saman araha hai! next left mein lagega jo lagega..
        if(top.state == 0){
          
          //increase indx to get the next element from array
          idx++;
          if(arr[idx] != null){
            
            //create a node
            Node n = new Node(arr[idx],null,null);
            
            //top in stack<node, state> --> top.node --> top ke node ka left Node<left, right> --> top.node.left
            top.node.left = n;
            //push in stach
            st.push(new Pair(top.node.left, 0));
          } else {
            top.node.left = null;
          }
          top.state++;
          
          
        } else if(top.state == 1){
          
          idx++;
          if(arr[idx] != null){
            Node n = new Node(arr[idx], null, null);
            
            top.node.right = n;
            
            st.push(new Pair(n,0));
          } else {
            top.node.right = null;
          }
          
          top.state++;
          
        } else {
          st.pop();
          // Pair nPop = 
          // System.out.println(nPop.node.data);
        }
        } catch (Exception err){
          System.out.println(err);
        }
      }
      
      display(nod);
  }
  
}