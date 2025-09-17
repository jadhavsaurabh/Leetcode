class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1p = 0;
        int n2p = 0;

        int[] merged = new int[nums1.length + nums2.length];
        int mp = 0;
        while(n1p < nums1.length || n2p < nums2.length) {
            if(n1p >= nums1.length) {
                while(n2p < nums2.length) {
                    merged[mp++] = nums2[n2p++];
                }
                break;
            }
            if(n2p >= nums2.length) {
                while(n1p < nums1.length) {
                    merged[mp++] = nums1[n1p++];
                }
                break;
            }

            if(nums1[n1p] < nums2[n2p]) {
                merged[mp++] = nums1[n1p++];
            } else {
                merged[mp++] = nums2[n2p++];
            }
        }


        if(merged.length % 2 == 0) {
            return (double) (merged[(merged.length - 1) / 2] + merged[((merged.length - 1) / 2) + 1 ]) / 2;
        } else {
            return merged[merged.length / 2];   
        }
    }
}
