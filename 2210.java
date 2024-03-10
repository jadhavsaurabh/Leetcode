class Solution {
     public int countHillValley(int[] nums) {
        ArrayList<Integer> ls = new ArrayList<>();
        int prev = nums[0];
        ls.add(prev);
        for(int i=1;i<nums.length;i++) {
            if(nums[i] == prev) {
                continue;
            }
            ls.add(nums[i]);
            prev = nums[i];
        }

        System.out.println(ls);
        int i = 1;
        int res = 0;
        while (i < ls.size() - 1) {
            if((ls.get(i-1) > ls.get(i) && ls.get(i) < ls.get(i+1)) || (ls.get(i-1) < ls.get(i) && ls.get(i) > ls.get(i+1))) {
                res++;
            }
            i++;
        }
        
        return res;
    }
}




Alternate:

class Solution {
     public int countHillValley(int[] a) {
        int r = 0, left = a[0];
        for(int i = 1; i < a.length - 1; i++)
            if(left < a[i] && a[i] > a[i + 1] || left > a[i] && a[i] < a[i + 1]){
                r++;
                left = a[i];
            }
        return r;
    }
}
