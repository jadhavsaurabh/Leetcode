/*
Use the set to save all possible combination of sum if one of the sum is equal to the total_sum/2 then return true.
*/
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0)
            return false;

        int desired = sum / 2;
        Set<Integer> st = new HashSet<>();
        st.add(0);

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> tempSet = new HashSet<>();
            Iterator<Integer> it = st.iterator();

            while (it.hasNext()) {
                int tempSum = it.next() + nums[i];
                if (desired == tempSum) {
                    return true;
                }
                tempSet.add(tempSum);
            }

            st.addAll(tempSet);
        }

        return false;
    }
}
