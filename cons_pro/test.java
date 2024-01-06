package cons_pro;

import java.util.Stack;

public class test {
     Stack<Integer> stack = new Stack<Integer>();
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
               stack.add(n);
               System.out.println("we added value n " + n + " " + stack);
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
               System.out.println("Poped " + stack.pop() + " " + stack);
               count--;
               notifyAll();
          }catch (Exception e)
          {
               System.out.println("In the consumer");
          }
     }
}
