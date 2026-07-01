class Solution {

    public boolean allAvailable(int[] freqarr) {
        for(int freq: freqarr) {
            if(freq == 0) {
                return false;
            }
        }
        return true;
    }
    
    public int numberOfSubstrings(String s) {
        int l = 0;
        int r = 0;
        int[] freq = new int[3];
        int res = 0;
        int len = s.length();
        while(r <= len) {
            if(allAvailable(freq)) {
                freq[s.charAt(l) - 97]--;
                res += (len - r + 1);
                l++;
            } else {
                if(r == len) break;

                freq[s.charAt(r) - 97]++;
                r++;
            }
        }
    
        return res;
    }
}
