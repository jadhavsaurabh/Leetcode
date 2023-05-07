class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length - 1;
        int c = matrix[0].length - 1;

        int ri = 0, rj = r;
        int probRow = -1;
        while(ri <= rj) {
            int midRow = (ri + rj) / 2;
            if(matrix[midRow][0] <= target && matrix[midRow][c] >= target){
                probRow = midRow;
                break;
            } else if(matrix[midRow][0] > target) {
                rj = midRow - 1;
            } else {
                ri = midRow + 1;
            }
        }

        if(probRow == -1) return false;
        int ci = 0, cj = c;
        while(ci <= cj) {
            int midRow = (ci + cj) / 2;
            if(matrix[probRow][midRow] == target) {
                return true;
            } else if(matrix[probRow][midRow] > target) {
                cj = midRow - 1;
            } else {
                ci = midRow + 1;
            }
        }
        return false;
    }
}
