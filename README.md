# Simple Java Web Server

This project implements a simple, multi-threaded web server in Java. It's capable of handling multiple simultaneous HTTP GET requests, serving files from its current directory, and responding with appropriate status codes and content types based on the request and the existence of requested files.

## Features

- **Multi-threaded Processing:** Each HTTP request is processed in a separate thread, allowing for simultaneous handling of multiple requests.
- **GET Request Handling:** Processes HTTP GET requests, serving requested files or responding with a 404 Not Found status if the file doesn't exist.
- **MIME Type Detection:** Automatically detects and responds with the correct MIME type for a wide range of file extensions.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or later

### Installation

1. **Clone the repository:**
   ```sh
   git clone https://your-repository-url-here
   ```
2. **Navigate to the project directory:**
   ```sh
   cd simple-java-web-server
   ```

### Running the Server

1. **Compile the server:**
   ```sh
   javac WebServer.java
   ```
2. **Start the server:**
   ```sh
   java WebServer
   ```
   By default, the server listens on port 6789. You can access the server by navigating to `http://localhost:6789/` in your web browser. Append the filename to the URL to request a specific file.

## How It Works

### Overview

The server listens for incoming TCP connections on a specified port. For each connection, it spawns a new thread to handle the request, allowing multiple requests to be processed in parallel.

### Request Handling

- **Reading Requests:** The server reads the HTTP request, extracts the requested filename, and determines whether the file exists within the current directory.
- **Serving Files:** If the requested file exists, the server reads the file and sends it back to the client with the appropriate MIME type and a 200 OK status.
- **Error Handling:** If the requested file does not exist, the server responds with a 404 Not Found status and an HTML document indicating the error.

### MIME Type Detection

The server uses the file extension to determine the MIME type of the response. It supports common file types such as HTML, JPEG, GIF, PNG, CSS, and JavaScript, defaulting to `application/octet-stream` for unknown file types.

## Customization

- **Port Number:** You can change the port number by modifying the `port` variable in the `WebServer` class.
- **MIME Types:** To add support for additional MIME types, modify the `contentType` method in the `HttpRequest` class.

## Contributing

Contributions are welcome! For major changes, please open an issue first to discuss what you would like to change.

## License

Distributed under the MIT License. See `LICENSE` for more information.
