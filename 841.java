/*
Simple BFS
*/

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);

        while(!q.isEmpty()) {
            int room = q.remove();
            
            if(!visited[room]) {
                visited[room] = true;
                
                List<Integer> keys = rooms.get(room);
                for(var key: keys) {
                    q.add(key);
                }
            }
        }
        
        for(int i = 0;i < visited.length; i++) {
            if(visited[i] == false) return false;
        }
        return true;
    }
}
