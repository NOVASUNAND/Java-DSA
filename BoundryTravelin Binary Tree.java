import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { 
        val = x;
        left = right = null;
    }
}

public class BoundaryTraversal {
    private static boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    private static void addLeftBoundary(TreeNode root, List<Integer> res) {
        TreeNode cur = root.left;
        while(cur != null) {
            if(!isLeaf(cur)) res.add(cur.val);
            if(cur.left != null) cur = cur.left;
            else cur = cur.right;
        }
    }

    private static void addLeaves(TreeNode root, List<Integer> res) {
        if(root == null) return;
        if(isLeaf(root)) {
            res.add(root.val);
        } else {
            addLeaves(root.left, res);
            addLeaves(root.right, res);
        }
    }

    private static void addRightBoundary(TreeNode root, List<Integer> res) {
        TreeNode cur = root.right;
        List<Integer> temp = new ArrayList<>();
        while(cur != null) {
            if(!isLeaf(cur)) temp.add(cur.val);
            if(cur.right != null) cur = cur.right;
            else cur = cur.left;
        }
        Collections.reverse(temp);
        res.addAll(temp);
    }

    public static List<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        if(!isLeaf(root)) res.add(root.val);
        else {
            res.add(root.val);
            return res;
        }
        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);
        return res;
    }

    // Helper method to build tree from level order input (using null for missing nodes)
    public static TreeNode buildTree(Integer[] nodes) {
        if(nodes.length == 0 || nodes[0] == null) return null;
        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while(!queue.isEmpty() && i < nodes.length) {
            TreeNode current = queue.poll();
            if(i < nodes.length && nodes[i] != null) {
                current.left = new TreeNode(nodes[i]);
                queue.offer(current.left);
            }
            i++;
            if(i < nodes.length && nodes[i] != null) {
                current.right = new TreeNode(nodes[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        // Example 1
        Integer[] nodes1 = {1,2,3,4,5};
        TreeNode tree1 = buildTree(nodes1);
        List<Integer> ans1 = boundaryTraversal(tree1);
        System.out.println(ans1); // Expected [1,2,4,5,3]
        
        // Example 2
        Integer[] nodes2 = {1,2,3,4,5,6,null,null,null,7,8,9,10};
        TreeNode tree2 = buildTree(nodes2);
        List<Integer> ans2 = boundaryTraversal(tree2);
        System.out.println(ans2); // Expected [1,2,4,7,8,9,10,6,3]
        
        // Example 3
        Integer[] nodes3 = {1};
        TreeNode tree3 = buildTree(nodes3);
        List<Integer> ans3 = boundaryTraversal(tree3);
        System.out.println(ans3); // Expected [1]
    }
}
