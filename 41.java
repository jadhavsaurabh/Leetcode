class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int num: nums) {
            set.add(num);
        }
        
        int check = 1;
        while(set.contains(check)) {
            check++;
        }
        
        return check;
    }
}
