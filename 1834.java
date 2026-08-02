
class Task {
    int enqueTime;
    int processingTime;
    int index;

    Task(int e, int p, int i) {
        enqueTime = e;
        processingTime = p;
        index = i;
    }
}

class Solution {
    public int[] getOrder(int[][] tasks) {
        Task[] sortedTasks = new Task[tasks.length];

        // Mark idx & sort on the basis of enqueTime
        for(int i=0;i<tasks.length;i++) {
            sortedTasks[i] = new Task(tasks[i][0], tasks[i][1], i);
        }
        Arrays.sort(sortedTasks, Comparator.comparingInt(a -> a.enqueTime));
        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) ->
                a.processingTime == b.processingTime ? a.index - b.index : a.processingTime - b.processingTime
        );

        int[] res = new int[tasks.length];
        int idx = 0;
        int id = 0;
        long time = 0;

        while(idx < tasks.length || !pq.isEmpty()) {
    
            if(pq.isEmpty() && time < sortedTasks[idx].enqueTime) {
                time = sortedTasks[idx].enqueTime;
            }

            while(idx < tasks.length && sortedTasks[idx].enqueTime <= time) {
                pq.offer(sortedTasks[idx]);
                idx++;
            }

            Task processed = pq.poll();
            time += processed.processingTime;
            res[id++] = processed.index;
        }
        
        return res;
    }
}
