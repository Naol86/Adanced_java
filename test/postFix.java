package test;
import java.util.Stack;

public class postFix {
    public int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch)) {
                // If the character is a digit, push it onto the stack
                stack.push(Character.getNumericValue(ch));
            } else {
                // If the character is an operator, pop two operands from the stack,
                // perform the operation, and push the result back onto the stack
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                    // You can add more operators as needed

                    default:
                        throw new IllegalArgumentException("Invalid operator: " + ch);
                }
            }
        }

        // The final result should be on the top of the stack
        return stack.pop();
    }
}
