class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        int result = 0;

        for(int i=0;i<nums.length;i++) {
            sum = (nums[i] == 1) ? sum + 1 : sum - 1;
            if(sum == 0) {
                result = ((i+1) > result) ? (i+1) : result;
            } else if(map.containsKey(sum)) {
                int diff = i - map.get(sum);
                result = (result > diff) ? result : diff;
            } else {
                map.put(sum, i);
            }
            
        }
        return result;
    }
}
