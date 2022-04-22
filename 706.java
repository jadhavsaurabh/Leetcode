class MyHashMap {
    int[] hash;
    public MyHashMap() {
        this.hash = new int[1000001];
        for(int i=0;i<1000001;i++) {
            this.hash[i] = -1;
        }
    }
    
    public void put(int key, int value) {
        this.hash[key] = value;
    }
    
    public int get(int key) {
        return this.hash[key];
    }
    
    public void remove(int key) {
        this.hash[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
