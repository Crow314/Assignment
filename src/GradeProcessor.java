import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GradeProcessor {

    private String scoreFile;
    private String settingFile;
    private String resultFile;

    public GradeProcessor(String score, String setting, String result){
        this.scoreFile = score;
        this.settingFile = setting;
        this.resultFile = result;
    }

    public void process(){
        String[][] score = new String[11][7];

        try(
                FileReader fr = new FileReader(scoreFile);
                BufferedReader br = new BufferedReader(fr)
        ) {
            String line = br.readLine();
            int count = 0;

            while (line != null){
                 String[] score_str = line.split(",");
                 for(int i=0; i<score_str.length; i++){
                     score[count][i] = score_str[i];
                 }
                 line = br.readLine();
                 count++;
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        Map<String, Boolean> setting = loadIni(settingFile);

        // ?)nullのときfalseを代入 / :)null以外のときその値を代入
        boolean settingSum = setting.get("sum") == null ? false : setting.get("sum");
        boolean settingAverage = setting.get("average") == null ? false : setting.get("average");
        boolean settingFuka = setting.get("fuka") == null ? false : setting.get("fuka");

        int resultLength = score[0].length;
        if(settingSum){
            resultLength++;
        }
        if(settingAverage){
            resultLength++;
        }
        if(settingFuka){
            resultLength++;
        }

        String[][] result = new String[score.length][resultLength];

        for(int i=0; i<score.length; i++){
            int sum = 0;
            int average = 0;
            int fukaCount = 0;

            int j;
            for(j=0; j<score[0].length; j++){
                String tmpScore = score[i][j];
                result[i][j] = tmpScore;
                if(i!=0 && j!=0){
                    int tmpIntegerScore = Integer.valueOf(tmpScore);
                    sum += tmpIntegerScore;
                    if(tmpIntegerScore < 60){
                        fukaCount++;
                    }
                }
            }

            average = sum / (score[0].length - 1);

            if(settingSum){
                if(i==0){
                    result[i][j] = "Sum";
                }else{
                    result[i][j] = String.valueOf(sum);
                }
                j++;
            }
            if(settingAverage){
                if(i==0){
                    result[i][j] = "Average";
                }else{
                    result[i][j] = String.valueOf(average);
                }
                j++;
            }
            if(settingFuka){
                if(i==0){
                    result[i][j] = "Fuka";
                }else{
                    result[i][j] = String.valueOf(fukaCount);
                }
            }
        }

        try(
                FileWriter fw = new FileWriter(resultFile);
                BufferedWriter bw = new BufferedWriter(fw)
        ) {

            for(int i=0; i<result.length; i++){
                bw.write(result[i][0]);
                for(int j=1; j<result[i].length; j++){
                    bw.write(",");
                    bw.write(result[i][j]);
                }
                bw.newLine();
                bw.flush();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private Map<String, Boolean> loadIni(String fileName){
        Map<String, Boolean> result = new HashMap<>();


        try(
                FileReader fr = new FileReader(settingFile);
                BufferedReader br = new BufferedReader(fr)
        ) {
            String line = br.readLine();
            boolean value = false;

            while (line != null) {
                // 行頭、行末の空白を取り除く
                line = line.trim();

                //空行
                if (line.equals("")) {
                    line = br.readLine();
                    continue;
                }
                //コメント行
                if (line.matches("^\\s*#.*$")) {
                    line = br.readLine();
                    continue;
                }

                //パラメータ行
                if (line.matches("^.+\\s*=\\s*.+$")) {
                    String key = line.substring(0, line.indexOf("=")).trim(); //先頭から"="の手前まで
                    String value_str = line.substring(line.indexOf("=") + 1).trim(); //"="の次の文字から末尾まで

                    if (value_str.equals("yes")){
                        value = true;
                    }else if(value_str.equals("no")){
                        value = false;
                    }else {
                        throw new IllegalArgumentException(settingFile + " has illegal argument.");
                    }

                    result.put(key, value);
                }

                line = br.readLine();
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        return result;
    }

}
