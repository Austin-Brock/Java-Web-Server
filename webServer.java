import java.io.*;
import java.net.*;
import java.util.*;

// Define the WebServer class as the main entry point of the application
public final class WebServer {
    public static void main(String argv[]) throws Exception {
        // Set the port number (above 1024 to avoid superuser rights requirement).
        int port = 6789;

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
        } //while
        // The server can be stopped by pressing Ctrl+C
    } //main
} //webServer

// Define the HttpRequest class that handles individual client requests
final class HttpRequest implements Runnable {
    final static String CRLF = "\r\n"; // Carriage return line feed pair
    Socket socket;

    // Constructor to initialize the HttpRequest object with a client socket
    public HttpRequest(Socket socket) throws Exception {
        this.socket = socket;
    } //HttpRequest

    // Implement the run() method of the Runnable interface.
    @Override
    public void run() {
        try {
            processRequest();
        } catch (Exception e) {
            System.out.println("Error processing request: " + e.getMessage());
        } //catch
    } //run

    // Process the client's request by reading from and writing to the socket
    private void processRequest() throws Exception {
        // Get references to the socket's input and output streams
        InputStream is = socket.getInputStream();
        DataOutputStream os = new DataOutputStream(socket.getOutputStream());

        // Set up input stream filters
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        // Read the request line of the HTTP request message
        String requestLine = br.readLine();
        
        // Display the request line
        System.out.println();
        System.out.println(requestLine);

        // Read and display the header lines
        String headerLine = null;
        while ((headerLine = br.readLine()).length() != 0) {
            System.out.println(headerLine);
        } //while

        // Close streams and socket
        os.close();
        br.close();
        socket.close();
    } //processRequest
} //