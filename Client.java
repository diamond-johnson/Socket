package Socket;

import java.net.Socket;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Client {

    public static void main(String[] args) {
        try {
            // Create Socket object for client.
        	Socket socket = new Socket("localhost", 8000);

            // Create PrintWriter object for send information to server.
        	PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        	
        	// Get number from user
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a number: ");
            int number = scanner.nextInt();

            // Send number to server with PrintWriter object.
            writer.println(number);
        	
            // Create BufferedReader object for receiving result from server.
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Print result in terminal.
            System.out.println(reader.readLine());
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}