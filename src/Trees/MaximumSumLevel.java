package Trees;

/**
 * Created by Prashant on 5/30/16.
 */
import java.util.Queue;
import java.util.LinkedList;
public class MaximumSumLevel {
    static int maxSumLevel(Node root){
        if(root==null) return 0;
        int maxSum = 0;
        int level = 0;
        int maxLevel = 0;
        int sum=0;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node tmp = q.poll();
            if(tmp==null) {
                level++;
                if(maxSum<sum) {
                    maxSum=sum;
                    maxLevel=level;
                }
                sum=0;
                if(!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                sum=sum+tmp.data;
                if(tmp.left!=null) q.add(tmp.left);
                if(tmp.right!=null) q.add(tmp.right);
            }
        }
        System.out.print(maxSum+" ");
        return maxLevel;
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);
        a.right.left = new Node(6);
        a.right.right = new Node(7);

        System.out.print(maxSumLevel(a)+" ");
    }
}
