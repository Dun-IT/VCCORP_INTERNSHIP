package DataStructure;

import javax.swing.text.Style;
import java.util.HashMap;

public class HashMapSolution {
    public static void main(String[] args) {
        HashMap<Integer, Double> myHashMap = new HashMap<>();

        // Them phan tu vao hash map
        myHashMap.put(1, 100000.5);
        myHashMap.put(2, 23000.8);
        myHashMap.put(4, 640000.6);
        myHashMap.put(3, 13540.5);
        myHashMap.put(5, 100310.6);
        myHashMap.put(9, 65000.3);

        // Duyet va in ra man hinh KEY
        for (int i : myHashMap.keySet()) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Duyet va in ra man hinh VALUE
        for (int i : myHashMap.keySet()) {
            System.out.print(myHashMap.get(i) + " ");
        }
        System.out.println();

        // Duyet va in ra key-value
        for (int i : myHashMap.keySet()) {
            System.out.println("KEY:" + i + "-VALUE:" + myHashMap.get(i));
        }

        // Truy nhap phan tu
        System.out.println("Phan tu co KEY = 2: " + myHashMap.get(2));

        // Xoa phan tu
        System.out.println("Xoa phan tu co KEY = 3: ");
        myHashMap.remove(3);

        // Kich thuoc cua hashMap
        System.out.println("Size cua handmap la: " + myHashMap.size());

        // Tinh tong
        tinhTong(myHashMap);

        // Kiem tra phan tu ton tai
        searchElement(4, myHashMap);
    }

    public static void tinhTong(HashMap<Integer, Double> hashMap) {
        Double sum = 0.0;
        for (int i : hashMap.keySet()) {
            sum += hashMap.get(i);
        }
        System.out.println("Tong cua hash map la: " + sum);
    }

    public static void searchElement(int ele, HashMap<Integer, Double> hashMap) {
        if (hashMap.containsKey(ele)) {
            System.out.println("Phan tu co key = " + ele + " ton tai va co gia tri la: " + hashMap.get(ele));
        } else {
            System.out.println("Phan tu khong ton tai");
        }
    }
}
