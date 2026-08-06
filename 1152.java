import java.util.*;

class Solution {

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

        // Step 1: Sort visits by timestamp
        List<Visit> visits = new ArrayList<>();
        for (int i = 0; i < username.length; i++) {
            visits.add(new Visit(timestamp[i], username[i], website[i]));
        }

        visits.sort(Comparator.comparingInt(v -> v.time));

        // Step 2: Build user -> ordered websites map
        Map<String, List<String>> userVisits = new HashMap<>();

        for (Visit visit : visits) {
            userVisits
                .computeIfAbsent(visit.user, k -> new ArrayList<>())
                .add(visit.website);
        }

        // Step 3: Count unique 3-sequences per user
        Map<String, Integer> scores = new HashMap<>();

        for (List<String> websitesList : userVisits.values()) {

            Set<String> seen = new HashSet<>();

            int n = websitesList.size();

            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {

                        String pattern = websitesList.get(i) + "," +
                                         websitesList.get(j) + "," +
                                         websitesList.get(k);

                        if (seen.add(pattern)) {
                            scores.put(pattern, scores.getOrDefault(pattern, 0) + 1);
                        }
                    }
                }
            }
        }

        // Step 4: Find best pattern
        String bestPattern = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            String pattern = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount ||
               (count == maxCount && pattern.compareTo(bestPattern) < 0)) {

                maxCount = count;
                bestPattern = pattern;
            }
        }

        return Arrays.asList(bestPattern.split(","));
    }

    static class Visit {
        int time;
        String user;
        String website;

        Visit(int time, String user, String website) {
            this.time = time;
            this.user = user;
            this.website = website;
        }
    }
}
