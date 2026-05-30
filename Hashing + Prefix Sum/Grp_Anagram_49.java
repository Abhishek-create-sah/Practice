class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>() ;

        HashMap<String,List<String>> hm = new HashMap<>() ;

        for(String s : strs){
            int[] ct = new int[26];

            for(char c : s.toCharArray()){
                ct[c-'a']++ ;
            }
            String key = Arrays.toString(ct);
            if(!hm.containsKey(key)){
                hm.put(key,new ArrayList<>());
            }
            hm.get(key).add(s);
        }
        return new ArrayList(hm.values()) ;
    }
}