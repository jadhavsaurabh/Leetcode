/*
  https://algomaster.io/learn/dsa/design-hit-counter
*/

class HitCounter {
    List<Integer> ls;
    public HitCounter() {
        ls = new ArrayList<>();
    }

    public void hit(int timestamp) {
        ls.add(timestamp);
        while(timestamp - ls.getFirst() >= 300) {
            ls.removeFirst();
        }
    }

    public int getHits(int timestamp) {
        int count = 0;
        for(int hit: ls) {
            if(timestamp - hit < 300) {
                count++;
            }
        }
        
        return count;
    }
}
