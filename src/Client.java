import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try(
                Socket sock = new Socket("127.0.0.1", 65432)
        ) {
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            System.out.println("127.0.0.1:65432へ接続開始");

            System.out.println("送る行数:");
            int dataLength = sc.nextInt();
            out.println(dataLength);

            for(int i=0; i<dataLength; i++){
                out.println(sc.next());
            }

            String result = in.readLine();
            System.out.println("サーバからの返信: " + result);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
