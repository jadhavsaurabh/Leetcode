class Solution {
    public int equalPairs(int[][] grid) {
        int rc = grid.length;
        Map<String, Integer> mp = new HashMap<>();
        for(int i=0;i<rc;i++) {
            StringBuilder strbldr = new StringBuilder(rc);
            for(int j=0;j<rc;j++) {
                strbldr.append(grid[i][j]);
                strbldr.append("_");
            }
            
            String str = strbldr.toString();
            mp.put(str,mp.getOrDefault(str, 0) + 1);
        }


        int result = 0;
        for(int i=0;i<rc;i++) {
            StringBuilder strbldr = new StringBuilder(rc);
            for(int j=0;j<rc;j++) {
                strbldr.append(grid[j][i]);
                strbldr.append("_");
            }

            String str = strbldr.toString();
            if(mp.containsKey(str)) {
                result += mp.get(str);
            }
        }
        return result;
    }
}
