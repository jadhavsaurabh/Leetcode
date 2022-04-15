/*
Simply store the cols & 
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        Set<Integer> rowset = new HashSet<>();
        Set<Integer> colset = new HashSet<>();

        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(matrix[i][j] == 0) {
                    rowset.add(i);
                    colset.add(j);
                }
            }
        }
        
        for(Integer rowno: rowset) {
            for(int i=0;i<cols;i++) {
                matrix[(int)rowno][i] = 0;
            }
        }
        
        for(Integer colno: colset) {
            for(int i=0;i<rows;i++) {
                matrix[i][(int)colno] = 0;
            }
        }
    }
}
