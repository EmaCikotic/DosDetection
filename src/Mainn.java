import java.io.*;


public class Mainn {

    public static void main(String[] args) throws IOException, InterruptedException {
          TcpDumpStarter tcpDumpStarter = new TcpDumpStarter();
         TcpDumpStarter.startTcpDump();

        TrafficMonitor trafficMonitor = new TrafficMonitor();

        SocketServer socketServer = new SocketServer(trafficMonitor);
        socketServer.startServer();

    }
}