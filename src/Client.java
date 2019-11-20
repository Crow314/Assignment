import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try(
                Socket sock = new Socket("127.0.0.1", 65432)
        ) {
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);

            out.println("はろー");
            String result = in.readLine();
            System.out.println("サーバからの返信: " + result);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
