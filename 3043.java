class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> st = new HashSet<>();
        for (int j : arr1) {
            int num = j;
            while (num != 0) {
                st.add(num);
                num = num / 10;
            }
        }
        int res = 0;
        for (int j : arr2) {
            int num = j;
            while (num != 0) {
                if (st.contains(num)) {
                    res = Math.max(res, num);
                }
                num = num / 10;
            }
        }
        
        int len = 0;
        while(res != 0) {
            len++;
            res = res/10;
        }
        return len;
    }
}
