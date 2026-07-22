class Solution {
    public void solve(int[] cnd , int tar , int i ,List<List<Integer>> ans,List<Integer> out ){
        if(tar == 0){
            ans.add(new ArrayList<>(out)); // we got one set
            return ;
        }
        if(i >= cnd.length || tar < 0){ 
            return ;
        }
        //include
        out.add(cnd[i]);
        solve(cnd,tar-cnd[i],i,ans,out); // as same elem can be used multiple time

        out.remove(out.size() - 1) ; // backtracking
        // must remove from output before calling exclude otherwise out will have val .
        // exclude 
        solve(cnd,tar,i+1,ans,out); 
    }
    public List<List<Integer>> combinationSum(int[] cnd, int tar) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        int idx = 0;

        solve(cnd,tar,idx,ans,out) ;
        return ans ;
    }
}
