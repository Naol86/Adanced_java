package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MathCalculator implements Runnable{

    private Socket soc;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;


    MathCalculator(Socket soc){
        try {
			this.soc = soc;
			this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
			this.bufferedReader = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            message("welcome naol's and hana's calculator !!!");

		} catch (Exception e) {
			closeServer(soc, bufferedReader, bufferedWriter);
		}
    }

    void message(String messaString){
        try {
                this.bufferedWriter.write(messaString);
                this.bufferedWriter.newLine();
                this.bufferedWriter.flush();
        }catch (Exception e) {
            closeServer(soc, bufferedReader, bufferedWriter);
        }
    }

    void closeServer(Socket soc, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        try {
			if (bufferedReader != null){
				bufferedReader.close();
			}
			if (bufferedWriter != null){
				bufferedWriter.close();
			}
			if (soc != null){
				soc.close();
			}
		} catch (Exception e) {
			// e.printStackTrace();
            System.out.println("error in closer server method of math calculator");
		}
    }


    public void run(){
        String messageFromClient;
		while (soc.isConnected()){
			try {
				messageFromClient = bufferedReader.readLine();
                System.out.println(messageFromClient);
                MathPostfix infixTopostfix = new MathPostfix();
                String exp = infixTopostfix.infixToPostfix(messageFromClient);

                MathEvalPost eval = new MathEvalPost();
                System.out.println("here we are");
                int res = eval.evaluatePostfix(exp);
                System.out.println(res + "result is");
				message(res + "");
			} catch (Exception e) {
				// closeEveryThing(soc, bufferedReader, bufferedWriter);
				break;
			}
		}
    }
}
