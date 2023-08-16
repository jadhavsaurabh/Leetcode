class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] res = new int[text1.length() + 1][text2.length() + 1];

        for(int i=text1.length() - 1;i>= 0;i--) {
            for(int j = text2.length() - 1;j>=0;j--) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    res[i][j] = 1 + res[i + 1][j+1];
                } else {
                    res[i][j] = Math.max(res[i + 1][j], res[i][j+1]);
                }
            }
        }
        
        return res[0][0];
    }
}
