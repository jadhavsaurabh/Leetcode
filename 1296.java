class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer, Integer> mp = new TreeMap<>();

        for(int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        while(!mp.isEmpty()) {
            int first = mp.firstKey();
            
            for(int i=0;i<k;i++) {
                int next = first + i;
                if(mp.containsKey(next)) {
                    int occ = mp.get(next);
                    if(occ == 1) {
                        mp.remove(next);
                    } else {
                        mp.put(next, occ - 1);
                    }
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
