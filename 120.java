class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> prev = triangle.getFirst();
        int min = prev.getFirst();
        for(int i=1;i<triangle.size();i++) {
            List<Integer> row = triangle.get(i);
            min = Integer.MAX_VALUE;
            List<Integer> next = new ArrayList<>(row.size());
            for(int j=0;j<row.size();j++) {
                int curr = row.get(j);
                if(j == 0) {
                    curr += prev.getFirst();
                } else if(j == row.size() - 1) {
                    curr += prev.getLast();
                } else {
                    curr += Math.min(prev.get(j), prev.get(j-1));
                }
                if(min > curr) {
                    min = curr;
                }
                next.add(j, curr);
            }
            prev = next;
        }

        return min;
    }
}
