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

        // Process HTTP service requests in an infinite loop.
        while (true) {
            // Listen for a TCP connection request.
            Socket connectionSocket = listenSocket.accept();

            // Construct an object to process the HTTP request message.
            HttpRequest request = new HttpRequest(connectionSocket);

            // Create a new thread to process the request.
            Thread thread = new Thread(request);

            // Start the thread.
            thread.start();
        //  The server can be stopped by pressing Ctrl+C
    } //main
} //webserver

// Define the HttpRequest class that handles individual client requests
final class HttpRequest implements Runnable {
    final static String CRLF = "\r\n"; // Carriage return line feed pair
    Socket socket;

    // Constructor to initialize the HttpRequest object with a client socket
    public HttpRequest(Socket socket) throws Exception {
        this.socket = socket;
    }