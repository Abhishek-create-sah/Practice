class Solution {
    public boolean canFinish(int n, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        int[] indg = new int[n];
        Queue<Integer> q = new LinkedList<>();

        for(int[] p : pre){
            adj.get(p[1]).add(p[0]); // to complete b , a should be completed
            indg[p[0]]++; // on how many a it is depended
        }

        for(int i = 0 ; i < n ; i++){
            if(indg[i] == 0){
                q.add(i); // add if not dependent on any a 
            }
        }
        int res = 0 ;

        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            res++ ;
            for(int neg : adj.get(node)){
                indg[neg]-- ; // remove dependency from neg
                if(indg[neg] == 0){
                    q.add(neg);
                }
            }
        }
        return res == n ; // all vis then return no cycle 
    }
}
