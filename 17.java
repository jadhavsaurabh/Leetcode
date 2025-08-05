import java.util.*;

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            return res;
        }

        Map<Character, String> dictionary = new HashMap<>();
        dictionary.put('2', "abc");
        dictionary.put('3', "def");
        dictionary.put('4', "ghi");
        dictionary.put('5', "jkl");
        dictionary.put('6', "mno");
        dictionary.put('7', "pqrs");
        dictionary.put('8', "tuv");
        dictionary.put('9', "wxyz");

        recursive(digits, 0, new StringBuilder(), dictionary, res);
        return res;
    }

    private void recursive(String digits, int depth, StringBuilder current, Map<Character, String> dictionary, List<String> res) {
        if (depth == digits.length()) {
            res.add(current.toString());
            return;
        }

        String letters = dictionary.get(digits.charAt(depth));
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));
            recursive(digits, depth + 1, current, dictionary, res);
            current.deleteCharAt(current.length() - 1);  // Backtrack
        }
    }
}
