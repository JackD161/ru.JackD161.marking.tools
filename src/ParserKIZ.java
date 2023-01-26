import javax.swing.*;
import java.awt.*;

public class ParserKIZ {
    public static void main(String[] args) {
        JFrame window = new JFrame("Конвертер КИЗ в SGTIN");
        window.setBounds(200, 300, 380, 400);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        JLabel sourceFile = new JLabel("Файл источник");
        JLabel destinationFile = new JLabel("Файл куда записать");
        JLabel scan = new JLabel("Сканировать КИЗ");
        JLabel sgtinLabel = new JLabel("SGTIN");
        JTextField inputFile = new JTextField(30);
        JTextField outputFile = new JTextField(30);
        JTextField scanField = new JTextField(30);
        JTextField sgtin = new JTextField(30);
        JButton reset = new JButton("Сброс");
        reset.setBackground(Color.RED);
        JButton confirm = new JButton("Конвертация");
        JButton ejectSgtin = new JButton("Извлечь SGTIN");
        ejectSgtin.setBackground(Color.ORANGE);
        confirm.setBackground(Color.GREEN);
        window.setVisible(true);
        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("Файл");
        JMenu help = new JMenu("Помощь");
        JMenuItem saveAs = new JMenuItem("Сохранить результат как...");
        JMenuItem exit = new JMenuItem("Выход");
        JMenuItem aboutIt = new JMenuItem("О программе");
        file.add(saveAs);
        file.add(exit);
        help.add(aboutIt);
        bar.add(file);
        bar.add(help);
        JPanel footer = new JPanel();
        JPanel center = new JPanel();
        center.add(sourceFile);
        center.add(inputFile);
        center.add(destinationFile);
        center.add(outputFile);
        center.add(scan);
        center.add(scanField);
        center.add(sgtinLabel);
        center.add(sgtin);
        footer.add(confirm);
        footer.add(reset);
        footer.add(ejectSgtin);
        footer.setLayout(new FlowLayout());
        window.getContentPane().add(BorderLayout.NORTH, bar);
        window.getContentPane().add(BorderLayout.SOUTH, footer);
        window.getContentPane().add(BorderLayout.CENTER, center);
        window.setVisible(true);
        reset.addActionListener(e -> {
            inputFile.setText("");
            outputFile.setText("");
            scanField.setText("");
            sgtin.setText("");
            inputFile.setBackground(Color.WHITE);
            outputFile.setBackground(Color.WHITE);
            scanField.setBackground(Color.WHITE);
        });
        aboutIt.addActionListener(e -> JOptionPane.showMessageDialog(window, "Версия конвертора 1.0 alpha"));
        exit.addActionListener(e -> System.exit(0));
        saveAs.addActionListener(e -> JOptionPane.showMessageDialog(window,"Ну допустим сохранили какой-то файл, реализую функционал потом"));
        confirm.addActionListener(e -> {
            boolean outFileNotEmpty;
            boolean originFileNotEmpty;
            String originFile;
            String outFile;
            originFile = inputFile.getText();
            outFile = outputFile.getText();
            if (originFile.isEmpty()) {
                inputFile.setBackground(Color.PINK);
                originFileNotEmpty = false;
            }
            else {
                originFileNotEmpty = true;
            }
            if (outFile.isEmpty()) {
                outputFile.setBackground(Color.PINK);
                outFileNotEmpty = false;
            }
            else {
                outFileNotEmpty = true;
            }
            if (originFileNotEmpty && outFileNotEmpty) {
                new FileWorker(originFile, outFile);
            }
        });
        ejectSgtin.addActionListener(e -> {
            boolean scanFieldNotEmpty;
            String inputScanField;
            inputScanField = scanField.getText();
            if (inputScanField.isEmpty()) {
                scanField.setBackground(Color.PINK);
                scanFieldNotEmpty = false;
            }
            else {
                scanFieldNotEmpty = true;
                scanField.setBackground(Color.WHITE);
            }
            if (scanFieldNotEmpty) {
                sgtin.setText(ParserData.ejectSgtin(inputScanField));
            }
        });
    }
}
