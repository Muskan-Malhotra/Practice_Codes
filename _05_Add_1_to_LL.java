//{ Driver Code Starts
import java.io.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class _05_Add_1_to_LL {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node reverse(Node head){
        Node cur = head;
        Node prev = null;
        
        while(cur != null){
            Node nxt = cur.next;
            cur.next = prev;
            
            prev = cur;
            cur = nxt;
            
        }
        
        return prev;
    }
    public Node addOne(Node head) {
        // code here.
        
        Node prev = reverse(head);
        Node temp = prev;
        Node ref = null;
        int carry = 0;   
        boolean flag = true;
        
        while(temp != null){
            int sum = carry;
            if(flag){
                sum = temp.data + 1;
                flag = false;
            } else {
                sum += temp.data;
            }
            int rem = sum%10;
            carry = sum/10;
            
            if(temp.next == null){
                ref = temp;
            }
            temp.data = rem;
            temp = temp.next;
            
        }
        
        if(carry != 0){
            Node n = new Node(carry);
            ref.next = n;
        }
        
        head = reverse(prev);
        
        return head;
    }
    
    
}
