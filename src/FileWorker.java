import java.io.*;
import java.util.ArrayList;

public class FileWorker {
    private final ArrayList<String> arrayKiz = new ArrayList<>();
    public FileWorker(String inputFile, String outputFile) {
        loadFile(inputFile);
        saveFile(outputFile);
    }
    private void loadFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while(reader.ready()) {
                arrayKiz.add(reader.readLine());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void saveFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Тип\tGTIN\tСерийный номер\tКод ответа\tКриптохвост");
            writer.write("\n");
            for (String string : arrayKiz) {
                writer.write(ParserData.parseKIZ(string));
                writer.write("\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
