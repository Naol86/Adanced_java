package test;
import java.util.Stack;


public class InfixToPostfixConverter {
    public String infixToPostfix(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        for (char ch : infixExpression.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                // If it's an operand, append it to the postfix expression
                postfix.append(ch);
            } else if (ch == '(') {
                // If it's an opening parenthesis, push it onto the stack
                operatorStack.push(ch);
            } else if (ch == ')') {
                // Pop and append operators from the stack until an opening parenthesis is encountered
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop());
                }
                // Pop the opening parenthesis from the stack
                operatorStack.pop();
            } else {
                // It's an operator
                // Pop and append operators from the stack while they have higher or equal precedence
                while (!operatorStack.isEmpty() && precedence(ch) <= precedence(operatorStack.peek())) {
                    postfix.append(operatorStack.pop());
                }
                // Push the current operator onto the stack
                operatorStack.push(ch);
            }
        }

        // Pop and append remaining operators from the stack to the postfix expression
        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop());
        }

        return postfix.toString();
    }

    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            // You can add more operators as needed

            default:
                return 0; // For operands or unknown operators
        }
    }

}

