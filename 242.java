class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        
        for(int i=0;i<s.length();i++) {
            Character ch = s.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        for(int i=0;i<t.length();i++) {
            Character ch = t.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        return map1.equals(map2);
    }
}
