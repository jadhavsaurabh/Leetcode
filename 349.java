class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> st = new HashSet<>();

        for (int j : nums1) {
            st.add(j);
        }
        Set<Integer> res = new HashSet<>();
        for (int j : nums2) {
            if (st.contains(j)) {
                res.add(j);
            }
        }
        
        int[] result = new int[res.size()];
        int i = 0;
        for(int a: res) {
            result[i++] = a;
        }
        
        return result;
    }
}
