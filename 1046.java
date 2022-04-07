class Solution {
    public int lastStoneWeight(int[] stones) {
        int broke = 0;
        while(stones.length - broke > 1) {
            int mx1 = 0;
            int mx2 = 0;
            int mx1ind = -1;
            int mx2ind = -1; 
            
            for(int i=0;i<stones.length;i++) {
                if(stones[i] > mx1) {
                    mx1ind = i;
                    mx1=stones[i];
                }
            }

            for(int i=0;i<stones.length;i++) {
                if(mx2 < stones[i] && stones[i] <= mx1 && i!= mx1ind) {
                    mx2ind = i;
                    mx2=stones[i];
                }
            }
            if(mx1ind > -1 && mx2ind > -1) {
                stones[mx1ind] = mx1 - mx2;   
                stones[mx2ind] = 0;   
            }
            broke++;
        }
        
        int res = 0;
        for(int i=0;i<stones.length;i++) {
            if(stones[i] > 0) {
                res = stones[i];
                break;
            }
        }
        return res;
    }
}
