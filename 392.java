class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0;
        int j=0;
        int count = 0;

        while(i<s.length()) {
            for(int k=j;k<t.length();k++) {
                if(s.charAt(i) == t.charAt(j)) {
                    count++;
                    j++;
                    break;
                }
                j++;
            }
            i++;
        }
        return count == s.length();
    }
}
