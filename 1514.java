class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<double[]>> adj = new ArrayList<>();

        for(int i=0;i<n;i++) {
            adj.add(i, new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++) {
            int[] edge = edges[i];
            double prob = succProb[i];
            adj.get(edge[0]).add(new double[]{edge[1], prob});
            adj.get(edge[1]).add(new double[]{edge[0], prob});
        }

        PriorityQueue<double[]> pq = new PriorityQueue<>(1, (a,b) -> (int) (b[1] * 100000 - a[1] * 100000));
        pq.add(new double[]{start_node, 1});
        HashMap<Double, Double> mp = new HashMap<>();

        while(!pq.isEmpty()) {
            double[] popped = pq.poll();
            if(mp.containsKey(popped[0])) continue;

            if(popped[0] == end_node) return popped[1];
            mp.put(popped[0], popped[1]);
            List<double[]> neighbors = adj.get((int) popped[0]);

            for(double[] neighbor: neighbors) {
                if(mp.containsKey(neighbor[0])) continue;
                pq.add(new double[]{neighbor[0], neighbor[1] * popped[1]});
            }
        }

        return 0;
    }
}
