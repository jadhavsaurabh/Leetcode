import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] frequency = new int[10];
        for (int digit : digits) {
            frequency[digit]++;
        }
        
        List<Integer> validNumbers = new ArrayList<>();
        
        for (int i = 100; i <= 998; i += 2) {
            int hundredth = i / 100;
            int tenth = (i / 10) % 10;
            int unit = i % 10;
            
            frequency[hundredth]--;
            frequency[tenth]--;
            frequency[unit]--;
            
            if (frequency[hundredth] >= 0 && frequency[tenth] >= 0 && frequency[unit] >= 0) {
                validNumbers.add(i);
            }
            
            frequency[hundredth]++;
            frequency[tenth]++;
            frequency[unit]++;
        }
        
        int[] result = new int[validNumbers.size()];
        for (int j = 0; j < validNumbers.size(); j++) {
            result[j] = validNumbers.get(j);
        }
        
        return result;
    }
}
