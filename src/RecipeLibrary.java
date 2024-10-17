/**
 * Represents a library for storing and managing recipes.
 * Allows adding recipes to the library and retrieving them by beverage name.
 */
public class RecipeLibrary {
    private Recipe[] recipes;
    private int recipeCount;

    /**
     * Constructs a RecipeLibrary with a specified maximum capacity for recipes.
     *
     * @param maxRecipes the maximum number of recipes the library can hold
     */
    public RecipeLibrary(int maxRecipes) {
        recipes = new Recipe[maxRecipes];
        recipeCount = 0;
    }

    /**
     * Adds a recipe to the library. If the library is full, the recipe is not added.
     *
     * @param recipe the recipe to be added to the library
     */
    public void addRecipe(Recipe recipe) {
        if (!isRecipeLibraryFull()) {
            recipes[recipeCount++] = recipe;
            System.out.println("Added recipe for " + recipe.getBeverageName() + " to the library.");
        } else {
            System.out.println("Recipe library is full!");
        }
    }

    /**
     * Checks if the recipe library has reached its maximum capacity.
     *
     * @return true if the recipe library is full, false otherwise
     */
    public boolean isRecipeLibraryFull() {
        return recipeCount >= recipes.length;
    }

    /**
     * Retrieves a recipe from the library by the beverage name.
     *
     * @param beverageName the name of the beverage for which the recipe is needed
     * @return the Recipe if found, or null if the recipe is not in the library
     */
    public Recipe getRecipe(String beverageName) {
        for (int i = 0; i < recipeCount; i++) {
            if (recipes[i].getBeverageName().equals(beverageName)) {
                return recipes[i];
            }
        }
        return null; // Recipe not found
    }
}
