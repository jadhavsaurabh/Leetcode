class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        Map<Character, Integer> mp = new HashMap<>();
        Map<Character, Integer> mp2 = new HashMap<>();

        for(int i=0;i<word1.length();i++) {
            char c = word1.charAt(i);
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }
        for(int i=0;i<word2.length();i++) {
            char c = word2.charAt(i);
            mp2.put(c, mp2.getOrDefault(c, 0) + 1);
        }

        if(!mp.keySet().equals(mp2.keySet())) {
            return false;
        }
        ArrayList<Integer> ar1 = new ArrayList<>();
        for(var entry: mp.entrySet()) {
            ar1.add(entry.getValue());
        }
        ArrayList<Integer> ar2 = new ArrayList<>();
        for(var entry: mp2.entrySet()) {
            ar2.add(entry.getValue());
        }

        Collections.sort(ar1);
        Collections.sort(ar2);
        return ar1.equals(ar2);
    }
}
