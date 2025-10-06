class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        // Initialize
        for(int i=0;i<=n;i++) {
            ArrayList<int[]> ls = new ArrayList<>();
            adj.add(i, ls);
        }

        // Create adj
        for (int[] time : times) {
            ArrayList<int[]> ls = adj.get(time[0]);
            ls.add(new int[]{time[1], time[2]});
            adj.set(time[0], ls);
        }
        
        HashMap<Integer, Integer> mp = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(1, Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{k, 0});
        while(!pq.isEmpty()) {
            int[] popped = pq.poll();
            if(mp.containsKey(popped[0])) {
                continue;
            }
            mp.put(popped[0], popped[1]);
            ArrayList<int[]> connected = adj.get(popped[0]);
            for (int[] connectedNode : connected) {
                if (mp.containsKey(connectedNode[0])) {
                    continue;
                }
                pq.add(new int[]{connectedNode[0], connectedNode[1] + popped[1]});
            }
        }

        int max = -1;
        for(int i=1;i<=n;i++) {
            if(!mp.containsKey(i)) return -1;
            if(max < mp.get(i)) {
                max = mp.get(i);
            }
        }
        return max;
    }
}
