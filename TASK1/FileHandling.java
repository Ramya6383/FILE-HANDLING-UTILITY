import java.io.*;
import java.util.Scanner;

public class FileHandling {

    public static void writeToFile(String fileName, String content) {
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public static void readFromFile(String fileName) {
        System.out.println("\n--- Reading File Content ---");
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null)
                System.out.println(line);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void appendToFile(String fileName, String newContent) {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.write("\n" + newContent);
            System.out.println("Content appended to file successfully.");
        } catch (IOException e) {
            System.out.println("Error appending file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "output.txt";

        System.out.print("Enter content to write to the file: ");
        String writeContent = scanner.nextLine();
        writeToFile(fileName, writeContent);

        readFromFile(fileName);

        System.out.print("\nEnter content to append to the file: ");
        String appendContent = scanner.nextLine();
        appendToFile(fileName, appendContent);

        readFromFile(fileName);
        scanner.close();
    }
}

