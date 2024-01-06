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

			Scanner get = new Scanner(soc.getInputStream());
			int x = get.nextInt();

			PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
			out.println(factorial(x));


			soc.close();
			ss.close();
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
