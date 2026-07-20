class Solution {

    public int[] findOrder(int n, int[][] prq) {
        // [a,b] => to complete "a" you need do "b" first
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indeg = new int[n];
        for (int p[] : prq) {
            adj.get(p[1]).add(p[0]);
            indeg[p[0]]++ ; // As to complete 'b' we need to complete 'a' , so we will cnt indegree of 0 .
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ;i < n ; i++){
            if(indeg[i] == 0){ // not dependent on anyone
                q.add(i);
            }
        }
        int res[] = new int[n];
        int idx = 0 ;

        while(!q.isEmpty()){
            int cur = q.poll();
            res[idx++] = cur ;
            for(int neg : adj.get(cur)){
                indeg[neg]-- ;
                if(indeg[neg] == 0){
                    q.add(neg);
                }
            }
        }
        return idx == n ? res : new int[0] ; 
    }

}
