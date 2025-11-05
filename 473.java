import java.util.*;

class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) return false;

        int sum = 0;
        for (int stick : matchsticks) sum += stick;
        if (sum % 4 != 0) return false; 

        int target = sum / 4;

        
        Integer[] sticks = Arrays.stream(matchsticks).boxed().toArray(Integer[]::new);
        Arrays.sort(sticks, (a, b) -> b - a);

        int[] sides = new int[4];
        return backtrack(0, sticks, sides, target);
    }

    private boolean backtrack(int idx, Integer[] sticks, int[] sides, int target) {
        if (idx == sticks.length) {
            return sides[0] == target && sides[1] == target &&
                   sides[2] == target && sides[3] == target;
        }

        for (int i = 0; i < 4; i++) {
            if (sides[i] + sticks[idx] > target) continue;  // prune
            sides[i] += sticks[idx];
            if (backtrack(idx + 1, sticks, sides, target)) return true;
            sides[i] -= sticks[idx];
        }
        return false;
    }
}
