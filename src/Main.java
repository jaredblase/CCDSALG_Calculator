import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Calculator 101");

        try (Scanner file = new Scanner(new File("infix.txt"))) {
            String input;

            do {
                input = file.nextLine();                        // read a line from the text file

                input = Infix.toPostfix(input);                 // convert input to postfix expression
                System.out.println(input);
                System.out.println(Postfix.evaluate(input));    // output the evaluated postfix expression
            } while (!input.equals("QUIT"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Terminating calculator...");
    }
}
