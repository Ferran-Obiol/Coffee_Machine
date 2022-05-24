package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {

        Machine coffeeMachine = new Machine();
        Scanner scanner = new Scanner(System.in);
        String input = "idle";
        while (!"exit".equals(input)) {
            coffeeMachine.method(input);
            input = scanner.nextLine();
        }
    }
}
