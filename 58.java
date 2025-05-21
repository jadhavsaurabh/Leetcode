class Solution {
    public int lengthOfLastWord(String s) {
        String trimmedS = s.trim();

        String[] strings = trimmedS.split(" ");
        return strings[strings.length - 1].length();
    }
}
