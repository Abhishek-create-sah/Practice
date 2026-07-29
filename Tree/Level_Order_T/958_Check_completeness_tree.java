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
    public boolean isCompleteTree(TreeNode root) {
        if (root == null)
            return true; 

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean past = false; //at starting no null have seen

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();

            if (cur == null) { // if get null 
                past = true;   // make past true as we have seen a null
            } else {
                if (past == true) { // after seeing null in past we are getting a val
                    return false;   // then it is not complete tree
                }
                q.offer(cur.left); // Add only if no null 
                q.offer(cur.right); // as we ealier checked the null and it is else 
            }
        }
        return true ; // we didn't find any val ofter past become true
    }
}
