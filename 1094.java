class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> seat = new HashMap<>();
        Map<Integer, Integer> drop = new HashMap<>();
        int maxkm = 0;
        for(int i=0;i<trips.length;i++) {
            if(drop.containsKey(trips[i][2])) {
                drop.put(trips[i][2], (Integer)drop.get(trips[i][2]) + trips[i][0]);
            } else {
                drop.put(trips[i][2], trips[i][0]);
            }
            if(seat.containsKey(trips[i][1])) {
                seat.put(trips[i][1], (Integer)seat.get(trips[i][1]) + trips[i][0]);
            } else {
                seat.put(trips[i][1], trips[i][0]);
            }

            if(trips[i][2] > maxkm) {
                maxkm = trips[i][2];
            }
        }
        
        boolean res = true;
        int currCapacity = 0;
        for(int i=0;i<=maxkm;i++) {
            if(drop.containsKey(i)) {
                currCapacity = currCapacity - (Integer)drop.get(i);
            }
            if(seat.containsKey(i)) {
                currCapacity = currCapacity + (Integer)seat.get(i);
            }
            if(currCapacity > capacity) {
                res = false;
                break;
            }
        }
        return res;
    }
}
