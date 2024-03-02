
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> neg = new Stack<>();
        ArrayList<Integer> pos = new ArrayList<>();

        for(int num: nums) {
            if(num < 0) {
                neg.add((int) Math.pow(num, 2));
            } else {
                pos.add((int) Math.pow(num, 2));
            }
        }

        int i = 0;
        int resCount = 0;
        while(!neg.empty() || i < pos.size()) {
            if(i >= pos.size()) {
                while(!neg.empty()) {
                    result[resCount++] = neg.pop();
                }
                break;
            }
            if(neg.empty()) {
                while(i < pos.size()) {
                    result[resCount++] = pos.get(i++);
                }
                break;
            }
            if(neg.peek() < pos.get(i)) {
                result[resCount++] = neg.pop();
            } else {
                result[resCount++] = pos.get(i++);
            }
        }

        return result;
    }
}
