class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean x = false;
        boolean y = false;
        boolean z = false;
        
        for(int i = 0;i<triplets.length;i++){
            if(triplets[i][0] == target[0] && triplets[i][1] <= target[1] && triplets[i][2] <= target[2]){
                x = true;
                break;
            }
        }
        
        for(int i = 0;i<triplets.length;i++){
            if(triplets[i][0] <= target[0] && triplets[i][1] == target[1] && triplets[i][2] <= target[2]){
                y = true;
                break;
            }
        }
        
        for(int i = 0;i<triplets.length;i++){
            if(triplets[i][0] <= target[0] && triplets[i][1] <= target[1] && triplets[i][2] == target[2]){
                z = true;
                break;
            }
        }
        
        if(x == true && y == true && z == true){
            return true;
        }
        
        return false;
    }
}
