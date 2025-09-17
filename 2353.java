import java.util.*;

class FoodRatings {
    class Food {
        String name;
        int rating;
        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
    }

    HashMap<String, String> fc; // food → cuisine
    HashMap<String, Food> fr;   // food → Food object (for updates)
    HashMap<String, TreeSet<Food>> cf; // cuisine → ordered set of foods

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        fc = new HashMap<>();
        fr = new HashMap<>();
        cf = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            fc.put(food, cuisine);

            Food f = new Food(food, rating);
            fr.put(food, f);

            cf.computeIfAbsent(cuisine, k -> new TreeSet<>(
                (a, b) -> a.rating != b.rating ? b.rating - a.rating : a.name.compareTo(b.name)
            ));

            cf.get(cuisine).add(f);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = fc.get(food);
        Food f = fr.get(food);

        // remove old entry
        cf.get(cuisine).remove(f);

        // update rating
        f.rating = newRating;

        // re-insert
        cf.get(cuisine).add(f);
    }

    public String highestRated(String cuisine) {
        return cf.get(cuisine).first().name;
    }
}
