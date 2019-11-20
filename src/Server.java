import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        while (true){
            try(
                    ServerSocket servSock = new ServerSocket(65432);
                    Socket sock = servSock.accept()
            ) {
                BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                PrintWriter out = new PrintWriter(sock.getOutputStream(), true);

                String data = in.readLine();
                System.out.println("受信データ: " + data);
                out.println("データ受け取りました");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
