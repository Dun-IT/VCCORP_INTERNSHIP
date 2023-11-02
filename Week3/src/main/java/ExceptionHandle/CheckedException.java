package ExceptionHandle;

import java.io.*;

public class CheckedException {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("ExceptionHandle/checkedEx.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        for (int i = 0; i < 10; i++) {
            bufferedReader.readLine();
        }

        fileReader.close();
    }
}
