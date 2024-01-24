package test;

public class Main {
    public static void main(String[] args) {
        postFix su = new postFix();
        InfixToPostfixConverter in = new InfixToPostfixConverter();
        String s = in.infixToPostfix("11+2*2");
        int x = su.evaluatePostfix("1122+");
        System.out.println(s + " " + x);
    }
}
