class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        if(k==0) return false;
        int i = 0;
        while(k-- >= 0 && i < nums.length) {
            if(set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i++]);
            }
        }

        for(int j = i;j<nums.length;j++) {
            set.remove(nums[j-i]);
            
            if(set.contains(nums[j])) {
                return true;
            } else {
                set.add(nums[j]);
            }
        }

        return false;
    }
}
