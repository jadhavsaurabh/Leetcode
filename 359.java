class Logger {
    Map<String, Integer> mp;

    public Logger() {
        mp = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!mp.containsKey(message)) {
            mp.put(message, timestamp + 10);
            return true;
        }
        int lastTime = mp.get(message);
        if(timestamp - lastTime >= 0) {
            mp.put(message, timestamp + 10);
            return true;
        }
        return false;
    }
}
