class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] chars = new int[26];
        for(char task: tasks) {
            chars[task - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<26;i++) {
            if(chars[i] == 0) continue;
            // negative because by default it is min heap
            pq.add(-chars[i]);
        }

        Queue<int[]> q = new LinkedList<>();

        int time = 0;
        while(!q.isEmpty() || !pq.isEmpty()) {
            time++;

            if(!pq.isEmpty()) {
                Integer top = pq.poll();
                top++;
                if(top != 0) {
                    q.add(new int[]{top, time + n});
                }
            }

            if(!q.isEmpty()) {
                int[] qTop = q.peek();

                if(qTop[1] == time) {
                    q.poll();
                    pq.add(qTop[0]);
                }
            }
        }
        return time;
    }
}
