# WEEK 4 REPORT

##### Thực tập sinh: Nguyễn Khoa Đoàn

#### 1. Mô tả công việc

- Tự cài đặt một cơ sở dữ liệu trên máy tính (cụ thể là mysql). Trình bày chi tiết về các thành phần liên quan
- Tự lấy ví dụ về 5 câu query không tốt và cách tối ưu nó.
- Tìm hiểu về các loại db và trình bày lại (ít nhất 3 db thuộc loại sql, 3 db thuộc loại no sql)

#### 2. Kết quả công việc

##### 2.1. MySQL

SQL là viết tắt của Ngôn ngữ truy vấn có cấu trúc và được sử dụng để giao tiếp với cơ sở dữ liệu quan hệ. Đó là ngôn ngữ tiêu chuẩn cho các hệ thống quản lý cơ sở dữ liệu quan hệ. Câu lệnh SQL được sử dụng để thực hiện các tác vụ như cập nhật dữ liệu trong cơ sở dữ liệu hoặc truy xuất dữ liệu từ cơ sở dữ liệu.

Các loại câu lệnh SQL. Các câu lệnh SQL được nhóm thành ba nhóm logic chính:

- Ngôn ngữ định nghĩa dữ liệu (DDL)
- Ngôn ngữ kiểm soát dữ liệu (DCL)
- Ngôn ngữ thao tác dữ liệu (DML)

**DDL**

| Câu lệnh | Mô tả                                                   |
| :------- | :------------------------------------------------------ |
| CREATE   | Tạo đối tượng mới trong cơ sở dữ liệu, table hoặc view. |
| ALTER    | Thay đổi cấu trúc của đối tượng                         |
| DROP     | Xóa đối tượng ra khỏi database                          |
| RENAME   | Đổi tên đối tượng                                       |

**DCL**

| Câu lệnh | Mô tả                              |
| :------- | :--------------------------------- |
| GRANT    | Cấp quyền các hoạt động cụ thể     |
| DENY     | Từ chối quyền các hoạt động cụ thể |
| REVOKE   | Xóa quyền đã cấp trước đó          |

**DML**

| Câu lệnh | Mô tả                        |
| :------- | :--------------------------- |
| SELECT   | Đọc các bản ghi từ bảng      |
| INSERT   | Thêm các bản ghi vào bảng    |
| UPDATE   | Thay đổi các bản ghi từ bảng |
| DELETE   | Xóa bản ghi từ bảng          |

MySQL: mysql -u root -p

Hiển thị databases: SHOW DATABASES

Tạo database: CREATE DATABASE SaleData

Chọn database muốn tạo bảng: USE SaleData

Tạo bảng: 

CREATE TABLE Customer ( 

​	ID  INT unsigned NOT NULL AUTO_INCREMENT, 

​	FirstName varchar(10) NOT NULL, 

​	LastName varchar(10) NOT NULL, 

​	Address varchar(30) NOT NULL, 

​	City varchar(20) NOT NULL, 

​	PRIMARY KEY (ID) 

);

CREATE TABLE Product (
	ProductID  INT unsigned NOT NULL,
	ProductName varchar(20) NOT NULL,
	Price decimal NOT NULL,
	PRIMARY KEY (ProductID) 

);

CREATE TABLE LineItem (
	OrderNo INT unsigned NOT NULL,
	ItemNo INT unsigned NOT NULL,
	ProductID INT unsigned NOT NULL,
	Quantity INT unsigned NOT NULL 

);

CREATE TABLE OrderList (
	OrderNo INT unsigned NOT NULL,
	OrderDate DATE NOT NULL,
	CustomerID INT unsigned NOT NULL,
	PRIMARY KEY (OrderNo) 

);

Thêm dữ liệu vào bảng:

INSERT INTO Customer (FirstName, LastName, Address, City) VALUES  

('Joe','Jones', '1 Main St.', 'Seattle'), ('Samir', 'Nadoy', '123 Elm PI.', 'New York');

INSERT INTO Product (ProductID, ProductName, Price) VALUES 

('123', 'Hammer', '2.99'), ('162', 'Screwdriver', '3.49'), ('201', 'Wrench', '4.25');

INSERT INTO OrderList (OrderNo, OrderDate, CustomerID) VALUES
('1000', '2023-01-01', '1'), ('1001', '2023-01-15', '2');

INSERT INTO LineItem (OrderNo, ItemNo, ProductID, Quantity) VALUES

('1000', '1', '123', '1'), ('1000', '2', '162' , '2'), ('1001','1', '123', '2');



