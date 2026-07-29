/*
  think of 0001, 0010 as adjecent nodes to 0000 & run bfs on such graph.
  if u reach target then mark min
*/
class Data {
    int level;
    String str;

    Data(int lvl, String s) {
        level = lvl;
        str = s;
    }
}

class Solution {
    public static String[] generateCombinations(String input) {
        int n = input.length();
        String[] result = new String[n * 2];
        int idx = 0;

        char[] digits = input.toCharArray();

        for (int i = 0; i < n; i++) {
            char original = digits[i];

            // Increment
            digits[i] = (char) ('0' + ((original - '0' + 1) % 10));
            result[idx++] = new String(digits);

            // Decrement
            digits[i] = (char) ('0' + ((original - '0' + 9) % 10));
            result[idx++] = new String(digits);

            // Restore
            digits[i] = original;
        }

        return result;
    }

    public int openLock(String[] deadends, String target) {
        
        HashSet<String> ends = new HashSet<>();
        Collections.addAll(ends, deadends);
        if(ends.contains("0000")) return -1;
        int min = Integer.MAX_VALUE;
        HashSet<String> visited = new HashSet<>();
        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(0, "0000"));
        visited.add("0000");

        while(!queue.isEmpty()) {
            Data popped = queue.poll();

            if(Objects.equals(popped.str, target)) {
                return popped.level;
            }

            // Add all combinations with level
            for(String combination: generateCombinations(popped.str)) {
                if(!ends.contains(combination) && !visited.contains(combination)) {
                    visited.add(combination);
                    queue.add(new Data(popped.level + 1, combination));
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
