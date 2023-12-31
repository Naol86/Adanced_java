package cons_pro;

import java.util.Stack;

public class test {
     Stack<Integer> d = new Stack<Integer>();
     int MAXSIZE;
     int count = 0;

     test(int n)
     {
          MAXSIZE = n;
     }
     public synchronized void produce(int n){
          try{
               while (count >= MAXSIZE) {
                    System.out.println("producer is waiting");
                    wait();
               }
               d.add(n);
               System.out.println("we added value n " + n + " " + d);
               notifyAll();
               count++;
               
          }catch (Exception e)
          {
               System.out.println("in the producer");
          }
     }
     public synchronized void consume()
     {
          try{
               while (count == 0)
               {
                    System.out.println("consumer is waiting");
                    wait();
               }
               System.out.println("Poped " + d.pop() + " " + d);
               count--;
               notifyAll();
          }catch (Exception e)
          {
               System.out.println("In the consumer");
          }
     }
}
