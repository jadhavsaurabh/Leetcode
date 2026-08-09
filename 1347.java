class Solution {
    public int minSteps(String s, String t) {
        int[] sfreq = new int[26];
        int[] tfreq = new int[26];

        for(int i=0;i<s.length();i++) {
            sfreq[s.charAt(i) - 97]++;
            tfreq[t.charAt(i) - 97]++;
        }
        int ans = 0;
        
        for(int i=0;i<26;i++) {
            if(sfreq[i] > tfreq[i]) {
                ans += (sfreq[i] - tfreq[i]);
            }
        }
        return ans;
    }
}
