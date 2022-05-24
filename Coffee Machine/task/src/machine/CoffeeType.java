package machine;

public enum CoffeeType {

    ESPRESSO(1, 250, 0, 16, 4),
    LATTE(2, 350, 75, 20, 7),
    CAPPUCINO(3, 200, 100, 12, 6);

    public final int identifier;
    public final int water;
    public final int milk;
    public final int beans;
    public final int cost;

    public static CoffeeType getById(int id) {
        for (CoffeeType coffeeType : CoffeeType.values()) {
            if (coffeeType.identifier == id) return coffeeType;
        }
        return CoffeeType.ESPRESSO;
    }

    CoffeeType(int identifier, int water, int milk, int beans, int cost) {
        this.identifier = identifier;
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cost = cost;
    }
}
