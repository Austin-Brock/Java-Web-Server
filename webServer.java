import java.io.*;
import java.net.*;
import java.util.*;

public final class WebServer {
    public static void main(String argv[]) throws Exception {
        int port = 6789; //setting port number

        // Establish the listen socket on the specified port
        ServerSocket listenSocket = new ServerSocket(port);

        // Print a start-up message
        System.out.println("WebServer listening on port " + port);
    } //main
} //webserver

final class HttpRequest implements Runnable {

}