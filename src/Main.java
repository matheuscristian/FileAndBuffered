import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            File csvFile = new File("data.csv");
            File csvOutFile = new File("out/summary.csv");

            FileReader fileReader = new FileReader(csvFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(csvOutFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedReader.readLine();
            bufferedWriter.write("name,total\n");

            String line = bufferedReader.readLine();
            while (line != null) {
                String[] columns = line.split(",");
                String resultEntry = columns[0] + "," + (Double.parseDouble(columns[1]) * Double.parseDouble(columns[2])) + "\n";
                bufferedWriter.write(resultEntry);
                line = bufferedReader.readLine();
            }

            bufferedReader.close();
            fileReader.close();

            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
