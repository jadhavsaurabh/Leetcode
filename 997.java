class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1) return 1;
        if(trust.length == 0) return -1;
        int res = -1;
        HashMap<Integer, ArrayList<Integer>> data = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int[] trustRelation : trust) {
            set.add(trustRelation[0]);
            if (data.containsKey(trustRelation[1])) {
                data.get(trustRelation[1]).add(trustRelation[0]);
            } else {
                ArrayList<Integer> ls = new ArrayList<>();
                ls.add(trustRelation[0]);
                data.put(trustRelation[1], ls);
            }
        }
        
    
        for(int i=1;i<=n;i++) {
            if(!set.contains(i) && (data.containsKey(i) && data.get(i).size() == (n-1))) {
                res = i;
                break;
            }
        }
        
        return res;
    }
}
