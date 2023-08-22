class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    int lastPopped;
    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        lastPopped = 1;
    }

    public int popSmallest() {
        if(pq.isEmpty()) {
            return lastPopped++;
        }
        return pq.poll();
    }

    public void addBack(int num) {
        if(num >= lastPopped || pq.contains(num)) {
            return;
        }
        pq.add(num);
    }
}
