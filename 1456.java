class Solution {
    public static boolean isVowel(Character ch) {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }
    public int maxVowels(String s, int k) {
        int max = 0;
        int vowels = 0;

        for(int i=0;i<k;i++) {
            Character ch = s.charAt(i);
            if(isVowel(ch)) vowels++;
        }
        max = vowels;

        for(int i=1;i<=s.length() - k;i++) {
            if(isVowel(s.charAt(i-1))) {
                vowels--;
            }
            if(isVowel(s.charAt(i+k-1))) {
                vowels++;
            }
            
            if(vowels > max) {
                max = vowels;
            }
        }
        return max;
    }
}
