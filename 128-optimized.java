class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> main = new HashSet<>();
        
        for(int i=0;i<nums.length;i++) {
            main.add(nums[i]);
        }
        int max = 0;
        for (Integer n : main) {
            if(!main.contains(n - 1)) {
                int temp = n;
                int count = 1;
                while(main.contains(temp + 1)) {
                    count++;
                    temp++;
                }
                
                max = count > max ? count : max;
            }            
        }
        return max;
    }
}
