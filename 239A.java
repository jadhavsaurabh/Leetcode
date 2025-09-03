class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Map<Integer, Integer> freq = new HashMap<>();

        // First window
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        res.add(pq.peek());

        for (int i = k; i < nums.length; i++) {
            // outgoing element
            int out = nums[i - k];
            freq.put(out, freq.get(out) - 1);

            // incoming element
            int in = nums[i];
            pq.add(in);
            freq.put(in, freq.getOrDefault(in, 0) + 1);

            // clean up invalid top elements
            while (!pq.isEmpty() && freq.get(pq.peek()) == 0) {
                pq.poll();
            }

            res.add(pq.peek());
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
