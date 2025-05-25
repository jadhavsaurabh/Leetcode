class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();

        for(int i = 0; i < t.length(); i++) {
            Character ichar = t.charAt(i);
            tmap.put(ichar, tmap.getOrDefault(ichar, 0) + 1);
        }
        
        int l = 0;
        int minLength = Integer.MAX_VALUE;
        int minl = 0;
        int minr = 0;

        for(int r = 0; r < s.length(); r++) {
            smap.put(s.charAt(r), smap.getOrDefault(s.charAt(r), 0) + 1);
            
            while(containsAll(smap, tmap) && l <= r) {
                Character lchar = s.charAt(l);
                if(minLength > (r - l + 1)) {
                    minLength = (r - l + 1);
                    minl = l;
                    minr = r;
                }
                if(smap.get(lchar) > 1) {
                    smap.put(lchar, smap.get(lchar) - 1);
                } else {
                    smap.remove(lchar);
                }
                l++;
            }
        }
        
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minl, minr + 1);
    }

    private boolean containsAll(HashMap<Character, Integer> smap, HashMap<Character, Integer> tmap) {
        for(char c : tmap.keySet()) {
            if(!smap.containsKey(c) || smap.get(c) < tmap.get(c)) {
                return false;
            }
        }
        return true;
    }
}
