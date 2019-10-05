public class verifyBST {
    public boolean isValidBST(TreeNode node) {
        return isValidBST(node, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean isValidBST(TreeNode node, long max, long min) {
        if (root == null) {
            return true;
        }
        if (root.val >= max || root.val <= min) {
            return false;
        }
        return isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
    }
}

/**
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
