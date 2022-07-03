import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClientThread extends Thread{

    private Socket socket;

    public ClientThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        InputStreamReader inputReader;
        try {
            inputReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(inputReader);
            String clientInfo;
            while ((clientInfo = reader.readLine()) != null) {
                System.out.println("Client: "+ clientInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
