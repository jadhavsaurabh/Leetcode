class Solution {
    public int snakesAndLadders(int[][] board) {
        HashMap<Integer, List<Integer>> squarePos = new HashMap<>();
        boolean forward = true;
        int square = 1;
        int len = board.length;
        int destination = len * len;

        // Saving square & resp position in board
        for(int i= len - 1;i>=0;i--) {
            if(forward) {
                for(int j=0;j < len;j++) {
                    squarePos.put(square++, new ArrayList<>(Arrays.asList(i,j)));
                }
            } else {
                for(int j=len - 1;j >= 0;j--) {
                    squarePos.put(square++, new ArrayList<>(Arrays.asList(i,j)));
                }
            }
            forward = !forward;
        }

        //System.out.println(squarePos);

        Queue<List<Integer>> squareMoves = new LinkedList<>();
        squareMoves.add(new ArrayList<>(Arrays.asList(1,0)));
        Set<Integer> visit = new HashSet<>();
        visit.add(1);

        while(!squareMoves.isEmpty()) {
            List<Integer>squareMove = squareMoves.poll();

            for(int i = 1;i<=6;i++) {
                int nextSquare = squareMove.getFirst() + i;

                List<Integer> nextSquarePos = squarePos.get(nextSquare);
                if(board[nextSquarePos.getFirst()][nextSquarePos.getLast()] != -1) {
                    // Modify if snake face or ladder bottom
                    nextSquare = board[nextSquarePos.getFirst()][nextSquarePos.getLast()];
                }
                if(nextSquare == destination) return squareMove.getLast() + 1;
                if(!visit.contains(nextSquare)) {
                    visit.add(nextSquare);
                    squareMoves.add(new ArrayList<>(Arrays.asList(nextSquare, squareMove.getLast() + 1)));
                }
            }
        }

        return -1;
    }
}
