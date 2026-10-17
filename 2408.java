class SQL {
    Map<String, Table> database;

    public SQL(List<String> names, List<Integer> columns) {
        database = new HashMap<>();

        for(int i=0;i<names.size();i++) {
            database.put(names.get(i), new Table(columns.get(i)));
        }
    }

    public boolean ins(String name, List<String> row) {
        if(!database.containsKey(name) || database.get(name).columns != row.size()) return false;

        Table table = database.get(name);
        table.rows.put(table.id, row);
        table.id++;
        return true;
    }

    public void rmv(String name, int rowId) {
        if(!database.containsKey(name)) return;
        Table table = database.get(name);

        if(!table.rows.containsKey(rowId)) return;

        database.get(name).rows.remove(rowId);
    }

    public String sel(String name, int rowId, int columnId) {
        if(columnId < 1 || !database.containsKey(name)) return "<null>";
        Table table = database.get(name);

        if(table.columns < columnId || !table.rows.containsKey(rowId)) return "<null>";

        return table.rows.get(rowId).get(columnId - 1);
    }

    public List<String> exp(String name) {
        List<String> res = new ArrayList<>();
        if(!database.containsKey(name)) return res;

        Table table = database.get(name);
        for(Map.Entry<Integer, List<String>> entry: table.rows.entrySet()) {
            Integer rowId = entry.getKey();
            List<String> row = entry.getValue();
            
            StringBuilder sb = new StringBuilder();
            sb.append(rowId).append(",");
            for(String cell: row) {
                sb.append(cell).append(",");
            }
            
            sb.deleteCharAt(sb.length() - 1);
            
            res.add(sb.toString());
        }

        return res;
    }
}

class Table {
    int columns;
    int id;
    Map<Integer, List<String>> rows;

    Table(int c) {
        rows = new HashMap<>();
        id = 1;
        columns = c;
    }
}
/**
 * Your SQL object will be instantiated and called as such:
 * SQL obj = new SQL(names, columns);
 * boolean param_1 = obj.ins(name,row);
 * obj.rmv(name,rowId);
 * String param_3 = obj.sel(name,rowId,columnId);
 * List<String> param_4 = obj.exp(name);
 */
