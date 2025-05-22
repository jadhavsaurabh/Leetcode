class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for(int i=0;i<numbers.length-1;i++) {

            int idx = search(numbers, i+1, target - numbers[i]);
            if(idx != -1) {
                res[0] = i + 1;
                res[1] = idx + 1;
                break;
            }
        }

        return res;
    }

    public int search(int[] numbers, int l, int key) {
        int r = numbers.length-1;

        while(l<=r) {
            int mid = (l+r)/2;

            if(numbers[mid] == key) return mid;
            else if(numbers[mid] < key) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }
}
