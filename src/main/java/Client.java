import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4000);
        Scanner scanner = new Scanner(System.in);

        ClientThread clientThread = new ClientThread(socket);
        clientThread.start();
        PrintStream exit = new PrintStream(socket.getOutputStream());
        String keyboard  = scanner.nextLine();
        exit.println(keyboard);
    }

}
