class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        int[] set = new int[n];
        for(int i = 1;i<=n;i++) {
            set[i-1] = i;
        }
        for(int i=0;i<n;i++) {
            List<Integer> list = new ArrayList<>();
            list.add(set[i]);
            add(k, i, set, list, res);
        }
        
        return res;
    }

    public void add(int k, int i, int[] set, List<Integer> list, List<List<Integer>> res) {
        if(list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int j=i+1;j<set.length;j++) {
            list.add(set[j]);
            add(k, j, set, list, res);
            list.removeLast();
        }
    }
}
