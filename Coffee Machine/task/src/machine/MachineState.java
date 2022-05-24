package machine;

public enum MachineState {
    BUY(""),
    FILL(""),
    TAKE(""),
    CHOOSE_TYPE("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: "),
    FILLING_WATER("Write how many ml of water you want to add: "),
    FILLING_CUPS("Write how many disposable cups of coffee you want to add"),
    FILLING_BEANS("Write how many grams of coffee beans you want to add"),
    FILLING_MILK("Write how many ml of milk you want to add: "),
    REMAINING(""),
    IDLE("Write action (buy, fill, take, remaining, exit): ");

    public final String message;

    MachineState(String message) {
        this.message = message;
    }
}
