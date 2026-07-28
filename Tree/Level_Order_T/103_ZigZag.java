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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res ;

        boolean lr = true ;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int s = q.size();
            List<Integer> l = new ArrayList<>();

            for(int i = 0 ; i < s ; i++){
                TreeNode cur = q.poll();
                if(lr){
                    l.add(cur.val); // add at ending
                }
                else {
                    l.addFirst(cur.val); // add at the begining
                }

                if(cur.left != null){
                    q.add(cur.left);
                }
                if(cur.right != null){
                    q.add(cur.right);
                }
            }
            lr = !lr ;
            res.add(l);
        }
        return res ;
    }
}
