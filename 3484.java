class Spreadsheet {
    int[][] sheet;
    public Spreadsheet(int rows) {
        sheet = new int[rows][26];
    }

    public int getCol(String cell) {
        return cell.charAt(0) - 'A';
    }

    public int getRow(String cell) {
        return Integer.parseInt(cell.substring(1)) - 1;
    }

    public void setCell(String cell, int value) {
        int r = getRow(cell);
        int c = getCol(cell);

        sheet[r][c] = value;
    }

    public void resetCell(String cell) {
        int r = getRow(cell);
        int c = getCol(cell);

        sheet[r][c] = 0;
    }

    public int getValue(String formula) {
        //=X+Y
        String woEqual = formula.substring(1);
        //System.out.println(woEqual);
        String[] cells = woEqual.split("\\+");
        //System.out.println(cells);
        int res = 0;
        if('A' <= cells[0].charAt(0)  && cells[0].charAt(0) <= 'Z') {
            int r = getRow(cells[0]);
            int c = getCol(cells[0]);

            res += sheet[r][c];
        } else {
            res += Integer.parseInt(cells[0]);
        }

        if('A' <= cells[1].charAt(0)  && cells[1].charAt(0) <= 'Z') {
            int r = getRow(cells[1]);
            int c = getCol(cells[1]);

            res += sheet[r][c];
        } else {
            res += Integer.parseInt(cells[1]);
        }
        return res;
    }
}
