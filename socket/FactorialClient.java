package socket;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class FactorialClient {
	public static void main(String[] args) {
		try {
			System.out.println("Client started");
			Socket soc = new Socket("localhost", 9806);

			Scanner in = new Scanner(System.in);
			System.out.print("Enter a number : ");
			int x = in.nextInt();

			PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
			out.println(x);

			Scanner get = new Scanner(soc.getInputStream());
			int ans = get.nextInt();

			System.out.println("factorial of " + x + " is " + ans);

			in.close();
			soc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
