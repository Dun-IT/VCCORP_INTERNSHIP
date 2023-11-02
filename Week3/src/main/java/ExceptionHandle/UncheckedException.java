package ExceptionHandle;

public class UncheckedException {
    public static void main(String[] args) {
        int x = 0;
        int y = 10;
        int z;
        if (x != 0) {
            z = y/x;
            System.out.println(z);
        } else {
            System.out.println("ERROR");
        }
    }
}
