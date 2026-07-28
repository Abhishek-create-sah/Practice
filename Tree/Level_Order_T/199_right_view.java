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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res ;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int s = q.size();
            

            for(int i = 0 ; i < s ; i++){
                TreeNode cur = q.poll() ;
                if(i == s-1) res.add(cur.val); // last val of queue of that run
                // for left view i == 0
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }
        }
        return res ;
    }
}

// we can use dfs also root-> right -> left 
//if null retun ;
// if depth == res.size() res.add(root.val)
// dfs(root.right , depth+1 , res) then same left , depth+1 , res
