class Solution {
    private int dominantCount = 0;

    public int countDominantNodes(TreeNode root) {
        dominantCount = 0; // Reset count for safety
        helper(root);
        return dominantCount;
    }

    private int helper(TreeNode node) {
        // Base case: If the node is null, it contributes nothing to the max value
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        // 1. Postorder step: Explore subtrees first
        int leftMax = helper(node.left);
        int rightMax = helper(node.right);

        // 2. Find the absolute maximum value below or at this node
        int subtreeMax = Math.max(node.val, Math.max(leftMax, rightMax));

        // 3. If the current node's value matches the maximum of its entire subtree,
        // it means it is greater than or equal to all nodes underneath it!
        if (node.val == subtreeMax) {
            dominantCount++;
        }

        // 4. Return the maximum value found in this subtree up to the parent
        return subtreeMax;
    }
}
