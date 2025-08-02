import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build prerequisite map
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            preMap.get(pair[0]).add(pair[1]);
        }

        Set<Integer> visitSet = new HashSet<>();  // Courses in the current DFS path

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, preMap, visitSet)) return false;
        }

        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> preMap, Set<Integer> visitSet) {
        if (visitSet.contains(course)) return false; // cycle detected
        if (preMap.get(course).isEmpty()) return true; // already processed

        visitSet.add(course);
        for (int pre : preMap.get(course)) {
            if (!dfs(pre, preMap, visitSet)) return false;
        }
        visitSet.remove(course);

        // Memoize this course as completed by clearing its prereqs
        preMap.get(course).clear();

        return true;
    }
}
