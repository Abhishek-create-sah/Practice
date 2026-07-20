class Solution {
    private boolean dfs(int i, ArrayList<ArrayList<Integer>> adj, int[] vis, ArrayList<Integer> res) {
        vis[i] = 1;

        for (int neg : adj.get(i)) {
            if(vis[neg] == 1){ // Already visited
                return true ;
            }
            if(vis[neg] == 0){
                if(dfs(neg , adj , vis , res)){ 
                    return true ;
                }
            }
        }
        vis[i] = 2 ; // all child have been processed so no further check for that node
        res.add(i); // just add to res 
        return false ; 
    }

    public int[] findOrder(int n, int[][] prq) {
        // [a,b] => to complete "a" you need do "b" first
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int p[] : prq) {
            adj.get(p[1]).add(p[0]);
        }

        ArrayList<Integer> res = new ArrayList<>();
        int[] vis = new int[n];

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                if(dfs(i, adj, vis, res)){ // if return true means there is cycle
                    return new int[0];
                }
            }
        }
        
        int ans[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            ans[i] = res.get(n-1-i); // because in list vale are added in post oder 
        }

        return ans;
    }

}
