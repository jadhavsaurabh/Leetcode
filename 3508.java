class Router {

    LinkedHashSet<List<Integer>> packets;
    int sz;
    HashMap<Integer, ArrayList<Integer>> destPackets;

    public Router(int memoryLimit) {
        sz = memoryLimit;
        packets = new LinkedHashSet<>();
        destPackets = new HashMap<>();
    }

    public void removeFromMap(int destination) {
        ArrayList<Integer> temp = destPackets.get(destination);
        temp.removeFirst();
        destPackets.put(destination, temp);
    }

    public void addInMap(int destination, int timestamp) {
        ArrayList<Integer> temp = destPackets.getOrDefault(destination, new ArrayList<>());
        temp.addLast(timestamp);
        destPackets.put(destination, temp);
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        List<Integer> packet = Arrays.asList(source, destination, timestamp);

        if (packets.contains(packet)) {
            return false;
        }

        if (packets.size() == sz) {
            List<Integer> removed = packets.getFirst();
            packets.removeFirst();
            removeFromMap(removed.get(1));
        }

        packets.add(packet);
        addInMap(destination, timestamp);
        return true;
    }

    public int[] forwardPacket() {
        if (packets.isEmpty()) return new int[]{};

        List<Integer> removed = packets.getFirst();
        packets.removeFirst();
        removeFromMap(removed.get(1));

        return new int[]{removed.get(0), removed.get(1), removed.get(2)};
    }

    public int getIndex(ArrayList<Integer> arr, int key) {
        int l = 0;
        int r = arr.size() - 1;
        int ans = arr.size(); // default: insert at end if all elements < key

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr.get(mid) >= key) {
                ans = mid;   // candidate position
                r = mid - 1; // search left
            } else {
                l = mid + 1; // search right
            }
        }

        return ans;
    }

    public int upperBound(ArrayList<Integer> arr, int key) {
        int l = 0, r = arr.size() - 1;
        int ans = arr.size(); // default = insert at end

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr.get(mid) > key) {
                ans = mid;   // candidate position
                r = mid - 1; // search left
            } else {
                l = mid + 1; // search right
            }
        }
        return ans;
    }

    public int getCount(int destination, int startTime, int endTime) {
        if(!destPackets.containsKey(destination)) return 0;
        ArrayList<Integer> temp = destPackets.get(destination);
        if(temp.isEmpty()) return 0;
        int startI = getIndex(temp, startTime);
        int endI = upperBound(temp, endTime);

        return endI - startI;
    }
}
