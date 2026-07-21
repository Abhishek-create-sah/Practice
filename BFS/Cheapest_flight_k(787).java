class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] f : flights){
            adj.get(f[0]).add(new int[] {f[1],f[2]}); // to reach f[1] cost f[2] from f[0]
        }

        int[] cost = new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src] = 0 ;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src,0}); // at cost 0 we reach src
        int stop = 0 ;

        while(!q.isEmpty() && stop <= k){
            int s = q.size();

            for(int i = 0 ; i < s ; i++){
                int[] cur = q.poll();
                int u = cur[0]; //src
                int cp = cur[1]; // to reach src cost

                for(int[] neg : adj.get(u)){
                    int v = neg[0]; // dest
                    int p = neg[1]; // to reach dest from src 

                    if(cp + p < cost[v]){ // total cost (cp + p) < alresdy set cost to reach v
                        cost[v] = cp + p;
                        q.add(new int[]{v,cost[v]}); // new dst and cost to reach it
                    }
                }
            }
            stop++;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}
