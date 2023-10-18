package FileRW;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryRW {
    public static void main(String[] args) {
        /* INPUT FILE */
        String fileWrite1 = "src/FileRW/output.bin";

        /* WRITE BINARY FILE */
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileWrite1)) {
            byte[] binaryData = {0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x2C, 0x20, 0x42, 0x69, 0x6E, 0x61, 0x72, 0x79, 0x20, 0x46, 0x69, 0x6C, 0x65, 0x21};
            fileOutputStream.write(binaryData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* READ BINARY FILE */
        try (FileInputStream fis = new FileInputStream("src/FileRW/output.bin")) {
            byte content;
            while ((content = (byte) fis.read()) != -1) {
                System.out.print(((char)content));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
