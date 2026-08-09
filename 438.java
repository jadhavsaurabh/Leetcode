class Solution {
    public boolean isEqual(int[] sfreq, int[] pfreq) {
        for(int i=0;i<26;i++) {
            if(sfreq[i] != pfreq[i]) return false;
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length() > s.length()) return res;
        int[] sfreq = new int[26];
        int[] pfreq = new int[26];

        for(char ch: p.toCharArray()) {
            pfreq[ch - 97]++;
        }

        int len = p.length();
        //first window
        for(int i=0;i<len;i++) {
            sfreq[s.charAt(i) - 97]++;
        }

        
        if(isEqual(sfreq, pfreq)) {
            res.add(0);
        }

        for(int i=len;i<s.length();i++) {
            sfreq[s.charAt(i-len) - 97]--;
            sfreq[s.charAt(i) - 97]++;

            if(isEqual(sfreq, pfreq)) {
                res.add(i- len + 1);
            }
        }
        return res;
    }
}
