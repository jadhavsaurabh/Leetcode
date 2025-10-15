class MyCircularQueue {

    ArrayList<Integer> ls;
    int sz;
    public MyCircularQueue(int k) {
        ls = new ArrayList<>(k);
        sz = k;
    }

    public boolean enQueue(int value) {
        if(ls.size() >= sz) return false;
        ls.add(value);
        return true;
    }

    public boolean deQueue() {
        if(ls.isEmpty()) return false;
        ls.removeFirst();
        return true;
    }

    public int Front() {
        if(ls.isEmpty()) return -1;
        return ls.getFirst();
    }

    public int Rear() {
        if(ls.isEmpty()) return -1;
        return ls.getLast();
    }

    public boolean isEmpty() {
        return ls.isEmpty();
    }

    public boolean isFull() {
        return ls.size() == sz;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
