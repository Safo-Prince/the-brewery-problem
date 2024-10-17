/**
 * Represents a recipe for creating a beverage.
 * A recipe includes the beverage name, the ingredients required,
 * the number of ingredients, and the number of bottles produced.
 */
public class Recipe {
    private String beverageName;
    private Ingredient[] ingredients;
    private int ingredientCount;
    private int bottlesProduced;

    /**
     * Constructs a Recipe with the specified beverage name, maximum number of ingredients,
     * and the number of bottles produced.
     *
     * @param beverageName the name of the beverage
     * @param maxIngredients the maximum number of ingredients in the recipe
     * @param bottlesProduced the number of bottles produced from this recipe
     */
    public Recipe(String beverageName, int maxIngredients, int bottlesProduced) {
        this.beverageName = beverageName;
        this.ingredients = new Ingredient[maxIngredients];
        this.ingredientCount = 0;
        this.bottlesProduced = bottlesProduced;
    }

    /**
     * Adds an ingredient to the recipe.
     * If the recipe has reached the maximum number of ingredients,
     * the ingredient will not be added.
     *
     * @param ingredient the ingredient to be added to the recipe
     */
    public void addIngredientToRecipe(Ingredient ingredient) {
        if (ingredientCount < ingredients.length) {
            ingredients[ingredientCount++] = ingredient;
        } else {
            System.out.println("Cannot add more ingredients to the recipe!");
        }
    }

    /**
     * Returns an array of non-null ingredients currently in the recipe.
     *
     * @return an array of non-null ingredients
     */
    public Ingredient[] getIngredients() {
        Ingredient[] nonNullIngredientsIndexes = new Ingredient[ingredientCount];
        int index = 0;

        for (int i = 0; i < ingredientCount; i++) {
            Ingredient ingredient = ingredients[i];
            if (ingredient != null) {
                nonNullIngredientsIndexes[index++] = ingredient;
            }
        }

        return retrieveNonNullIngredients(nonNullIngredientsIndexes, index);
    }

    /**
     * Retrieves an array containing only the non-null ingredients.
     *
     * @param ingredients an array containing ingredients with potential null values
     * @param index the number of non-null ingredients in the array
     * @return an array containing only non-null ingredients
     */
    public Ingredient[] retrieveNonNullIngredients(Ingredient[] ingredients, int index) {
        Ingredient[] result = new Ingredient[index];
        for (int i = 0; i < index; i++) {
            result[i] = ingredients[i];
        }
        return result;
    }

    /**
     * Returns the name of the beverage for this recipe.
     *
     * @return the name of the beverage
     */
    public String getBeverageName() {
        return beverageName;
    }
}
