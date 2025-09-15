class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int res = 0;
        boolean[] broken = new boolean[26];
        for(int i=0;i<brokenLetters.length();i++) {
            char c = brokenLetters.charAt(i);
            broken[c - 97] = true;
        }

        String[] splitted = text.split(" ");
        for(String word: splitted) {
            boolean flag = true;
            for(int i=0;i<word.length();i++) {
                char c = word.charAt(i);
                if(broken[c-97]) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) res++;
        }
        return res;
    }
}
