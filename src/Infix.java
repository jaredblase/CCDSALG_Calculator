public class Infix {
    /**
     * Converts an infix expression to postfix
     * @param expression the infix expression to be converted
     * @return the postfix equivalent of the parameter
     */
    public static Queue toPostfix(String expression) throws Exception {
        String[] tokens = tokenizeExpression(expression);   // get tokens
        Stack opStack = new Stack();
        Queue postfix = new Queue();

        for (String i : tokens) {
            if (i.matches("[\\d]+")) {
                postfix.enqueue(i);                         // add number to queue
            } else if (i.equals("(")) {                      // if left parenthesis
                opStack.push(i);
            } else if (i.equals(")")) {                      // if right parenthesis
                try {
                    while (!opStack.top().equals("(")) {
                        postfix.enqueue(opStack.pop());     // enqueue until left bracket found
                    }
                    opStack.pop();                          // discard left bracket from stack
                } catch (Exception e) {
                    throw new Exception("No matching left parenthesis found!");
                }
            } else {
                while (!opStack.isEmpty() && test(opStack.top(), i)) {
                    postfix.enqueue(opStack.pop());
                }
                opStack.push(i);
            }
        }

        while (!opStack.isEmpty()) {                        // pop the rest from the stack
            if(opStack.top().equals("(")) {
                throw new Exception("No matching right parenthesis found!");
            }
            postfix.enqueue(opStack.pop());
        }

        return postfix;
    }

    /**
     * Splits the expression to tokens of operands and operators
     * @param expression the expression to be converted
     * @return a String array containing the tokens
     */
    private static String[] tokenizeExpression(String expression) {
        // put spaces in between operators to separate them from operands and other operators
        expression = expression.replaceAll("!", " ! ");
        expression = expression.replaceAll(" ! =", " != ");
        expression = expression.replaceAll("[(]", " ( ");
        expression = expression.replaceAll("[)]", " ) ");
        expression = expression.replaceAll("\\^", " ^ ");
        expression = expression.replaceAll("\\*", " * ");
        expression = expression.replaceAll("/", " / ");
        expression = expression.replaceAll("%", " / ");
        expression = expression.replaceAll("\\+", " + ");
        expression = expression.replaceAll("-", " - ");
        expression = expression.replaceAll("<", " < ");
        expression = expression.replaceAll(">", " > ");
        expression = expression.replaceAll(" < =", " <= ");
        expression = expression.replaceAll(" > =", " >= ");
        expression = expression.replaceAll("==", " == ");
        expression = expression.replaceAll("[|]{2}", " || ");
        expression = expression.replaceAll("[&]{2}", " && ");

        // trims extra whitespaces before and after the String and tokenizes string with space as key
        return expression.trim().split("\\s+");
    }

    /**
     * Evaluates whether an operator from the stack will be popped.
     * @param a the operator at the top of the stack
     * @param b the operator to be pushed into the stack
     * @return true if
     */
    private static boolean test(String a, String b) {
        int levelA = getPrecedenceLevel(a);
        int levelB = getPrecedenceLevel(b);
                                                                        // right association exemption
        return !a.equals("(") && (levelA > levelB || levelA == levelB && !b.equals("^"));
    }

    /**
     * Evaluates the precedence level of an operator. The higher the number,
     * the higher its precedence level.
     * Precondition: This follows the hierarchy of operation of C and Java.
     * @param c the operator symbol.
     * @return the operator precedence level.
     */
    private static int getPrecedenceLevel(String c) {
        int n = 0;

        switch(c) {
            case "!":
                n++;
            case "^":
                n++;
            case "*", "/", "%":
                n++;
            case "+", "-":
                n++;
            case ">", "<", "<=", ">=":
                n++;
            case "==", "!=":
                n++;
            case "&&":
                n++;
            case "||":
                n++;
        }

        return n;
    }
}
