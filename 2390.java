class Solution {
    public String removeStars(String s) {
        Stack<Character> ch = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(c == '*') {
                ch.pop();
            } else {
                ch.push(c);
            }
        }
        
        StringBuilder str = new StringBuilder();
        while(!ch.isEmpty()) {
            char c = ch.pop();
            str.append(c);
        }

        return str.reverse().toString();
    }
}
