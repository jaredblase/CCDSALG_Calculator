public class Infix {
    public static String toPostfix(String expression) {
        expression = processExpression(expression);
        String[] tokens = expression.split("\\s+");  // tokenize string with space as key

        Stack opStack = new Stack();
        Queue postfix = new Queue();

        for(String i: tokens) {
            if(i.matches("[\\d]+")) {
                postfix.enqueue(i);                       // add number to queue
            } else if(i.equals("(")) {                    // if left parenthesis
                opStack.push(i);
            } else if(i.equals(")")) {                    // if right parenthesis
                try {
                    while(!opStack.topElem().equals("(")) {
                        postfix.enqueue(opStack.pop());     // enqueue until left bracket found
                    }
                    opStack.pop();                          // discard left bracket from stack
                } catch(Exception e) {
                    System.out.println("No left parenthesis found!");
                }
            } else {
                while(!opStack.isEmpty() && test(opStack.topElem(), i)) {
                    postfix.enqueue(opStack.pop());
                }
                opStack.push(i);
            }
        }

        while(!opStack.isEmpty()) {
            postfix.enqueue(opStack.pop());                     // pop the rest from the stack
        }
        return outputPostfix(postfix);
    }

    private static String processExpression(String expression) {
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

        return expression.trim(); // clean out excess spaces before and after the string
    }

    private static boolean test(String a, String b) {
        int levelA = getPrecedenceLevel(a);
        int levelB = getPrecedenceLevel(b);

        return !a.equals("(") && (levelA > levelB || levelA == levelB && !b.equals("^"));
    }

    private static int getPrecedenceLevel(String c) {
        int n = 0;

        // follows the C and Java operator precedence.
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

    private static String outputPostfix(Queue expression) {
        StringBuilder postfix = new StringBuilder();

        while(!expression.isEmpty()) {
            postfix.append(expression.dequeue());
            postfix.append(" ");
        }

        return postfix.toString();
    }
}
