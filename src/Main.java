import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner consoleIn = new Scanner(System.in);

        File file = new File(consoleIn.next());
        int statusCode = consoleIn.nextInt();

        consoleIn.close();

        try(
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                ) {
            String str = br.readLine();

            int count = 0;

            while (str != null){
                /*
                String[] strArray = str.split(" ");
                if(strArray[8].equals(Integer.toString(statusCode))){
                    count++;
                }
                 */
                if(str.matches("^.+ .+ .+ \\[.+\\] \".+\" " + statusCode + " .+ .*$")){
                    count++;
                }
                str = br.readLine();
            }

            System.out.println(count);
        }catch (IOException e){
            System.out.println("File: " + file.getName() + " not found.");
        }
    }
}
