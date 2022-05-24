package machine;


public class Machine {

    private  int water = 400;
    private  int milk = 540;
    private  int beans = 120;
    private  int cups = 9;
    private  int money = 550;

    private MachineState machineState = MachineState.IDLE;

    public void method (String userLine) {
        switch (machineState) {
            case IDLE:
                machineState = MachineState.valueOf(userLine.toUpperCase());
                if (machineState.equals(MachineState.REMAINING)){
                    printState();
                    machineState = MachineState.IDLE;
                } else if (machineState.equals(MachineState.BUY)) {
                    machineState = MachineState.CHOOSE_TYPE;
                } else if (machineState.equals(MachineState.FILL)) {
                    machineState = MachineState.FILLING_WATER;
                } else if (machineState.equals(MachineState.TAKE)) {
                    System.out.println("I gave you $" + money);
                    money = 0;
                    machineState = MachineState.IDLE;
                }
                break;
            case CHOOSE_TYPE:
                if ("back".equalsIgnoreCase(userLine)) {
                    machineState = MachineState.IDLE;
                    break;
                }
                if (canCoffeeBeMade(userLine)) {
                    System.out.println("I have enough resources, making you a coffee!");
                    makeCoffee(userLine);
                }
                machineState = MachineState.IDLE;
                break;
            case FILLING_WATER:
                water += Integer.parseInt(userLine);
                machineState = MachineState.FILLING_MILK;
                break;
            case FILLING_MILK:
                milk += Integer.parseInt(userLine);
                machineState = MachineState.FILLING_BEANS;
                break;
            case FILLING_BEANS:
                beans += Integer.parseInt(userLine);
                machineState = MachineState.FILLING_CUPS;
                break;
            case FILLING_CUPS:
                cups += Integer.parseInt(userLine);
                machineState = MachineState.IDLE;
                break;
            case TAKE:

                break;
        }
        System.out.println(machineState.message);
    }

    private boolean canCoffeeBeMade(String type) {
        CoffeeType coffeeType = CoffeeType.getById(Integer.parseInt(type));
        if (water < coffeeType.water){
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (milk < coffeeType.milk) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (beans < coffeeType.beans) {
            System.out.println("Sorry, not enough beans!");
            return false;
        }
        if (cups <= 0) {
            System.out.println("Sorry, not enough cups!");
            return false;
        }
        return true;
    }

    private void makeCoffee(String type) {
        CoffeeType coffeeType = CoffeeType.getById(Integer.parseInt(type));
        water -= coffeeType.water;
        beans -= coffeeType.beans;
        milk -= coffeeType.milk;
        cups --;
        money += coffeeType.cost;
    }

    private void printState() {
        System.out.print("The coffee machine has:\n" +
                "" + water + " ml of water\n" +
                "" + milk + " ml of milk\n" +
                "" + beans + " g of coffee beans\n" +
                "" + cups + " disposable cups\n" +
                "$" + money + " of money\n");

    }
}
