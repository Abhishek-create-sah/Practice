class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int mx = 0 ;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int r = 0 , l = 0 ; r < n ; r++){
            char k = s.charAt(r);
            if(hm.containsKey(k)){
                l = Math.max(hm.get(k),l);
            }
            mx = Math.max(mx , r-l+1);
            hm.put(k,r+1);
        }
        return mx ;
    }
}
