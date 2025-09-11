class Solution {

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c =='U';
    }

    public String sortVowels(String s) {
        int[] ch = new int[255];

        for(int i = 0;i<s.length();i++) {
            char c = s.charAt(i);
            if(isVowel(c)) {
                ch[c - 'A']++;
            }
        }

        int chP = 0;
        StringBuilder sb = new StringBuilder();

        for(int sP = 0;sP<s.length();sP++) {
            char c = s.charAt(sP);
            if(isVowel(c)) {
                while(chP < ch.length && ch[chP] == 0) {
                    chP++;
                }

                sb.append((char)(chP + 'A'));
                ch[chP]--;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
