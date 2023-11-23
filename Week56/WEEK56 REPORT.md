## Giới thiệu về dữ liệu lớn và Hadoop

*Thực tập sinh: Nguyễn Khoa Đoàn*

### 1. Hadoop

#### 1.1 Giới thiệu

- **Giới thiệu**
  - Năm 2004, lĩnh vực nghiên cứu Big Data tạo ra sự quan tâm rộng rãi trong giới kỹ thuật với việc các nhà nghiên cứu của Google xuất bản bài nghiên cứu về MapReduce. Sau đó Big Data dần trờ nên phổ biến. Điều này xảy ra do khối lượng dữ liệu được thu thập bùng nổ và các tập đoàn tìm cách khai thác từ các thiết bị Internet of Things (IoT). 
  - Giống như các công nghệ mới, Big Data từ mù mờ đến phổ biến và sau đó quay trở lại trạng thái ổn định. Dữ liệu lớn có thể không phải là liều thuốc chữa bách bệnh cho tất cả các vấn đề. Tuy nhiên, nó cực kỳ hữu ích trong một số khía cạnh của vấn đề dữ liệu, 
  - Ngày này, ngày càng có nhiều nhà cung cấp đám mây (AWS, Azure, GCP) cung cấp các giải pháp dựa trên nền tảng đám mây cho các vấn đề về dữ liệu lớn. Điều này giúp các công ty nhỏ cực kỳ dễ dàng tận dụng lợi ích của Dữ liệu lớn mà không cần triển khai tại chỗ tốn kém.

- **Hadoop**
  - Hadoop là biểu hiện phần mềm của Big Data

  - Hadoop là một nền mã nguồn mở tảng đáng tin cậy, phân tán và có thể mở rộng để lưu trữ và phân tích lượng dữ liệu khổng lồ.
  - Điểm hấp dẫn của Hadoop là khả năng chạy trên phần cứng thông dụng giá rẻ, trong khi các đối thủ cạnh tranh của nó có thể cần phần cứng đắt tiền để thực hiện công việc tương tự.

#### 1.2 Sự bùng nổ của Big Data

- Trong thế giới ngày nay, các nguồn dữ liệu tiềm năng ở xung quanh chúng ta và việc nắm bắt thu thập bằng kỹ thuật số dễ dàng hơn bao giờ hết. Như báo chí, GPS của điện thoại thông minh, những nhà hàng, những người gặp, giao dịch mua hàng, thời gian đi ngủ và thực dậy,... đều là những dữ liệu có thể được thu thập. 
- Thiết bị cảm biến có thể phát hiện chuyển động, nhiệt độ, tốc độ gió,... giá thành rẻ và có khả năng gửi dữ liệu định kỳ cho máy chủ. Ngày nay do sự phát triển nhanh hơn và băng thông mạng tốt hơn nên việc truyền dữ liệu khổng lồ chỉ là chuyện nhỏ.
- Ví dụ: TIktok có thể thu thập thông tin về các video, clip và mà người dùng đã xem, đối tượng mà người dùng tương tác để thông qua thuật toán đề xuất đưa ra các video, clip đề xuất hiệu quả.

- Dữ liệu được tạo ra từ con người và máy móc có thể sẽ tiếp tục tăng. Hàng núi dữ liệu được thu thập không thể được xử lý bằng các kỹ thuật xử lý và lưu trữ dữ liệu truyền thống. Ngay cả Trí tuệ nhân tạo và Học máy cũng được hưởng lợi từ Dữ liệu lớn. AI cần dữ liệu để xây dựng dựa trên trí thông minh của nó và nhiều dữ liệu hơn có thể đào tạo các thuật toán học tập tốt hơn.

#### 1.3 Thuật ngữ trong dữ liệu

- **Data (Dữ liệu)**
  - Dữ liệu là tập hợp thông tin
  - Dữ liệu có thể tồn tài ở nhiều dạng khác nhau: số, văn bản, byte, hình ảnh, video
  - Có 3 dạng dữ liệu: Structured, Semi-Structured, Unstructured
    - Structured data: Dữ liệu này có các thuộc tính được xác định trước giúp dễ dàng phân tích và tìm kiếm. Dữ liệu được lưu trữ trong cơ sở dữ liệu SQL có cấu trúc.
    - Unstructured data: Đặc trưng bởi việc thiếu cấu trúc tổ chức. Video, âm thành, blog, tệp nhất kỹ và bài đăng trên mạng xã hội bất kỳ đều là ví dụ về dữ liệu phi cấu trúc.
    - Semi-Structured data: Là sự kết hợp giữa dữ liệu cấu trúc và phi cấu trúc. Ví dụ bao gồm dữ liệu JSON và XML
- **Cơ sở dữ liệu**
  - Cơ sở dữ liệu là một tập hợp dữ liệu có tổ chức và cấu trúc,  thường được lưu trữ và truy xuất. Cơ sở dữ liệu tồn tại trong hệ thống quản lý cơ sở dữ liệu. Có cấu trúc và có tổ chức giúp việc truy xuất dữ liệu hiệu quả.
  - Có 2 loại có sở dữ liệu: Relational (SQL) và Non-Relational (NoSQL)
- **Cơ sở dữ liệu quan hệ**
  - Cơ sở dữ liệu quan hệ bao gồm dữ liệu được lứu trữ dưới dạng hàng trong bảng. Các cột của bảng tuần theo một lược đồ xác định mô tả loại và kích thước dữ liệu mà một cột trong bảng có thể chứa. Các bảng thường có một cột làm khóa, dùng để xác định duy nhất mỗi hàng trong bảng. 
  - Hệ thống quản lý cơ sở dữ liệu quan hệ (RDBMS) là công nghệ hoàn thiện và được áp dụng rộng rãi.
- **Cơ sở dữ liệu phi quan hệ/NoSQL**
  - Cơ sở dữ liệu NoSQL có nhiều dạng khác nhau và đáp ứng các trường hợp sử dụng khác nhau. Có nhiều dạng lữu trữ bao gồm key-value (Redis, Amazon Dynamo DB), column (HBase, Cassandra), document (Mongo DB, Couchbase), graph (Neo4J), và công cụ search (Solr, Elastic, Splunk). 
  - Sự khác biệt chính giữa cơ sở dữ liệu NoSQL và SQL là không có lược đồ
- **Big Data**
  - Dữ liệu lớn thường bao gồm các tập dữ liệu mà các công cụ phần mềm truyền thống (Ví dụ: công nghệ SQL) không thể nắm bắt, sắp xếp, quản lý và xử lý trong khoảng thời gian có thể chấp nhận được do kích thước khổng lồ của tập hợp

#### 1.4 Định nghĩa Big Data

- Dữ liệu lớn được định nghĩa là dữ liệu có độ đa dạng cao hơn với khối lượng ngày càng tăng và tốc độ cao hơn bao giờ hết, đồng thời yêu cầu kiến trúc có thể mở rộng để lưu trữ, thao tác và phân tích hiệu quả. Những thuộc tính này còn được gọi là ba Vs
  - Volume: Khối lượng dữ liệu rất quan trọng. Với Big Data người ta sẽ phải xử lý khối lượng dữ liệu lớn. Đây có thể là dữ liệu có giá trị không xác định.
  - Velocity: Tốc độ nhận và xử lý dữ liệu. Thông thường, tốc độ cao nhất của luồng dữ liệu trực tiếp vào bộ nhớ, thay vì được ghi vào đĩa. Một số sản phẩm thông minh hỗ trợ internet hoạt động theo thời gian thực hoặc gần thời gian thực.
  - Variety: Đa dạng đề cập đến nhiều loại dữ liệu có sẵn. Dữ liệu có nhiều dạng khác nhau. Dữ liệu có cấu trúc có thể được sắp xếp gọn gàng trong các cột của cơ sở dữ liệu. Loại dữ liệu này tương đối dễ dàng để nhập, lưu trữ, truy vấn và phân tích. Dữ liệu phi cấu trúc khó sắp xếp và trích xuất giá trị hơn
- Gần đây, có thêm nhiều Vs đã được thêm vào danh sách các đặc điểm mô tả Big Data:
  - Veracity (Tính xác thực): Điều này đề cập đến chất lượng của dữ liệu được thu thập. Nếu dữ liệu nguồn không chính xác, các phân tích sẽ vô giá trị.
  - Value (Giá trị): Giá trị là lợi ích hữu hình mà tổ chức có thể thu được từ dữ liệu. Dữ liệu có giá trị nội tại . Nhưng nó không có tác dụng cho đến khi giá trị được phát hiện.
  - Visualization (Trực quan hóa):  Dữ liệu phải dễ hiểu đối với các bên liên quan phi kỹ thuật và người ra quyết định. Trực quan hóa là việc tạo ra các biểu đồ phức tạp
  - Variability (Tính biến đổi): Ý nghĩa và bối cảnh của dữ liệu có thể thay đổi theo thời gian. 

#### 1.5 Big Data và Data Warehouse

- **Data Warehouse (Kho dữ liệu)**
  - Kho dữ liệu là một hệ thống lấy dữ liệu từ nhiều nguồn khác nhau về một tổ chức, chuyển đổi và lưu trữ dữ liệu đó cho mục đích báo cáo và phân tích.
  - Kho dữ liệu lưu trữ số lượng lớn dữ liệu lịch sử và cho phép truy vấn nhanh, phức tạp trên tất cả dữ liệu. Các báo cáo được tạo từ các truy vấn phức tạp trong kho dữ liệu được sử dụng để đưa ra quyết định kinh doanh. Kho dữ liệu cho phép *Business Intelligence* từ đó các nhà quản lý và nhà phân tích thu thập thông tin chi tiết, xu hướng và các vấn đề tiềm ẩn bằng cách phân tích dữ liệu của công ty

