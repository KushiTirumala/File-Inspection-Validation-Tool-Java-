import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileInspector {

    public static void inspectFile(String path) {
        File file = new File(path);

        if (!file.exists()) {
            System.out.println("❌ File does not exist.");
            return;
        }

        System.out.println("✅ File Found!");
        System.out.println("File Name: " + file.getName());
        System.out.println("Absolute Path: " + file.getAbsolutePath());
        System.out.println("Writable: " + file.canWrite());
        System.out.println("Readable: " + file.canRead());
        System.out.println("File Size (bytes): " + file.length());
        System.out.println("Is Directory: " + file.isDirectory());
    }

    public static boolean validateFile(String path, String extension) {
        File file = new File(path);

        if (!file.exists()) {
            System.out.println("❌ File does not exist.");
            return false;
        }

        if (!file.isFile()) {
            System.out.println("❌ Path is not a file.");
            return false;
        }

        if (!file.getName().endsWith(extension)) {
            System.out.println("❌ File extension does not match: " + extension);
            return false;
        }

        System.out.println("✅ File is valid.");
        return true;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== File Inspection & Validation Tool ===");

        System.out.print("Enter file path: ");
        String path = scanner.nextLine();

        inspectFile(path);

        System.out.print("Enter expected file extension (e.g., .txt, .csv): ");
        String ext = scanner.nextLine();

        validateFile(path, ext);

        scanner.close();
    }
}
