

# REPORT WEEK 5 & WEEK 6

*Thực tập sinh: Nguyễn Khoa Đoàn*

### 1. Mô tả

- Big Data 
- Hadoop ecosystem
- Khái niệm cơ bản về HDFS, Đọc ghi trong HDFS, khái niệm namenode, datanode, secondary namenode, HDFS block, block replication
- Khái niệm YARN, Các thành phần YARN, MapReduce
- Thành phần SPARK, SPARK API
- HA trong HDFS (JournalNode, Zookeeper)
- Khải niệm editlog, stand by namenode, FSimage

![Lightbox](https://media.geeksforgeeks.org/wp-content/cdn-uploads/HadoopEcosystem-min.png)

### 2. Kết quả 

#### 2.1 Big data

- Bắt nguồn từ nghiên cứu của Google về MapReduce, và sự bùng nổ dữ liệu
- Big data có độ đa dạng dữ liệu cao hơn, khối lượng ngày càng tăng và tốc độ cao, yêu cầu kiến trúc có thể mở rộng để lưu trữ. 3 Vs:
  - Volume Khối lượng
  - Velocity: Tốc độ nhận và xử lý dữ liệu
  - Variety: Đa dạng dữ liệu
- Ngày nay, Vs mở rộng:
  - Veracity (Xác thực): Chất lượng của dữ liệu (Dữ liệu từ nguồn không chính xác sẽ trở nên vô nghĩa)
  - Value (Giá trị): Dữ liệu có giá trị nội tại. Có giá trị khi được khai thác
  - Visualization (Trực quan hóa): Dữ liệu phải dễ hiểu với các bên phi kỹ thuật. Tạo ra các biểu đồ phức tạp
  - Variability (Tính biến đổi): Ý nghĩa của dữ liệu có thể thay đổi theo thời gian
- Data Warehouse (Kho dữ liệu)
  - Kho dữ liệu là một hệ thống lấy dữ liệu từ nhiều nguồn khác nhau về một tổ chức, chuyển đổi và lưu trữ dữ liệu đó cho mục đích báo cáo và phân tích. (ETL)
- Data Lake (Hồ dữ liệu)
  - Hồ dữ liệu lưu trữ dữ liệu thuộc mọi loại, kích cỡ và định dạng ở định dạng gốc cho đến khi cần. Hồ dữ liệu có thể có dung lượng lưu trữ lớn hơn kho dữ liệu.
- Data mart
  - Tập con dữ liệu có cùng chủ đề. Phục vụ nhu cầu của một bộ phận cụ thể trong tổ chức

#### 2.2 Hadoop Ecosystem

- Hadoop ecosystem đề cập đến các thành phần khác nhau của thư viện phần mềm Apache Hadoop. Các công cụ nổi tiếng của hệ sinh thái Hadoop bao gồm HDFS, Hive, Pig, YARN, MapReduce , Spark, HBase, Oozie, Sqoop, Zookeeper, v.v. 
- Hadoop là một nền mã nguồn mở tảng đáng tin cậy, phân tán và có thể mở rộng để lưu trữ và phân tích lượng dữ liệu khổng lồ.
- Điểm hấp dẫn của Hadoop là khả năng chạy trên phần cứng thông dụng giá rẻ, trong khi các đối thủ cạnh tranh của nó có thể cần phần cứng đắt tiền để thực hiện công việc tương tự.

#### 2.3 HDFS

- HDFS là hệ thống quản lý dữ liệu phân tán dựa trên nền tảng Java cung cấp giải pháp lưu trữ tin cậy, ổn định, truy cập nhanh chóng. Với mục đích này thì cách thức “wrice once, read many” được sử dụng, cho phép dữ liệu thường được ghi một lần mỗi HDFS, sau đó sẽ được đọc nhiều lần.
- Hai thành phần của HDFS:
  - Namenode: Lưu trữ metadata (Data about data), Tiêu đề và mô tả, thẻ và danh mục, ai đã tạo và khi nào, ai sửa đổi lần cuối và khi nào, ai có thể truy cập, ai có thể cập nhật
  - Datanode: Lưu actual data, chứa các byte thực tế tạo nên một tệp được lưu trữ trên HDFS
  - Mối quan hệ giữa Namenode và Datanodes là mối quan hệ giữa chủ và nô lệ. Namenode đóng vai trò là chủ và Datanode là nô lệ.
  - Client giao tiếp với Namenode để đọc hoặc ghi tệp. Namenode phản hồi với vị trí của các Datanode phù hợp để client gửi hoặc nhận dữ liệu
  - Secondary Namenode: Nó liên đọc nội dung trong Editlogs và cập nhật vào FsImage, để chuẩn bị cho lần khởi động tiếp theo của namenode. Nó liên tục kiểm tra tính chính xác của các tệp tin lưu trên các datanode. Secondary Namenode trợ giúp cho Namenode chính, nhưng không thể thay thế nó trong trường hợp bị lỗi. Thông thường, Namenode phụ được chạy trên một máy khác vì nó yêu cầu tài nguyên bộ nhớ và máy tính tương tự như chính Namenode.
- HDFS block
  - Blocks là một đơn vị lưu trữ của HDFS, các data được đưa vào HDFS sẽ được chia thành các block có các kích thước cố định (nếu không cấu hình thì mặc định nó là 128MB).
- Large block size
  - Giảm áp lực cho Namenode: Với block size bé, như 1KB, để lưu file 10KB cần có 10 HDFS mà Namenode cần lưu trữ trong bộ nhớ. Thay vào đó sử dụng size 10KB
  - Giảm thời gian tìm kiếm: Giả sử phải mất 10ms để tìm đến đầu khối và tốc độ truyền dữ liệu là 100MB/s. Kích thước khối cần phải có kích thước khoảng 100 MB để làm cho thời gian tìm kiếm đĩa bằng 1% thời gian truyền.
  - Có throughput cao: tốc độ xử lý truy nhập dữ liệu cao 
  - Cải thiện hiệu suất MapReduce: Nếu block size quá nhỏ, dẫn tới nhiều tác vụ Map dẫn tới viêc quản lý quá tải. Ngược lại, block size không nên quá to, dẫn tới việc quá ít tác vụ map và tăng thời gian thực thi
- Block Replication
  - Nếu 1 file gồm 4 HDFS blocks và hệ số sao chép là 3, sau đó mỗi khối dữ liệu sẽ có 3 bản sao chép của chúng. Các bản sao này nằm rải rác trong cụm, có tổng cộng 12 khối. Việc sao chép đảm bảo rằng nếu một khối dữ liệu bị hỏng hoặc xảy ra lỗi phần cứng thì yêu cầu đọc vẫn có thể được thực hiện bởi một bản sao có sẵn khác của khối đó. 
  - Lựa chọn node cho việc sao chép
    - Trong thực tế, Hadoop đặt bản sao đầu tiên trên cùng nút với máy khách. Nếu máy khách đang chạy bên ngoài cụm, một nút sẽ được chọn ngẫu nhiên. Bản sao thứ hai được đặt trên giá được chọn ngẫu nhiên khác với bản sao đầu tiên. Bản sao thứ ba được đặt trên một nút được chọn ngẫu nhiên trên cùng giá với bản sao thứ hai. Bất kỳ bản sao nào khác sẽ được đặt trên các nút được chọn ngẫu nhiên mà không đặt quá nhiều bản sao vào cùng một giá.

![img](https://i.imgur.com/Z6k4xMx.png)

- Read

  - Client RPC (Gọi hàm từ xa) call tới Namenode truy xuất một vài vị trí khối đầu tiên của tệp mà máy khách muốn đọc (1: open)
  - Namenode phản hồi lại danh sách địa chỉ Datanode chứa bản sao của block đó. (2: get block locations)
  - Đọc thông qua FSDataInputStream, Client gọi phương thức read() ở FSDataInputStream, DFSInputStream kết nối với DataNode gần nhất để đọc block đầu tiên của file. Phương thức read() được lặp đi lặp lại nhiều lần cho đến cuối block. (3:read, 4:read,5:read)
  - Nếu không có bản sao cục bộ của khối dữ liệu hoặc máy khách đang chạy bên ngoài cụm thì máy khách sẽ kết nối với DataNode gần nhất để truy xuất khối đầu tiên trong tệp. 
  - Quá trình này được lặp lại. Máy khách kết nối với Datanode gần nhất để lấy khối dữ liệu tiếp theo. Các khối tập tin được đọc theo thứ tự.
  - Nếu xảy ra lỗi khi giao tiếp với Datanode, thì nó sẽ chuyển sang DataNode khác gần nhất có chứa block đó. Nút dữ liệu bị lỗi sẽ được ghi nhớ để nó không truy xuất bất kỳ khối nào trong tương lai.
  - Đọc xong file thì đóng (6:close)

  ![Đọc dữ liệu trong HDFS](https://images.viblo.asia/69e90a8e-d994-4d0c-82f9-96593dc0ec31.png)

- Write

  - Ban đầu, client tạo bộ đệm trên đĩa cục bộ. Chờ cho đến khi tích lũy 1 khối HDFS trước khi liên hệ với Namenode.
  - Namenode, sau khi được client liên hệ, sẽ xác minh xem tệp có tồn tại hay không và client có các quyền cần thiết để tạo tệp đó hay không. Nếu thỏa mãn, Namenode sẽ trả về cho client danh sách các DataNodes mà có thể ghi. Các DataNode này lưu trữ các khối (và bản sao của chúng) tạo nên tệp.
  - Sau khi nhận được danh sách từ Namenode, client bắt đầu ghi từ DataNode đầu tiên.
  - DataNode đầu tiên nhận data từ client theo từng phần. Nó nhận phần đầu tiên, ghi nó vào kho lưu trữ cục bộ và sau đó bắt đầu chuyển phần đó sang DataNode thứ hai trong danh sách.
  - DataNode thứ 2 nhận data từ DataNode đầu tiền, ghi vào kho lưu trữ cục bộ, và chuyển phần đó sang DataNode thứ 3
  - Một pipeline được hình thành từ máy khách đến tất cả các DataNode có liên quan. Một DataNode có thể đồng thời nhận và truyền dữ liệu.

  ![Ghi dữ liệu trong HDFS](https://images.viblo.asia/63e4d759-b3df-49ea-ad1b-59d6abb09e2a.png)

#### 2.4 YARN

![img](https://i.imgur.com/9mVlw5h.png)

- YARN là Yet Another Resource Negotiator. Bao gồm 2 công việc chính:
  - Quản lý các tài nguyên cụm như máy tính, mạng và bộ nhớ
  - Lập kế hoạch và giám sát công việc

- YARN thực hiện mục tiêu này qua 2 trình:
  - Quản lý tài nguyên
  - Quản lý Node

![img](https://i.imgur.com/Hc8PmT1.png)

- Hai thành phần này hoạt động theo mối quan hệ chủ - nô lệ. Trong đó, Resource Manager là chủ và Node Manager là nô lệ. Cùng nhau, hai thành phần này tạo nên khung tính toán dữ liệu
- Resource Manager gồm 2 thành phần:
  - Applications Manager: chịu trách nhiệm chấp nhận các yêu cầu gửi công việc và khởi tạo vùng chứa cho một thực thể được gọi là ApplicationMaster. Nó cũng khởi tạo lại vùng chứa ApplicationMaster nếu vùng chứa bị lỗi. 
  - Scheduler: Bộ lập lịch chịu trách nhiệm phân bổ các tài nguyên như đĩa, CPU và các ứng dụng đang chạy mạng, tuân theo các hạn chế do hàng đợi và dung lượng áp đặt. Bộ lập lịch không giám sát các ứng dụng cũng như không bắt đầu khởi động lại khi có lỗi ứng dụng hoặc phần cứng.
  - Người đọc sẽ nhận ra rằng nếu Resource Manager bị lỗi thì không có công việc nào được lên lịch. Điều này yêu cầu một Standby ResourceManager, nếu ResourceManager đang hoạt động bị lỗi thì trình quản lý dự phòng sẽ hoạt động và cụm tiếp tục hoạt động chính xác. 
- Node manager:
  - NodeManager là một tác nhân chạy trên mọi máy trong cụm. Nó chịu trách nhiệm khởi chạy các container trên máy đó và quản lý việc sử dụng tài nguyên của các container. Nó báo cáo việc sử dụng trở lại thành phần Scheduler của Resource Manager
- Work flow:
  - Client gửi công việc cho Resource Manager
  - Resource Manager tìm kiếm Node manager có thể khởi chạy vùng chứa để lữu trữ Application Master
  - Application Master đại diện cho công việc của client
  - Node Manager đại diện cho Application Master khởi chạy các container chạy các tính toán phân tán

![img](https://i.imgur.com/oaO5dkG.png)

- Ứng dụng YARN có thể chạy trong vài giây tới vài ngày. Việc ánh xạ Job tới Ứng dụng có thể diễn ra theo ba mô hình:

  - One job per application: Đây là mô hình đơn giản nhất.

  - Several jobs per application: Điều này phù hợp để chạy một số công việc (có thể liên quan) dưới dạng một quy trình làm việc hoặc trong một phiên người dùng. Lợi ích là các container có thể được tái sử dụng trong các công việc và dữ liệu trung gian giữa các công việc có thể được lưu vào bộ nhớ.

  - Perpetually running application: Trong mô hình này, một ứng dụng đóng vai trò điều phối viên sẽ tiếp tục chạy, thậm chí là mãi mãi và được chia sẻ giữa nhiều người dùng khác nhau. 

![img](https://i.imgur.com/uc0qlng.png)

#### 2.5 MapReduce

- MapReduce là sự kết hợp của “map” và “reduce” để mô tả hai giai đoạn mà nó bao gồm. 
- MapReduce giống như một chiến lược chia để trị. Một tập dữ liệu khổng lồ được chia cho các máy công nhân. Sau khi quá trình xử lý hoàn tất, dữ liệu từ mỗi máy sẽ được tổng hợp để đưa ra kết quả cuối cùng. 
- Mô hình bao gồm hai giai đoạn: 
  - Giai đoạn Map: Hàm này có nhiệm vụ là xử lý một cặp key (key, value) để tạo ra một cặp key mới (keyl, valuel), lúc này cặp key (keyl, valuel) sẽ đóng vai trò là trung gian. Sau đó, người dùng chỉ cần ghi dữ liệu xuống đĩa cứng và nhanh chóng tiến hành thông báo cho hàm Reduce để dữ liệu đi vào input của Reduce.
  - Pha Reduce: Hàm này có nhiệm vụ là tiếp nhận cặp từ khoá trung gian và giá trị tương ứng với lượng từ khoá đó (keyl, valuel) để tạo thành một tập khoá khác nhau bằng cách tiến hành ghép chúng lại.
  - Ngoài ra, ở giữa Map và Reduce còn một bước trung gian khác mang tên Shuffle. Sau khi Map hoàn thành xong nhiệm vụ của mình thì Shuffle sẽ tiếp tục công việc thu thập cũng như tổng hợp cặp từ khoá/giá trị trung gian đã được tạo ra bởi Map trước đó và chuyển nó đến Reduce để tiếp tục xử lý.
- **Đặc điểm**
  - Distributed: MapReduce là một khung phân tán bao gồm các cụm phần cứng hàng hóa chạy các tác vụ Map hoặc Reduce.
  - Parallel: Các tác vụ Map và Reduce luôn hoạt động song song.
  - Fault tolerant: Nếu bất kỳ tác vụ nào bị lỗi, nó sẽ được lên lịch lại trên một nút khác.
  - Scalable: Nó có thể mở rộng quy mô tùy ý. Khi bài toán trở nên lớn hơn, có thể thêm nhiều máy móc hơn để giải bài toán trong một khoảng thời gian hợp lý; khung có thể mở rộng theo chiều ngang thay vì theo chiều dọc.

- Mapper Input
  - Mỗi dòng trong tệp dữ liệu đại diện cho một bản ghi. Khi ứng dụng MapReduce tính toán phần phân chia đầu vào, nó sẽ tìm ra nơi bắt đầu của toàn bộ bản ghi đầu tiên trong một khối và nơi kết thúc của bản ghi cuối cùng trong khối. Trong trường hợp bản ghi cuối cùng trong một khối không đầy đủ, phần phân tách đầu vào sẽ bao gồm thông tin vị trí cho khối tiếp theo và độ lệch byte của dữ liệu cần thiết để hoàn thành bản ghi. Hệ quả: tác vụ Map xử lý việc phân chia đầu vào như vậy có thể đọc khối dữ liệu từ xa được lưu trữ trên một nút khác trong cụm để xử lý hoàn toàn việc phân tách đầu vào.
- Data locality (Vị trí dữ liệu)
  - Dữ liệu trong cụm Hadoop có thể được đặt ở bất cứ đâu. Framework cố gắng lập lịch tác vụ Map trên cùng node có dữ liệu đầu vào cho tác vụ map đó. 
  - Nếu tác vụ Map không thể được lên lịch trên cùng một nút nơi chứa dữ liệu của nó hoặc một trong các bản sao của nó, thì framwork sẽ cố gắng chọn một nút trong giá chứa dữ liệu
  - Cuối cùng, nếu 2 điều trên là không thể, một nút ngoài giá sẽ được chọn để chạy tác vụ Map và quá trình truyền dữ liệu giữa các giá sẽ diễn ra

![img](https://i.imgur.com/VekNzRT.png)

- Tác vụ Reduce hoạt động dựa trên đầu vào trung gian do tác vụ Map tạo ra. Các tác vụ Reduce hoàn toàn độc lập với nhau giống như các tác vụ Map; họ không giao tiếp. Tuy nhiên, các tác vụ Reduce yêu cầu các cặp khóa/giá trị trung gian do các tác vụ ánh xạ tạo ra làm đầu vào. 
- Combiner (Bộ kết hợp)
  - Chúng ta có thể chỉ định một lớp hoạt động dựa trên đầu ra của tác vụ Map cho mỗi khóa. Một trong những lý do để triển khai bộ kết hợp là để tổng hợp đầu ra Map trung gian. 
- Partitioner (Trình phân vùng)
  - Trình phân vùng xác định phân vùng nào mà khóa của bản ghi ánh xạ tới và định vị bản ghi cho phân vùng đó

![img](https://i.imgur.com/GuW4Rcn.png)

![img](https://i.imgur.com/PXI2r7V.png)

1. Công việc được gửi đi bởi phương thức waitForCompletion(). Phương thức này trả về công việc nếu như công việc đã được hoàn thành

2. Lớp JobSubmitter chịu trách nhiệm giao tiếp với RM (Trình quản lý tài nguyên) và lấy ID ứng dụng mới được sử dụng làm ID công việc MapReduce. Lớp này cũng thực hiện kiểm tra độ chính xác, chẳng hạn như xác minh xem đường dẫn đầu ra có tồn tại hay không và việc phân chia đầu vào có thể được tính toán thành công hay không.

3. Tiếp theo, tài nguyên cần thiết cho công việc được sao chép tới HDFS trong thư mục chạy, với ID của công việc trong đường dẫn. Các tài nguyên bao gồm tệp jar chứa mã chương trình mapper và trình reducer để thực thi. Tệp này được đổi tên thành job.jar . Các tệp cấu hình và siêu dữ liệu về phân chia đầu vào cũng được sao chép. Sau khi công việc kết thúc thành công, framework sẽ xóa thư mục staging này. Bạn có thể đặt thuộc tính mapreduce.task.files.preserve.filepattern để chọn những tệp cần giữ cho mục đích gỡ lỗi.

4. Công việc được gửi để thực thi cho RM bằng cách gọi phương thức submitApplication()trên trình quản lý tài nguyên.

5. Người quản lý tài nguyên, khi nhận được submitApplication(), sẽ chuyển yêu cầu tới bộ lập lịch YARN. Một vùng chứa được phân bổ và một Application Master của ứng dụng, được đại diện bởi lớp MRAppMaster, được khởi chạy trong vùng chứa. Trình quản lý nút quản lý việc khởi chạy tiến trình chính.

6. ApplicationMaster đã tạo sẽ khởi tạo một số đối tượng book-keeping cần thiết để theo dõi tiến trình của Map và Reduce các tác vụ được tạo 

7. Sau đó, ApplicationMaster cần quyết định chạy Map và Reduce trong cùng một JVM hoặc yêu cầu các vùng chứa để các tác vụ có thể chạy song song. Đôi khi ApplicationMaster chạy các tác vụ trong cùng một JVM. Một công việc nhỏ có thể hoàn thành sớm hơn khi các tác vụ Map và Reduce chạy tuần tự trong cùng một JVM so với khi chúng được chạy trong các vùng chứa riêng biệt trên các nút khác nhau. Nếu một công việc được thực thi trong cùng một JVM với ApplicationMaster, thì công việc đó sẽ được uber hóa và các tác vụ này được gọi là các tác vụ uber.
8. Nếu một công việc không thể chạy như một công việc uber thì ApplicationMaster sẽ yêu cầu các vùng chứa cho tất cả các tác vụ Map và Reduce từ trình quản lý tài nguyên. 
9. Khi Trình lập lịch biểu của ResourceManager đã được lên lịch phù hợp trên một nút cụ thể, ApplicationMaster sẽ liên hệ với trình quản lý nút để khởi động vùng chứa các tài nguyên cần thiết cho tác vụ Map Reduce. 
10. Tác vụ Map và Reduce báo cáo tiến trình của nó tới ApplicationMaster. Chương trình client có thể thăm dò ApplicaitonMaster để biết các bộ đếm và trạng thái khác nhau. Giao diện người dùng web RM hiển thị tất cả các ứng dụng đang chạy có liên kết đến ApplicationMasters của chúng, mỗi ứng dụng sẽ hiển thị thông tin chi tiết hơn về công việc và tiến trình của nó.
11. Sau khi ApplicaitonMaster được thông báo về việc hoàn thành nhiệm vụ cuối cùng, AM sẽ đánh dấu trạng thái công việc là thành công. ApplicaitonMaster và Task containers cũng dọn dẹp trạng thái của nó và xóa mọi đầu ra trung gian sau khi công việc hoàn thành.

#### 2.6 SPARK

- Spark, nền tảng phổ biến để xử lý dữ liệu và đã gần như thay thế MapReduce truyền thống. Apache Spark có thể chạy nhanh hơn 10 lần so với Haddop ở trên đĩa cứng và 100 lần khi chạy trên bộ nhớ RAM.

![img](https://i.imgur.com/qSVt0ub.png)

- Sự khác biệt với MapReduce
  - Các công việc lặp lại giảm thời gian I/O
  - Hỗ trợ phân tích tương tác
  - Nhiều APIs



- Spark có kiến trúc chủ-nô lệ giống như MapReduce, trong đó một tiến trình, chủ, điều phối và phân phối công việc giữa các quy trình phụ. Hai quá trình này được gọi là:

  - Driver
  - Executor
- Driver
  - Điều khiển các Spark job. Chịu trách nhiệm duy trì trạng thái chung của ứng dụng Spark, phản hồi chương trình hoặc đầu vào của người dùng và phân tích, phân phối và lập lịch công việc giữa các tiến trình thực thi. Driver là trung tâm của ứng dụng Spark và duy trì tất cả thông tin liên quan đến ứng dụng trong suốt vòng đời của ứng dụng.
- Executor

  - Executors là nô lệ thực thi code được giao bởi Driver. Và phản hồi lại trạng thái toán của nó cho Driver.

![img](https://i.imgur.com/G7bAnR5.png)

- Spark có thể chạy các quản lý cụm sau:

  - Hadoop YARN
  - Apache Mesos
  - Standalone Cluster Manager
  - Localmode

![img](https://i.imgur.com/Ej2BifN.png)

Execution modes (Chế độ thực thi)

- Cluster mode: Trong cluster mode, user gửi spark application tới cluster manager. Cluster manager lần lượt sinh ra Driver và Executor để thực thi job. Cả driver và executors đều tồn tại trong cụm

![img](https://i.imgur.com/hqGH4bH.png)

- Client mode:  Giống Cluster mode ngoại trừ việc Driver sẽ ở trên máy client, submit Spark job bên ngoài cụm. Client chịu trách nhiệm duy trì Driver Process, trong khi đó cluster chịu trách nhiệm duy trì Executor process.

![img](https://i.imgur.com/cuWmny1.png)

- Vòng đời của Spark
  - Người dùng submit task tới cluster. Nếu job này được chấp nhận, Resource Manager sẽ chạy Spark driver trên một máy trong cụm
  - Khi driver bắt đầu chạy, nó thực thi code của người dùng. Code cần có SparkSession để sets-up Spark cluster. Driver process và executor processes gọi chung là Spark cluster. SparkSesssion giao tiếp với Cluster Manager daemon, để chạy Spark executor process
  - RM (Cluster Manager) sẽ chạy Spark executor trên cụm và trả về vị trí của executor process cho Driver process.
  - Khi cụm Spark sẵn sàng, driver giao task cho executor, và bắt đầu thực thi job. Data có thể được di chuyển và executor báo cáo về trạng thái của họ cho Driver
  - Driver thoát khi Spark job hoàn thành, và cluster manager đóng executor processes thay cho Driver



#### 2.7 High Avaibility

- HA là đặc trưng của hệ thống phân tán. standby Namenodes là 1 trong số thể hiện của HA trong HDFS

- Giả sử cụm có 2 Namenodes. Để standby Namenode có thể thay thế Namenode bị lỗi thành công, nó cần bắt chước chính xác các hành động được thực hiện bởi Namenode. Điều này được triển thai bằng cách sử dụng JournalNodes. Giống như nhật ký , JournalNodes lưu giữ bản ghi tất cả các thay đổi mà Namenode đang hoạt động. Vì là hệ thống phân tán nên các thay đổi được ghi lại vào phần lớn các JournalNodes. Cần nhiều hơn một JournalNode để ghi lại hoạt đông của Namenode vì bản thân JournalNode dễ bị lỗi.
- Công thức cho biết số lần thất bại mà JournalNode có thể chấp nhận được: (N-1)/2
  - N: số lượng JournalNodes trong thiết lập HA (N > 3)

![img](https://i.imgur.com/kYQN4se.png)



#### 2.8 Zookeeper

- ZooKeeper là một dịch vụ tập trung để duy trì thông tin cấu hình, đặt tên, cung cấp các dịch vụ nhóm và đồng bộ hóa phân tán. Tất cả các dịch vụ này được sử dụng bởi các ứng dụng phân tán. 
- Zookeeper rất dễ hiểu. Hãy nghĩ về nó như một hệ thống tập tin phân cấp hoặc một cái cây. Khối xây dựng cơ bản của Zookeeper là znode . Một znode có thể lưu trữ dữ liệu (như một tập tin) hoặc có các znode con (như một thư mục). Thiết kế tổng thể của Zookeeper cung cấp một hệ thống có tính sẵn sàng cao bao gồm các znode tạo nên một không gian tên có thứ bậc.

![img](https://i.imgur.com/4FFnCUY.png)

- Zookeeper có thể chạy trên server độc lập trong standalone mode hoặc trên một cụm máy ở chế độ sao chép replicated mode, gọi là tập hợp (ensemble). Tính HA ở chế độ sao chép (replicated) đạt được bằng cách đảm bảo các sửa đổi đối với cây znodes được sao chép thành phần lớn của tập ensemble. Giả sử 5 máy (A, B, C, D, E) chạy trong Zookeeper ensemble. Phần lớn số máy, gọi là quorum, cần update. Máy A, C, E cần update. Nếu một số máy bị lỗi, giả sử là A và E bị lỗi khi đó có ít nhất một máy C có trạng thái mới nhất. Hai máy còn lại là B và D có thể nắm được trạng thái mới nhất. 
- Zookeeper sử dụng giao thức gọi là Zab để triển khai. Giao thức hoạt động theo 2 giai đoạn. 
  - Giai đoạn 1: Lựa chọn leader, những người khác là người theo dõi và đồng bộ hóa trạng thái với leader.
  - Giai đoạn 2: Tất cả yêu cầu ghi đều được chuyển tiếp đến leader, người này sẽ gửi thông tin update cho người theo dõi

- Máy trong ensemble ghi cập nhật vào đĩa trước khi cập nhật trong bộ bản sao trong cây znode. Client có thể trực tiếp gửi yêu cầu đọc tới bất kỳ máy nào

- Nếu leader gặp lỗi, thì tiến hành lựa chọn leader mới. Nếu leader cũ quay lại, nó thành người theo dõi

- Zookeeper không hỗ trợ các chế độ xem đồng thời nhất quán giữa nhiều khách hàng . Điều này có nghĩa là nếu khách hàng X cập nhật znode từ s thành s' và thông báo cho khách hàng Y đọc giá trị cập nhật của znode, thì Y có thể đọc giá trị cũ s chứ không phải s' . Để máy khách Y đọc giá trị mới nhất, nó phải gọi thao tác đồng bộ hóa (một phần của API Zookeeper) trên znode.

#### 2.9 Editlog, FSImage

- FS Image: FsImage là một tệp được lưu trữ trên hệ thống tệp OS chứa cấu trúc thư mục hoàn chỉnh (không gian tên) của HDFS với các chi tiết về vị trí của dữ liệu trên Khối dữ liệu và khối nào được lưu trữ trên nút nào. Tệp này được NameNode sử dụng khi nó được khởi động.

- Editlog: EditLogs là nhật ký giao dịch ghi lại các thay đổi trong hệ thống tệp HDFS hoặc bất kỳ hành động nào được thực hiện trên cụm HDFS chẳng hạn như thêm khối mới, sao chép, xóa, v.v. Nói tóm lại, nó ghi lại các thay đổi kể từ khi FsImage cuối cùng được tạo.