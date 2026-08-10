/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        Map<Integer, Integer> imp = new HashMap<>();
        for(Employee emp: employees) {
            imp.put(emp.id, emp.importance);
            mp.put(emp.id, emp.subordinates);
        }

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        int res = 0;

        vis.add(id);
        q.add(id);

        while(!q.isEmpty()) {
            int popped = q.poll();
            res += imp.get(popped);

            for(Integer sub: mp.get(popped)) {
                if(!vis.contains(sub)) {
                    vis.add(sub);
                    q.add(sub);
                }
            }
        }

        return res;
    }
}
