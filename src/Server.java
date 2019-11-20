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

                System.out.println("接続の受付を開始します。");
                String data = in.readLine();

                int dataLength = Integer.valueOf(data);

                String[] dataArray = new String[dataLength];

                for(int i=0; i<dataLength; i++){
                    dataArray[i] = in.readLine();
                }

                System.out.println("受信データ: " + data);

                for(int i=0; i<dataLength; i++){
                    System.out.println("受信データ: " + dataArray[i]);
                }

                out.println("データ受け取りました");
                System.out.println("切断します");

            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
