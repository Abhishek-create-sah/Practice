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
    public int maxLevelSum(TreeNode root) {
        int mx =Integer.MIN_VALUE ;
        int res = 0 ;

        if(root == null) return res ;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        int cnt = 0 ;
        while(!q.isEmpty()){
            int s = q.size();
            int sum = 0 ;
            cnt++;
            for(int i = 0 ; i < s ; i++){
                TreeNode cur = q.poll();
                sum += cur.val ;

                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q .add(cur.right); 
            }
            if(sum > mx){
                mx = sum ;
                res = cnt ;
            }
        }
        return res ;
    }
}
