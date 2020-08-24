import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Calculator 101");

        try (Scanner file = new Scanner(new File("TESTCASE.txt"))) {
            String input;

            input = file.nextLine();                                // read a line from the text file
            while (!input.equals("QUIT")) {

                System.out.println(input);                          // show input
                try {
                    input = Infix.toPostfix(input);                 // convert infix to postfix expression
                    System.out.println(input);                      // show converted
                    System.out.println(Postfix.evaluate(input));    // output the evaluated postfix expression
                    System.out.println();
                } catch (ArithmeticException e) {
                    System.out.println("Error! Division by 0!");
                } catch (Exception e) {
                    System.out.println(e.toString());
                    System.out.println();
                }

                input = file.nextLine();                        // read next line from the text file
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

        System.out.println("Terminating calculator...");
    }
}
