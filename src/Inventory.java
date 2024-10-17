/**
 * Represents an inventory system for managing ingredients.
 * Allows adding ingredients, checking quantities, and using ingredients for recipes.
 */
public class Inventory {
    private Ingredient[] ingredients;
    private int ingredientCount;

    /**
     * Constructs an Inventory with a specified maximum capacity for ingredients.
     *
     * @param maxIngredients the maximum number of ingredients the inventory can hold
     */
    public Inventory(int maxIngredients) {
        ingredients = new Ingredient[maxIngredients];
        ingredientCount = 0;
    }


    /**
     * Adds an ingredient to the inventory. If the ingredient already exists,
     * increases its quantity. If the inventory is full, the ingredient is not added.
     *
     * @param ingredient the ingredient to be added to the inventory
     */
    public void addIngredientToInventory(Ingredient ingredient) {
        if (!inventoryIsFull()) {
            for (int i = 0; i < ingredientCount; i++) {
                if (ingredientIsInInventory(i, ingredient)) {
                    increaseIngredientInInventory(i, ingredient);
                    System.out.println("Updated quantity of " + ingredient.getName());
                    return;
                }
            }
            ingredients[ingredientCount++] = ingredient;
            System.out.println("Added " + ingredient.getName() + " to inventory.");
        } else {
            System.out.println("Inventory is full, cannot add more ingredients.");
        }
    }

    /**
     * Uses the specified ingredients for a recipe and adjusts the inventory quantities.
     *
     * @param recipe the recipe requiring ingredients
     * @param servings the number of servings for the recipe
     * @return true if the ingredients were successfully used, false if not enough ingredients were available
     */
    public boolean useIngredientsForRecipe(Recipe recipe, int servings) {
        if (!hasEnoughIngredients(recipe, servings)) {
            return false;
        }
        for (Ingredient needed : recipe.getIngredients()) {
            double requiredAmount = calculateRequiredAmount(needed, servings);
            for (int i = 0; i < ingredientCount; i++) {
                Ingredient available = ingredients[i];
                if (available.getName().equals(needed.getName())) {
                    subtractNeededIngredientsFromInventory(available, requiredAmount);
                }
            }
        }
        return true;
    }

    /**
     * Displays the current ingredients in the inventory along with their quantities.
     */
    public void showIngredientsInInventory() {
        System.out.println("Current Inventory:");
        for (int i = 0; i < ingredientCount; i++) {
            Ingredient ingredient = ingredients[i];
            System.out.println("- " + ingredient.getName() + ": " + ingredient.getQuantity());
        }
    }

    /**
     * Subtracts the required amount of an ingredient from the available quantity in the inventory.
     *
     * @param available the ingredient in the inventory
     * @param requiredAmount the amount to subtract
     */
    public void subtractNeededIngredientsFromInventory(Ingredient available, double requiredAmount) {
        available.setQuantity(available.getQuantity() - requiredAmount);
    }

    /**
     * Calculates the required quantity of an ingredient for the specified number of servings.
     *
     * @param needed the ingredient required for the recipe
     * @param servings the number of servings for the recipe
     * @return the total required amount of the ingredient
     */
    public double calculateRequiredAmount(Ingredient needed, int servings) {
        return needed.getQuantity() * servings;
    }

    /**
     * Checks if the inventory has enough ingredients for a given recipe and number of servings.
     *
     * @param recipe the recipe to be prepared
     * @param servings the number of servings for the recipe
     * @return true if the inventory has enough ingredients, false otherwise
     */
    public boolean hasEnoughIngredients(Recipe recipe, int servings) {
        for (Ingredient needed : recipe.getIngredients()) {
            double requiredAmount = calculateRequiredAmount(needed, servings);
            if (!isIngredientInInventoryAndSufficient(needed, requiredAmount)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if an ingredient is in the inventory with a sufficient quantity.
     *
     * @param needed the ingredient to check
     * @param requiredAmount the required amount of the ingredient
     * @return true if the ingredient is available in sufficient quantity, false otherwise
     */
    public boolean isIngredientInInventoryAndSufficient(Ingredient needed, double requiredAmount) {
        for (int i = 0; i < ingredientCount; i++) {
            Ingredient available = ingredients[i];
            if (available.getName().equals(needed.getName()) && available.getQuantity() >= requiredAmount) {
                return true;
            }
        }
        return false;
    }

    /**
     * Increases the quantity of an existing ingredient in the inventory.
     *
     * @param iterator the index of the ingredient in the array
     * @param ingredient the ingredient whose quantity is to be increased
     */
    public void increaseIngredientInInventory(int iterator, Ingredient ingredient) {
        ingredients[iterator].setQuantity(ingredients[iterator].getQuantity() + ingredient.getQuantity());
    }

    /**
     * Checks if an ingredient is already present in the inventory.
     *
     * @param iterator the index of the ingredient in the array
     * @param ingredient the ingredient to check
     * @return true if the ingredient is already in the inventory, false otherwise
     */
    public boolean ingredientIsInInventory(int iterator, Ingredient ingredient) {
        return ingredients[iterator].getName().equals(ingredient.getName());
    }

    /**
     * Checks if the inventory is full.
     *
     * @return true if the inventory has reached its maximum capacity, false otherwise
     */
    public boolean inventoryIsFull() {
        return ingredientCount >= ingredients.length;
    }
}
