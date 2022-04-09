class NumOcc {
    int num;
    int occ;
    
    NumOcc(int num, int occ) {
        this.num = num;
        this.occ = occ;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map <Integer, Integer> map = new TreeMap<>();
        
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);   
        }

        PriorityQueue<NumOcc> pq3 = new PriorityQueue<>(new Comparator<NumOcc>()
        {
            @Override
            public int compare(NumOcc a, NumOcc b)
            {
                return b.occ-a.occ;
            }
        });
        

        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            NumOcc num = new NumOcc(e.getKey(), e.getValue());
            pq3.offer(num);
        }
        
        int[] res = new int[k];
        for(int i=0;i<k;i++) {
            res[i] = pq3.poll().num;
        }
        return res;
    }
}
