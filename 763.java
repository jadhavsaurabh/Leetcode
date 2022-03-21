class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> charind = new HashMap<>();
        
        for(int i=0;i<s.length();i++) {
            Character ch = s.charAt(i);
            charind.put(ch, i);
        }
        //System.out.println(charind);
        int max = 0;
        int prev = -1;
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i=0;i<s.length();i++) {
            Character ch = s.charAt(i);
            max = Math.max(max, charind.get(ch));
            
            if(max == i) {
                res.add(max - prev);
                prev = max;
            }
        }
        return res;
    }
}
