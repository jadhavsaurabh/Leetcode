class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);
            double val = values[i];

            graph.computeIfAbsent(a, key -> new HashMap<>()).put(b, val);
            graph.computeIfAbsent(b, key -> new HashMap<>()).put(a, 1.0 / val);
        }

        double[] result = new double[queries.size()];

        for (int i=0;i<queries.size();i++) {
            List<String> query = queries.get(i);
            // System.out.println(query);
            HashSet<String> visited = new HashSet<>();
            if(!graph.containsKey(query.getFirst()) || !graph.containsKey(query.getLast())) {
                //System.out.println("invalid query -1");
                result[i] = -1;
                continue;
            }
            dfs(query.getFirst(), graph, query, i, result, 1, visited);
        }

        return result;
    }

    public void dfs(String key, HashMap<String, HashMap<String, Double>> graph, List<String> query, int queryIdx, double[] result, double product, HashSet<String> visited) {
        if(visited.contains(key)) return;
        visited.add(key);
        if(Objects.equals(query.getLast(), key)) {
            // System.out.println(product);
            result[queryIdx] = product;
            return;
        }

        HashMap<String, Double> ads = graph.get(key);
       
        for(String it: ads.keySet()) {
            dfs(it, graph, query, queryIdx, result, product * ads.get(it), visited);
        }
        if(!visited.contains(query.getLast())) {
            // System.out.println("no path -1");
            result[queryIdx] = -1;
        }
    }
}
