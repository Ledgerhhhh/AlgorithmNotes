package t.easy;


import main.Main;

public class FindTilt {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(Solution.findTilt(root));
    }

    static class Solution {
        static int i = 0;

        public static int findTilt(TreeNode root) {
            Solution.preorder(root);
            return Solution.i;
        }

        public static int preorder(TreeNode root) {
            if (root != null) {
                int leftVal = preorder(root.left);
                int rightVal = preorder(root.right);
                i += Math.abs(leftVal - rightVal);
                root.val = leftVal + rightVal + root.val;
                return root.val;
            }
            return 0;
        }
    }

    public static class TreeNode {
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