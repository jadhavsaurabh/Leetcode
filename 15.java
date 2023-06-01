// Sort & divide problem in n - two sum problems
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();

        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++) {
            // skip if prev & current nums[i] is same
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int l = i + 1;
            int r = nums.length - 1;

            while(l<r) {
                int sum = nums[i] + nums[l] + nums[r];

                if(sum > 0) {
                    r--;
                } else if(sum < 0) {
                    l++;
                } else {
                    result.add(new ArrayList(Arrays.asList(nums[i], nums[l], nums[r])));
                    l++;
                    // skip
                    while(l<r && nums[l] == nums[l-1]) {
                        l++;
                    }
                }
            } 
        }  

        return result;      
    }
}
