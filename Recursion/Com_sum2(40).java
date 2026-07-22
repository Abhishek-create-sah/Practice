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
        solve(cnd,tar-cnd[i],i+1,ans,out);// one ele at a time

        out.remove(out.size() - 1) ; // backtracking
        // must remove from output before calling exclude otherwise out will have val .
       
        // To have only unique
        while(i+1 < cnd.length && cnd[i] == cnd[i+1] ){
            i++;  // if there are duplicate skip them
        }
        // exclude 
        solve(cnd,tar,i+1,ans,out); 
    }
    public List<List<Integer>> combinationSum2(int[] cnd, int tar) {
        Arrays.sort(cnd); // so that duplicate come together
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        int idx = 0;

        solve(cnd,tar,idx,ans,out) ;
        return ans ;
    }
}
