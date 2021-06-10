package stringaddcalculator.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public String input() {
        System.out.print("입력 : ");
        return scanner.nextLine();
    }

}
