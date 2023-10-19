package FileRW;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.DataInputStream;

public class DataInput {
    public static void main(String[] args) {
        try {
            // Tao luong va lien ket du lieu
            FileInputStream fis = new FileInputStream("src/FileRW/mydata.bin");
            DataInputStream dis = new DataInputStream(fis);

            // Doc du lieu
            int n = dis.readInt();
            double m = dis.readDouble();

            // DOng luong
            fis.close();
            dis.close();

            //Hien thi noi dung
            System.out.println("So nguyen: " + n);
            System.out.println("So thuc: " + m);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
