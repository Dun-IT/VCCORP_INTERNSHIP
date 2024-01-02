# REPORT WEEK 9 - 10 - 11

*Thực tập sinh: Nguyễn Khoa Đoàn*

### 1. Mô tả công việc

- Setup môi trường cài đặt cụm HDFS, YARN
- Cài đặt Spark standalone, Spark trên YARN

### 2. Báo cáo công việc

#### 2.1. Setup môi trường cài đặt cụm HDFS, YARN

##### 2.1.1. Phiên bản

- Hadoop-3.2.4
- Openjdk 11
- Docker version 24.0.7, build afdd53b (Sử dụng để ảo hóa các node)

##### 2.1.2. Cài đặt môi trường

- Tạo một bridge network mới trên Docker

```cmd
$ docker network create hadoop-network
```

- Tạo một container trên image Ubuntu 20.04

```cmd
$ docker run -it --name node-master -p 9870:9870 -p 8088:8088 -p 19888:19888 --hostname node-master --network hadoop-network ubuntu:20.04
```

- Cài đặt các package cần thiết

```cmd
$ apt update
$ apt install -y wget tar ssh default-jdk 
```

- Tạo user hadoop

```cmd
$ groupadd hadoop
$ useradd -g hadoop -m -s /bin/bash hdfs
$ useradd -g hadoop -m -s /bin/bash yarn
$ useradd -g hadoop -m -s /bin/bash mapred
```

- Tạo ssh-key trên mỗi user

```cmd
$ su <username>
$ ssh-keygen -m PEM -P '' -f ~/.ssh/id_rsa
$ cat ~/.ssh/id_rsa.pub >> ~/.ssh/authorized_keys
$ chmod 0600 ~/.ssh/authorized_keys
```

- Đặt mật khẩu cho từng user

```cmd
$ passwd <username>
```

- Quay trở lại root, start ssh service

```cmd
$ service ssh start
```

- lKiểm tra hostname trong file /etc/hosts trên root

```cmd
172.19.0.2		node-master
```

- Kiểm tra ssh 

```cmd
$ ssh <username>@node01
```

##### 2.1.3. Download hadoop và cấu hình 

- Cấu hình tại root
- Download và cài đặt hadoop

```cmd
$ wget https://dlcdn.apache.org/hadoop/common/hadoop-3.2.4/hadoop-3.2.4.tar.gz
$ tar -xvzf hadoop-3.2.4.tar.gz
$ mv hadoop-3.2.4 /lib/hadoop
$ mkdir /lib/hadoop/logs
$ chgrp hadoop -R /lib/hadoop
$ chmod g+w -R /lib/hadoop
```

- Cấu hình biến môi trường trong file /etc/bash.bashrc

```cmd
export JAVA_HOME=/usr/lib/jvm/default-java
export HADOOP_HOME=/lib/hadoop
export PATH=$PATH:$HADOOP_HOME/bin

export HDFS_NAMENODE_USER="hdfs"
export HDFS_DATANODE_USER="hdfs"
export HDFS_SECONDARYNAMENODE_USER="hdfs"
export YARN_RESOURCEMANAGER_USER="yarn"
export YARN_NODEMANAGER_USER="yarn"

export HADOOP_CONF_DIR=$HADOOP_HOME/etc/hadoop
```

- Cập nhật biến môi trường

```cmd
$ source /etc/bash.bashrc
```

- Cập nhật file $HADOOP_HOME/etc/hadoop/hadoop-env.sh

```cmd
export JAVA_HOME=/usr/lib/jvm/default-java
```

- Cấu hình cho Hadoop:
- $HADOOP_HOME/etc/hadoop/core-site.xml (`/home/${user.name}/hadoop` là thư mục lưu dữ liệu trên HDFS)

```xml
<configuration>
    <property>
        <name>fs.defaultFS</name>
        <value>hdfs://node-master:9000</value>
    </property>
    <property>
        <name>hadoop.tmp.dir</name>
        <value>/home/${user.name}/hadoop</value>
    </property>
</configuration>
```

- $HADOOP_HOME/etc/hadoop/hdfs-site.xml (Cấu hình `dfs.replication` thiết lập số bản sao thực tế được lưu trữ đối với một dữ liệu trên HDFS, chỉ có user thuộc hadoop mới có quyền đọc ghi)

