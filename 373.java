class Pair {
    int i, j, sum;

    Pair(int i, int j, int sum) {
        this.i = i;
        this.j = j;
        this.sum = sum;
    }
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.sum));
        Set<String> visited = new HashSet<>();

        pq.add(new Pair(0, 0, nums1[0] + nums2[0]));
        visited.add("0,0");

        while (!pq.isEmpty() && res.size() < k) {
            Pair p = pq.poll();
            res.add(Arrays.asList(nums1[p.i], nums2[p.j]));

            if (p.i + 1 < nums1.length && visited.add((p.i + 1) + "," + p.j)) {
                pq.add(new Pair(p.i + 1, p.j, nums1[p.i + 1] + nums2[p.j]));
            }

            if (p.j + 1 < nums2.length && visited.add(p.i + "," + (p.j + 1))) {
                pq.add(new Pair(p.i, p.j + 1, nums1[p.i] + nums2[p.j + 1]));
            }
        }

        return res;
    }
}
