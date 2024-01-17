import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class TrafficMonitor {
    // Extract source IP from the packet

    //ip we need to values so hash
    private final Map<String, Long> sourceIPTrafficMap = new HashMap<>();

    public void processPacket(String packet) {
        String sourceIp = extractSourceIp(packet);

        // Updating traffic map
        sourceIPTrafficMap.merge(sourceIp, 1L, Long::sum);

        // Check for anomalies
        if (isAnomaly(sourceIp)) {
            handleAnomaly(sourceIp);
        }
    }

    private String extractSourceIp(String packet) {
        // code
        return "127.0.0.1"; // Default value
    }

    private boolean isAnomaly(String sourceIp) {
        // code
        return sourceIPTrafficMap.getOrDefault(sourceIp, 0L) > 10;
    }

    private void handleAnomaly(String sourceIp) {
        // code
        System.out.println("Anomaly detected for source IP: " + sourceIp);
    }


    public void processSocketTraffic(Socket clientSocket) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String line;

            while ((line = reader.readLine())!= null){
                processPacket(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
