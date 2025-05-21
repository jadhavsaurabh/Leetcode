class Solution {
    public int lengthOfLastWord(String s) {
        String trimmedS = s.trim();

        String[] strings = trimmedS.split(" ");
        return strings[strings.length - 1].length();
    }
}

// Optimized
class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;

        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count the length of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}
