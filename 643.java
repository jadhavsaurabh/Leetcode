class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i=0;i<k;i++) {
            sum += nums[i];
        }
        double max = (double) sum/k;
        
        for(int i=1;i<=nums.length - k;i++) {
            sum = sum - nums[i-1] + nums[i+k-1];
            System.out.println(sum);
            double avg = (double) sum/k;
            if(avg > max) {
                max = avg;
            }
        }
        return max;
    }
}
