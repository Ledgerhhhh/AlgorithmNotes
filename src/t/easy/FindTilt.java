package t.easy;

public class FindTilt {

    public int findTilt(TreeNode root) {

        return preorder(root, 0);
    }

    public int preorder(TreeNode root, Integer i) {
        if (root != null) {
            preorder(root.left, i);
            int left = root.left == null ? 0 : root.left.val;
            int right = root.right == null ? 0 : root.right.val;
            i += Math.abs(left - right);
            preorder(root.right, i);
        }
        return i;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
