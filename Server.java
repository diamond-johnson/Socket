package Socket;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Server {
    public static void main(String[] args) {
 
        try {
            // Create ServerSocket object for server.
        	ServerSocket serverSocket = new ServerSocket(8000);

            // Create Socket object for server.
        	Socket socket = serverSocket.accept();

            // Create BufferedReader for receive number from client.
        	BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Receive number from client with BufferedReader object.
        	String number = reader.readLine();
            int num = Integer.parseInt(number);   
            int factorial = calculateFactorial(num);

            // Create PrintWriter object for send result to client.
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Send result to client.
            writer.println("The factorial of " + num + " is " + factorial);
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int calculateFactorial(int n) {
        int factorial = 1;
        for(int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}