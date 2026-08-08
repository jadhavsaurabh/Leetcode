import java.util.HashMap;
import java.util.Map;

class Solution {
    public int size(int[] chararr) {
        int c = 0;
        for (int i = 0; i < 26; i++) {
            if (chararr[i] > 0) c++;
        }
        return c;
    }
    
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int[] charfreq = new int[26];
        int l = 0;
        int r = 0;
        int length = s.length();

        Map<String, Integer> freq = new HashMap<>();
        int max = 0;

        while (r < length || (r - l) >= minSize) {
            if (minSize > (r - l)) {
                char ch = s.charAt(r);
                charfreq[ch - 97]++;
                r++;
                continue;
            }

            if ((maxSize < (r - l)) || size(charfreq) > maxLetters) {
                char ch = s.charAt(l);
                charfreq[ch - 97]--;
                l++;
                continue;
            }
            
            String sub = s.substring(l, r);
            int curr = freq.getOrDefault(sub, 0);
            if (max < curr + 1) {
                max = curr + 1;
            }
            freq.put(sub, curr + 1);

            char ch = s.charAt(l);
            charfreq[ch - 97]--;
            l++;
        }

        return max;
    }
}
