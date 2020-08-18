public class Infix {
    public static String toPostfix(String expression) {
        Stack opStack = new Stack();
        StringBuilder postfix = new StringBuilder();

        // No concept of hierarchy yet
        for(char i: expression.toCharArray()) {
            if(Character.isDigit(i)) {
                postfix.append(i);
            } else {
                postfix.append(" ");
                opStack.push(i);
            }
        }

        while(!opStack.isEmpty()) {
            postfix.append(" ");
            postfix.append(opStack.pop());
        }

        return postfix.toString();
    }
}
