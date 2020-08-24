public class Postfix {
    public static int evaluate(String exp) {
        int x = 0, y = 0, eval = 0;
        Stack stack = new Stack();
        String[] tokens = exp.split("\\s+");

        for(String s: tokens) {
            if(s.matches("[\\d]+"))
                stack.push(s);
            else {
                y = Integer.parseInt(stack.pop());
                x = Integer.parseInt(stack.pop());

                if(s.equals("+"))
                    eval = x + y;
                else if(s.equals("-"))
                    eval = x - y;
                else if(s.equals("*"))
                    eval = x * y;
                else if(s.equals("/"))
                    eval = x / y;
                else if(s.equals("%"))
                    eval = x % y;
                else if(s.equals("^"))
                    eval = (int) Math.pow(x, y);
                else if(s.equals("!")) {
                    if(x == 0)
                        eval = 0;
                    else
                        eval = 1;
                }
                else if(s.equals("!=")) {
                    if(x / y == 1)
                        eval = 0;
                    else
                        eval = 1;
                }
                else if(s.equals(">")) {
                    if(x > y)
                        eval = 1;
                    else
                        eval = 0;
                }
                else if(s.equals("<")) {
                    if(x < y)
                        eval = 1;
                    else
                        eval = 0;
                }
                else if(s.equals(">=")) {
                    if(x >= y)
                        eval = 1;
                    else
                        eval = 0;
                }
                else if(s.equals("<=")) {
                    if(x <= y)
                        eval = 1;
                    else
                        eval = 0;
                }
                else if(s.equals("==")) {
                    if(x == y)
                        eval = 1;
                    else
                        eval = 0;
                }
                else if(s.equals("||")) {
                    if(x == 0 && y == 0)
                        eval = 0;
                    else
                        eval = 1;
                }
                else if(s.equals("&&")) {
                    if (x >= 1 && y >= 1)
                        eval = 1;
                    else
                        eval = 0;
                }
            }
        }
        return eval;
    }
}
