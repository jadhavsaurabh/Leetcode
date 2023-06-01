// Use two pointers
// one at the end one at the starting
// if target is < leftnum + rightNum right--
// else left++
class Solution {
    public int[] twoSum(int[] num, int target) {
        int[] res = new int[2];

        int l = 0;
        int r = num.length - 1;
        while(l<r) {
            if(target == (num[l] + num[r])) {
                res[0] = l + 1;
                res[1] = r + 1;
                break;
            } else if(target < (num[l] + num[r])) {
                r--;
            } else {
                l++;
            }
        }
        return res;
    }
}