```xml
<configuration>
    <property>
        <name>dfs.replication</name>
        <value>1</value>
    </property>
    <property>
        <name>dfs.permissions.superusergroup</name>
        <value>hadoop</value>
    </property>
    <property>
        <name>dfs.datanode.data.dir.perm</name>
        <value>774</value>
    </property>
</configuration>
```

- $HADOOP_HOME/etc/hadoop/yarn-site.xml 

```xml
<configuration>
    <property>
        <name>yarn.resourcemanager.hostname</name>
        <value>node-master</value>
    </property>
    <property>
        <name>yarn.nodemanager.resource.memory-mb</name>
        <value>-1</value>
    </property>
    <property>
        <name>yarn.nodemanager.resource.detect-hardware-capabilities</name>
        <value>true</value>
    </property>
</configuration>
```



##### 2.1.4. Chạy trên 1 node

- Format file trên Name Node

```cmd
$ su hdfs
[hdfs]$ $HADOOP_HOME/bin/hdfs namenode -format
$ exit
```

- Chạy các dịch vụ của Hadoop trên root

```cmd
$ $HADOOP_HOME/sbin/start-all.sh
```



##### 2.1.5. Thêm node mới vào cụm

- Tạo một image từ container đang có 

```cmd
$ docker commit node-master hadoop
```

- Run container mới từ image vừa tạo

```cmd
$ docker run -it --name node1 --hostname node1 --network hadoop-network hadoop
```

- Trên node1, start service ssh và xoá thư mục data cũ đi

```cmd
$ service ssh start
$ rm -rf /home/hdfs/hadoop
$ rm -rf /home/yarn/hadoop
```

- Cập nhật ip, hostname của Namenode cho node1 (File /etc/hosts)
  - 172.19.0.2	node-master	
  - 172.19.0.3	node1
- Trên node-master chúng ta bổ sung thêm ip và hostname của node01 (File /etc/hosts)
  - 172.19.0.2	node-master	
  - 172.19.0.3	node1
- File $HADOOP_HOME/etc/hadoop/workers

```
node-master
node1
```

- Làm tương tự các bước trên ta có 3 node trên cụm
- Kết quả
- http://localhost:8088/cluster/nodes

