class Solution {
    //prim's Algorithm
    public int minCostConnectPoints(int[][] points) {
        int n = points.length ;
        boolean[] vis = new boolean[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));

        pq.add(new int[]{0,0}); // mh_dist = 0 to reach 0

        int tt = 0; // total cost
        int ct = 0 ; // total edges

        while(ct < n ){ // until we cover all the edges
            int[] cur = pq.poll();
            int wt = cur[0]; // cost
            int u = cur[1]; // to reach u

            if(vis[u]){ // if already vist skipp
                continue ;
            }

            vis[u] = true ; // mark visted
            tt += wt ; // add to total cost
            ct++; // edge cnt++

            for(int v = 0 ; v < n ; v++){
                if(!vis[v]){ // check
                    int dist = Math.abs(points[u][0] - points[v][0]) +
                               Math.abs(points[u][1] - points[v][1]);  // mh dist

                    pq.add(new int[] {dist , v}); // add cost to reach v
                }
            }
        }
        return tt ; // total cost to cover all edges
    }
}
