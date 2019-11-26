### 1、多数据源逆向工程
1) 在generator-sc/sb中添加要生成的表名
2) 将pom文件逆向工程的插件对应的数据源移至最后(configurationFile),点击生成代码

### 2、jvm调优
1) -XX:MetaspaceSize=128m  -XX:MaxMetaspaceSize=128m  -Xms1024m -Xmx1024m -Xmn256m  -Xss256k -XX:SurvivorRatio=8 -XX:+UseConcMarkSweepGC