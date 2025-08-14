import java.util.*;

class Solution {
    public int numDecodings(String s) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 1); // base case

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp.put(i, 0);
            } else {
                dp.put(i, dp.get(i + 1));
            }

            if (i + 1 < s.length() &&
               (s.charAt(i) == '1' ||
               (s.charAt(i) == '2' && "0123456".indexOf(s.charAt(i + 1)) != -1))) {
                dp.put(i, dp.get(i) + dp.getOrDefault(i + 2, 0));
            }
        }

        return dp.get(0);
    }
}
