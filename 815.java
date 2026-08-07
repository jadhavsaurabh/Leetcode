
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        HashMap<Integer, List<Integer>> stopToBus = new HashMap<>();

        for(int i=0;i<routes.length;i++) {
            int[] stops = routes[i];
            for(int stop: stops) {
                List<Integer> buses = stopToBus.getOrDefault(stop, new ArrayList<>());
                buses.add(i);
                stopToBus.put(stop, buses);
            }
        }


        if(!stopToBus.containsKey(source) || !stopToBus.containsKey(target)) return -1;
        Queue<int[]> queue = new LinkedList<>();
        HashSet<Integer> visitedStops = new HashSet<>();
        HashSet<Integer> visitedBus = new HashSet<>();

        queue.add(new int[]{source, 0});
        visitedStops.add(source);

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                size--;
                int[] currStop = queue.peek();
                queue.poll();

                if(currStop[0] == target) return currStop[1];

                for(Integer bus: stopToBus.get(currStop[0])) {
                    if(visitedBus.contains(bus)) continue;

                    visitedBus.add(bus);
                    for(int stop: routes[bus]) {
                        if(visitedStops.contains(stop)) continue;

                        visitedStops.add(stop);
                        queue.add(new int[]{stop, currStop[1] + 1});
                    }
                }
            }
        }

        return -1;
    }
}
