package cons_pro;

public class Consumer extends Thread{
    test t;
    Consumer (test n){
        t = n;
    }
    public void run(){
        for (int i = 0; i < 100; i++) {
            t.consume();
        }
    }
}
