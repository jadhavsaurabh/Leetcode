/*
Sliding window
*/
class Solution {
  public int[] getAverages(int[] nums, int k) {
    int n = nums.length, divider = 2 * k + 1, ans[] = new int[n];
    var sum = 0L;

    Arrays.fill(ans, -1);
    if (divider > n) return ans;

    for (var i = 0; i < divider; i++)
      sum += nums[i];

    ans[k] = (int) (sum / divider);
    for (var i = k+1; i < n-k; i++) {
      sum += nums[i+k] - nums[i-k-1];
      ans[i] = (int) (sum / divider);
    }
    return ans;
  }
}
