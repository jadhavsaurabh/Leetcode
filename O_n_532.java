class Solution {
    public int findPairs(int[] nums, int k) {
        
        var map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            map.put(num, (int)map.getOrDefault(num, 0) + 1);
        }
        
        for (var mapkeyval : map.entrySet()) {
            if (k == 0) {
                if ((int)mapkeyval.getValue() >= 2) {
                    count++;
                } 
            } else {
                if (map.containsKey((int)mapkeyval.getKey() + k)) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
