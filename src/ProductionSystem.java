/**
 * Represents a production system for creating batches of beverages.
 * The system uses an inventory of ingredients and a library of recipes
 * to produce specific beverages in desired quantities.
 */
public class ProductionSystem {
    private Inventory inventory;
    private RecipeLibrary recipeLibrary;

    /**
     * Constructs a ProductionSystem with the specified inventory and recipe library.
     *
     * @param inventory the inventory of ingredients available for production
     * @param recipeLibrary the library of recipes available for production
     */
    public ProductionSystem(Inventory inventory, RecipeLibrary recipeLibrary) {
        this.inventory = inventory;
        this.recipeLibrary = recipeLibrary;
    }

    /**
     * Attempts to make a specified number of servings of a beverage.
     * Checks if the inventory has sufficient ingredients as per the recipe
     * and updates the inventory accordingly.
     *
     * @param beverageName the name of the beverage to be produced
     * @param servings the number of servings to produce
     */
    public void makeBatch(String beverageName, int servings) {
        Recipe recipe = recipeLibrary.getRecipe(beverageName);

        System.out.println("Attempting to make " + servings + " servings of " + beverageName);
        if (inventory.useIngredientsForRecipe(recipe, servings)) {
            System.out.println("Batch of " + beverageName + " created successfully.");
        } else {
            System.out.println("Failed to create batch: Not enough ingredients.");
        }
    }

    /**
     * Bottles the produced batch and marks the container as dirty.
     * This method simulates the bottling process after a successful production.
     */
    public void bottleBatch() {
        System.out.println("Batch bottled. Container marked as dirty.");
    }



    /**
     * Cleans the production container.
     * This method simulates the cleaning process to prepare the container for the next batch.
     */
    public void cleanContainer() {
        System.out.println("Container cleaned.");
    }
}
