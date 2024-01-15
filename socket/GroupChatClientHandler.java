package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class GroupChatClientHandler implements Runnable{
	

	public static ArrayList<GroupChatClientHandler> clientHandlers = new ArrayList<>();
	private Socket soc;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	private String ClientUserName;

	GroupChatClientHandler(Socket soc){
		try {
			this.soc = soc;
			this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
			this.bufferedReader = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			this.ClientUserName = bufferedReader.readLine();
			clientHandlers.add(this);
			broadcastMessage("Server Client " + ClientUserName + " has entered the chat");

		} catch (Exception e) {
			System.out.println(e + "one");
			closeEveryThing(soc, bufferedReader, bufferedWriter);
		}
	}


	public void broadcastMessage(String message){
		for(GroupChatClientHandler client : clientHandlers){
			try {
				if (client.ClientUserName != ClientUserName){
					client.bufferedWriter.write(message);
					client.bufferedWriter.newLine();
					client.bufferedWriter.flush();
				}
			} catch (Exception e) {
				System.out.println(e + "two");
				closeEveryThing(soc, bufferedReader, bufferedWriter);
			}
		}
	}

	public void removeClientHandler(){
		clientHandlers.remove(this);
		broadcastMessage("Server: " + ClientUserName +" has left the chat");
	}

	public void closeEveryThing(Socket soc, BufferedReader br, BufferedWriter bw){
		removeClientHandler();
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

	public void run(){
		String messageFromClient;
		while (soc.isConnected()){
			try {
				messageFromClient = bufferedReader.readLine();
				broadcastMessage(messageFromClient);
			} catch (Exception e) {
				System.out.println("three");
				// closeEveryThing(soc, bufferedReader, bufferedWriter);
				break;
			}
		}
	}
}
