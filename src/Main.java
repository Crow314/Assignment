import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner consoleIn = new Scanner(System.in);

        File file = new File(consoleIn.next());

        consoleIn.close();

        Map<String, Integer> accessCount = new HashMap<>();

        try(
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                ) {
            String str = br.readLine();

            while (str != null){
                String[] strArray = str.split(" ");
                String tmpAddress = strArray[0];

                Integer count = accessCount.get(tmpAddress);

                if(count == null){
                    count = 0;
                }

                count++;

                accessCount.put(tmpAddress, count);

                str = br.readLine();
            }

        }catch (IOException e){
            System.out.println("File: " + file.getName() + " not found.");
        }

        List<String> addressList = new ArrayList<>(accessCount.keySet());
        addressList.sort(null);

        for(String tmpAddress : addressList){
            int count = accessCount.get(tmpAddress);
            System.out.println(tmpAddress + ": " + count + " time(s)");
        }
    }
}
