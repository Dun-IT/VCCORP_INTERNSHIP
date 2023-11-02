# WEEK 3 REPORT

##### Thực tập sinh: Nguyễn Khoa Đoàn

#### 1. Mô tả công việc

- Exception: nắm được cách xử lí exception, hệ thống các exception trong java, lấy ví dụ về ít nhất 2 loại exception
- JSON: nắm được json là gì, sử dụng java parse json, lấy giá trị, chuyển jsonobject thành string. sử dụng thư viện gson để parse trực tiếp 1 string sang 1 object tương ứng
- Concurrency (Optional): (1) viết 1 luồng chạy ngầm kế thừa Runnable sử dụng java, (2) viết chương trình sử dụng threadpool bằng ngôn ngữ java

#### 2. Kết quả công việc

##### 2.1. Exception 

- Có 2 loại Exception: Checked Exception và Unchecked Exception
- Checked Exception xảy ra tại thời điểm compile time và có thể khôi phục được. Xử lý lỗi bằng khối lệnh try - catch hoặc throws
- Unchecked Exception hay còn gọi là lỗi logic xảy ra tại thời điểm runtime và không thể khôi phục được. Để xử lý lỗi thì người lập trình cần chú ý tới tính logic của chương trình

![Types of Exceptions in Java, Checked vs Unchecked](https://cdn.rollbar.com/wp-content/uploads/2021/10/types-of-exceptions-in-java-checked-unchecked.png.webp)

- Xử lý checked exception:

```java
public static void main(String[] args) throws IOException {
    FileReader fileReader = new FileReader("ExceptionHandle/checkedEx.txt");
    BufferedReader bufferedReader = new BufferedReader(fileReader);

    for (int i = 0; i < 10; i++) {
        bufferedReader.readLine();
    }

    fileReader.close();
}
```

- Unchecked Exception

```java
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
```

 

##### 2.2 JSON

- JSON là viết tắt của JavaScript Object Notation, là một kiểu định dạng dữ liệu tuân theo một quy luật nhất định mà hầu hết các ngôn ngữ lập trình hiện nay đều có thể đọc được. JSON là một tiêu chuẩn mở để trao đổi dữ liệu trên web.

- Định dạng JSON sử dụng các cặp key – value để dữ liệu sử dụng. Nó hỗ trợ các cấu trúc dữ liệu như đối tượng và mảng.

- Google Gson là một thư viện Java hỗ trợ xử lý JSON (Chuyển đổi một chuỗi JSON thành đối tượng Java hoặc ngược lại). Ứu điểm của Gson:

  - Chuẩn hóa: Gson là thư viện chuẩn hóa do Google quản lý

  - Hiệu quả: Đây là một phần mở rộng đáng tin cậy, nhanh chóng và hiệu quả cho thư viện chuẩn Java

  - Tối ưu hóa: Thư viện được tối ưu hóa cao

  - Hỗ trợ Generics: Nó cung cấp hỗ trợ rộng rãi cho generics

  - Hỗ trợ các class phức tạp: Nó hỗ trợ các đối tượng phức tạp với hệ thống phân cấp kế thừa sâu sắc

- Cài đặt Gson (Maven):

```java
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>
```

- Để chuyển đổi Object sang Json chúng ta dùng `toJson()`:

```java
Person arr[] = new Person[5];
arr[0] = new Person("John", 25, "American");
arr[1] = new Person("Chris", 30, "France");
arr[2] = new Person("Madeline", 19, "Colombia");
arr[3] = new Person("Anna", 21, "Russia");
arr[4] = new Person("Hoàng", 27, "Việt Nam");
String rs = gson.toJson(arr);
```

- Để chuyển đổi từ JSON sang Object ta cũng cần tạo đối tượng Gson và sử dụng phương thức `fromJson()` để chuyển đổi:

```java
Gson gson = new Gson();
Person[] people = null;

try (FileReader fileReader = new FileReader("src/main/java/JsonExample/GsonFile.json")) {
    people = gson.fromJson(fileReader, Person[].class);
} catch (IOException e) {
    e.printStackTrace();
}
```



##### 2.3 Concurrency

**Thread** 

- Vòng đời và trạng thái của Thread trong JAVA:

![Lifecycle and States of a Thread in Java - GeeksforGeeks](https://media.geeksforgeeks.org/wp-content/uploads/20230620182419/Lifecycle-and-States-of-a-Thread-in-Java-768.png)

- - **New**: Khi khai báo mới một thread, nó sẽ có state New. (Chưa start)
  - **Runable**: Sau khi start thread, nó sẽ được đưa vào ready queue.
  - **Blocked**: Nó nói đến việc khi các thread cùng truy cập vào shared resource, chỉ có duy nhất 1 thread thành công, các thread còn lại rơi vào trạng thái Blocked.
  - **Waiting**: Waiting là trạng thái thread này chờ thread khác và không có thời gian cụ thể.
  - **Time Waiting**: Timed waiting là trạng thái của thread khi chờ thread khác nhưng có thời gian giới hạn. Nếu quá thời gian chờ, thread tiếp tục chạy và không chờ nữa.
  - **Terminated**: Terminated muốn nói đến trạng thái của thread khi đã hoàn thành xong và kết thúc.
- Có 2 cách để tạo Thread trong JAVA là extends lớp Thread hoặc implement interface Runable. Nếu extends từ Thread ta không thể extend các lớp nào khác do JAVA không hỗ trợ đa kế thừa. Do đó ta nên sử dụng interface Runable.

- Để sử dụng giao diện Runnable để tạo và bắt đầu một thread, ta thực hiện các bước sau:

  - Tạo một lớp triển khai Runnable

  - Cung cấp phương thức run() trong lớp Runnable

  - Tạo một instance của lớp Thread và chuyển đối tượng Runnable tới hàm tạo của nó làm tham số

  - Gọi phương thức start() của đối tượng Thread

  - Phương thức run() của đối tượng Runnable được gọi và thực thi trong một luồng riêng biệt

**Executor**

- JAVA cung cấp framework hỗ trợ đa luồng được goi là JAVA Executor Framework. Được sử dụng để chạy các đối tượng Runnable mà không cần tạo luồng mới mỗi lần và chủ yếu sử dụng lại các luồng đã tạo.

- Java.util.concurrent.Executors cung cấp các phương thức để tạo ThreadPool của các luồng công việc. ThreadPool sử dụng các luồng tồn tại và sử dụng lại các luồng đó. Bất kỳ tác vụ dư thừa nào được đưa vào các luồng trong ThreadPool nếu không thể xử lý thì đều sẽ được giữ trong Hàng đợi. Khi bất kỳ Thread nào được giải phóng, chúng sẽ nhận nhiệm vụ tiếp theo từ hàng đợi này

  - SingleThreadExecutor: Tạo ra một ThreadPool có khả năng thực thi 1 Thread trong đó, các Thread khi này được xem như được thực hiện tuần tự.

  - FixedThreadPool(n) : Đây là ThreadPool thông dụng. Phương thức này giúp tạo ra một Pool có thể chứa tối đa nThreads. Khi Pool đạt đến giá trị tối đa nThreads, các Thread còn lại sẽ được đưa vào hàng đợi và chờ đến khi có Thread trong Pool được xử lý xong mới được thực thi tiếp.
  - CachedThreadPool: Hệ thống sẽ tự quyết định số lượng Thread được thực thi. Pool sẽ cache và sử dụng lại cấu trúc của Thread cũ đã xử lý xong để thực thi cho Thread mới. Ngoài ra nếu một Thread trong Pool này không được sử dụng trong 1 khoảng thời gian sẽ bị gỡ ra khỏi cache.

##### Lock

- Locks (khóa) trong Java được sử dụng để thực hiện đồng bộ hóa truy cập vào các tài nguyên được chia sẻ giữa các luồng trong một chương trình đa luồng. Khi nhiều luồng cố gắng truy cập hoặc sửa đổi dữ liệu chia sẻ cùng một lúc, có thể xảy ra các vấn đề race conditions hoặc trạng thái không xác định của dữ liệu. Locks giúp giải quyết các vấn đề này bằng cách đảm bảo rằng chỉ một luồng có thể truy cập vào tài nguyên chia sẻ tại một thời điểm.

- Lock và synchronized là hai cách để thực hiện đồng bộ hóa trong Java, nhưng chúng có các đặc điểm và tính năng khác nhau.  Nhưng nên sử dụng Lock vì:

  - Lock Linh hoạt hơn vì bạn có thể chủ động kiểm soát việc đồng bộ hóa. Bạn có thể thực hiện đồng bộ hóa không chờ đợi, đặt thời gian chờ đợi, và giải phóng lock bất kỳ lúc nào.

  - Lock Đa nhiệm (khả năng của Hệ điều hành để thực thi nhiều hơn một nhiệm vụ hoặc công việc đồng thời trên một tài nguyên được chia sẻ). Lock Đa luồng (khả năng của Hệ điều hành thực thi nhiều luồng cùng một lúc)
  - Locks cung cấp khả năng loại bỏ lock mà không cần chờ đợi. Trong trường hợp bạn muốn giải phóng lock mà không cần đợi, bạn có thể gọi `unlock()` một cách tự do.

##### Atomic Interger

- AtomicInteger là một lớp trong Java thuộc gói java.util.concurrent.atomic, được thiết kế để hỗ trợ các phép toán nguyên tố (atomic operations) trên biến kiểu nguyên (int) mà không cần sử dụng locks. Atomic operations là các phép toán mà không bị ngắt gián đoạn bởi các luồng khác và được thực hiện nguyên vẹn mà không bị trạng thái chưa xác định (intermediate state).
- Trong AtomicInteger, các phép toán như tăng (increment), giảm (decrement), cộng (add), trừ (subtract), và so sánh-đặt (compareAndSet) đều được thực hiện một cách nguyên vẹn và không bị chia cắt bởi các luồng khác.
- AtomicInteger không hoàn toàn thay thế cho việc sử dụng locks, nhưng trong một số trường hợp đơn giản khi bạn chỉ cần thực hiện các phép toán nguyên tố một cách an toàn, AtomicInteger là một giải pháp hiệu quả và dễ sử dụng.

##### ConcurrentHashMap

- ConcurrentHashMap là một lớp trong Java thuộc gói java.util.concurrent được thiết kế để hỗ trợ các thao tác đọc và ghi an toàn trong môi trường đa luồng mà không cần sử dụng locks bên ngoài. Nó là một phiên bản đồng bộ hóa của HashMap, cho phép nhiều luồng truy cập và thay đổi dữ liệu một cách an toàn.

  - Các phép toán đọc như get() và containsKey() không chặn các luồng khác đang cố gắng đọc hoặc ghi dữ liệu.

  - Các phép toán ghi như put(), remove(), và replace() được thực hiện một cách an toàn và đồng bộ hóa giữa các luồng.
  - ConcurrentHashMap chia dữ liệu thành nhiều phần nhỏ, gọi là các segment. Mỗi segment được quản lý bởi một lock riêng biệt, điều này giúp giảm bớt sự cần thiết phải đồng bộ hóa toàn bộ bộ nhớ.
  - ConcurrentHashMap không cho phép chứa các khóa hoặc giá trị null



