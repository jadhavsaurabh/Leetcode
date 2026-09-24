class Solution {
    public void dfs(int[][] graph, int curr, List<Integer> pathSoFar, List<List<Integer>> res) {
        for(int i=0;i< graph[curr].length;i++) {
            // target
            if(graph[curr][i] == graph.length - 1) {
                pathSoFar.add(graph.length - 1);
                res.add(List.copyOf(pathSoFar));
                pathSoFar.removeLast();
                continue;
            }
            pathSoFar.add(graph[curr][i]);
            dfs(graph, graph[curr][i], pathSoFar, res);
            pathSoFar.removeLast();
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, path, res);
        return res;
    }
}
