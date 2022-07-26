package contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodRatings {
    private String[] foods;
    private String[] cuisines;
    private int[] ratings;
    private Map<String, Integer> maxRating = new HashMap<>();
    private Map<String, List<String>> maxRatingFoods = new HashMap<>();
    private Map<String, Integer> foodIndex = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;
        String food, cuisine;
        int rating;
    
        for (int i = 0; i < cuisines.length; i++) {
            food = foods[i];
            cuisine = cuisines[i];
            rating = ratings[i];
            foodIndex.put(food, i);
            if (maxRating.containsKey(cuisine)) {
                if (rating > maxRating.get(cuisine)) {
                    maxRating.put(cuisine, rating);
                    List<String> foodNames = new ArrayList<>();
                    foodNames.add(food);
                    maxRatingFoods.put(cuisine, foodNames);
                } else if (rating == maxRating.get(cuisine)) {
                    maxRatingFoods.get(cuisine).add(food);
                }
            } else {
                maxRating.put(cuisine, rating);
                List<String> foodNames = new ArrayList<>();
                foodNames.add(food);
                maxRatingFoods.put(cuisine, foodNames);
            }
        }

        maxRatingFoods.forEach((key, value) -> Collections.sort(value));
    }
    
    public void changeRating(String food, int newRating) {
        int index = foodIndex.get(food);
        String cuisine = cuisines[index];
        int rating = ratings[index];
        int cuisineMaxRating = maxRating.get(cuisine);
        ratings[index] = newRating;

        if (newRating > cuisineMaxRating) {
            maxRating.put(cuisine, newRating);
            List<String> foodNames = new ArrayList<>();
            foodNames.add(food);
            maxRatingFoods.put(cuisine, foodNames);
        }

        if (newRating > rating && newRating == cuisineMaxRating) {
            maxRatingFoods.get(cuisine).add(food);
        } 

        if (rating == cuisineMaxRating && newRating < rating) {
            maxRating.put(cuisine, Integer.MIN_VALUE);
            maxRatingFoods.put(cuisine, new ArrayList<>());
            for (int i = 0; i < cuisines.length; i++) {
                if (cuisines[i] != cuisine) {
                    continue;
                }
                food = foods[i];
                cuisine = cuisines[i];
                rating = ratings[i];
                if (rating > maxRating.get(cuisine)) {
                    maxRating.put(cuisine, rating);
                    List<String> foodNames = new ArrayList<>();
                    foodNames.add(food);
                    maxRatingFoods.put(cuisine, foodNames);
                } else if (rating == maxRating.get(cuisine)) {
                    maxRatingFoods.get(cuisine).add(food);
                }
            }
        }

        maxRatingFoods.forEach((key, value) -> System.out.println(key + ": " + value));
        Collections.sort(maxRatingFoods.get(cuisine));
    }
    
    public String highestRated(String cuisine) {
        return maxRatingFoods.get(cuisine).get(0);
    }

    public static void main(String[] args) {
        String[] foods = new String[]{"czopaaeyl","lxoozsbh","kbaxapl"};
        String[] cuisines = new String[]{"dmnuqeatj","dmnuqeatj","dmnuqeatj"};
        int[] ratings = new int[]{11,2,15};

        FoodRatings foodRatings = new FoodRatings(foods, cuisines, ratings);
        foodRatings.changeRating("czopaaeyl", 12);
        System.out.println(foodRatings.highestRated("dmnuqeatj"));
        foodRatings.changeRating("kbaxapl", 8);
        foodRatings.changeRating("lxoozsbh", 5);
        System.out.println(foodRatings.highestRated("dmnuqeatj"));

        System.out.println();
    }
}
