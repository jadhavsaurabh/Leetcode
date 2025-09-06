class NumMatrix {
    int[][] prefixSum;
    int row, col;
    public NumMatrix(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        prefixSum = new int[row][col];

        for(int i=0;i<row;i++) {
            prefixSum[i][0] = matrix[i][0];
            for(int j=1;j<col;j++) {
                prefixSum[i][j] = prefixSum[i][j-1] + matrix[i][j];
            }
        }

        for(int j=0;j<col;j++) {
            int sum = prefixSum[0][j];
            for(int i=1;i<row;i++) {
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(col1 == 0 && row1 == 0) {
            return prefixSum[row2][col2];
        } else if (row1 == 0) {
            return prefixSum[row2][col2] - prefixSum[row2][col1 - 1];
        } else if (col1 == 0) {
            return prefixSum[row2][col2] - prefixSum[row1 - 1][col2];
        } else {
            return (prefixSum[row2][col2] - prefixSum[row2][col1 - 1]) - (prefixSum[row1-1][col2] - prefixSum[row1-1][col1-1]);
        }
    }
}
