package PeP.BinaryTree;

public class _05_PrintKLvlsDown {

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

    public static void printKDown(Node root, int k){
        if(root == null || k<0){
          return;
        }
        
        if(k == 0){
          System.out.println(root.data);
        }
        
        printKDown(root.left,k-1);
        printKDown(root.right,k-1);
      }
      
    
}
