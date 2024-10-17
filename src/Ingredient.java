/**
 * Represents an ingredient used in a recipe with a specific quantity.
 * The ingredient has a name and a quantity associated with it.
 */

public class Ingredient {
    private String name;
    private double quantity;

    public Ingredient(String name, double quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
