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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res ;
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            int s = q.size(); // Same level node in one run

            List<Integer> al = new ArrayList<>();
            
            for(int i = 0 ; i < s ; i++){
                TreeNode cur = q.poll();
                al.add(cur.val);

                if(cur.left != null){
                    q.add(cur.left); 
                }

                if(cur.right != null){
                    q.add(cur.right);
                }
            }
            res.add(al);

        }
        return res ;
    }
}
