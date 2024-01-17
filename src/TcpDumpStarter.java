import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TcpDumpStarter {

public static void startTcpDump() throws IOException, InterruptedException {
    //comand to execute
    //for mac
    String[] command = {"expect", "-c", "spawn sudo tcpdump -i any port 8080 and (tcp-syn or tcp-ack)!=0; expect \"Password:\"; send \"//password//\\r\"; interact"};


    // for other
    //String[] command = {"sudo", "tcpdump", "-i", "any", "port", "8080", "and", "(tcp-syn or tcp-ack)!=0"};

    //start the process
    ProcessBuilder processBuilder =  new ProcessBuilder(command);
    processBuilder.redirectErrorStream(true);
    Process process = processBuilder.start();

    //read the output
    InputStream inputStream = process.getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

    //read and process each line of the output
    String line;

    while ((line =reader.readLine())!= null){
        System.out.println(line);
    }

    //wait for the process to exit
    int exit = process.waitFor();
    System.out.println("Process exited with code: "+ exit);


}
}
