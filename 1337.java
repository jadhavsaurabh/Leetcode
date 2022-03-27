class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] soldierCount = new int[mat.length];
        
        for(int i=0;i<mat.length;i++) {
            int count = 0;
            for(int j=0;j<mat[i].length;j++) {
                if(mat[i][j] == 1) {
                    count++;
                }
            }
            soldierCount[i] = count;
        }
        
        int[] visited = new int[mat.length];
        int[] clone = soldierCount.clone();
        int[] res = new int[k];
        int kc = 0;
        Arrays.sort(soldierCount);
        
        for(int i=0;i<k;i++) {
            for(int j=0;j<clone.length;j++) {
                if(clone[j] == soldierCount[i] && visited[j] != 1 && kc < k) {
                    res[kc++] = j;
                    visited[j] = 1;
                    break;
                }
            }
        }
        return res;
    }
} 
