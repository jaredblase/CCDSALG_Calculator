public class Postfix {
    /**
     * Evaluates a postfix expression
     * @param exp the String postfix expression
     * @return the evaluated number as a String
     */
    public static String evaluate(String exp) throws Exception {
        Stack stack = new Stack();
        String[] tokens = exp.split("\\s+");                  // split into tokens

        for(String s: tokens) {
            if (s.matches("[\\d]+"))                          // if it is a number
                stack.push(s);                                      // push it to stack
            else {
                int y = Integer.parseInt(stack.pop());              // pop a number

                if (s.equals("!")) {                                // if unary operator
                    stack.push(Integer.toString((y == 0)? 1 : 0));
                } else {
                    int x = Integer.parseInt(stack.pop());          // pop another operator
                    stack.push(compute(x, y, s));
                }
            }
        }
        return stack.pop();
    }

    /**
     * Computes an expression based on given two operands and an operator.
     * @param x the first operand.
     * @param y the second operand.
     * @param operator the operator.
     * @return the computed value as a String.
     * @throws ArithmeticException if division by 0 occurs.
     * @throws IllegalStateException if an undefined operator is encountered.
     */
    private static String compute(int x, int y, String operator) throws Exception {
        return Integer.toString(switch(operator) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            case "/" -> x /y;
            case "%" -> x % y;
            case "^" -> (int) Math.pow(x, y);
            default -> computeBool(x, y, operator)? 1 : 0;
        });
    }

    /**
     * Special method for computing logical and relational operators
     * @param x the first operand.
     * @param y the second operand.
     * @param operator the operator.
     * @return the boolean result.
     * @throws IllegalStateException if an undefined operator is encountered.
     */
    private static boolean computeBool(int x, int y, String operator) throws IllegalStateException {
        return switch (operator) {
            case "!=" -> x != y;
            case ">" -> x > y;
            case "<" -> x < y;
            case ">=" -> x >= y;
            case "<=" -> x <= y;
            case "==" -> x == y;
            case "||" -> x == 0 && y == 0;
            case "&&" -> x == 0 || y == 0;
            default -> throw new IllegalStateException("Undefined operator encountered: " + operator);
        };
    }
}
