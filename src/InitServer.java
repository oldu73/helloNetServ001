import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Olivier Durand on 15.12.2018.
 * SRC: https://medium.com/@martinomburajr/java-create-your-own-hello-world-server-2ca33b6957e
 */
public class InitServer {

  private ServerSocket serverSocket;
  private Socket connectionSocket;

  private InputStream inputToServer;
  private OutputStream outputFromServer;

  Scanner scanner;
  PrintWriter serverPrintOut;

  InitServer(String serverName, int port, String encoding) {

    try {
      serverSocket = new ServerSocket(port);
      connectionSocket = serverSocket.accept();

      // Create Input and Output streams for the connection
      inputToServer = connectionSocket.getInputStream();
      outputFromServer = connectionSocket.getOutputStream();

      scanner = new Scanner(inputToServer, encoding);
      serverPrintOut = new PrintWriter(new OutputStreamWriter(outputFromServer, encoding), true);
      serverPrintOut.println("Server " + serverName + " started. Enter exit to terminate!");

      //Have the server take input from the client and echo it back
      //This should be placed in a loop that listens for a terminator text e.g. exit
      boolean done = false;

      while(!done && scanner.hasNextLine()) {
        String line = scanner.nextLine();

        if(line.toLowerCase().trim().equals("exit")) {
          done = true;
        } else {
          serverPrintOut.println("Echo: " + line);
        }
      }

      serverPrintOut.println("Server " + serverName + " terminated!");

    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
