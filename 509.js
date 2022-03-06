class Solution {
    public int fib(int n) {
        int[] arr = new int[31];
        arr[0] = 0;
        arr[1] = 1;
        if(n==0) {
            return 0;
        }
        if(n==1) {
            return 1;
        }
        int res = 0;
        for(int i=2;i<=n;i++) {
            arr[i] = arr[i-1] + arr[i-2];
            if(i == n) {
                res = arr[i];
            }
        }
        return res;
    }
}
