class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int i=0;
        if(n%2 != 0) {
            res[0] = 0;
            i = 1;
        }
        int num = 1;
        while(i+1 < n) {
            res[i++] = num;
            res[i++] = -num;
            num++;
        }
        
        return res;
    }
}
