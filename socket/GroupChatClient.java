package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GroupChatClient {

	private Socket soc;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	private String ClientUserName;

	GroupChatClient(Socket soc, String username){
		try {
			this.soc = soc;
			this.bufferedReader = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
			this.ClientUserName = username;
		} catch (Exception e) {
			closeEveryThing(soc, bufferedReader, bufferedWriter);
		}
	}

	public void sendMessage(){
		try {
			bufferedWriter.write(ClientUserName);
			bufferedWriter.newLine();
			bufferedWriter.flush();

			Scanner scanner = new Scanner(System.in);
			while (soc.isConnected()){
				String messageToSend = scanner.nextLine();
				bufferedWriter.write(ClientUserName + " : " + messageToSend);
				bufferedWriter.newLine();
				bufferedWriter.flush();
			}
			scanner.close();
		} catch (Exception e) {
			closeEveryThing(soc, bufferedReader, bufferedWriter);
		}
	}

	public void listenForMessage(){
		new Thread(new Runnable() {
			public void run(){
				String messageFromGroupChat;
				while (soc.isConnected()){
					try {
						messageFromGroupChat = bufferedReader.readLine();
						System.out.println(messageFromGroupChat);
					} catch (IOException e) {
						closeEveryThing(soc, bufferedReader, bufferedWriter);
					}
				}
			}
		}).start();
	}

	public void closeEveryThing(Socket soc, BufferedReader br, BufferedWriter bw){
		try {
			if (br != null){
				br.close();
			}
			if (bw != null){
				bw.close();
			}
			if (soc != null){
				soc.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter user name for group chat : ");
		String username = scanner.nextLine();
		Socket soc = new Socket("localhost",9806);
		GroupChatClient client = new GroupChatClient(soc, username);
		client.listenForMessage();
		client.sendMessage();

		scanner.close();
	}
}
