class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length == 0) {
            return res;
        }
        int prev = nums[0];
        if(nums.length == 1) res.add(String.valueOf(prev));

        for(int i=1;i< nums.length;i++) {
            if(nums[i] != nums[i-1] + 1) {
                if(prev == nums[i-1]) {
                    res.add(String.valueOf(prev));
                } else {
                    res.add(prev + "->" + nums[i-1]);    
                }
                
                prev = nums[i];
                if(i== nums.length - 1) {
                    res.add(String.valueOf(nums[i]));
                }
            } else {
                if(i== nums.length - 1) {
                    res.add(prev + "->" + nums[i]);
                }    
            }
        }

        return res;
    }
}
