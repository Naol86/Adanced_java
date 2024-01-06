package collections_test;

public class PrintArray<T> {
	public void print(T lis[]){
		for(int i = 0; i < lis.length;i++){
			System.out.println(lis[i]);
		}
	}
	
	public <E> void test(E lis[]){
		for(int i = 0; i < lis.length;i++){
			System.out.println(lis[i]);
		}
	}
}
