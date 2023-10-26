# WEEK 2 REPORT

##### Thực tập sinh: Nguyễn Khoa Đoàn

#### 1. Mô tả công việc

* Collection(s): Tìm hiểu và viết trương trình java sử dụng các cấu trúc dữ liệu HashMap, HashSet, ArrayList
* Design Pattern: lựa chọn ít nhất 3 Design Pattern để implement bằng java và trình bày lại
* Serialize: tìm hiểu liên quan serialize trong java (viết code ví dụ minh họa bằng java và giải thích code)



#### 2. Kết quả công việc

##### 2.0 Các vấn đề cần được giải thích thêm

- Cách lưu trữ và hoạt động của hashcode trong Set

##### 2.1. Collections

- ArrayList: ArrayList là cấu trúc dữ liệu tương đương mảng, nhưng khác với mảng, khi thêm hoặc xóa ArrayList có thể thay đổi kích thước mảng
- HashMap: Là cấu trúc lưu trữ dữ liệu dưới dạng <Key, Value>. Trong hashmap Key sẽ ánh xạ tới Value tương ứng
- HashSet: Là cấu trúc lưu trữ liệu dưới dạng các đối tượng (object) 
- So sánh HashMap và HashSet:

Cả hai cấu trúc dữ liệu không duy trì bất kỳ thứ tự cho các phần tử truyền vào.
Cả hai đều sử dụng phương thức hashCode và equals để duy trì tính duy nhất của dữ liệu.
Cả hai cung cấp cho hiệu suất thời gian là hằng số cho các thao tác chèn và loại bỏ.
Cả hai đều không đồng bộ (non-synchronized).

| HashSet                                           | HashMap                                                      |
| :------------------------------------------------ | :----------------------------------------------------------- |
| Implement Set interface                           | Implement Map interface                                      |
| Không cho phép các phần tử trùng lặp              | Không cho phép các khóa (key) trùng lặp, nhưng cho phép các giá trị (value) trùng lặp. |
| Cho phép một phần tử null                         | Cho phép một khóa (key) null và nhiều giá trị (value) null   |
| Lưu trữ dưới dạng các đối tượng (object)          | Lưu trữ dưới dạng <Key, Value>                               |
| Sử dụng HashSet khi cần duy nhất dữ liệu (object) | Sử dụng HashMap khi cần duy nhất khóa (key)                  |

##### 2.2 Mô tả chương trình sử dụng ArrayList, HashMap, HashSet

Chương trình **ArrayListSolution.java**

- Khởi tạo ArrayList: 

```java
ArrayList<Integer> myArr = new ArrayList<Integer>();
```

- Thêm phần tử: 

```java
myArr.add(1);
myArr.add(5);
myArr.add(2);
myArr.add(1);
myArr.add(3);
```

- Thay đổi phần tử: 

```java
myArr.set(2, 4);
```

- Xóa phần tử:

```java
myArr.remove(3);
```

- Duyệt các phần tử:

```java
for (int i : myArr) {
    System.out.print(i + " ");
}
```

- Sắp xếp:

```java
Collections.sort(myArr);
```

- Kích cỡ mảng:

```java
myArr.size()
```



Chương trình **HashMapSolution.java**

- Khởi tạo HashMap:

```java
HashMap<Integer, Double> myHashMap = new HashMap<>();
```

- Thêm các phần tử:

```java
myHashMap.put(1, 100000.5);
myHashMap.put(2, 23000.8);
myHashMap.put(4, 640000.6);
myHashMap.put(3, 13540.5);
myHashMap.put(5, 100310.6);
myHashMap.put(9, 65000.3);
```

- Duyệt HashMap và in ra Key và Value tương ứng:

```java
for (int i : myHashMap.keySet()) {
    System.out.println("KEY:" + i + "-VALUE:" + myHashMap.get(i));
}
```

- Tìm phần tử có Key bằng 2:

```java
myHashMap.get(2)
```

- Xóa phần tử có Key bằng 3:

```java
myHashMap.remove(3);
```

- Kích thước HashMap:

```java
myHashMap.size()
```

- Kiểm tra xem có tồn tại Key:

```java
hashMap.containsKey(element)
```



