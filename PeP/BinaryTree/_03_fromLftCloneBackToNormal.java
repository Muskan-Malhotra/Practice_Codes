package PeP.BinaryTree;

public class _03_fromLftCloneBackToNormal {
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
      
    public static void cloneToNormal(Node root){
      
        if(root == null){
          return;
        }
        
        Node leftCh = root.left != null && root.left.left == null ? null : root.left.left;
        root.left = leftCh;
        
        cloneToNormal(leftCh);
        cloneToNormal(root.right);
      }
    
}
