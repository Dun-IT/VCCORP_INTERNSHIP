package DataStructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ArrayListSolution {
    public static void main(String[] args) {
        // Khoi tao ArrayList
        ArrayList<Integer> myArr = new ArrayList<Integer>();

        // Them cac phan tu vao ArrayList
        myArr.add(1);
        myArr.add(5);
        myArr.add(2);
        myArr.add(1);
        myArr.add(3);

        // In cac phan tu ra man hinh
        System.out.println("Cac phan tu cua mang");
        System.out.println(myArr);

        // Truy cap phan tu
        System.out.println("Truy cap phan tu thu co index = 3");
        System.out.println(myArr.get(3));

        // Thay doi phan tu
        myArr.set(2, 4);
        System.out.println("Thay doi phan tu co index = 2 thanh 4: " + myArr);

        // Xoa phan tu
        myArr.remove(3);
        System.out.println("Xoa phan tu co index = 3: " + myArr);

        // Kich co cua ArrayList
        System.out.println("So luong phan tu cua mang: " + myArr.size());

        // Duyet qua cac phan tu cua ArrayList
        for (int i : myArr) {
            System.out.print(i + " ");
        }
        Collections.sort(myArr);
        System.out.println("Danh sach sau khi duoc sap xep");
        System.out.println(myArr);

        // Tinh tong
        tinhTong(myArr);

        // Tim gia tri be nhat cua mang
        minElement(myArr);
    }

    public static void tinhTong(ArrayList<Integer> arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        System.out.println("Tong cac phan tu cua mang: " + sum);
    }

    public static void minElement(ArrayList<Integer> arr) {
        int min = arr.get(0);
        for (int i : arr) {
            if (min > i) {
                min = i;
            }
        }
        System.out.println("Phan tu nho nhat cua mang la: " + min);
    }
}
