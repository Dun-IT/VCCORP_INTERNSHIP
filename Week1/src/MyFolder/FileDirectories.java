package MyFolder;

import java.io.*;

public class FileDirectories {
    public static void main(String[] args) {
        // Đường dẫn đến thư mục cần kiểm tra
        String folderPath = "src/MyZoo";

        // Liệt kê tất cả các tệp tin trong thư mục
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files != null) {
            System.out.println("ALL OF MY FILES:");
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
            System.out.print("\n");
        }

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Hiển thị tên của các tệp tin trong thư mục
                    System.out.println("FILE NAME: " + file.getName() + "\n");

                    // Đọc nội dung của các tệp tin và hiển thị
                    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                        String line;
                        System.out.println("FILE CONTENT: ");
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }
                        System.out.println("----------------------");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("Thư mục không tồn tại hoặc không có tệp tin.");
        }
    }
}