![img](https://i.imgur.com/po8wAxk.png)

- http://localhost:9870/dfshealth.html#tab-datanode

![img](https://i.imgur.com/wzr6pH5.png)



##### 2.1.6. Chạy chương trình MapReduce

- Start HDFS

```cmd
root@node-master:~# $HADOOP_HOME/sbin/start-dfs.sh
```

- Tạo 1 file trên HDFS làm input cho bài toán Wordcount (Ghi nhiều file có dạng *.log vào /input_wordcount.log)

```cmd
root@node-master:~# hdfs dfs -D dfs.replication=2 -appendToFile /lib/hadoop/logs/*.log /input_wordcount.log
```

- Source code JAVA chương trình WordCount

```java
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCount {

  public static class TokenizerMapper
       extends Mapper<Object, Text, Text, IntWritable>{

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {
      StringTokenizer itr = new StringTokenizer(value.toString());
      while (itr.hasMoreTokens()) {
        word.set(itr.nextToken());
        context.write(word, one);
      }
    }
  }

  public static class IntSumReducer
       extends Reducer<Text,IntWritable,Text,IntWritable> {
    private IntWritable result = new IntWritable();

    public void reduce(Text key, Iterable<IntWritable> values,
                       Context context
                       ) throws IOException, InterruptedException {
      int sum = 0;
      for (IntWritable val : values) {
        sum += val.get();
      }
      result.set(sum);
      context.write(key, result);
    }
  }

  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    Job job = Job.getInstance(conf, "word count");
    job.setJarByClass(WordCount.class);
    job.setMapperClass(TokenizerMapper.class);
    job.setCombinerClass(IntSumReducer.class);
    job.setReducerClass(IntSumReducer.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}
```

- Lưu file với tên file WordCount.java trong thư mục wordcount
- Bổ sung biến môi trường (Dịch ra file jar)

```xml
export HADOOP_CLASSPATH=${JAVA_HOME}/lib/tools.jar
```

- Complie code

```cmd
root@node-master:~/wordcount# hadoop com.sun.tools.javac.Main WordCount.java
root@node-master:~/wordcount# jar cf wc.jar WordCount*.class
```

- Chạy và kiểm tra kết quả

```cmd
root@node-master:~/wordcount# hadoop jar wc.jar WordCount /input_wordcount.log /ouput_wordcount 
root@node-master:~/wordcount# hdfs dfs -cat /ouput_wordcount/part-r-00000
```

![img](https://i.imgur.com/9XGzUpI.png)

#### 2.2. Cài đặt Spark standalone, spark trên yarn

##### 2.2.1 Cài đặt Spark

- Download spark và cài đặt

```cmd
$ wget https://dlcdn.apache.org/spark/spark-3.3.4/spark-3.3.4-bin-without-hadoop.tgz
$ tar -xzvf spark-3.3.4-bin-without-hadoop.tgz 
$ mv spark-3.3.4-bin-without-hadoop /lib/spark
$ mkdir /lib/spark/logs
$ chgrp hadoop -R /lib/spark
$ chmod g+w -R /lib/spark
```

- Cấu hình các biến môi trường trong file /etc/bash.bashrc

```cmd
export SPARK_HOME=/lib/spark
export PATH=$PATH:$SPARK_HOME/bin
```

- Cập nhật biến môi trường

```cmd
$ source /etc/bash.bashrc
```

- Tạo file $SPARK_HOME/conf/spark-env.sh

```cmd
cp $SPARK_HOME/conf/spark-env.sh.template $SPARK_HOME/conf/spark-env.sh
```

- Thêm cấu hình classpath vào file `$SPARK_HOME/conf/spark-env.sh`

```cmd
export SPARK_DIST_CLASSPATH=$(hadoop classpath)
```

- Kiểm tra xem đã chạy được Spark ở YARN mode hay chưa:

```cmd
spark-shell --master yarn --deploy-mode client
```

![img](https://i.imgur.com/XGehsVy.png)

![img](https://i.imgur.com/1O2utUQ.png)

##### 2.2.2 WordCount với Spark chạy trên YARN

- Tạo file cho input của bài toán và đẩy lên hdfs

```cmd
$ nano WordCountSpark.txt
# Nhập nội dung file
$ hdfs dfs -copyFromLocal WordCountSpark.txt /input_spark
```

- Kiểm tra file trên hdfs:

![img](https://i.imgur.com/fs0YNYR.png)

- Chạy spark: 

```cmd
$ spark-shell --master yarn --deploy-mode client
```

- Chạy WordCount

```scala
val textFile = sc.textFile("hdfs://node-master:9000/input_spark/WordCountSpark.txt")
val counts = textFile.flatMap(line => line.split(" "))
                 .map(word => (word, 1))
                 .reduceByKey(_ + _)
counts.saveAsTextFile("hdfs://node-master:9000/output_spark/WCResultYarn")
```

- Kiểm tra kết quả

![img](https://i.imgur.com/eJeJnUg.png)

![img](https://i.imgur.com/sDEKEng.png)

![img](https://i.imgur.com/4aLiid1.png)



##### 2.2.3 Sinh file parquet trên hệ thống hdfs đã cài đặt: khoảng 1 triệu bản ghi gồm các cột: Tên, ngày sinh, địa chỉ (địa chỉ random từ 1-100), giới tính, số điện thoại.

- Cài đặt pyspark, faker

- File generate_parquet.py:

```python
from pyspark.sql import SparkSession
from pyspark.sql import Row
from faker import Faker
import random


spark = SparkSession.builder.appName("generate_parquet").getOrCreate()

fake = Faker()
data = []

for _ in range(1000000):
    data.append(Row(name=fake.name(), birthdate=fake.date_of_birth(), address=random.randint(1, 100),
                    gender=random.choice(["Male", "Female"]), phone=fake.phone_number()))


df = spark.createDataFrame(data)

df.write.parquet("hdfs://node-master:9000/input_parquet/newdata.parquet")
```

- Kiểm tra dữ liệu được sinh trên hdfs (Đường dẫn /input_parquet/newdata.parquet):

![img](https://i.imgur.com/bzTC8rF.png)



##### 2.2.4 Chạy jupyter notebook

- Cài đặt Scala:

```cmd
curl -fL https://github.com/coursier/coursier/releases/latest/download/cs-x86_64-pc-linux.gz | gzip -d > cs && chmod +x cs && ./cs setup
```

- Chạy jupyter notebook:

```cmd
jupyter notebook --ip 0.0.0.0 --port 8888 --no-browser --allow-root
```

- Kiểm tra tại http://node-master:8888/tree:

![img](https://i.imgur.com/fZAWMoN.png)



##### 2.2.5 Sử dụng Pyspark để đọc file

- Đọc file paquet (Hiển thị 10 bản ghi):

```python
from pyspark.sql import SparkSession

spark = SparkSession.builder.appName("read_parquet").getOrCreate()

df = spark.read.parquet("hdfs://node-master:9000/input_parquet/newdata.parquet")

df.printSchema()
df.show(10)
```

- Kiểm tra kết quả:

![img](https://i.imgur.com/7AKZDpY.png)



##### 2.2.6 Visualize thống kê lượng user theo tuổi (khoảng độ tuổi ví dụ từ 10-20, 20-30 tuổi,...), giới tính bằng biểu đồ 

- Cài đặt matplotlib để sử dụng các biểu đồ

- Code (Do docker không có UI, nên sẽ lưu thành file ảnh và mở bằng công cụ khác)

```python
from pyspark.sql import SparkSession
from pyspark.sql import functions as F

spark = SparkSession.builder.appName("read_parquet").getOrCreate()

df = spark.read.parquet("hdfs://node-master:9000/input_parquet/newdata.parquet")

df = df.withColumn("age", F.floor(F.datediff(F.current_date(), "birthdate") / 365.25))

result = df.groupBy("gender", F.expr("floor(age/10)*10").alias("age_group")).count()

result_pd = result.toPandas()

import matplotlib.pyplot as plt

result_pd.pivot(index='age_group', columns='gender', values='count').plot(kind='bar', stacked=True)

plt.title('User and gender')

plt.xlabel('Age')

plt.ylabel('Count')

plt.savefig('bar_chart.png')
```



- Kiểm tra kết quả:
- Chuyển file ảnh từ docker sang máy có UI:

![img](https://i.imgur.com/6S6aJor.png)

- Kiểm tra trên jupyter notebook:

![img](https://i.imgur.com/DFLqXq6.png)



##### 2.2.6 Chuyển các code pyspark về code java và submit với spark chạy trên yarn

- Chuyển code đọc file parquet sang java và submit:                                                                                   

```java
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class ReadParquetApp {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .appName("java_read_parquet")
                .getOrCreate();

        Dataset<Row> df = spark.read().parquet("hdfs://node-master:9000/input_parquet/newdata.parquet");
    
        System.out.println("Schema:");
        df.printSchema();
    
        System.out.println("First 10 rows:");
        df.show(10);
    
        spark.stop();
    }
}
```

- Compile và chuyển thành file jar:

```cmd
javac -cp "/lib/spark/jars/*" ReadParquetApp.java
jar cf ReadParquetApp.jar ReadParquetApp*.class
```

- Submit code lên spark chạy trên yarn 

```cmd
spark-submit --class ReadParquetApp --master yarn --deploy-mode client ReadParquetApp.jar
```

- Kết quả (in ra schema của dữ liệu và 10 bản ghi đầu)

![img](https://i.imgur.com/zLM3Tvu.png)

- Mã nguồn 

```java
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.expressions.Window;
import org.apache.spark.sql.functions;

import static org.apache.spark.sql.functions.col;

public class AgeGroupStatisticsApp {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .appName("age_group_statistics")
                .getOrCreate();

        Dataset<Row> df = spark.read().parquet("hdfs://node-master:9000/input_parquet/newdata.parquet");
    
        df = df.withColumn("age", functions.expr("floor(datediff(current_date(), birthdate) / 365.25)"))
                .withColumn("age_group", functions.floor(col("age").divide(10)).multiply(10));
    
        Dataset<Row> result = df.groupBy("gender", "age_group").count();
    
        result.show(Integer.MAX_VALUE, false);
    
        spark.stop();
    }

}
```

- Compile code và chuyển sang file jar:

```cmd
javac -cp "/lib/spark/jars/*" AgeGroupStatisticsApp.java
jar cf AgeGroupStatisticsApp.jar AgeGroupStatisticsApp.class
```

- Submit lên spark chạy trên yarn:

>     ```cmd
>     spark-submit --class AgeGroupStatisticsApp \
>     >     --master yarn \
>     >     --deploy-mode client \
>     >     --num-executors 2 \
>     >     --executor-memory 2g \
>     >     --executor-cores 2 \
>     >     AgeGroupStatisticsApp.jar
>     ```

- Kết quả:

![img](https://i.imgur.com/tKQWx2y.png)