Chương trình **HashSetSolution.java**

- Khai báo HashSet:

```java
HashSet<Student> myClass = new HashSet<Student>();
```

- Tạo các đối tượng thuộc lớp Student và thêm vào HashSet:

```java
Student student1 = new Student(1, "Doan");
Student student2 = new Student(2, "Khoa");
Student student3 = new Student(3, "Nguyen");

myClass.add(student1);
myClass.add(student2);
myClass.add(student3);
```

- Duyệt qua HashSet và gọi hàm toString qua từng phần tử:

```java
for (Student student : myClass) {
    System.out.println(student.toString());
}
```

- Tạo 2 đối tượng Student và kiểm tra 2 đối tượng có bằng nhau sử dụng equals():

```java
Student student4 = new Student(4, "A");
Student student5 = new Student(4, "B");
System.out.println(student4.equals(student5));

student5.setName("A");
System.out.println(student4.equals(student5));
```

- In ra size và hashcode của HashSet:

```java
System.out.println(myClass.hashCode());
System.out.println(myClass.size());
```

##### 2.3 Mô tả chương trình serialize

Chương trình **Teacher.java** implements interface Serializable

```java
public class Teacher implements Serializable {
    private int maSo;
    private String hoTen;

    public Teacher(int maSo, String hoTen) {
        this.maSo = maSo;
        this.hoTen = hoTen;
    }
}
```

Chương trình **TeacherSerialization.java** chuyển object qua byte stream

