package t.easy;

public class IsUnivalTree {


    public static void main(String[] args) {

    }
    class Solution {

        int init =-1;
        boolean flag=true;

        public boolean isUnivalTree(TreeNode root) {
            init =root.val;
            recursion(root);
            return flag;
        }

        public void recursion(TreeNode root){
            if(root==null) return;
            if(!flag){
                return;
            }
            recursion(root.left);
            recursion(root.right);
            if(init!= root.val){
                flag=false;
            }
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
