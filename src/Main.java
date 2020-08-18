import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Calculator 101");

        try (Scanner file = new Scanner(new File("infix.txt"))) {
            String input;

            input = file.nextLine(); // read a line from the text file
            while (!input.equals("QUIT")) {

                System.out.println(input);                      // show input
                input = Infix.toPostfix(input);                 // convert infix to postfix expression
                System.out.println(input);                      // show converted
                System.out.println(Postfix.evaluate(input));    // output the evaluated postfix expression
                System.out.println();

                input = file.nextLine();                        // read next line from the text file
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Terminating calculator...");
    }
}