```java
public class TeacherSerialization {
    public static void main(String[] args) {
        Teacher teacher = new Teacher(10, "Nguyen Van A");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/SerializeObject/teacher.ser"))) {
            // Serialize đối tượng và ghi vào tệp tin
            out.writeObject(teacher);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

Chương trình **TeacherDeserialization.java** chuyển đổi các byte stream sang object

```java
public class TeacherDeserialization {
    public static void main(String[] args) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/SerializeObject/teacher.ser"))) {
            // Deserialization: Đọc đối tượng từ tệp tin
            Teacher deserializedTeacher = (Teacher) in.readObject();
            System.out.println("Deserialized teacher: " + deserializedTeacher);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

##### 2.4 Tìm hiểu Design Pattern

Design Patterns (Mẫu thiết kế) là một kỹ thuật trong lập trình hướng đối tượng. Design Pattern giúp tái sử dụng mã lệnh và dẽ dàng mở rộng. Design pattern cung cấp giải pháp ở dạng tổng quát, giúp tăng tốc độ phát triển phần mềm bằng cách đưa ra các mô hình test, mô hình phát triển đã qua kiểm nghiệm. Dùng lại các design pattern giúp tránh được các vấn đề tiềm ẩn có thể gây ra những lỗi lớn, dễ dàng nâng cấp, bảo trì về sau. 

Phân loại design pattern:

- **Creational Pattern** gồm: *Factory Method,* *Abstract Factory, Builder, Prototype, Singleton*. Những Design pattern loại này cung cấp một giải pháp để tạo ra các object và che giấu được logic của việc tạo ra nó, thay vì tạo ra object một cách trực tiếp bằng cách sử dụng từ khóa new. Điều này giúp cho chương trình trở nên mềm dẻo hơn trong việc quyết định object nào cần được tạo ra trong những tình huống được đưa ra.
- **Structural Pattern** gồm: *Adapter, Bridge, Composite, Decorator, Facade, Flyweight và Proxy*. Những Design pattern loại này liên quan tới **class** và các thành phần của **object**. Nó dùng để thiết lập, định nghĩa quan hệ giữa các đối tượng.
- **Behavioral Pattern** gồm: *Interpreter, Template Method, Chain of Responsibility, Command, Iterator, Mediator, Memento, Observer, State, Strategy và Visitor*. Nhóm này dùng trong thực hiện các hành vi của đối tượng, sự giao tiếp giữa các **object** với nhau.

##### 2.5 Factory  Pattern

![Factory Method pattern](https://refactoring.guru/images/patterns/content/factory-method/factory-method-en.png)

Factory Method Design Pattern hay gọi ngắn gọn là Factory Pattern là một trong những Pattern thuộc nhóm Creational Design Pattern. Nhiệm vụ của Factory Pattern là quản lý và trả về các đối tượng theo yêu cầu, giúp cho việc khởi tạo đổi tượng một cách linh hoạt hơn.

Factory Pattern đúng nghĩa là một nhà máy, và nhà máy này sẽ “sản xuất” các đối tượng theo yêu cầu.

Factory Pattern được sử dụng khi có một class cha (super-class) với nhiều class con (sub-class), dựa trên đầu vào và phải trả về 1 trong những class con đó.

Một Factory Pattern bao gồm các thành phần cơ bản sau:

- **Super Class**: môt super class trong Factory Pattern có thể là một **interface**, **abstract class** hay một **class** thông thường.
- **Sub Classes**: các sub class sẽ implement các phương thức của **supper class** theo nghiệp vụ riêng của nó.
- **Factory Class**: một class chịu tránh nhiệm khởi tạo các đối tượng **sub class** dựa theo tham số đầu vào. Factory class sử dụng if-else hoặc switch-case để xác định class con đầu ra.

![img](https://i.imgur.com/Jt0g77l.png)

##### 2.6 Facade Pattern

![Facade design pattern](https://refactoring.guru/images/patterns/content/facade/facade.png)

**Facade Pattern** là một trong những Pattern thuộc nhóm cấu trúc (Structural Pattern). Pattern này cung cấp một giao diện chung đơn giản thay cho một nhóm các giao diện có trong một hệ thống con (subsystem). Facade Pattern định nghĩa một giao diện ở một cấp độ cao hơn để giúp cho người dùng có thể dễ dàng sử dụng hệ thống con này.

**Facade Pattern** cho phép các đối tượng truy cập trực tiếp giao diện chung này để giao tiếp với các giao diện có trong hệ thống con. Mục tiêu là che giấu các hoạt động phức tạp bên trong hệ thống con, làm cho hệ thống con dễ sử dụng hơn.

Các thành phần cơ bản của một Facade Pattern:

- **Facade**: biết rõ lớp của hệ thống con nào đảm nhận việc đáp ứng yêu cầu của client, sẽ chuyển yêu cầu của client đến các đối tượng của hệ thống con tương ứng.
- **Subsystems**: cài đặt các chức năng của hệ thống con, xử lý công việc được gọi bởi Facade. Các lớp này không cần biết Facade và không tham chiếu đến nó.
- **Client**: đối tượng sử dụng Facade để tương tác với các subsystem.

![img](https://i.imgur.com/XMvrA1E.png)

##### 2.7 Observer Pattern

![Observer Design Pattern](https://refactoring.guru/images/patterns/content/observer/observer.png)

**Observer Pattern** là một trong những Pattern thuộc nhóm hành vi (Behavior Pattern). Nó định nghĩa mối phụ thuộc **một** – **nhiều** giữa các đối tượng để khi mà một đối tượng có sự thay đổi trạng thái, tất các thành phần phụ thuộc của nó sẽ được thông báo và cập nhật một cách tự động.

Observer có thể đăng ký với hệ thống. Khi hệ thống có sự thay đổi, hệ thống sẽ thông báo cho Observer biết. Khi không cần nữa, mẫu Observer sẽ được gỡ khỏi hệ thống.

Các thành phần tham gia Observer Pattern:

- **Subject** : chứa danh sách các observer, cung cấp phương thức để có thể thêm và loại bỏ observer.
- **Observer** : định nghĩa một phương thức update() cho các đối tượng sẽ được subject thông báo đến khi có sự thay đổi trạng thái.
- **ConcreteSubject** : cài đặt các phương thức của Subject, lưu trữ trạng thái danh sách các ConcreateObserver, gửi thông báo đến các observer của nó khi có sự thay đổi trạng thái.
- **ConcreteObserver** : cài đặt các phương thức của Observer, lưu trữ trạng thái của subject, thực thi việc cập nhật để giữ cho trạng thái đồng nhất với subject gửi thông báo đến.

Mỗi khi subject có sự thay đổi trạng thái, nó sẽ duyệt qua danh sách các observer của nó và gọi phương thức cập nhật trạng thái ở từng observer.

![img](https://i.imgur.com/CaQQcfs.png)
