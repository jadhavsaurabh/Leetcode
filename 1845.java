class SeatManager {
    // seat array
    // initialized to 0
    // [1,2,3,4]
    PriorityQueue<Integer> pQueue;

    public SeatManager(int n) {
        this.pQueue = new PriorityQueue<Integer>();
        for(int i=1;i<=n;i++) {
            this.pQueue.add(i);
        }
        System.out.println(this.pQueue);
    }
    
    public int reserve() {
        int seatNo = (int)this.pQueue.poll();
        return seatNo;
    }
    
    public void unreserve(int seatNumber) {
        this.pQueue.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
