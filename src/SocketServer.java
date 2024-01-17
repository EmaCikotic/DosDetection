import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    private final TrafficMonitor trafficMonitor;

    public SocketServer(TrafficMonitor trafficMonitor) {
        this.trafficMonitor = trafficMonitor;
    }

    public void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(55000);  //when i put 8080 i get already in use

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from: " + clientSocket.getInetAddress());


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processSocketTraffic(Socket clientSocket) {
        trafficMonitor.processSocketTraffic(clientSocket);
    }
}

