class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int len = people.length;
        int[] visited = new int[len];
        
        Arrays.sort(people);

        int res = 0;
        for(int i=len - 1;i>=0;i--) {
            if(visited[i] == 1) continue;
            int target = limit - people[i];
            if(target == 0) {
                visited[i] = 1;
                res++;
            } else {
                boolean flag = false;
                for(int j=i - 1;j>=0;j--) {
                    if(visited[j] == 0 && people[j] <= target) {
                        visited[j] = 1;
                        visited[i] = 1;
                        res++;
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    visited[i] = 1;
                    res++;
                }
            }
        }
        return res;
    }
}
