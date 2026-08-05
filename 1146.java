class SnapshotArray {
    HashMap<Integer, ArrayList<List<Integer>>> mp;
    HashMap<Integer, Integer> change;
    int snap_id;

    public SnapshotArray(int length) {
        snap_id = 0;
        change = new HashMap<>();
        mp = new HashMap<>();

        for (int i = 0; i < length; i++) {
            mp.put(i, new ArrayList<>());
        }
    }

    public void set(int index, int val) {
        change.put(index, val);
    }

    public int snap() {
        for (Map.Entry<Integer, Integer> entry : change.entrySet()) {
            mp.get(entry.getKey()).add(Arrays.asList(snap_id, entry.getValue()));
        }

        change.clear();
        return snap_id++;
    }

    public int get(int index, int snap_id) {
        ArrayList<List<Integer>> snaps = mp.get(index);

        if (snaps.isEmpty()) {
            return 0;
        }

        int l = 0;
        int r = snaps.size() - 1;
        int res = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            int storedSnap = snaps.get(mid).get(0);

            if (storedSnap <= snap_id) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if (res == -1) {
            return 0;
        }

        return snaps.get(res).get(1);
    }
}
