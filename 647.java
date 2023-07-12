public class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = i - 1;
            int r = i + 1;
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                    count++;
                } else {
                    break;
                }
            }
        }
        
        for (int i = 0, j = 1; i < s.length() - 1 && j < s.length(); i++, j++) {
            int l = i;
            int r = j;
            
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                    count++;
                } else {
                    break;
                }
            }
        }
        
        return count + s.length();
    }
}
