import java.awt.datatransfer.StringSelection;

/**
 * Created by Olivier Durand on 15.12.2018.
 */
public class MyServer {

  public static void main(String[] args) {

    InitServer initServer;
    initServer = new InitServer("myServer001", 9991, "UTF-8");

    System.out.println("bye");

  }

}
