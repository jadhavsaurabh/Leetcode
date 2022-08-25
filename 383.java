class Solution {
    public boolean canConstruct(String rs, String ms) {
        int[] rc = new int[26];
        int[] mc = new int[26];
        
        for(int i=0;i<rs.length();i++) {
            rc[(int)rs.charAt(i) - 97]++;
        }
        for(int i=0;i<ms.length();i++) {
            mc[(int)ms.charAt(i) - 97]++;
        }
        
        for(int i=0;i<26;i++) {
            if(rc[i] > mc[i]) {
                return false;
            }
        }
        return true;
    }
}
