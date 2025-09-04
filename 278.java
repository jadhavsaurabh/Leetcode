/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 0;
        int last = n;
        int res = -1;

        while(start <= last) {
            int mid = start + (last - start) / 2;
            boolean isBad = isBadVersion(mid);
            if(!isBad) {
                start = mid + 1;
            } else {
                last = mid - 1;
                res = mid;
            }
        }

        return res;
    }
}
