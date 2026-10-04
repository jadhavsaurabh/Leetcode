/*
  https://algomaster.io/learn/dsa/design-hit-counter
*/


import java.util.ArrayDeque;
import java.util.Deque;

class HitCounter {
    private final Deque<Integer> hits;

    public HitCounter() {
        hits = new ArrayDeque<>();
    }

    public void hit(int timestamp) {
        removeExpired(timestamp);
        hits.offerLast(timestamp);
    }

    public int getHits(int timestamp) {
        removeExpired(timestamp);
        return hits.size();
    }

    private void removeExpired(int timestamp) {
        while (!hits.isEmpty()
                && timestamp - hits.peekFirst() >= 300) {
            hits.pollFirst();
        }
    }
}
