public int getCommon(int[] nums1, int[] nums2) {
        int n1p = 0;
        int n2p = 0;

        while(n1p < nums1.length && n2p < nums2.length) {
            if(n1p >= nums1.length || n2p > nums2.length) {
                return -1;
            }

            if(nums1[n1p] < nums2[n2p]) {
                n1p++;
            } else if(nums1[n1p] > nums2[n2p]) {
                n2p++;
            } else {
                return nums1[n1p];
            }
        }

        return -1;
    }
