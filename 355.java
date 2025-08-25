import java.util.*;

class Twitter {

    private static int timeStamp = 0;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<int[]>> tweetMap;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    // Post a tweet
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{timeStamp++, tweetId});
    }

    // Get the 10 most recent tweets
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> b[0] - a[0]   // Max heap by timestamp
        );

        // Add self follow
        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        // Collect tweets from followees
        for (int followeeId : followMap.get(userId)) {
            if (tweetMap.containsKey(followeeId)) {
                List<int[]> tweets = tweetMap.get(followeeId);
                for (int i = 0; i < tweets.size(); i++) {
                    minHeap.add(new int[]{tweets.get(i)[0], tweets.get(i)[1]});
                }
            }
        }

        // Take 10 most recent tweets
        int count = 0;
        while (!minHeap.isEmpty() && count < 10) {
            res.add(minHeap.poll()[1]);
            count++;
        }

        return res;
    }

    // Follow
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    // Unfollow
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
