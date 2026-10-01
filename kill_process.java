void main() {
    Solution s = new Solution();

    int[] pid = new int[]{1,3,10,5};
    int[] ppid = new int[]{3,0,5,3};
    System.out.println(s.killedProcess(pid, ppid, 5));
}
/*
Input:
pid  = [1, 3, 10, 5]
ppid = [3, 0, 5, 3]
kill = 5

Output:
[5, 10]

3 -> 1
0 -> 3
5 -> 10
3 -> 5

pid  = [1, 2, 3, 4]
ppid = [0, 1, 1, 2]

0->1
1-> 2, 3
2-> 4
 */

class Solution {
    public List<Integer> killedProcess(int[] pid, int[] ppid, int target) {
        List<Integer> ls = new ArrayList<>();
        HashMap<Integer, List<Integer>> parentChild = new HashMap<>();

        for(int i=0;i<pid.length;i++) {
            int parent = ppid[i];
            int child = pid[i];

            List<Integer> children = parentChild.getOrDefault(parent, new ArrayList<>());
            children.add(child);

            parentChild.put(parent, children);
        }

        Stack<Integer> stk = new Stack<>();
        stk.add(target);
        while(!stk.isEmpty()) {
            int process = stk.pop();
            ls.add(process);

            if(!parentChild.containsKey(process)) {
                continue;
            }
            List<Integer> children = parentChild.get(process);

            stk.addAll(children);
        }

        return ls;
    }
}
