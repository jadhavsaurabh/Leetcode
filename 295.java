class MedianFinder {
    PriorityQueue<Integer> minPQ; // second half
    PriorityQueue<Integer> maxPQ; // 1st half

    public MedianFinder() {
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>(1, (a,b) -> b-a);
    }

    public void addNum(int num) {
        if(minPQ.isEmpty()) {
            minPQ.add(num);
            return;
        }

        if(num > minPQ.peek()) {
            minPQ.add(num);
        } else {
            maxPQ.add(num);
        }
        
        if(minPQ.size() - maxPQ.size() >= 2) {
            while(minPQ.size() - maxPQ.size() >= 1) {
                maxPQ.add(minPQ.poll());
            }
            return;
        }
        if(maxPQ.size() - minPQ.size() >= 2) {
            while(maxPQ.size() - minPQ.size() >= 1) {
                minPQ.add(maxPQ.poll());
            }
        }
    }

    public double findMedian() {
        if(maxPQ.isEmpty() && minPQ.isEmpty()) return 0;
        if(maxPQ.isEmpty()) return minPQ.peek();
        if(minPQ.isEmpty()) return maxPQ.peek();

        if(minPQ.size() == maxPQ.size()) return (double) (minPQ.peek() + maxPQ.peek()) /2;
        if(minPQ.size() > maxPQ.size()) return minPQ.peek();
        else return maxPQ.peek();
    }
}
