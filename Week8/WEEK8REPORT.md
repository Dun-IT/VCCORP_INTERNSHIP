## WEEK 8 REPORT

*Thực tập sinh: Nguyễn Khoa Đoàn*

### 1. Mô tả công việc

- Tìm hiểu về Shell linux, các câu lệnh liên quan:
  - Các command cơ bản
  - Các command liên quan đến quyền 
  - Các command thực hiện song song
- Sử dụng vim: tạo file, sửa file, save, ...
- Quản lý tiến trình
- Tìm hiểu về docker



### 2. Kết quả công việc

#### 2.1 Shell linux

Shell là một chương trình cung cấp giao diện giao tiếp giữa người dùng và hệ điều hành (OS). Hệ điều hành khởi động một shell cho mỗi người dùng khi người dùng đăng nhập hoặc mở một cửa sổ terminal hoặc console.

![Shell là gì? 4 loại Shell phổ biến nhất hiện nay - Ảnh 1.](https://techvccloud.mediacdn.vn/thumb_w/650/2018/11/19/shellscripting-1542594064464172154102.png)

Kernel (nhân) là một chương trình thực hiện các tác vụ sau:

- Kiểm soát tất cả các hoạt động của máy tính.
- Điều phối tất cả các tiện ích trong xử lý lệnh
- Đảm bảo rằng các tiện ích không xung đột lẫn nhau hoặc tiêu thụ hết tài nguyên hệ thống.
- Lên lịch và quản lý tất cả các quy trình hệ thống

Trong lúc giao tiếp với kernel, Shell sẽ cung cấp phương thức để người dùng có thể sử dụng được các tiện ích và chương trình.

#### 2.2 Các command 

##### 2.2.1 cd command

- Di chuyển tới thư mục khác

```cmd
cd [directory]
```

- Di chuyển tới thư mục cha chứa nó

```cmd
cd ..
```

- Di chuyển tới root

```cmd
cd /
```

- Di chuyển tới home

```cmd
cd ~
```



##### 2.2.2 ls command

- Liệt kê toàn bộ file/thư mục

```cmd
ls [option] [file/directory]
```

- option

| Options | Mô tả                                                    |
| ------- | -------------------------------------------------------- |
| **-l**  | Liệt kê nhiều thông tin hơn về file/directory            |
| **-a**  | Liệt kê cả file/directory ẩn                             |
| **-t**  | Sắp xếp theo thứ tự sửa đổi, hay sửa đổi thì xếp lên đầu |
| **-r**  | Đảo ngược thứ tự liệt kê mặc định                        |
| **-S**  | Sắp xếp file/directory theo kích cỡ, lớn nhất ở đầu      |
| **-R**  | Liệt kệ file/directory và cả file/directory con          |
| **-i**  | Liệt kê inode của file/directory                         |
| **-g**  | Hiển thị sở hữu group thay vì người dùng                 |
| **-h**  | In ra kích cỡ file mà con người đọc được (1K, 234M, 2G)  |
| **-d**  | Hiển thị thư mục chính nó, thay vì nội dung bên tron     |



##### 2.2.3 cp command 

- Sử dụng để copy

```cmd
cp [OPTION] Source Destination
cp [OPTION] Source Directory
cp [OPTION] Source-1 Source-2 Source-3 Source-n Directory
```

- option

| option         | Mô tả                                                        |
| -------------- | ------------------------------------------------------------ |
| **-i**         | Yêu cầu xác nhận từ người dùng trước khi ghi đè lên một tệp tin đã tồn tại |
| **-r hoặc -R** | Sao chép thư mục và nội dung bên trong nó đệ quy             |
| **-u**         | Chỉ sao chép khi nguồn có nội dung mới hơn hoặc tệp đích không tồn tại |
| **-v**         | Hiển thị thông báo chi tiết về quá trình sao chép            |
| **-f**         | Ghi đè lên các tệp tin đích mà không cần xác nhận từ người dùng |



##### 2.2.4 mv command

- Sử dụng để di chuyển hoặc đổi tên tệp hoặc thư mục

```cmd
mv [options] source destination
```

- option

| option | Mô tả                                                        |
| ------ | ------------------------------------------------------------ |
| **-i** | Yêu cầu xác nhận từ người dùng trước khi ghi đè lên một tệp tin đã tồn tại |
| **-b** | Tạo bản sao lưu của tệp tin đích nếu đã tồn tại và ghi đè lên nó. |
| **-u** | Chỉ sao chép khi nguồn có nội dung mới hơn hoặc tệp đích không tồn tại |
| **-v** | Hiển thị thông báo chi tiết về quá trình di chuyển hoặc đổi tên. |
| **-n** | Không ghi đè lên các tệp tin đích đã tồn tại.                |



##### 2.2.5 mkdir command

- Sử dụng để tạo mới một hoặc nhiều thư mục mới 

```cmd
mkdir [options] directory_name
```

- option

| option | Mô tả                                                 |
| ------ | ----------------------------------------------------- |
| **-p** | Tạo các thư mục cha nếu chúng không tồn tại           |
| **-m** | Thiết lập quyền truy cập cho thư mục mới được tạo.    |
| **-v** | Hiển thị thông báo chi tiết về quá trình tạo thư mục. |



##### 2.2.6 cat command

- Sử dụng để hiển thị nội dung của tệp tin hoặc nhiều tệp tin

```cmd
cat [options] [file(s)]
```

- option

| option | Mô tả                                                        |
| ------ | ------------------------------------------------------------ |
| **-n** | Hiển thị số dòng cho mỗi dòng trong nội dung tệp tin         |
| **-A** | Hiển thị các ký tự không in ra màn hình, như ký tự xuống dòng và tab |
| **-b** | Tương tự như `-n`, nhưng chỉ số cho các dòng không trống     |
| **-E** | Hiển thị ký tự $ ở cuối mỗi dòng.                            |
| **-T** | Hiển thị các ký tự tab với `^I`.                             |



##### 2.2.7 head command

- Sử dụng để hiển thị phần đầu của nội dung của một hoặc nhiều tệp tin. Mặc định sẽ hiển thị 10 dòng đầu

```cmd
head [options] [file(s)]
```

- option

| option   | Mô tả                                                        |
| -------- | ------------------------------------------------------------ |
| **-n N** | Hiển thị N dòng đầu tiên của mỗi tệp tin.                    |
| **-c N** | Hiển thị N byte đầu tiên của mỗi tệp tin.                    |
| **-q**   | Không hiển thị tiêu đề tên tệp tin khi có nhiều hơn một tệp tin. |



##### 2.2.8 chmod command

- Sử dụng để thay đổi quyền truy cập của tệp tin hoặc thư mục (rwx) - (Chủ sở hữu, nhóm, người khác)

```cmd
chmod [options] mode file(s)
```

- Octal Mode
  - Thiết lập quyền đầy đủ cho người sở hữu, quyền đọc và thực thi cho nhóm và quyền đọc cho người khác: *chmod 755 filename*
  - Chỉ cho phép người sở hữu đọc và ghi, nhóm đọc, và người khác không có quyền: *chmod 640 filename*

- Symbolic Mode
  - Thêm quyền thực thi cho tất cả mọi người: *chmod +x filename*
  - Gỡ bỏ quyền ghi của nhóm và người khác: chmod go-w filename (group và other trừ write)

- option

| option              | Mô tả                                                        |
| ------------------- | ------------------------------------------------------------ |
| **-R**              | Áp dụng quyền truy cập theo cách đệ quy cho cả thư mục và nội dung bên trong. |
| **-reference=file** | Sao chép quyền truy cập từ tệp tin đã cho đến tệp tin được chỉ định. |



##### 2.2.9 chown command

- Sử dụng để thay đổi chủ sở hữu của tệp tin hoặc thư mục

```cmd
chown [options] new_owner[:new_group] file(s)
```

- Trong đó:
  - [options]: Các tùy chọn có thể được thêm vào để điều chỉnh hành vi của lệnh.
  - new_owner: Tên người sở hữu mới mà bạn muốn thiết lập.
  - new_group: (Tùy chọn) Tên nhóm mới mà bạn muốn thiết lập.
- option

| option              | Mô tả                                                        |
| ------------------- | ------------------------------------------------------------ |
| **-v**              | Hiển thị thông báo chỉ khi có thực sự thay đổi được thực hiện. |
| **-c**              | Hiển thị thông báo chi tiết, bao gồm cả khi không có thay đổi. |
| **-reference=file** | Sao chép người sở hữu và nhóm từ tệp tin đã cho đến tệp tin được chỉ định. |



##### 2.2.10 Các command thực hiện song song

- cat test.txt | wc -l : Đọc file test.txt, đầu ra khi đọc sẽ được đếm số dòng 
- cat test.txt | grep "a" : Đọc file test.txt, đầu ra khi đọc sẽ được lọc các chuỗi chứa "a"
- cat test.txt | head : Đọc file test.txt, đầu ra được hiển thị 1 phần đầu
- echo "aabb" > test.txt : Hiển thị chuỗi "aabb", ">" nghĩa là ghi đè file test.txt
- echo "cc" >> test.txt : Hiển thị chuỗi "cc", ">>" nghĩa là ghi tiếp file test.txt



##### 2.2.11 vim command

- Sử dụng để thao tác với file

- Mở file:

```cmd
vim filename
```

- Tạo mới file:

```cmd
vim newfile
```

- Di chuyển con trỏ:

  - `h`: Di chuyển sang trái.

  - `j`: Di chuyển xuống dưới.

  - `k`: Di chuyển lên trên.

  - `l`: Di chuyển sang phải.

- Lưu và Thoát:
  - `:w`: Lưu (ghi) tệp tin.
  - `:q`: Thoát khỏi `vim`.
  - `:wq` hoặc `:x`: Lưu và thoát.
- Thoát Mà Không Lưu:
  - `:q!`: Thoát mà không lưu thay đổi.



##### 2.2.12 Quản lý tiến trình

**HTOP**

- htop: Tiện ích dòng lệch trực quan theo dõi và quản lý tiến trình trên Linux. Cung cấp giao diện người dùng đồ họa
- Thao Tác Tương Tác:
  - `F2`: Mở cài đặt.
  - `F3` và `F4`: Tìm kiếm và lọc theo tên tiến trình.
  - `F5`: Làm mới hiển thị.
  - `F9`: Mở menu chọn tiến trình để kết thúc hoặc gửi tín hiệu.
- Sắp Xếp Tiến Trình:
  - Nhấn các phím `P` (sắp xếp theo CPU), `M` (sắp xếp theo bộ nhớ), `T` (sắp xếp theo thời gian CPU),...
- Thoát `htop`:
  - Nhấn `q` để thoát `htop`.



**PS AUX**

- Sử dụng để hiển thị danh sách các tiến trình đang chạy trên hệ thông
- Thông tin được hiển thị: USER       PID  %CPU %MEM    VSZ   RSS TTY      STAT START   TIME COMMAND
  - **USER:** Tên người dùng (username) của người chạy tiến trình.
  - **PID:** Process ID, là một số duy nhất để định danh mỗi tiến trình.
  - **%CPU:** Phần trăm CPU mà tiến trình đang sử dụng.
  - **%MEM:** Phần trăm bộ nhớ RAM (physical memory) mà tiến trình đang sử dụng.
  - **VSZ:** Kích thước ảo (virtual memory size) của tiến trình, tính bằng kilobyte (KB).
  - **RSS:** Kích thước không gian đã cấp phát (Resident Set Size), đại diện cho bộ nhớ RAM thực sự được sử dụng bởi tiến trình, tính bằng kilobyte (KB).
  - **TTY:** Thiết bị đầu cuối (terminal) mà tiến trình đang chạy trên.
  - **STAT:** Trạng thái của tiến trình, có thể là "R" (running - đang chạy), "S" (sleeping - đang ngủ), "Z" (zombie - tiến trình đã kết thúc nhưng không được dọn dẹp), và nhiều trạng thái khác nữa.
  - **START:** Thời điểm bắt đầu chạy của tiến trình.
  - **TIME:** Tổng thời gian CPU đã chiếm bởi tiến trình.
  - **COMMAND:** Lệnh (command) hoặc tên của tiến trình.



**KILL -9**

- Sử dụng để kết thúc tiến trình ngay lập tức.
- Lệnh này sẽ gửi một tín hiệu SIGKILL cho tiến trình có Process ID là "xxxxx", làm cho tiến trình đó kết thúc ngay lập tức mà không có bất kỳ cơ hội để xử lý hoặc thực hiện bất kỳ hành động dọn dẹp nào.
- Việc sử dụng kill -9 có thể là lựa chọn mạnh mẽ nhưng cũng có thể gây mất dữ liệu hoặc tình trạng không đoán trước được của hệ thống. 



#### 3. Docker

##### 3.1 Docker Overview

- Docker là nền tảng phần mềm cho phép dựng, kiểm thử và triển khai ứng dụng một cách nhanh chóng. Docker đóng gói phần mềm vào các đơn vị tiêu chuẩn hóa được gọi là **container** có mọi thứ mà phần mềm cần để chạy, trong đó có thư viện, công cụ hệ thống, mã và thời gian chạy. Bằng cách sử dụng Docker, ta có thể nhanh chóng triển khai và thay đổi quy mô ứng dụng vào bất kỳ môi trường nào và biết chắc rằng mã của bạn sẽ chạy được.

##### 3.2 How Docker work

- Docker hoạt động bằng cách cung cấp phương thức tiêu chuẩn để chạy mã của bạn. Docker là hệ điều hành dành cho container. Cũng tương tự như cách máy ảo ảo hóa (loại bỏ nhu cầu quản lý trực tiếp) phần cứng máy chủ, các container sẽ ảo hóa hệ điều hành của máy chủ. Khi được cài đặt trên từng máy chủ, docker cung cấp các lệnh cơ bản để bạn có thể build, khởi tạo hay dừng container.

![img](https://d1.awsstatic.com/Developer%20Marketing/containers/monolith_2-VM-vs-Containers.78f841efba175556d82f64d1779eb8b725de398d.png)

- Hoạt động của Docker sẽ thông qua một Docker Engine có sự kết hợp của hai yếu tố server và client. Server và Client giao tiếp với nhau thông qua REST API.

##### 3.3 Kiến trúc Docker

- Docker sử dụng mô hình client-server. Docker client giao tiếp với Docker daemon, Docker daemon thực hiện công việc building, running, và phân phối Docker containers. Docker client và daemon có thể chạy trên cùng một hệ thống. Có thể kết nối tới Docker client bởi remote Docker daemon. Docker client và Docker daemon giao tiếp với nhau thông qua REST API, qua giao diện mạng. Có Docker client khác là Docker Compose, 
  - Docker deamon: lắng nghe các yêu cầu API Docker và quản lý các đối tượng như Images, containers, networks, và volumes. Deamon có thể giao tiếp với daemons khác để quản lý Docker services
  - Docker client: Khi sử dụng lệnh *docker run*, client sẽ gửi lệnh này đến *docker daemon*, để thực hiện chúng. Lệnh *docker* sử dụng API Docker. Docker client có thể giao tiếp với nhiều daemon
  - Docker registries: Lưu trữ Docker images. Docker Hub là registry công khai mà ai cũng có thể sử dụng. Khi sử dụng *docker pull* hoặc *docker run*, Docker pull image cần thiết từ registry đã cấu hình. Khi sử dụng *docker push*, Docker push image tới registry được cấu hình

![Docker Architecture diagram](https://docs.docker.com/get-started/images/docker-architecture.webp)

- Docker Objects
  - Images: Read-only template được sử dụng để tạo Docker Container.
  - Containers: Container là một thực thể có thể chạy của Image. Có thể tạo, bắt đầu, dừng, di chuyển, hoặc xóa container sử dụng API Docker hoặc CLI. Có thể tạo mới Image dựa trên trạng thái của Container hiện tại. Thông thường một container được cách ly với các container khác và máy chủ của nó. Một container được xác đinh bởi Images của nó cũng như mọi tùy chọn cấu hình mà bạn cung cấp cho nó khi tạo. 
- Docker file
  - Để tạo ra Image chúng ta sẽ viết cấu hình cho Image ở trong 1 file gọi là Dockerfile, Dockerfile là text file chứa các command, theo thứ tự 
  - FROM: Base image lấy trên docker hub
  - RUN: Thực thi một command bất kỳ trong quá trình build image, thường dùng để build các package trong image
  - CMD:  Thực thi một command bất kỳ trong quá trình chạy container. CMD sẽ không thực thi bất cứ thứ gì trong quá trình build image và mỗi Dockerfile chỉ chứa duy nhất một lệnh CMD
  - LABEL: Cung cấp metadata cho image
  - EXPOSE: thiết lập port để truy cập tới container sau khi khởi chạy
  - ENV: thiết lập các biến môi trường để sử dụng cho các câu lệnh trong quá trình build
  - ADD và COPY: sao chép file, thư mục vào container
  - ENTRYPOINT: cung cấp một số lệnh mặc định cùng tham số khi thực thi container
  - VOLUME: tạo một folder dùng để truy cập và lưu trữ dữ liệu, folder được liên kết từ máy host và container
  - USER: dùng để chỉ định username hoặc UID được dùng trong quá trình tạo image cho các lệnh RUN, CMD, ENTRYPOINT
  - WORKDIR: Thiết lập thư mục làm việc trong container cho các lệnh COPY, ADD, RUN, CMD, ENTRYPOINT
  - ARG: Định nghĩa các biến để sử dụng trong build-time
  - ONBUILD: Tạo một trigger cho image để thực thi khi nó được sử dụng làm base image cho việc build một image khác
  - STOPSIGNAL: Chỉ định kí hiệu hệ thống dùng để stop container
  - HEALTHCHECK: cung cấp phương thức cho Docker để kiểm tra container có hoạt động bình thường hay không
  - SHELL: Dùng để thay đổi các lệnh shell mặc định

- Lệnh thường sử dụng:

![img](https://i.imgur.com/LktAJ0J.png)

