package test;

public class classTwo extends Thread {

	countNumber c = new countNumber();
	@Override
	public void run(){
		for (int i = 0; i < 10 ; i++){
			c.countNum();
		}
	}
}

class countNumber{
	int count = 0;
	public void countNum(){
		count++;
	}

}
