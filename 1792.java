class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int[] c : classes) {
            double gain = gain(c[0], c[1]);
            pq.add(new double[]{gain, c[0], c[1]});
        }

        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            int pass = (int) top[1] + 1;
            int total = (int) top[2] + 1;
            pq.add(new double[]{gain(pass, total), pass, total});
        }

        double totalAvg = 0;
        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            totalAvg += cur[1] / cur[2];
        }

        return totalAvg / classes.length;
    }

    private double gain(int pass, int total) {
        return (double) (pass + 1) / (total + 1) - (double) pass / total;
    }
}
