class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];

        dp[s.length()] = true;
        for(int i =s.length() - 1;i>=0;i--) {
            String subWord = s.substring(i,s.length());

            for(String word: wordDict) {
                if(i + word.length() <= s.length() && subWord.startsWith(word)) {
                    dp[i] = dp[i+word.length()];
                }
                
                if(dp[i]) break;
            }
        }

        return dp[0];
    }
}
