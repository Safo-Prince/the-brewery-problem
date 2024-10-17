import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory(100);
        RecipeLibrary recipeLibrary = new RecipeLibrary(50);
        ProductionSystem productionSystem = new ProductionSystem(inventory, recipeLibrary);

        // Add initial ingredients
        inventory.addIngredientToInventory(new Ingredient("Water", 100.0));
        inventory.addIngredientToInventory(new Ingredient("Malt", 50.0));
        inventory.addIngredientToInventory(new Ingredient("Hops", 20.0));
        inventory.addIngredientToInventory(new Ingredient("Yeast", 10.0));
        inventory.showIngredientsInInventory();

        // Create a new recipe
        Recipe beerRecipe = new Recipe("Beer", 5, 100);
        beerRecipe.addIngredientToRecipe(new Ingredient("Water", 0.5));
        beerRecipe.addIngredientToRecipe(new Ingredient("Malt", 0.2));
        beerRecipe.addIngredientToRecipe(new Ingredient("Hops", 0.05));
        beerRecipe.addIngredientToRecipe(new Ingredient("Yeast", 0.01));
        recipeLibrary.addRecipe(beerRecipe);

        // Make a batch of Beer
        System.out.println("\nEnter the number of servings to make a batch:");
        int servings = scanner.nextInt();
        productionSystem.makeBatch("Beer", servings);

        // Bottle the batch and clean the container
        productionSystem.bottleBatch();
        productionSystem.cleanContainer();

        // Display updated inventory
        inventory.showIngredientsInInventory();
        scanner.close();
    }
}