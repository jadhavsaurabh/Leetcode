class Solution {
    public static List<Integer> depths = new ArrayList<>();
    public static void recusiveOperation(int start, int target, int current, int depth) {
        System.out.println(current);
        if(depth > 0 && current == start) {
            return;
        }
        if(current == target) {
            depths.add(depth);
        } else {
            if(current < target) {
                recusiveOperation(start, target, current * 2, depth + 1);   
            }
            if (current > (target / 2)) {
                recusiveOperation(start, target, current - 1, depth + 1);   
            }
        }
    }

    public int brokenCalc(int start, int target) {
        System.out.println(depths);
        recusiveOperation(start, target, start, 0);
        System.out.println(depths);
        
        int res = 100000000;
        for(int i=0;i<depths.size();i++) {
            Integer temp = depths.get(i); 
            if(temp < res) {
                res = temp;
            }
        }
        depths.clear();
        System.out.println(res);
        return res;
    }
}
