import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str;
        System.out.println("Calculator 101");

        str = input.nextLine();
        while (!str.equals("QUIT")) {
            System.out.println(str);
            try {
                Queue tokens = Infix.toPostfix(str);         // convert infix to postfix expression
                for(String t : tokens) {                     // display elements in the queue
                    System.out.print(t + " ");
                }
                System.out.println();
                System.out.println(Postfix.evaluate(tokens));    // output the evaluated postfix expression
            } catch (ArithmeticException e) {
                System.out.println("Division by zero error!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println();

            str = input.nextLine();
        }

        System.out.println("Terminating calculator...");
    }
}
