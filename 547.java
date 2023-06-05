/*
use dfs to traverse, attach identifier to certain province
calculate the unique identifiers at the end
*/
class Solution {
    public int findCircleNum(int[][] isConnected) {
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[isConnected.length];

        for(int i = 0;i<isConnected.length;i++) {
            if(visited[i] > 0) continue;
            
            stack.add(i);
            while(!stack.isEmpty()) {
                int node = stack.pop();
                visited[node] = i + 1;
                
                for(int j=0;j<isConnected.length;j++) {
                    if(i == j) continue;
                    
                    if(visited[j] == 0 && isConnected[node][j] == 1) {
                        stack.push(j);
                    }
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<isConnected.length;i++) {
            set.add(visited[i]);
        }
        return set.size();
    }
}
