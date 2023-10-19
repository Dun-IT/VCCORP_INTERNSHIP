package FileRW;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.DataOutputStream;

public class DataOutput {
    public static void main(String[] args) {
        try {
            // Tao luong va lien ket nguon du lieu
            FileOutputStream fos = new FileOutputStream("src/FileRW/mydata.bin");
            DataOutputStream dos = new java.io.DataOutputStream(fos);

            // Ghi du lieu
            dos.writeInt(100);
            dos.writeDouble(9.5);

            // Dong luong
            fos.close();
            dos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
