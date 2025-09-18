class TaskManager {
    // taskId -> {userId, priority}
    private Map<Integer, int[]> taskMap;
    // max heap of {priority, taskId}
    private PriorityQueue<int[]> pq;

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0]; // higher priority first
            return b[1] - a[1]; // tie -> larger taskId first
        });

        for (List<Integer> t : tasks) {
            int userId = t.get(0), taskId = t.get(1), priority = t.get(2);
            taskMap.put(taskId, new int[]{userId, priority});
            pq.offer(new int[]{priority, taskId});
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskMap.put(taskId, new int[]{userId, priority});
        pq.offer(new int[]{priority, taskId});
    }

    public void edit(int taskId, int newPriority) {
        int[] old = taskMap.get(taskId);
        taskMap.put(taskId, new int[]{old[0], newPriority});
        pq.offer(new int[]{newPriority, taskId});
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int priority = top[0], taskId = top[1];
            if (!taskMap.containsKey(taskId)) continue; // removed
            int[] info = taskMap.get(taskId);
            if (info[1] != priority) continue; // outdated
            taskMap.remove(taskId);
            return info[0]; // userId
        }
        return -1;
    }
}
