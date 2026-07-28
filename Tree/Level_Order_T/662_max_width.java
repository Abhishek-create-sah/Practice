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

class Pair {
    TreeNode node ;
    int num ;

    Pair(TreeNode nd , int nm){
        this.node = nd ;
        this.num = nm ;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0 ;
        int width = 0 ;
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root,0));

        while(!q.isEmpty()){
            int s = q.size();
            int mmin = q.peek().num; // first node will have min val
            int f = 0 ; 
            int l = 0 ;

            for(int i = 0 ; i < s ; i++){
                Pair cur = q.poll();

                int idx = cur.num - mmin ; // update new idx = parent.num - mmin

                if(i == 0 ) f = idx ; // it mean it is starting
                if(i == s-1) l = idx ; // it means it is ending

                if(cur.node.left != null){
                    q.add(new Pair(cur.node.left,2*idx+1)); // new level indx again start with 1
                }
                if(cur.node.right != null){
                    q.add(new Pair(cur.node.right,2*idx+2)); // if left = 1 then right = left+1;
                }
            }
            width = Math.max(width , l-f+1); // final width last - first +1
        }
        return width ;
    }
}
