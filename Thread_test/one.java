package Thread_test;

public class one implements Runnable{
	count n;
	String name;
	one(count n, String name){
		this.n = n;
		this.name = name;
	}
	public void run(){
		for (int i = 0; i<50; i++){
			n.increment();
			int te = n.n * n.n;
			te = te / n.n;
			System.out.println(te + "  " + name);
		}
	}

}
