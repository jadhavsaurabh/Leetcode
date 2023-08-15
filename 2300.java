import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            int start = 0;
            int end = potions.length - 1;

            int count = 0;
            while (start <= end) {
                int mid = (start + end) / 2;
                long product = (long)potions[mid] * (long)spells[i];
                if (product >= success) {
                    count = potions.length - mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            result[i] = count;
        }

        return result;
    }
}
