
class TimeMap {

        Map<String, TreeMap<Integer, String>> map;
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if(map.containsKey(key)) {
                map.get(key).put(timestamp, value);
            } else {
                TreeMap<Integer, String> treeMap = new TreeMap<>();
                treeMap.put(timestamp, value);
                map.put(key, treeMap);
            }
        }

        public String get(String key, int timestamp) {
            if(map.containsKey(key)){
                if(map.get(key).containsKey(timestamp)){
                    return map.get(key).get(timestamp);
                }
                else{
                    Integer prevTimestamp = map.get(key).floorKey(timestamp);
                    if(prevTimestamp!=null){
                        return map.get(key).get(prevTimestamp);
                    }
                }
            }
            return "";
        }
    }
