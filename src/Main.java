import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner consoleIn = new Scanner(System.in);

        File file = new File(consoleIn.next());

        consoleIn.close();

        try(
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                ) {
            String str = br.readLine();

            while (str != null){
                char[] str_char = str.toCharArray();
                for(char c : str_char){
                    if(c >= 0x41 && c <= 0x5A){
                        c += 0x20;
                    }else if(c >= 0x61 && c <= 0x7A){
                        c -= 0x20;
                    }

                    System.out.print(c);
                }
                System.out.println();
                str = br.readLine();
            }
        }catch (IOException e){
            System.out.println("File: " + file.getName() + " not found.");
        }
    }
}
