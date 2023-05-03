class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet();
        Set<Integer> set2 = new HashSet();

        for(int i = 0;i<nums1.length;i++) {
            set1.add(nums1[i]);
        }
        for(int i = 0;i<nums2.length;i++) {
            set2.add(nums2[i]);
        }
        
        List<Integer> aList = new ArrayList<>();
        Set<Integer> copySet = new HashSet(set1);
        copySet.removeAll(set2);
        aList.addAll(copySet);
        List<Integer> bList = new ArrayList<>();
        set2.removeAll(set1);
        bList.addAll(set2);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(aList);
        result.add(bList);

        return result;
    }
}
