class Solution {
    public List<List<Integer>> generate(int r) {
        int[][] mat = new int[r][r];
        
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<r;i++) {
            mat[i][0] = 1;
            mat[0][i] = 1;
        }
        
        result.add(Arrays.asList(1));
        if(r == 1) return result;
        result.add(Arrays.asList(1,1));
        
        for(int i=2;i<r;i++) {
            List<Integer> newList = new ArrayList<>();
            int k = i;
            int j = 0;
            
            while(k>1) {
                k--;
                j++;
                
                mat[k][j] = mat[k][j-1] + mat[k-1][j];
                newList.add(mat[k][j]);
            }
            newList.add(0, 1);
            newList.add(1);
            result.add(newList);
        }

        return result;
    }
}
