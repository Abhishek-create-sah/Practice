/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int help(TreeNode root,int[] max){
        if(root == null) return 0 ;

        int lh = Math.max(0,help(root.left,max));
        int rh = Math.max(0,help(root.right,max));

        max[0] = Math.max(max[0], lh+rh+root.val) ;
        return Math.max(lh,rh)+root.val ;
    }
    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        help(root,max);
        return max[0];
    }
}
