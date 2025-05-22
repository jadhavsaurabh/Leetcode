class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        Map<Character, Integer> mp = new HashMap<>();
        mp.put('I', 1);
        mp.put('V', 5);
        mp.put('X', 10);
        mp.put('L', 50);
        mp.put('C', 100);
        mp.put('D', 500);
        mp.put('M', 1000);
        
        int i = s.length() - 1;
        while(i >= 0) {
            if(i > 0 && mp.get(s.charAt(i)) > mp.get(s.charAt(i-1))) {
                sum += (mp.get(s.charAt(i)) - mp.get(s.charAt(i-1)));
                i = i - 2;
            } else {
                sum += mp.get(s.charAt(i));
                i--;
            }
        }
        return sum;
    }
}