![Order data in a normalized tabular schema](https://learn.microsoft.com/en-us/training/wwl-data-ai/explore-relational-data-offerings/media/normalized-data.png)

##### 2.2. 5 Câu query

- SELECT *

```sql
-- Bad

SELECT * FROM Customer WHERE id = 1;

-- Good

SELECT FirstName, LastName FROM Customer WHERE id = 1;
```



- SUB QUERY TRONG SELECT

```sql
-- Bad

SELECT LastName, (SELECT COUNT(*) FROM Order WHERE Order.Customer = Customer.id) AS order_count

FROM Customer;

-- Good

SELECT Customer.LastName, COUNT(Order.*) AS order_count

FROM Customer

JOIN Order ON Customer.id = Order.Customer

GROUP BY Customer.id;
```



- Sử dụng ORDER BY với số lượng lớn các bản ghi

```sql
-- Bad

SELECT * FROM Product ORDER BY price;

-- Good

SELECT * FROM Product ORDER BY price LIMIT 50;
```



- Sử dụng DISTINCT 

```sql
-- Bad

SELECT DISTINCT ProductName FROM Product;

-- Good

SELECT ProductName FROM Product;
```



- Sử dụng LIKE

```sql
-- Bad

SELECT * FROM Product WHERE name LIKE '%apple%';

-- Good

SELECT * FROM Product WHERE name LIKE 'apple%';
```



##### 2.3 3 loại sql, 3 loại noSql

- SQL

  - Relational Databases: Cơ sở dữ liệu quan hệ là một loại cơ sở dữ liệu lưu trữ và cung cấp quyền truy cập vào các điểm dữ liệu có liên quan đến nhau. Cơ sở dữ liệu quan hệ dựa trên mô hình quan hệ, một cách trực quan, đơn giản để biểu diễn dữ liệu trong bảng. Trong cơ sở dữ liệu quan hệ, mỗi hàng trong bảng là một bản ghi với một ID duy nhất được gọi là khóa. Các cột của bảng chứa các thuộc tính của dữ liệu và mỗi bản ghi thường có một giá trị cho mỗi thuộc tính, giúp dễ dàng thiết lập mối quan hệ giữa các điểm dữ liệu.
  - Các hệ thống RDBMS hữu dụng trong việc xử lí các dữ liệu được cấu trúc kỹ càng và hỗ trợ ACID – 4 thuộc tính quan trọng của bất kì hệ thống cơ sở dữ liệu nào:

    - Tính nguyên tố (Atomicity). Một giao dịch có nhiều thao tác khác biệt thì hoặc là toàn bộ các thao tác hoặc là không một thao tác nào được hoàn thành. Chẳng hạn việc chuyển tiền có thể thành công hay trục trặc vì nhiều lý do nhưng tính nguyên tố bảo đảm rằng một tài khoản sẽ không bị trừ tiền nếu như tài khoản kia chưa được cộng số tiền tương ứng.
    - Tính nhất quán (Consistency). Một giao dịch hoặc là sẽ tạo ra một trạng thái mới và hợp lệ cho dữ liệu, hoặc trong trường hợp có lỗi sẽ chuyển toàn bộ dữ liệu về trạng thái trước khi thực thi giao dịch.
    - Tính độc lập (Isolation). Một giao dịch đang thực thi và chưa được xác nhận phải bảo đảm tách biệt khỏi các giao dịch khác.
    - Tính bền vững (Durability). Dữ liệu được xác nhận sẽ được hệ thống lưu lại sao cho ngay cả trong trường hợp hỏng hóc hoặc có lỗi hệ thống, dữ liệu vẫn đảm bảo trong trạng thái chuẩn xác.
  - Columnar Databases: CSDL quan hệ là row store database hoặc row oriented database. Columnar databases là column oriented or column store database. Khi sử dụng columnar database, ta có thể thêm data bằng cách thêm 1 cột mới vào columnar database. 

- NoSQL

  - Key - Value Databases: Trong đó mỗi bản ghi mang 1 giá trị khóa duy nhất và 1 giá trị liên quan

  ![Image showing a key-value database](https://learn.microsoft.com/en-us/training/wwl-data-ai/explore-core-data-concepts/media/key-value-store.png)

  - Column Family Databases: Cơ sở dữ liệu column-family lưu trữ dữ liệu trong nhiều cột trong mỗi dòng với key cho từng dòng. Column families là một nhóm các dữ liệu liên quan được truy cập cùng với nhau

  ![Image showing a column family database](https://learn.microsoft.com/en-us/training/wwl-data-ai/explore-core-data-concepts/media/column-family-store.png)

  - Document Databases: Có thể ở định dạng dữ liệu JSON, XML, YAML, ...

  ![Image showing a document database](https://learn.microsoft.com/en-us/training/wwl-data-ai/explore-core-data-concepts/media/document-store.png)

  - Graph Database: Kiểu đồ thị này cho phép bạn lưu trữ các thực thể và quan hệ giữa các thực thể. Các đối tượng này còn được gọi là các nút, trong đó có các thuộc tính. Mỗi nút là một thể hiện của một đối tượng trong ứng dụng. Quan hệ được gọi là các cạnh, có thể có các thuộc tính. Cạnh có ý nghĩa định hướng; các nút được tổ chức bởi các mối quan hệ. 

  ![Image showing a graph database](https://learn.microsoft.com/en-us/training/wwl-data-ai/explore-core-data-concepts/media/graph.png)