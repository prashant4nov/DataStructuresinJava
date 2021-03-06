Node inOrderSuccessor(Node root, Node n) {
 
        // step 1 of the above algorithm 
        if (n.right != null) {
            return minValue(n.right);
        }
 
        // step 2 of the above algorithm
        Node p = n.parent;
        while (p != null && n == p.right) {
            n = p;
            p = p.parent;
        }
        return p;
    }
 
http://algorithms.tutorialhorizon.com/inorder-successor-in-binary-search-tree-without-using-parent-link/

http://algorithms.tutorialhorizon.com/inorder-successor-in-binary-tree/
