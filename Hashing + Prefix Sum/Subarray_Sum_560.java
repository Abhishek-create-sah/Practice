class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        int cur = 0 ;
        int res = 0 ;

        for(int num : nums){
            cur += num ;
            if(hm.containsKey(cur-k)){
                res += hm.get(cur-k);
            }
            hm.put(cur,hm.getOrDefault(cur,0)+1);
        }
        return res  ;
    }
}
