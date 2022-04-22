class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        
        for(int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        
        int res = -1;
        for(Map.Entry entry: mp.entrySet()) {
            if((int)entry.getValue() == 1) {
                res = (int)entry.getKey();
            }
        }
        return res;
    }
}
