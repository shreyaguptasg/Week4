package Day1.PersonalizedMealPlanGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//Interface representing meal plan
interface MealPlan{
    String getMealDetails();
}

//Different meal types implementing MealPlan
class VegertarianMeal implements MealPlan{
    public String getMealDetails(){
        return "Vegetarian Meal : Grilled Vegetables";
    }
}

class VeganMeal implements MealPlan{
    public String getMealDetails(){
        return "Vegan Meal : Avacado Toast with Humus";
    }
}

class KetonMeal implements MealPlan{
    public String getMealDetails(){
        return "Keto Meal : Grilled Chicken with Avacodo Salad";
    }
}

class HighProteinMeal implements MealPlan{
    public String getMealDetails(){
        return "High Protein Meal : Broccoli";
    }
}

//Generic Meal class with bounded type parameter
class Meal<T extends MealPlan>{
    private List<T> meals = new ArrayList<>();

    public void addMeals(T meal){
        meals.add(meal);
    }

    public List<T> getMeals(){
        return meals;
    }
}

//Utlity class to test teh implememtation
class MealPlanUtil{
    public static<T extends MealPlan> void generateMealPlan(T meal){
        System.out.println("Generated Meal Plan : " + meal.getMealDetails());
    }
}
public class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {
        Meal<VegertarianMeal> vegertarianMeal= new Meal<>();
        vegertarianMeal.addMeals(new VegertarianMeal());

        Meal<VeganMeal> veganMeal = new Meal<>();
        veganMeal.addMeals(new VeganMeal());

        Meal<KetonMeal> ketonMeal = new Meal<>();
        ketonMeal.addMeals(new KetonMeal());

        Meal<HighProteinMeal> highProteinMeal = new Meal<>();
        highProteinMeal.addMeals(new HighProteinMeal());

        System.out.println("Personalized Meal Plans : ");
        for(VegertarianMeal meal : vegertarianMeal.getMeals()){
            MealPlanUtil.generateMealPlan(meal);
        }
        for(VeganMeal meal : veganMeal.getMeals()){
            MealPlanUtil.generateMealPlan(meal);
        }
        for(KetonMeal meal : ketonMeal.getMeals()){
            MealPlanUtil.generateMealPlan(meal);
        }
        for(HighProteinMeal meal : highProteinMeal.getMeals()){
            MealPlanUtil.generateMealPlan(meal);
        }

    }
}