![img](https://i.imgur.com/bL6Jfyy.png)

- **Data Warehouse với cơ sở dữ liệu**
  - Các tổ chức thường sử dụng cơ sở dữ liệu nhất để Xử lý giao dịch trực tuyến (OLTP). Cơ sở dữ liệu sử dụng OLTP để xóa, chèn, thay thế và cập nhật số lượng lớn các giao dịch ngắn, trực tuyến. 
  - Cơ sở dữ liệu được tối ưu hóa để tối đa hóa tốc độ và hiệu quả mà dữ liệu được cập nhật (thêm, sửa đổi hoặc xóa) và cho phép phân tích và truy cập dữ liệu nhanh hơn. Tuy nhiên, cơ sở dữ liệu thường không phù hợp với các truy vấn phân tích phức tạp vì cần có số lượng bảng nối.
  - Trong kho dữ liệu, dữ liệu được sắp xếp thành một định dạng và có thể được kết hợp với các nguồn dữ liệu khác cho phép xử lý nhanh hơn các truy vấn phức tạp.

- **Big Data và Data Warehouse**
  - Kho dữ liệu thường bao gồm dữ liệu chi tiết và có cấu trúc phù hợp với lược đồ, tất cả được lưu giữ trong cơ sở dữ liệu quan hệ. Với Big Data, dữ liệu nguồn tuân theo cấu trúc lỏng lẻo và thường không được tinh chỉnh. 
  - Thông thường Data Warehouse được so sánh với Data lake, thay vì Big Data nói chung. Data lake, là một khái niệm Big Data, đề cập đến việc lưu trữ dữ liệu thô, không có cấu trúc và có cấu trúc từ các nguồn dữ liệu của tổ chức nhưng việc sử dụng vẫn chưa được xác định.  Hồ dữ liệu lưu trữ dữ liệu thuộc mọi loại, kích cỡ và định dạng ở định dạng gốc cho đến khi cần. Hồ dữ liệu có thể có dung lượng lưu trữ lớn hơn kho dữ liệu.
  - Data mart: Bạn cũng có thể nghe về thuật ngữ Data Mart, một tập hợp con hướng chủ đề của kho dữ liệu. Nó phục vụ nhu cầu của một bộ phận cụ thể trong một tổ chức. Nó được thiết kế đặc biệt cho một ngành kinh doanh cụ thể, chẳng hạn như bán hàng, tài chính hoặc tiếp thị. 
  - Cuối cùng, trong một số trường hợp, hồ dữ liệu có thể bị lạm dụng và biến thành đầm lầy dữ liệu khi dữ liệu chảy vào hồ dữ liệu mà không có bất kỳ kiểm tra quản trị hoặc chất lượng nào.
- **Big Data trên cloud**
  - Đám mây là phạm trù mới trong Dữ liệu lớn. Đám mây mang lại nhiều lợi ích: tính linh hoạt, cộng tác và khả năng truy cập từ mọi nơi. Mô hình đám mây giảm thấp các  khó khăn — đặc biệt là chi phí, độ phức tạp và thời gian tạo ra giá trị kéo dài.



### 2. YARN

#### 2.1 Giới thiệu

YARN có thể được coi là tương tự như một hệ điều hành cho một cụm. Cụm là một tập hợp các máy tính được kết nối lỏng lẻo hoặc chặt chẽ hoạt động cùng nhau để được xem như một hệ thống duy nhất. Cụm đại diện cho tập hợp các tài nguyên, chẳng hạn như tính toán, bộ nhớ, dung lượng ổ đĩa và băng thông mạng mà YARN phải phân xử giữa các công việc chạy trên cụm. Tương tự như cách hệ điều hành quản lý tài nguyên của máy và phân phối chúng giữa các quy trình cạnh tranh, YARN phân bổ tài nguyên cụm giữa các công việc cạnh tranh. Hình ảnh sau đây cho thấy vị trí YARN nằm trong ngăn xếp Hadoop.

![img](https://i.imgur.com/9mVlw5h.png)

#### YARN

- YARN là Yet Another Resource Negotiator. Bao gồm 2 công việc chính:
  - Quản lý các tài nguyên cụm như máy tính, mạng và bộ nhớ
  - Lập kế hoạch và giám sát công việc

- YARN thực hiện những mục tiêu này thông qua 2 trình trải dài:
  - Quản lý tài nguyên
  - Quản lý Node

![img](https://i.imgur.com/Hc8PmT1.png)

- Hai thành phần này hoạt động theo mối quan hệ chủ - nô lệ. Trong đó, Resource Manager là chủ và Node Manager là nô lệ. Mỗi Resoure Manager chạy trong cụm với một Node Manager mỗi máy.  Cùng nhau, hai thành phần này tạo nên khung tính toán dữ liệu

- **Resource Manager**
- Trình quản lý tài nguyên được mô tả trong tài liệu chính thức là cơ quan có thẩm quyền tối cao phân xử tài nguyên giữa tất cả các ứng dụng trong hệ thống. Trình quản lý tài nguyên bao gồm hai phần:
  - Applications Manager: chịu trách nhiệm chấp nhận các yêu cầu gửi công việc và khởi tạo vùng chứa cho một thực thể được gọi là ApplicationMaster. Nó cũng khởi tạo lại vùng chứa ApplicationMaster nếu vùng chứa bị lỗi. 
  - Scheduler: Bộ lập lịch chịu trách nhiệm phân bổ các tài nguyên như đĩa, CPU và các ứng dụng đang chạy mạng, tuân theo các hạn chế do hàng đợi và dung lượng áp đặt. Bộ lập lịch không giám sát các ứng dụng cũng như không bắt đầu khởi động lại khi có lỗi ứng dụng hoặc phần cứng.

- Người đọc sẽ nhận ra rằng Trình quản lý tài nguyên hoạt động như một điểm duy nhất. Nếu máy lưu trữ RM bị hỏng thì không có công việc nào có thể được lên lịch. Để giảm thiểu thiếu sót này, tính khả dụng cao của YARN đã được giới thiệu trong Hadoop 2.4. Một cặp Trình quản lý tài nguyên chạy ở cấu hình Hoạt động/Dự phòng để đạt được tính sẵn sàng cao. Nếu Trình quản lý tài nguyên đang hoạt động bị chết thì trình quản lý dự phòng sẽ hoạt động và cụm tiếp tục hoạt động chính xác. Việc chuyển từ chế độ chờ sang chế độ hoạt động có thể được quản trị viên thực hiện thủ công hoặc tự động. Để chuyển đổi tự động, cần có Zookeeper để bầu chọn.

![img](https://i.imgur.com/t4W56uD.png)

- **Node Manager**
  - NodeManager là một tác nhân chạy trên mọi máy trong cụm. Nó chịu trách nhiệm khởi chạy các container trên máy đó và quản lý việc sử dụng tài nguyên của các container. Nó báo cáo việc sử dụng trở lại thành phần Lập lịch biểu của Trình quản lý tài nguyên.



#### 2.2 Workflow

- Bước đầu tiên khi chạy ứng dụng YARN yêu cầu RM (trình quản lý tài nguyên) tạo quy trình Ứng dụng chính (AM). Một client gửi công việc và RM tìm thấy Node manager có thể khởi chạy vùng chứa để lưu trữ quy trình Application Master. Application Master đại diện cho công việc/ứng dụng của client. Nó có thể tự chạy công việc và trả về hoặc yêu cầu các tài nguyên bổ sung từ Resource Manager. Sau này, Resource Manager có Node Manager các máy khác khởi chạy các container thay mặt cho quy trình Application Master để chạy tính toán phân tán. 

![img](https://i.imgur.com/oaO5dkG.png)

- Ứng dụng YARN có thể chạy trong vài giây tới vài ngày. Việc ánh xạ Job tới Ứng dụng có thể diễn ra theo ba mô hình:
  - One job per application: Đây là mô hình đơn giản nhất.
  - Several jobs per application: Điều này phù hợp để chạy một số công việc (có thể liên quan) dưới dạng một quy trình làm việc hoặc trong một phiên người dùng. Lợi ích là các container có thể được tái sử dụng trong các công việc và dữ liệu trung gian giữa các công việc có thể được lưu vào bộ nhớ.
  - Perpetually running application: Trong mô hình này, một ứng dụng đóng vai trò điều phối viên sẽ tiếp tục chạy, thậm chí là mãi mãi và được chia sẻ giữa nhiều người dùng khác nhau. 

![img](https://i.imgur.com/uc0qlng.png)

- **MapReduce1 (MR1)**
  - Phiên bản đầu tiên Hadoop, được biết là MapReduce1. MR1 chưa có YARN và giới hạn ở các công việc MapReduce Trong MR1 có 2 deamon kiểm soát công việc:
    - JobTracker: chịu trách nhiệm điều phối thực hiện tất cả các công việc được gửi tới cụm.
    - TaskTracker: chạy nhiệm vụ và báo cáo tiến độ cho jobtracker.
  - Thiết kế MR1 đã chùn bước khi mở rộng quy mô lên 4000 nút và 40.000 nhiệm vụ vì trình theo dõi công việc phải quản lý các nhiệm vụ và công việc. YARN đã giải quyết vấn đề này bằng cách giới thiệu kiến trúc ứng dụng chính và trình quản lý tài nguyên. Tóm lại, YARN hiệu quả hơn, có thể mở rộng, khả dụng và đa năng hơn MR1. YARN có thể chứa các mô hình tính toán phân tán khác với MapReduce.

![img](https://i.imgur.com/S0mJtjC.png)

![img](https://i.imgur.com/6bzaYgE.png)

- **Tỷ lệ chiều ngang và chiều dọc**
  - Hầu hết các vấn đề về Dữ liệu lớn không thể giải quyết được trên một máy thông thường. Nhưng YARN quản lý một cụm có thể giải quyết các vấn đề về Dữ liệu lớn. Cụm này thường được làm bằng máy thông thường, giúp kiểm soát chi phí. Giải pháp thay thế cho một cụm máy là một máy tốt hơn và lớn hơn khi quy mô bài toán tăng lên. Những cách tiếp cận tương phản này được gọi là chia tỷ lệ theo chiều ngang (thêm nhiều máy hơn) và chia tỷ lệ theo chiều dọc (máy mạnh hơn). Về mặt hình thức, chia tỷ lệ theo chiều ngang có nghĩa là thêm nhiều máy hơn vào nhóm tài nguyên, trong khi chia tỷ lệ theo chiều dọc có nghĩa là chia tỷ lệ bằng cách bổ sung thêm CPU, RAM cho máy hiện có. Nếu một vấn đề cụ thể trở nên khó giải quyết đối với cụm YARN hiện có, thì nhiều máy hơn có thể tăng khả năng tính toán và lưu trữ của cụm.

#### 2.3 Scheduling

Trách nhiệm của YARN là lập lịch công việc cho người dùng. Việc lập kế hoạch rất quan trọng vì cụm có nguồn tài nguyên hữu hạn để phân bổ cho công việc của người dùng. Nếu không lập lịch trình, một công việc có thể chiếm dụng toàn bộ cụm và làm cạn kiệt các tài nguyên của các công việc khác. YARN đi kèm với nhiều lựa chọn về bộ lập lịch và các nút cấu hình. Ba bộ lập lịch trong YARN là:

- FIFO Scheduler: được hiểu là first-in-first-out scheduler. Sử dụng bộ lập lịch này, các công việc sẽ được xếp vào hàng đợi và được thực hiện theo thứ tự gửi của chúng. Mặc dù đơn giản nhưng bộ lập lịch FIFO không phù hợp với cụm dùng chung. Một công việc lớn có thể cản trở việc thực hiện những công việc nhỏ hơn.
- Capacity Scheduler: xác định hàng đợi với mỗi hàng đợi được phân bổ một phần tài nguyên cụm. Một hàng đợi có thể được chia thành các hàng đợi con theo thứ bậc. Bộ lập lịch năng lực được thiết kế để hỗ trợ một cụm tổ chức được chia sẻ giữa các phòng ban và nhóm khác nhau trong mỗi phòng ban.
  - Với mỗi hàng đợi, công việc được thực hiện theo cách FIFO. Hàng đợi có thể sử dụng hết sức chứa của hàng đợi khác nếu hàng đợi đó không sử dụng tài nguyên của nó. Điều này được gọi là độ co giãn của hàng đợi.
  - Dung lượng mượn từ một hàng đợi chỉ được trả về khi vùng chứa công việc từ hàng đợi khác hoàn tất. Các container không bị ngừng đột ngột khi hàng đợi cho vay yêu cầu lấy lại dung lượng. Tuy nhiên, dung lượng cụm tối đa mà một hàng đợi có thể sử dụng có thể bị giới hạn bởi cấu hình. Điều này ngăn không cho một hàng đợi chiếm toàn bộ tài nguyên của cụm.
- Fair Scheduler: đúng như tên gọi của nó, cố gắng phân bổ tài nguyên một cách công bằng giữa tất cả các ứng dụng đang chạy. Về cơ bản, tài nguyên được phân chia khá đều giữa các hàng đợi và sau đó được phân chia đệ quy giữa các công việc trong hàng đợi. 

![img](https://i.imgur.com/bByJTtk.png)

![img](https://i.imgur.com/N9u7hHr.png)

### 3. MapReduce

#### 3.1 Basis

- **Map and Reduce:**

  - MapReduce là sự kết hợp của “map” và “reduce” để mô tả hai giai đoạn mà nó bao gồm. MapReduce là sự triển khai mô hình điện toán do Google giới thiệu.
  - MapReduce giống như một chiến lược phân chia và trị. Một tập dữ liệu khổng lồ được chia cho các máy công nhân. Sau khi quá trình xử lý hoàn tất, dữ liệu từ mỗi máy sẽ được tổng hợp để đưa ra giải pháp cuối cùng. Luồng dữ liệu trong các giai đoạn khác nhau của công việc MapReduce được hiển thị bên dưới.

  ![img](https://i.imgur.com/p8qmeal.png)

  - Tóm lại, MapReduce là mô hình lập trình được sử dụng để xử lý các tập dữ liệu lớn trên một cụm máy sản xuất hàng hóa bằng cách sử dụng thuật toán phân tán.

  - Mô hình bao gồm hai giai đoạn:

    - Giai đoạn Map: Hàm này có nhiệm vụ là xử lý một cặp key (key, value) để tạo ra một cặp key mới (keyl, valuel), lúc này cặp key (keyl, valuel) sẽ đóng vai trò là trung gian. Sau đó, người dùng chỉ cần ghi dữ liệu xuống đĩa cứng và nhanh chóng tiến hành thông báo cho hàm Reduce để dữ liệu đi vào input của Reduce.

    - Pha Reduce: Hàm này có nhiệm vụ là tiếp nhận cặp từ khoá trung gian và giá trị tương ứng với lượng từ khoá đó (keyl, valuel) để tạo thành một tập khoá khác nhau bằng cách tiến hành ghép chúng lại.

    - Ngoài ra, ở giữa Map và Reduce còn một bước trung gian khác mang tên Shuffle. Sau khi Map hoàn thành xong nhiệm vụ của mình thì Shuffle sẽ tiếp tục công việc thu thập cũng như tổng hợp cặp từ khoá/giá trị trung gian đã được tạo ra bởi Map trước đó và chuyển nó đến Reduce để tiếp tục xử lý.

- **Đặc điểm**

  - Distributed: MapReduce là một khung phân tán bao gồm các cụm phần cứng hàng hóa chạy các tác vụ Map hoặc Reduce.
  - Parallel: Các tác vụ Map và Reduce luôn hoạt động song song.
  - Fault tolerant: Nếu bất kỳ tác vụ nào bị lỗi, nó sẽ được lên lịch lại trên một nút khác.
  - Scalable: Nó có thể mở rộng quy mô tùy ý. Khi bài toán trở nên lớn hơn, có thể thêm nhiều máy móc hơn để giải bài toán trong một khoảng thời gian hợp lý; khung có thể mở rộng theo chiều ngang thay vì theo chiều dọc.

- **Đầu vào và đầu ra:** 

  Framework hoạt động với các cặp khóa-giá trị. Đầu vào và đầu ra của cả hai giai đoạn Map và Reduce bao gồm các cặp khóa-giá trị. Tuy nhiên, các hạn chế đầu vào và đầu ra:

  - Serializable: Yêu cầu cả khóa và giá trị phải có khả năng tuần tự hóa và phải triển khai Writeable interface.
  - Comparable: Framework sắp xếp đầu ra của giai đoạn Map trước khi đưa nó vào giai đoạn Reduce. Việc sắp xếp yêu cầu các khóa có thể so sánh được với nhau và do đó bắt buộc phải triển khai WritableComparable interface.

- **Giai đoạn Map**

  - Map là các tác vụ riêng lẻ chuyển đổi các bản ghi đầu vào thành các bản ghi trung gian. Các bản ghi trung gian được chuyển đổi không cần phải cùng loại với các bản ghi đầu vào. Một cặp khóa/giá trị đầu vào nhất định có thể ánh xạ tới 0 hoặc nhiều cặp đầu ra.

- **Pha Reduce**

  - Tập hợp trung gian các giá trị khóa đầu ra theo giai đoạn ánh xạ được giảm xuống thành một tập hợp nhỏ hơn các cặp giá trị khóa bằng reducer.



#### 3.2 Mapper

- **Mapper class**

  ```java
  public class Mapper<KEYIN, VALUEIN, KEYOUT, VALUEOUT> {
          //...class body
      }
  ```

  ```java
  public class CarMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
  
      @Override
  
      protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
  
          *// We can ignore the key and only work with value*
  
          String[] words = value.toString().split(" ");
  
          for (String word : words) {
  
              context.write(new Text(word.toLowerCase()), new IntWritable(1));
  
          }
  
      }
  
  }
  ```

  - Mapper class định nghĩa phương thức map(...) chứa pha Map. 

  - Ví dụ mapper:

![img](https://i.imgur.com/VekNzRT.png)

- Tệp dữ liệu được đưa vào chương trình như sau:

```text
Toyota Toyota Mercedes 
BMW Tesla Porsche
Porsche Tesla GM Volvo ford
```

- Hàm ánh xạ được gọi ba lần, một lần cho mỗi dòng, với các cặp khóa-giá trị sau:

```text
(0, Toyota Toyota Mercedes)
(23, BMW Tesla Porsche)
(41, Porsche Tesla GM Volvo ford)
```

- Dòng đầu tiên có khóa là 0 vì nó xuất hiện ở đầu tệp dữ liệu. Dòng thứ hai có độ lệch là 23, vì dòng đầu tiên có 22 ký tự và một ký tự dòng mới ở cuối, tổng cộng có 23 ký tự. Đầu ra của các tác vụ Map sẽ như thế này:

```text
(toyota, 1)
(toyota, 1)
(mercedes-benz, 1)
(bmw, 1)
(tesla, 1)
(porsche, 1)
(porsche, 1)
(tesla, 1)
(gm,1 )
(volvo, 1)
(ford, 1)
```

- **Mapper Input**
  - Mỗi dòng trong tệp dữ liệu đại diện cho một bản ghi. Sự phân chia đầu vào, bao gồm các khối HDFS, được tạo thành từ các bản ghi. Có thể một bản ghi có thể trải rộng trên nhiều khối HDFS. Không có gì đảm bảo rằng một khối HDFS sẽ bao gồm toàn bộ số bản ghi. HDFS không có khái niệm về nội dung bên trong của khối HDFS. Nó không thể xác định liệu một bản ghi có tràn sang một khối khác hay không. Vấn đề này được giải quyết bằng cách phân chia đầu vào. Khi ứng dụng MapReduce tính toán phần phân chia đầu vào, nó sẽ tìm ra nơi bắt đầu của toàn bộ bản ghi đầu tiên trong một khối và nơi kết thúc của bản ghi cuối cùng trong khối. Trong trường hợp bản ghi cuối cùng trong một khối không đầy đủ, phần phân tách đầu vào sẽ bao gồm thông tin vị trí cho khối tiếp theo và độ lệch byte của dữ liệu cần thiết để hoàn thành bản ghi. Hệ quả: tác vụ Map xử lý việc phân chia đầu vào như vậy có thể đọc khối dữ liệu từ xa được lưu trữ trên một nút khác trong cụm để xử lý hoàn toàn việc phân tách đầu vào.

- **Data locality (Vị trí dữ liệu)**
  - Dữ liệu trong cụm Hadoop có thể được đặt ở bất cứ đâu. Framework cố gắng lập lịch tác vụ Map trên cùng node có dữ liệu đầu vào cho tác vụ map đó. 
  - Nếu tác vụ Map không thể được lên lịch trên cùng một nút nơi chứa dữ liệu của nó hoặc một trong các bản sao của nó, thì framwork sẽ cố gắng chọn một nút trong giá chứa dữ liệu
  - Cuối cùng, nếu 2 điều trên là không thể, một nút ngoài giá sẽ được chọn để chạy tác vụ Map và quá trình truyền dữ liệu giữa các giá sẽ diễn ra.

![img](https://i.imgur.com/J2Bm8nn.png)



#### 3.3 Reducer

- Tác vụ Reduce hoạt động dựa trên đầu vào trung gian do tác vụ Map tạo ra. Các tác vụ Reduce hoàn toàn độc lập với nhau giống như các tác vụ Map; họ không giao tiếp. Tuy nhiên, các tác vụ Reduce yêu cầu các cặp khóa/giá trị trung gian do các tác vụ ánh xạ tạo ra làm đầu vào. 
- Lưu ý rằng tất cả các bản ghi cho một khóa nhất định đều nằm trong một phân vùng duy nhất, cho phép một tác vụ Reduce duy nhất xử lý tất cả dữ liệu cho một khóa nhất định.

![img](https://i.imgur.com/GuW4Rcn.png)

- Combiner (Bộ kết hợp)
  - Chúng ta có thể chỉ định một lớp hoạt động dựa trên đầu ra của tác vụ Map cho mỗi khóa. Một trong những lý do để triển khai bộ kết hợp là để tổng hợp đầu ra Map trung gian. Sau đó, trong quá trình xáo trộn, số byte được truyền qua dây sẽ giảm đi. Việc truyền dữ liệu qua mạng có độ trễ đáng kể và do đó, càng ít dữ liệu được đưa vào mạng thì càng tốt.

- Partitioner (Trình phân vùng)
  - Trình phân vùng xác định phân vùng nào mà khóa của bản ghi ánh xạ tới và định vị bản ghi cho phân vùng đó

![img](https://i.imgur.com/FHyubWp.png)

![img](https://i.imgur.com/PXI2r7V.png)

#### 3.4 Đặt mọi thứ lại với nhau

![img](https://i.imgur.com/wwfak9A.png)

- 1. Công việc được gửi đi bởi phương thức waitForCompletion(). Phương thức này trả về công việc nếu như công việc đã được hoàn thành

```java
  job.waitForCompletion(true);
```

- 2. Lớp JobSubmitter chịu trách nhiệm giao tiếp với RM (Trình quản lý tài nguyên) và lấy ID ứng dụng mới được sử dụng làm ID công việc MapReduce. Lớp này cũng thực hiện kiểm tra độ chính xác, chẳng hạn như xác minh xem đường dẫn đầu ra có tồn tại hay không và việc phân chia đầu vào có thể được tính toán thành công hay không.

- 3. Tiếp theo, tài nguyên cần thiết cho công việc được sao chép tới HDFS trong thư mục chạy, với ID của công việc trong đường dẫn. Các tài nguyên bao gồm tệp jar chứa mã chương trình mapper và trình reducer để thực thi. Tệp này được đổi tên thành job.jar . Các tệp cấu hình và siêu dữ liệu về phân chia đầu vào cũng được sao chép. Sau khi công việc kết thúc thành công, framework sẽ xóa thư mục staging này. Bạn có thể đặt thuộc tính mapreduce.task.files.preserve.filepattern để chọn những tệp cần giữ cho mục đích gỡ lỗi.
- 4. Công việc được gửi để thực thi cho RM bằng cách gọi phương thức submitApplication()trên trình quản lý tài nguyên.
- 5. Người quản lý tài nguyên, khi nhận được submitApplication(), sẽ chuyển yêu cầu tới bộ lập lịch YARN. Một vùng chứa được phân bổ và một Application Master của ứng dụng, được đại diện bởi lớp MRAppMaster, được khởi chạy trong vùng chứa. Trình quản lý nút quản lý việc khởi chạy tiến trình chính.
     - Sau khi ResourceManager gửi một ứng dụng, một vùng chứa sẽ được tạo cho ApplicationMaster. ApplicationMaster là một thực thể chịu trách nhiệm quản lý vòng đời của một công việc. Sau khi được khởi tạo, nó sẽ giao tiếp với ResourceManager để thương lượng tài nguyên, sau đó làm việc với người quản lý nút để thực thi và giám sát các tác vụ. Trong trường hợp MapReduce, ApplicationMaster là MRAppMaster. Nhưng nói chung, một thư viện dành riêng cho khung sẽ thương lượng các tài nguyên từ Trình quản lý tài nguyên và làm việc với Trình quản lý nút.

![img](https://i.imgur.com/EFAVEOV.png)

- 6. ApplicationMaster đã tạo sẽ khởi tạo một số đối tượng sổ ghi cần thiết để theo dõi tiến trình của Map và Reduce các tác vụ sẽ được tạo trong thời gian ngắn. 
- 7. Sau đó, ApplicationMaster cần quyết định chạy Map và Reduce trong cùng một JVM hoặc yêu cầu các vùng chứa để các tác vụ có thể chạy song song. Đôi khi ApplicationMaster chạy các tác vụ trong cùng một JVM. Một công việc nhỏ có thể hoàn thành sớm hơn khi các tác vụ Map và Reduce chạy tuần tự trong cùng một JVM so với khi chúng được chạy trong các vùng chứa riêng biệt trên các nút khác nhau. Chi phí yêu cầu vùng chứa và quản lý việc thực thi chúng có thể lớn hơn thời gian thực hiện công việc. Nếu một công việc được thực thi trong cùng một JVM với ApplicationMaster, thì công việc đó sẽ được uber hóa và các tác vụ này được gọi là các tác vụ uber. Có nhiều nút bấm khác nhau được framework mapreduce hiển thị để điều chỉnh khi một công việc có thể được lên lịch dưới dạng công việc uber.
- 8. Nếu một công việc không thể chạy như một công việc uber thì ApplicationMaster sẽ yêu cầu các vùng chứa cho tất cả các tác vụ Map và Reduce từ trình quản lý tài nguyên. 

- 9. Khi Trình lập lịch biểu của ResourceManager đã được lên lịch phù hợp trên một nút cụ thể, ApplicationMaster sẽ liên hệ với trình quản lý nút để khởi động vùng chứa các tài nguyên cần thiết cho tác vụ Map Reduce. Java application có main class là YarnChild sẽ thực thi tác vụ. TIến trình YarnChild chạy các tác vụ Map và Reduce trong JVM chuyên dụng. Nếu trường hợp có bất kỳ lỗi hay sự cố nào trình quản lý Node sẽ không bị ảnh hưởng và tiến trình này sẽ chạy trong một JVM khác

![img](https://i.imgur.com/tkqeFsJ.png)

- 10. Framework cung cấp khả năng sử dụng các định dạng output khác, như viết bởi S3 hoặc định dạng Parquet trên ổ đĩa. 
- 11. Tác vụ Map và Reduce báo cáo tiến trình của nó tới ApplicationMaster. Chương trình client có thể thăm dò ApplicaitonMaster để biết các bộ đếm và trạng thái khác nhau. Giao diện người dùng web RM hiển thị tất cả các ứng dụng đang chạy có liên kết đến ApplicationMasters của chúng, mỗi ứng dụng sẽ hiển thị thông tin chi tiết hơn về công việc và tiến trình của nó.

- 12. Sau khi ApplicaitonMaster được thông báo về việc hoàn thành nhiệm vụ cuối cùng, AM sẽ đánh dấu trạng thái công việc là thành công. ApplicaitonMaster và Task containers cũng dọn dẹp trạng thái của nó và xóa mọi đầu ra trung gian sau khi công việc hoàn thành.

#### 3.5 Khả năng phục hồi (Resiliency)

- **Lỗi tác vụ**
  - Tác vụ Map hoặc Reduce có thế gặp lỗi do: bug trong code, bug trong JVM, không đủ dung lượng trên ổ đĩa, ... Khi tác vụ bị lỗi, JVM application thông báo lỗi tới AM cha trước khi thoát.AM sẽ đánh dấu tác vụ bị lỗi. Và tái lập lịch lại để thực thi trên node manager khác nếu có thể. Có thể config số lần Map và Reduce được phép lỗi.
- **Lỗi ApplicationMaster**
  - Trình quản lý tài nguyên YARN nhận định kỳ heartbeats từ ApplicationMaster và có thể phát hiện được khi nào ApplicationMaster lỗi. Resource Manager sẽ khởi động lại AM trong container khác quản lý bởi Node Manager. AM có thể được giới hạn số lần mà nó lỗi. Trong trường hợp khởi động lại, client cần update lại với vùng chưa mới cho AM. Client sẽ thăm dò AM địa chỉ cũ và thời gian kết nối. Và client sẽ liên hệ RM cho vùng chứa mới cho AM và thiết lập lại kết nối. 
  - Ngoài ra, RM, khi khởi động lại ApplicationMaster bị lỗi có thể khôi phục trạng thái của các tác vụ chạy trước khi xảy ra lỗi từ máy chủ lịch sử công việc để chúng không chạy lại.
- **Lỗi Node Manager**
  - Node Manager gửi định kỳ heartbeat tới RM. Nếu heartbeat không thể nhận bởi RM trong số phút đã thiết lập, nó cho rằng Node Manager bị chết. Nếu điều đó xảy ra, RM khởi động lại bất kỳ tác vụ lỗi nào hoặc AM đang chạy trên Node Manager bị lỗi trên Node không bị lỗi khác. Do đó, tác vụ Map hoàn thành trên Node bị lỗi phải chạy lại. 
- **Lỗi Resource Manager**
  - RM là lỗi critical, sẽ không thể chạy tác vụ mởi, tác vụ lỗi, hoặc AM. Thông thường, 2 RM sẽ chạy như 1 cặp cùng nhau active/dự phòng. Active RM sẽ khởi tạo và phản hồi tất cả các tương tác. RM dự phòng sẽ không hoạt động đến khi active RM gặp lỗi. Tại thời điểm lỗi, RM dự phòng sẽ trở nên active. Đây được gọi là tính sẵn sàng cao. 
  - Sự chuyển trạng thái từ dự phòng sang active được tiến hành bởi failover controller. Controller này sử dụng leader Zookeeper để đảm bảo chỉ có 1 active RM. Zookeeper là dịch vụ lưu trữ cấu hình, đặt tên, đồng bộ hóa phân tán và các dịch vụ nhóm khác cho ứng phân tán
  - Zookeeper lưu thông tin về ứng dụng đang chạy. Khi RM dự phòng trở thành active, nó đọc thông tin để xây dựng lại trạng thái trước khi RM ngừng hoạt động. Ứng dụng sẽ được khởi động lại bởi RM active mới. Thông tin liên quan tới Node Manager được xây dựng từ heartbeat và không được lưu trong Zookeeper. Cuối cùng, Node Managers và ứng dụng client xử lý các lỗi của RM bằng cách kết nối với các phiên bản RM theo kiểu vòng tròn cho đến khi tìm thấy phiên bản đang hoạt động.

### 4. HDFS

#### 4.1 File System (Hệ thống tệp tin)

- **Types of file systems** 
  - Disk File Systems
  - Tape File Systems
  - Network File Systems
  - Special Purpose FIle Systems
- **OS và file systems**
  - OS hỗ trợ nhiều file system. Ví dụ, MacOS sử dựng APFS (Apple File System), Window hỗ trợ FAT, Linux hỗ trợ EXT 
- **Distributed file systems (Hệ thống file phân tán)**
  - Trong Hadoop, chúng ta sử dụng hệ thống file phân tán (DFS). DFS sử dụng mạng để gửi/nhận dữ liệu và tạo hệ thống tệp cục bộ cho khách hàng. Kết nối tới file được cung cấp bởi nhiều hosts. Các tệp tin có thể được lưu trên máy chủ chung tâm hoặc trên nhiều máy chủ. 
- **Disk block**
  - Disk block là đơn vị nhỏ nhất có thể ghi bởi đĩa hoặc hệ thống file. Mọi thứ hệ thống file được thực hiện trên khối đĩa. Hệ thống file không ghi trên các khối đĩa riêng lẻ. Thay vào đó đọc/ghi trên cặp khối đĩa hiệu quả hơn.  Sự trừu tượng hóa này đối với các khối đĩa vật lý được gọi là khối hệ thống tập tin. Khối hệ thống tệp luôn có cùng kích thước hoặc lớn hơn (theo bội số nguyên) so với kích thước khối đĩa.
- **File metadata**
  - Tên của file là metadata bởi vì thông tin về file không nằm trong luồng bytes tạo nên file. Có nhiều metadate như người sở hữu, quyền truy cập bảo mật, ngày sửa đổi lần cuối, thời gian tạo và kích thước. Nói chung, file system lưu trữ file metadata ở dạng i-node hoặc index-node.
- **i-Node**
  - Trong filesystem truyền thống, i-node là cấu trúc dữ liệu trong filesystem để lưu trữ thông tin metadata và thông tin về vị trí dữ liệu trên phương tiện lưu trữ. I-node link tới nội dung của file bởi theo dõi danh sách các blocks trên đĩa thuộc về file. I-node chưa thông tin file system dùng để ánh xạ địa chỉ logic trong file tới địa chỉ vật lý trong ổ đĩa

#### 4.2 Bức tranh toàn cảnh

File lớn: Hệ thống có thẻ lưu file lớn chứa hàng trăm GB hoặc PB

Truy cập dữ liệu trực tuyến: HDFS được ước lượng và xây dựng cho việc viết một lần và đọc nhiều lần. Đọc tập dataset quan trọng hơn việc đọc bản ghi đầu tiên. HDFS không hỗ trợ nhiều người ghi

Phần cứng thương mại: Hadoop được thiết kế để chạy trên cụm phần cứng giá rẻ. Tỉ lệ phần cứng bị lỗi là rất cao nhưng hệ thống dự kiến sẽ hoạt động bình thường

Working of HDFS

- Filesystem, phân tán hoặc cục bộ, cần biết được vị trí của disk blocks tạo nên file. Filesystem cần trả về bất kỳ metadata nào liên quan tới file cho client. Hai deamons tạo nên HDFS:

  - Namenode (NN)
  - Datanode (DN)

  ![img](https://i.imgur.com/ZMSXcFr.png)

  - Namenode theo dõi toàn bộ dữ liệu lưu trên HDFS. Nó duy trì không gian tên hệ thống tập tin và kiểm soát quyền truy cập của khách hàng vào các tập tin. Công việc của nó là giữ siêu dữ liệu
  - Datanodes chứa các byte thực tế tạo nên một tệp được lưu trữ trên HDFS.

- Data-locality: Tính toán mà ứng dụng yêu cầu sẽ hiệu quả hơn nếu được thực hiện gần dữ liệu mà nó hoạt động. Điều này đặc biệt đúng khi tập dữ liệu rất lớn.

- Client giao tiếp với Namenode để đọc hoặc ghi tệp. Namenode phản hồi với vị trí của các Datanode phù hợp để client gửi hoặc nhận dữ liệu

![img](https://i.imgur.com/BUcMQkI.png)

- Mối quan hệ giữa Namenode và Datanodes là mối quan hệ giữa chủ và nô lệ. Namenode đóng vai trò là chủ và Datanode là nô lệ.

- Những thiếu xót:
  - Truy cập dữ liệu có độ trễ thấp
  - Nhiều tệp nhỏ



#### 4.3 Disk Blocks & HDFS Blocks

- **Thông thường disk blocks có size 512 bytes. Size default của HDFS block là 128MB.** 

- **HDFS Blocks**
  - FIle trong HDFS được chia thành các HDFS blocks. Mỗi khối HDFS về mặt vật lý được tạo thành từ các khối hệ thống tệp của hệ thống tệp cơ bản, do đó khối này là bội số nguyên của kích thước disk blocks.
  - Nếu lưu 10MB thì cũng chỉ chiểm 10MB dung lượng ổ đĩa chứ không phải 128MB. Nếu có 3 tệp 10KB thì dung lượng tiêu thụ trên đĩa sẽ là 3x10KB = 30KB trong khi Namenode sẽ chứa 3 khối HDFS, mỗi khối trong bộ nhớ
  - Các khối HDFS của một file có thể trải trên nhiều máy trong 1 cụm. Trong trường hợp cực đoan, một tệp có thể chiếm toàn bộ dung lượng đĩa trống trên cụm với tất cả các khối HDFS trong cụm, thuộc về một tệp. Data blocks không lưu trữ metadata. Metadata lưu trữ bởi Namenode. Mỗi HDFS block được lưu trữ như là file trên Datanode  
- **Large block size**
  - HDFS có khối mặc định lớn (128MB)
  - Giảm áp lực cho Namenode: Với block size bé, như 1KB, để lưu file 10KB cần có 10 HDFS mà Namenode cần lưu trữ trong bộ nhớ. Thay vào đó sử dụng size 10KB
  - Giảm thời gian tìm kiếm: Giả sử phải mất 10ms để tìm đến đầu khối và tốc độ truyền dữ liệu là 100MB/s. Kích thước khối cần phải có kích thước khoảng 100 MB để làm cho thời gian tìm kiếm đĩa bằng 1% thời gian truyền.
  - Có throughput cao: tốc độ xử lý truy nhập dữ liệu cao 
  - Cải thiện hiệu suất MapReduce: Nếu block size quá nhỏ, dẫn tới nhiều tác vụ Map dẫn tới viêc quản lý quá tải. Ngược lại, block size không nên quá to, dẫn tới việc quá ít tác vụ map và tăng thời gian thực thi
  - Không đọc ghi song song
- **Block size lý tưởng**
  - Trong thực tế, không có kích thước khối HDFS nào phù hợp với mọi trường hợp sử dụng. Bạn phải xem xét cụm, dữ liệu đầu vào và kiểu xử lý mong muốn. Kích thước khối HDFS có thể được thay đổi riêng lẻ từ tệp này sang tệp khác.



#### 4.4 Block Replication (Sao chép khối)

- Nếu 1 file gồm 4 HDFS blocks và hệ số sao chép là 3, sau đó mỗi khối dữ liệu sẽ có 3 bản sao chép của chúng. Các bản sao này nằm rải rác trong cụm, có tổng cộng 12 khối. Việc sao chép đảm bảo rằng nếu một khối dữ liệu bị hỏng hoặc xảy ra lỗi phần cứng thì yêu cầu đọc vẫn có thể được thực hiện bởi một bản sao có sẵn khác của khối đó. 

- Lựa chọn node cho việc sao chép
  - Trong thực tế, Hadoop đặt bản sao đầu tiên trên cùng nút với máy khách. Nếu máy khách đang chạy bên ngoài cụm, một nút sẽ được chọn ngẫu nhiên. Bản sao thứ hai được đặt trên giá được chọn ngẫu nhiên khác với bản sao đầu tiên. Bản sao thứ ba được đặt trên một nút được chọn ngẫu nhiên trên cùng giá với bản sao thứ hai. Bất kỳ bản sao nào khác sẽ được đặt trên các nút được chọn ngẫu nhiên mà không đặt quá nhiều bản sao vào cùng một giá.

![img](https://i.imgur.com/Z6k4xMx.png)

#### 4.5 Namenode

- Namenode

  - Namenode duy trì cây filesystem và toàn bộ metadata cho toàn bộ các files và directories trong cây. Thông tin siêu dữ liệu của hệ thống tệp được lưu trữ trên đĩa cục bộ của Namenode bởi các thực thể sau: Namespace Image File, Edit log

- Namespace Image File (FS Image)

  - FsImage là ảnh chụp nhanh metadata hệ thống tệp HDFS tại một thời điểm nhất định. Nó là một điểm kiểm tra metadata của hệ thống tập tin. Mọi sửa đổi đối với hệ thống tập tin đều được gán một ID giao dịch duy nhất, tăng dần đều. Tệp FS Image thể hiện trạng thái của hệ thống tệp sau tất cả các sửa đổi đối với ID cụ thể.

- Edit log

  - EditLog là nhật ký giao dịch hoặc nhật ký chứa các bản ghi cho mọi thay đổi xảy ra với siêu dữ liệu của hệ thống tệp. 

  - FS image và edit log đều tồn tại trên hệ thống file cục bộ trên NameNode

- Hoạt động của Namenode

  - Một tập tin trong hệ thống bao gồm một số khối. Các khối tạo nên một tệp không nằm trên cùng một Datanode mà thay vào đó được trải rộng trên các Datanode khác nhau. Khi khởi động, Namenode không biết vị trí các khối dữ liệu của file. Nó xây dựng một bản đồ chứa vị trí của từng khối dữ liệu của mỗi tệp từ các báo cáo định kỳ được gửi bởi Datanodes. Datanode xác định các bản sao khối mà nó sở hữu cho NameNode, bằng cách gửi báo cáo khối. Namenode tự động tính toán bản đồ khối từ các báo cáo và lưu giữ nó trong bộ nhớ.
  - Khi Namenode khởi động, nó chọn FS Image và mở edit log để nhận trạng thái của metadata mới nhất của hệ thống tệp. Tiếp theo, Namenode ghi trạng thái HDFS mới vào FS Image và bắt đầu hoạt động bình thường với một tệp chỉnh sửa trống.

- Secondary Namenode
  - Không phải để backup Namenode. Nút tên phụ định kỳ hợp nhất edit log với FS Image để edit log không vượt quá giới hạn hợp lý. Secondary Namenode trợ giúp cho Namenode chính, nhưng không thể thay thế nó trong trường hợp bị lỗi. Thông thường, Namenode phụ được chạy trên một máy khác vì nó yêu cầu tài nguyên bộ nhớ và máy tính tương tự như chính Namenode.
- Điểm lỗi duy nhất 
  - Nếu một thành phần cụ thể trong hệ thống phân tán được chỉ định là một điểm lỗi duy nhất thì lỗi của thành phần quan trọng này có thể khiến toàn bộ hệ thống bị ảnh hưởng
  - Namenode là một điểm lỗi duy nhất trong hệ sinh thái Hadoop. Nếu Datanode là công cụ lao động thì Namenode là trung tâm thần kinh. Nếu nó không khả dụng, tất cả các máy khách tương tác với Namenode, bao gồm cả các công việc MapReduce, sẽ không thành công. Không có khách hàng nào có thể đọc, ghi hoặc liệt kê các tập tin và thư mục trên hệ thống.
- Giải quyết các lỗi của Namenode
  - Sử dụng backup
  - Sử dụng Secondary Namenode
  - Sử dụng Namenode dự phòng
- Hạn chế
  - Namenode lưu hệ thống file metadata trong bộ nhớ. Nếu có quá nhiều file trong hệ thống, metadata có thể sẽ không được chứa trong bộ nhớ của Namenode. Mặc dù có thể lưu trữ các tệp lớn trong hệ thống nhưng nó không thể xử lý số lượng tệp rất lớn. Hệ thống không thể xử lý hàng tỷ tệp nhỏ vì metadata không hoàn toàn vừa với bộ nhớ của Namenode.

#### 4.6 Datanode

- Datanode lưu trữ dữ liệu thực tế. Nó lưu trữ các khối dữ liệu trên hệ thống tệp cục bộ của nó và gửi báo cáo khối tới Namenode.
- Dữ liệu cho các tệp HDFS sẽ được lưu trữ trong thư mục được chỉ định làm giá trị cho cài đặt cấu hình dfs.datanode.data.dir. Giá trị mặc định của cài đặt này là ＄{hadoop.tmp.dir}/dfs/data.



#### 4.7 Read and Write

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



#### 4.8 High Availability (Tính sẵn sàng cao)

- HA là đặc trưng của hệ thống phân tán. standby Namenodes là 1 trong số thể hiện của HA trong HDFS

- **Working**

  - Giả sử cụm có 2 Namenodes. Để standby Namenode có thể thay thế Namenode bị lỗi thành công, nó cần bắt chước chính xác các hành động được thực hiện bởi Namenode. Điều này được triển thai bằng cách sử dụng JournalNodes. Giống như nhật ký , JournalNodes lưu giữ bản ghi tất cả các thay đổi mà Namenode đang hoạt động. Vì là hệ thống phân tán nên các thay đổi được ghi lại vào phần lớn các JournalNodes. Cần nhiều hơn một JournalNode để ghi lại hoạt đông của Namenode vì bản thân JournalNode dễ bị lỗi.
  - Công thức cho biết số lần thất bại mà JournalNode có thể chấp nhận được: (N-1)/2
    - N: số lượng JournalNodes trong thiết lập HA (N > 3)

  ![img](https://i.imgur.com/kYQN4se.png)

- **Split brain scenario**

  - JournalNodes phải đảm bảo chỉ có 1 active Namenode có thể ghi vào chúng. Do phân vùng mạng trong cụm, mỗi Namenode có thể đưa ra kết luận rằng nút khác đã chết. Sau đó, nó tự coi mình là Namenode đang active. Nếu mỗi Namenode có thể ghi vào JournalNodes thì trạng thái được duy trì bởi JournalNodes sẽ bị hỏng.

- **Fencing**

  - Fencing là một cơ chế do người dùng cấu hình nhằm ngăn chặn nút hoạt động trước đó cung cấp dữ liệu cũ cho client. Do QJM cho phép 1 Namenode có thể ghi, nhưng có thể trước đó 1 Namenode active có yêu cầu read.	
    - sshfence: SSH tới active Namenode và kills tiến trình
    - shell: Lệnh shell do người dùng chỉ định để tạo hàng rào (fence) cho Namenode đang hoạt động.

- **Shared NFS directory**

  - Cách thứ 2 để cấu hình HDFS HA là sử dụng NFS (Network File System) cho việc lưu trữ chia sẻ. Edit logs được chia sẻ giữa các Namenodes sử dụng thư mục NFS dùng chung. Active Namenode ghi lại bất kỳ sự thay đổi nào trong edit log trên thư mục NFS được chia sẻ. Standby Namenode liên tục theo dõi thư mục dùng chung xem có bất kỳ thay đổi nào không và áp dụng vào namespace riêng của chúng.



#### 4.9 Distcp (Distributed Copy tool)

- Công cụ quan trọng của Hadoop. Thường được sử dụng để di chuyển dữ liệu. Tool này cho phép việc sử lý song song tệp trên cùng cụm Hadoop hoặc giữa 2 cụm Hadoop. 



#### 4.10 Edilog, FS Image

- FS Image: FsImage là một tệp được lưu trữ trên hệ thống tệp OS chứa cấu trúc thư mục hoàn chỉnh (không gian tên) của HDFS với các chi tiết về vị trí của dữ liệu trên Khối dữ liệu và khối nào được lưu trữ trên nút nào. Tệp này được NameNode sử dụng khi nó được khởi động.

- Editlog: EditLogs là nhật ký giao dịch ghi lại các thay đổi trong hệ thống tệp HDFS hoặc bất kỳ hành động nào được thực hiện trên cụm HDFS chẳng hạn như thêm khối mới, sao chép, xóa, v.v. Nói tóm lại, nó ghi lại các thay đổi kể từ khi FsImage cuối cùng được tạo.

### 5. Spark

#### 5.1 Giới thiệu

Spark, nền tảng phổ biến để xử lý dữ liệu và đã gần như thay thế MapReduce truyền thống. Spark vượt trội hơn MapReduce theo nhiều bậc độ lớn trong nhiều điểm chuẩn và nghiên cứu hiệu suất. Spark được bắt đầu như một dự án vào năm 2009 tại Đại học California Berkeley và một bài nghiên cứu về những phát hiện này đã được xuất bản vào năm sau. Spark chủ yếu được viết bằng Scala, ngôn ngữ mặc định của nó. Tuy nhiên, Spark hoạt động với Python, Java và R.

![img](https://i.imgur.com/qSVt0ub.png)

- Sự khác biệt với MapReduce
  - Các công việc lặp lại giảm thời gian I/O
  - Hỗ trợ phân tích tương tác
  - Nhiều APIs

- Spark giữ lại nhiều tính năng của MapReduce như khả năng chịu lỗi, lập lịch và cân bằng tải. Nhưng Spark vượt trội trong việc tái sử dụng dữ liệu một cách hiệu quả bằng cách lưu nó vào bộ nhớ trên toàn cụm, tiết kiệm thời gian IO tốn kém vào đĩa. Truy cập bộ nhớ luôn nhanh hơn truy cập đĩa. Điều này giải thích phần lớn cách Spark vượt trội hơn MapReduce.

#### 5.2 Kiến trúc Spark

- Spark là một khung xử lý dữ liệu song song phân tán và có nhiều điểm tương đồng với khung MapReduce truyền thống. Spark có kiến trúc chủ-nô lệ giống như MapReduce, trong đó một tiến trình, chủ, điều phối và phân phối công việc giữa các quy trình phụ. Hai quá trình này được gọi là:

  - Driver
  - Executor

- Driver

  - Điều khiển các Spark job. Chịu trách nhiệm duy trì trạng thái chung của ứng dụng Spark, phản hồi chương trình hoặc đầu vào của người dùng và phân tích, phân phối và lập lịch công việc giữa các tiến trình thực thi. Driver là trung tâm của ứng dụng Spark và duy trì tất cả thông tin liên quan đến ứng dụng trong suốt vòng đời của ứng dụng.

- Executor

  - Executors là nô lệ thực thi code được giao bởi Driver. Và phản hồi lại trạng thái toán của nó cho Driver.

  ![img](https://i.imgur.com/G7bAnR5.png)

- Quản lý cụm

  - MapReduce Application Master hay Spark Driver không có khả năng phân bổ tài nguyên. Cần có quản lý cụm. Spark có thể chạy các quản lý cụm sau:
    - Hadoop YARN
    - Apache Mesos
    - Standalone Cluster Manager
    - Localmode

![img](https://i.imgur.com/Ej2BifN.png)

- Execution modes (Chế độ thực thi)

  - Cluster mode: Trong cluster mode, user gửi spark application tới cluster manager. Cluster manager lần lượt sinh ra Driver và Executor để thực thi job. Cả driver và executors đều tồn tại trong cụm

  ![img](https://i.imgur.com/hqGH4bH.png)

  - Client mode:  Giống Cluster mode ngoại trừ việc Driver sẽ ở trên máy client, submit Spark job bên ngoài cụm. Client chịu trách nhiệm duy trì Driver Process, trong khi đó cluster chịu trách nhiệm duy trì Executor process.

  ![img](https://i.imgur.com/cuWmny1.png)

#### 5.3 Vòng đời Spark Application

1. Người dùng submit task tới cluster. Nếu job này được chấp nhận, Resource Manager sẽ chạy Spark driver trên một máy trong cụm
2. Khi driver bắt đầu chạy, nó thực thi code của người dùng. Code cần có SparkSession để sets-up Spark cluster. Driver process và executor processes gọi chung là cụm Spark. SparkSesssion giao tiếp với Cluster Manager daemon, để chạy Spark executor process
3. RM (Cluster Manager) sẽ chạy Spark executor trên cụm và trả về vị trí của executor process cho Driver process.
4. Khi cụm Spark sẵn sàng, driver giao task cho executor, và bắt đầu thực thi job. Data có thể được di chuyển và executor báo cáo về trạng thái của họ cho Driver
5. Driver thoát khi Spark job hoàn thành, và cluster manager đóng executor processes thay cho Driver



#### 5.4 Spark API

- Spark cho phép xử lý dữ liệu phân tán thông qua các phép biến đổi chức năng của bộ sưu tập dữ liệu (RDD). 3 dữ liệu trừu tượng có sẵn trên Spark là:
  - Resilient Distributed Datasets
  - DataFrames
  - Datasets
- DataFrames và Dataset là các API có cấu trúc cao (high) còn RDD được gọi là các API có cấu trúc thấp (low). Thường thì dùng high lever APIs. Một vài trường hợp RDDs sẽ hoạt động tốt hơn.



#### 5.5 RDDs

- Read-only (immutable): tập hợp các đối tượng (bản ghi) chỉ đọc, không đổi, được phần vùng trên cụm và có thể được vận hành song song
- Giải nghĩa Resilient Distributed Datasets:
  - Resilient: Khả năng chịu lỗi và có thể tính toán lại các phân vùng bị thiếu hoặc bị hỏng do node bị lỗi. RDD ghi nhớ lại cách nó ở trạng thái hiện tại và có thể theo dõi lại các bước để tính toán lại mọi phân vùng bị mất
  - Distributed: Dữ liệu tạo nên RDD được trải rộng trên một cụm máy
  - Datasets: Dữ liệu ngoài có thể được tải bằng nhiều nguồn khác nhau như tệp JSON, CSV, tệp văn bản hoặc cơ sở dữ liệu qua JDBC
- Spark RDD có thể được lưu vào bộ nhớ đệm và phân vùng 1 cách thủ công. Bộ nhớ đệm rất hữu ích vì nó cho phép sử dụng RDD nhiều lần. Phân vùng thủ công giúp cân bằng chính xác các phân vùng.
- RDDs support two types of operations: 
  - Transformations, các hoạt động lazy trả về một RDD khác, RDD này không tính toán trừ khi hành động được thực hiện trên nó. Một số ví dụ về phép biến đổi là map(), flatmap(), filter()
  - Action, các hoạt động kích hoạt tính toán và trả về giá trị. Một số ví dụ về hành động là count, top(), savetofile()



#### 5.6 DataFrames

- DataFrames có thể coi như là các collections như bảng phân tán với các hàng và cột được xác định rõ ràng. Mỗi cột có cùng loại dữ liệu trên tất cả các hàng, việc thiếu giá trị có thể rỗng. 
- DataFrames cũng có thể chia thành các partition. Partition (Phân vùng), là tập hợp các hàng từ DataFrame góc nằm trên một máy trên cụm. Số lượng phân vùng quyết định tính song song đạt được trong Spark job. 
- 1 phân vùng chỉ có 1 người thực thi duy nhất. 
- Các phân vùng không bao giờ được thao tác thủ công hoặc riêng lẻ. 

- Lược đồ:
  - Lược đồ định nghĩa ra các tên cột, và kiểu của DataFrame. 
- Spark types
  - Spark sử dụng engine gọi là Catalyst để duy trì kiểu thông tin. Spark ánh xạ tới các loại tương ứng trong các ngôn ngữ được hỗ trợ (Java, Python, v.v.)



#### 5.7 Datasets

- Là tập hợp các đối tượng strongly-typed, không đổi ánh xạ tới lược đồ quan hệ, và type-safe structured
- Không hỗ trợ R và Python. Sau Spark 2.0, RDD thay thế bởi Datasets, strongly-type giống RDD nhưng tối ưu hóa phong phú hơn

- Dataset có thể thực hiện được nhờ Encoder. Encoder chuyển các kiểu JVM sang kiểu bảng chuyên biệt của Spark SQL. Encoder ánh xạ kiểu miền cụ thể tới kiểu bên trong của Spark.
- Trong khi sử dụng API Dataset, Spark tạo code trong thời gian chạy để mã hóa một đối tượng Java thành cấu trúc nhị phân bên trong và ngược lại. Việc chuyển đổi này có thể ảnh hưởng nhẹ đến hiệu suất nhưng có một số lợi ích.

- Khác biệt với DataFrames
  - Datasets kiểm tra xem các loại có tuân thủ tại thời điểm biên dịch hay không. DataFrames thì không  thực sự untyped bởi nó được duy trì bởi Spark, nhưng việc xác minh được thực hiện trong lúc runtime
  - DataFrames được coi như dataset với kiểu row

- Use-cases for Datasets
  - Một số thao tác không thể được biểu thị bằng DataFrames, chỉ với Dataset
  - Yêu cầu kiểu an toàn (type-safe). Check lúc compile
  - Nếu tất cả dữ liệu và phép biến đổi của bạn được chấp nhận, thì việc sử dụng lại chúng cho cả khối lượng công việc phân tán và khối lượng công việc cục bộ là điều đơn giản.

### 6. Input and Output format

#### 6.1 Sequence File

- Sequence file là binary formats.
- Sử dụng cho 2 mục đích
  - Có thể sử dụng như cấu trúc dữ liệu để lưu nhị phân các cặp key-value
  - Có thể sử dụng để chứa các files nhỏ hơn. Trong trường hợp lưu file nhỏ hơn, tên file là key và value là nội dung file
- Thành phần của bản ghi

![img](https://i.imgur.com/xjqy9Vz.png)

- Sync markers
  - Đánh dấu đồng bộ cho phép reader đánh dáu vị trí chính nó tớirìa bản ghi tiếp theo.
- Nén
  - Bản ghi nén (Record Compressed): Mỗi bản ghi trong tệp tuần tự sẽ được nén. 
  - Khối nén (Block Compressed): Nhiều bản ghi được thêm vào một khối cho đến khi kích thước có thể định cấu hình tối đa. Sau đó tất cả các bản ghi trong môt khối sau đó sẽ được nén

#### 6.2 SerDe

- SerDe = Serializer/Deserializer
- Encoding đối tượng thành byte stream gọi là serializing object.
- Tại sao cần SerDe: Đối tượng Ser trên Java không thể được De trên Python
- Giải quyết vấn đề trên có thể sử dụng JSON, XML. Nhưng không thể phân biệt giữa các loại dữ liệu khác nhau khi sử dụng các định dạng này
- Tác dụng: Minimizing size, portability, data integrity (Toàn vẹn)



#### 6.3 Rows vs Columner Databases

- 2 Kiểu store:
  - Row
  - Columnar
- Sự ra đời của Columnar

![img](https://i.imgur.com/tLuEtss.png)

![img](https://i.imgur.com/8PIE8Vj.png)

- Row Formats

  - ```text
    001: BMW, 840i, 2020, 335
    002: Porsche, 911, 2019, 443
    003: Mercedes-Benz, G-Wagon, 2019, 577 
    ```

- Column Format

  - ```text
    BMW:001, Porsche:002, Mercedes-Benz:003
    840i:001, 911:002, G-Wagon:003
    2020:001, 2019:002, 2019:003
    335:001, 443:002, 577:003
    ```

- Nén

  - Hệ thống máy tính sẽ đọc từ bộ nhớ theo từng đoạn có kích thước cố định được gọi là word. Word là lũy thừa 2, tức là 2,4,6,8,16,32 bit,... 

- Giả sự lưu trữ số nguyên tại các địa chỉ chia hết cho 4. Nếu lưu byte được đánh số 6, sẽ chiếm 2 Word. Điều này bao gồm 2 Word. 

![img](https://i.imgur.com/NHAiCtg.png)

struct Option1  

{ 

​    bool item1; // 1 byte

​    int item2; // 2 bytes

​    int item3;

​    bool item4; 

}; 

  

struct Option2  

{ 

​    bool item1;

​    bool item4; 

​    int item2;

​    int item3;

}; 

![img](https://i.imgur.com/TIxnpUy.png)

![img](https://i.imgur.com/nRzO3ea.png)

- Nếu chúng ta lưu trữ ở dạng cột thì tất cả các giá trị của một cột nhất định sẽ liền kề nhau. Điều này không lãng phí dung lượng vì tất cả các giá trị cho cùng một cột đều có cùng độ dài.



#### 6.4 Avro

- Avro là hệ thống data serialization cho phép thực hiện các hàm gọi thủ tục từ xa cũng như tuần tự hóa dữ liệu nhanh chóng và nhỏ gọn. Tính năng xác định của Avro là một lược đồ luôn được nhúng trong tệp avro. Nó cho phép một người đọc tệp mà không cần biết trước lược đồ. 
- Lược đồ avro được thể hiện bằng JSON



#### 6.5 Avro IDL & RPC (Remote Procedure Call)

- IDL (Interface Definition Language) cho phép người dùng thể hiện một lược đồ tương tự như việc bạn có thể viết mã bằng ngôn ngữ lập trình, thay vì sử dụng JSON để chỉ định lược đồ. Avro cung cấp một sản phẩm tương đương: Avro IDL.

- Avro IDL có các quy tắc và cú pháp riêng. Nó xuất hiện tương tự như các ngôn ngữ phổ biến như Java, C++ và Python.

```text
@namespace("io.datajek")
protocol CarProtocol {

  record Car {
    string make;
    string model;
    int year;
    int horsepower;
  }

string carToString(Car car);
}
```

- Định nghĩa từ điển của proxy là đại diện quyền cho người khác . Trong thiết lập proxy, proxy có trách nhiệm đại diện cho một đối tượng khác được gọi là subject, trước client. Đối tượng thực sự được bảo vệ khỏi sự tương tác trực tiếp với client. Có một số lý do để sử dụng proxy:

  - Để truy cập các đối tượng từ xa qua internet, chạy trong một JVM hoặc không gian địa chỉ khác
  - Để bảo vệ một subject khỏi những client không được phép truy cập vào nó
  - Để thay thế một đối tượng có thể tốn kém để tạo và trì hoãn việc tạo đối tượng cho đến khi nó được truy cập
  - Để lưu trữ các truy vấn hoặc kết quả từ chủ đề cho client
  - Có nhiều trường hợp sử dụng khác, chẳng hạn như proxy tường lửa, proxy đồng bộ hóa và các trường hợp khác.
- Class diagram bao gồm thực thể sau: 
  - Proxy
  - Subject
  - Real Subject

![img](https://i.imgur.com/NXGte6i.png)



#### 6.6 Parquet

- Điều khiến Parquet khác biệt so với các định dạng cột khác là khả năng lưu trữ dữ liệu lồng nhau một cách hiệu quả. Các trường lồng nhau sâu cũng được lưu trữ theo kiểu cột thực sự và có thể được đọc độc lập với các trường khác.

- Mục tiêu thiết kế chính của Parquet là:

  - Khả năng tương tác
  - Hiệu quả không gian
  - Hiệu quả truy vấn

- Dữ liệu được lưu trữ trong Parquet dựa trên lược đồ lưu trữ trong Parquet file. Mô hình được dùng để mô tả dữ liệu giống như bộ đệm giao thức của Google. Một vài mô tả của mô hình dữ liệu được sử dụng trong Parquet xuất hiện dưới đây:

  - Phần tử root gọi là message và chứa các trường.
  - Trường chứa 3 thuộc tính sau: <repetition>  <type> <name>
  - Repetion được set chính xác một lần, được thể hiện bằng từ khóa required. Có thể set bằng 0 hoặc 1. Cuối cùng có thể biểu thị Map và list với bằng cách chỉ định sự lạp đi lặp lại là optional, ngụ ý rằng có thể có 1 hoặc nhiều lần
  - Kiểu của Field có thể là kiểu nguyên thủy như int, float, string hoặc nested có kiểu group

- ```tex
  message Car {
   required string make;
   required int year;
   
   repeated group part {
       required string name;
       optional int life;
       repeated string oem;   
   }
  }
  ```

- required: chính xác một lần xuất hiện

- optional: 0 hoặc 1 lần xuất hiện

- repeated: 0 lần hoặc nhiều xuất hiện trở lên

![img](https://i.imgur.com/Q6PtZQU.png)

![img](https://i.imgur.com/msqwp58.png)



### 7. Zookeeper

#### 7.1 Zookeeper Intro

- ZooKeeper là một dịch vụ tập trung để duy trì thông tin cấu hình, đặt tên, cung cấp các dịch vụ nhóm và đồng bộ hóa phân tán. Tất cả các dịch vụ này được sử dụng bởi các ứng dụng phân tán. 
- Zookeeper rất dễ hiểu. Hãy nghĩ về nó như một hệ thống tập tin phân cấp hoặc một cái cây. Khối xây dựng cơ bản của Zookeeper là znode . Một znode có thể lưu trữ dữ liệu (như một tập tin) hoặc có các znode con (như một thư mục). Thiết kế tổng thể của Zookeeper cung cấp một hệ thống có tính sẵn sàng cao bao gồm các znode tạo nên một không gian tên có thứ bậc.

![img](https://i.imgur.com/4FFnCUY.png)

- Zookeeper có thể chạy trên server độc lập trong standalone mode hoặc trên một cụm máy ở chế độ sao chép replicated mode, gọi là tập hợp (ensemble). Tính HA ở chế độ sao chép (replicated) đạt được bằng cách đảm bảo các sửa đổi đối với cây znodes được sao chép thành phần lớn của tập ensemble. Giả sử 5 máy (A, B, C, D, E) chạy trong Zookeeper ensemble. Phần lớn số máy, gọi là quorum, cần update. Máy A, C, E cần update. Nếu một số máy bị lỗi, giả sử là A và E bị lỗi khi đó có ít nhất một máy C có trạng thái mới nhất. Hai máy còn lại là B và D có thể nắm được trạng thái mới nhất. 
- Zookeeper sử dụng giao thức gọi là Zab để triển khai. Giao thức hoạt động theo 2 giai đoạn. 
  - Giai đoạn 1: Lựa chọn leader, những người khác là người theo dõi và đồng bộ hóa trạng thái với leader.
  - Giai đoạn 2: Tất cả yêu cầu ghi đều được chuyển tiếp đến leader, người này sẽ gửi thông tin update cho người theo dõi

- Máy trong ensemble ghi cập nhật vào đĩa trước khi cập nhật trong bộ bản sao trong cây znode. Client có thể trực tiếp gửi yêu cầu đọc tới bất kỳ máy nào

- Nếu leader gặp lỗi, thì tiến hành lựa chọn leader mới. Nếu leader cũ quay lại, nó thành người theo dõi

- Data model (Mô hình dữ liệu)
  - Znodes có một danh sách kiểm soát truy cập access control list (ACL) quản lý những người có thể đọc hoặc viết một znode cụ thể. Hơn nữa, việc đọc và ghi vào znode là atomic (nguyên tử).  Yêu cầu đọc/ghi hoàn tất thành công hoặc thất bại. Việc tham chiếu các znode bằng đường dẫn cho phép chúng ta hình dung Zookeeper như một hệ thống tệp phân cấp.
  - Ngoài ra, còn có znode tuần tự, có số thứ tự được đính kèm. Số thứ tự là giá trị của bộ đếm tăng đơn điệu, được duy trì bởi znode gốc. Zookeeper có thể đặt các watchs trên các znode giám sát việc thay đổi cấu hình của một ứng dụng. Một ứng dụng có thể đặt watch trên znode chứa một số cấu hình và được thông báo khi nó bị thay đổi bởi một ứng dụng khác.
- Tính nhất quán  (Consistency)
  - Mọi thay đổi tới cây znode đều được gán một mã định danh duy nhất trên toàn cầu, gọi là transaction ID, hiển thị là zxid. Cập nhật theo thứ tự, ví dụ zxid của A bé hơn zxid B, A sẽ được cập nhật sau B. 
    - Tính nhất quán tuần tự : Các cập nhật từ máy khách được áp dụng theo thứ tự
    - Tính nguyên tử : Sửa đổi thành công hoặc thất bại. 
    - Hệ thống ảnh đơn: Máy khách sẽ nhìn thấy cùng một chế độ xem của hệ thống bất kể máy chủ Zookeeper mà nó kết nối với một tập hợp. Hãy xem xét tình huống trong đó máy khách ngắt kết nối với máy chủ bị lỗi. Nó cố gắng kết nối với một máy chủ khác phía sau máy chủ bị lỗi. Vì máy chủ kia chưa bắt kịp trạng thái của máy chủ bị lỗi nên nó sẽ từ chối máy khách kết nối cho đến khi bắt kịp.
    - Tính bền vững: Khi được cập nhật thành công, nó sẽ được giữ cố định
    - Tính kịp thời: Chế độ xem hệ thống của máy khách được đảm bảo cập nhật trong một khoảng thời gian nhất định (theo thứ tự hàng chục giây).
  - Zookeeper không hỗ trợ các chế độ xem đồng thời nhất quán giữa nhiều khách hàng . Điều này có nghĩa là nếu khách hàng X cập nhật znode từ s thành s' và thông báo cho khách hàng Y đọc giá trị cập nhật của znode, thì Y có thể đọc giá trị cũ s chứ không phải s' . Để máy khách Y đọc giá trị mới nhất, nó phải gọi thao tác đồng bộ hóa (một phần của API Zookeeper) trên znode.