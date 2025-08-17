class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(
                k,
                (l1, l2) -> {
                    int sum1 = l1.get(0) * l1.get(0) + l1.get(1) * l1.get(1);
                    int sum2 = l2.get(0) * l2.get(0) + l2.get(1) * l2.get(1);
                    return Integer.compare(sum2, sum1); // descending order
                }
        );
        
        for(int[] point: points) {
            
            if(pq.size() < k) {
                //System.out.println("Adding" + point);
                pq.add(new ArrayList<>(Arrays.asList(point[0], point[1])));
            } else {
                int curr = point[0] * point[0] + point[1] * point[1];
                List<Integer> top = pq.peek();
                int topDistance = top.get(0) * top.get(0) + top.get(1) * top.get(1);
                
                if(curr < topDistance) {
                    pq.poll();
                    //System.out.println("Removing & Adding as full" + point);
                    pq.add(new ArrayList<>(Arrays.asList(point[0], point[1])));
                }
            }
        }
        
        int[][] res = new int[pq.size()][2];
        int i = 0;
        while(!pq.isEmpty()) {
            List<Integer> pop = pq.poll();
            res[i][0] = pop.get(0);
            res[i][1] = pop.get(1);
            i++;
        }
        return res;
    }
}
