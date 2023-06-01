// Sort the cars based on descending order of position
// Calculate the time at which they will reach the target if it is equal it becomes part of fleet.

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Double> cars = new TreeMap(Collections.reverseOrder());
        for(int i = 0;i < position.length;i++) {
            cars.put(position[i], (double)speed[i]);
        }

        Stack<Integer> fleet = new Stack<>();
        for(var car: cars.entrySet()) {
            if(fleet.empty()) {
                fleet.push(car.getKey());
                continue;
            }

            double fleetTime = (target - fleet.peek()) / cars.get(fleet.peek());
            double currCarTime = (target - car.getKey()) / car.getValue();

            if(fleetTime < currCarTime) {
                fleet.push(car.getKey());
            }
        }

        return fleet.size();
    }
}
