/*
Problem:
For example:

If s = "a{b,c}", the first position must be 'a', but the second position can be either 'b' or 'c'. This produces the words ["ab", "ac"]
If s = "{a,b}c{d,e}", you can form: ["acd", "ace", "bcd", "bce"]
*/
void main() {
    Solution s = new Solution();
    System.out.println(s.braceExpansion("{a,b}{c,d}"));
}

class Solution {
    public void backtrack(String s, int idx, List<String> res, List<Character> charsSofar) {
        if(idx >= s.length()) {
            StringBuilder sb = new StringBuilder();

            for(Character ch: charsSofar) {
                sb.append(ch);
            }
            res.add(sb.toString());
            return;
        }

        if(s.charAt(idx) == '{') {
            List<Character> options = new ArrayList<>();

            while(true) {
                if(s.charAt(idx) == '}') {
                    break;
                } else if(s.charAt(idx) >= 'a' && s.charAt(idx) <= 'z') {
                    options.add(s.charAt(idx++));
                } else {
                    idx++;
                }
            }

            for(Character ch: options) {
                charsSofar.add(ch);
                backtrack(s, idx + 1, res, charsSofar);
                charsSofar.removeLast();
            }
        } else {
            charsSofar.add(s.charAt(idx));
            backtrack(s, idx + 1, res, charsSofar);
            charsSofar.removeLast();
        }
    }

    public List<String> braceExpansion(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, 0, res, new ArrayList<>());
        return res;
    }
}
