package socket;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class FactorialServer {
	public static void main(String[] args) {
		try {
			System.out.println("waiting for client...");
			ServerSocket ss = new ServerSocket(9806);
			Socket soc = ss.accept();
			System.out.println("Connection established with client");

			while (true){

				Scanner get = new Scanner(soc.getInputStream());
				int x = get.nextInt();
				if (x < 0){
					soc.close();
					ss.close();
					break;
				}
	
				PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
				out.println(factorial(x));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static int factorial(int x){
		int temp = 1;
		for (int i = 1; i <= x; i++)
			temp *= i;
		return temp;
	}
}
