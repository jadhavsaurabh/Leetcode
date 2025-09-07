class Solution {
    public void dfs(String src , HashSet<String> visited ,HashMap<String,List<String>> adjlist,List<String> sublist){
        visited.add(src);
        sublist.add(src);
        if(!adjlist.containsKey(src)){
            return;
        }
        List<String> neighbours = adjlist.get(src);
        for(String neighbour : neighbours){
            if(!visited.contains(neighbour)){
                dfs(neighbour,visited,adjlist,sublist);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,List<String>> adjlist = new HashMap<>();
        
        // Build graph
        for(List<String> account : accounts){
            String firstEmail = account.get(1);
            for(int i = 2 ; i<account.size() ; i++){
                String email = account.get(i);
                adjlist.computeIfAbsent(firstEmail, k -> new ArrayList<>()).add(email);
                adjlist.computeIfAbsent(email, k -> new ArrayList<>()).add(firstEmail);
            }
        }

        List<List<String>> res = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        
        // DFS for connected components
        for(List<String> account : accounts){
            String firstEmail = account.get(1);
            if(!visited.contains(firstEmail)){
                List<String> sublist = new ArrayList<>();
                dfs(firstEmail,visited,adjlist,sublist);
                Collections.sort(sublist);
                sublist.add(0,account.get(0)); // add account name
                res.add(sublist);
            }
        }
        return res;
    }
}
