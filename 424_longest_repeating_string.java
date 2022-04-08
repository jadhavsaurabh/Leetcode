/*
have two pts l & r
withing range of l to r if length of window - mostoccured char > k then window is invalid ie we need more than k chars to make that window substring
if window invalid increment the l ptr & reduce the freq of char at l
*/
class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int mostfreq = 0;
        int l = 0;
        int max = 0;
        for(int r=0;r<s.length();r++) {
            freq[s.charAt(r) - 'A']++;
            mostfreq = Math.max(mostfreq, freq[s.charAt(r) - 'A']);
            
            if(r - l + 1 - mostfreq > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            
            max = Math.max(max, r-l+1);
        }
        return max;
    }
}
