package cons_pro;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        test test1 = new test(5);
        Producer p = new Producer( test1);
        Consumer c = new Consumer(test1);

        p.start();
        c.start();

    }
}
