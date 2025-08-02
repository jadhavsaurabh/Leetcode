import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            preMap.get(pair[0]).add(pair[1]);
        }

        Set<Integer> visitSet = new HashSet<>();
        Set<Integer> completed = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, preMap, visitSet, completed, result)) return new int[0];
        }

        // Convert to array
        return result.stream().mapToInt(i -> i).toArray();
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> preMap, Set<Integer> visitSet, Set<Integer> completed, List<Integer> result) {
        if (visitSet.contains(course)) return false; // cycle detected
        if (completed.contains(course)) return true; // already added to result

        visitSet.add(course);
        for (int pre : preMap.get(course)) {
            if (!dfs(pre, preMap, visitSet, completed, result)) return false;
        }
        visitSet.remove(course);

        // Add to result and mark as completed
        result.add(course);
        completed.add(course);

        return true;
    }
}
