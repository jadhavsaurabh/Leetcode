/*
Similar to 3 sum
if you find matching sum instead of skipping duplicate nums
count them from start & end
and cound the combinations they can generate
*/
class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        long res = 0;
        for(int i=0;i<arr.length - 2;i++) {
            int l = i+1;
            int r = arr.length - 1;
            while(l<r) {
                int sum = arr[l] + arr[r] + arr[i];
                if(sum > target) {
                    r--;
                } else if(sum < target) {
                    l++;
                } else {
                    int le = 1, re = 1;
                    while (l + le < r && arr[l + le] == arr[l]) {
                        le++;
                    }
                    while (l + le <= r - re && arr[r - re] == arr[r]) {
                        re++;
                    }
                  
                    res += (arr[l] == arr[r]) ? (r - l + 1) * (r - l) / 2 : (le * re) ;
                    l += le;
                    r -= re;
                }
            }
        }
        return (int)(res % 1_000_000_007);
    }
}
