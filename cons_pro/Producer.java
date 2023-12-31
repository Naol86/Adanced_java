package cons_pro;
class Producer extends Thread{
    test n;
    Producer(test t){
        n  = t;
    }
    public void run(){
        for (int i = 0; i < 100; i++) {
            n.produce(i);
        }
    }
}