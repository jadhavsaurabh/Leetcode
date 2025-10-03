import java.util.*;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int r = heightMap.length, c = heightMap[0].length;
        if (r <= 2 || c <= 2) return 0; // no space for water

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[r][c];

        // push all boundary cells into pq
        for (int i = 0; i < r; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, c-1, heightMap[i][c-1]});
            visited[i][0] = visited[i][c-1] = true;
        }
        for (int j = 1; j < c-1; j++) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{r-1, j, heightMap[r-1][j]});
            visited[0][j] = visited[r-1][j] = true;
        }

        int res = 0;
        int maxBoundary = Integer.MIN_VALUE;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], h = cur[2];
            maxBoundary = Math.max(maxBoundary, h);

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                if (heightMap[nx][ny] < maxBoundary) {
                    res += maxBoundary - heightMap[nx][ny];
                }
                pq.offer(new int[]{nx, ny, heightMap[nx][ny]});
            }
        }
        return res;
    }
}
