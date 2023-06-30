class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        
        for (int i=0;i<arr.length;i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }
        
        for(var it: mp.entrySet()) {
            if(set.contains(it.getValue())) {
                return false;
            } else {
                set.add(it.getValue());
            }
        }
        return true;
    }
} 
