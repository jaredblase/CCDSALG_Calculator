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
                str = Infix.toPostfix(str);                 // convert infix to postfix expression
                System.out.println(str);                      // show converted
                System.out.println(Postfix.evaluate(str));    // output the evaluated postfix expression
                System.out.println();
            } catch (ArithmeticException e) {
                System.out.println("Error! Division by 0!");
            } catch (Exception e) {
                System.out.println(e.toString());
                System.out.println();
            }

            str = input.nextLine();
        }

        System.out.println("Terminating calculator...");
    }
}
