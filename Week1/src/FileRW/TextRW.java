package FileRW;

import java.io.*;

public class TextRW {
    public static void main(String[] args) throws IOException {
        /* Input File */
        File fileRead = new File("src/FileRW/textReader.txt");
        File fileWrite = new File("src/FileRW/textWriter.txt");

        /* Write text file */
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(fileWrite));
        try (buffWrite) {
            buffWrite.write("Hi my name is Nguyen Khoa Doan");
            buffWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* Read text file */
        BufferedReader buffRead = new BufferedReader(new FileReader(fileRead));
        try (buffRead) {
            String line;
            while ((line = buffRead.readLine()) != null) {
                System.out.println(line);
            }
            buffRead.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
