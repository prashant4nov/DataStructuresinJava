package Trees;

/**
 * time complexity is O(n)
 * Created by Prashant on 5/30/16.
 * http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 * The diameter of a tree (sometimes called the width) is the number of nodes 
 * on the longest path between two leaves in the tree.
 * https://www.geeksforgeeks.org/diameter-of-a-binary-tree/ ::: O(n) complexity
 */
class Height {
  int h;
}
public class DiameterTree {
    static int diameterOn(Node root, Height height) {
       if(root == null) {
           height.h = 0;
           return 0;
       }
       
       Height lh = new Height(), rh = new Height();
       
       lh++; rh++;
       
       int leftDiameter = diameterOn(root.left, lh);
       int rightDiameter = diameterOn(root.right, rh);
        
       height.h = Math.max(lh, rh) + 1;
        
       return Math.max(Math.max(leftDiameter, rightDiameter), lh + rh + 1);
    }
        
    static int diameter(Node root) {
        if(root==null) return 0;
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);
        int leftHeight = HeightofTree.height(root.left);
        int rightHeight = HeightofTree.height(root.right);
        return Math.max(Math.max(leftDiameter, rightDiameter),
                        1+leftHeight+rightHeight);

    }
    public static void main(String[] args) {
        Node a = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);
        a.right.left = new Node(6);
        a.right.right = new Node(7);

        System.out.print(diameter(a)+" ");
    }
}
