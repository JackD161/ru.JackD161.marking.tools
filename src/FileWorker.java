import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileWorker {
    private final String fileInput;
    private final String fileOutput;
    private final Scanner scanner = new Scanner(System.in);
    private final ArrayList<String> arrayKiz = new ArrayList<>();

    public FileWorker() {
        System.out.println("ВВедите файл источник кизов");
        fileInput = scanner.nextLine();
        System.out.println("ВВедите файл разобранных кизов");
        fileOutput = scanner.nextLine();
        loadFile(fileInput);
        saveFile(fileOutput);
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
