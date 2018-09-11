
# 基本配置说明

## redis

#### 基本命令

    auth password  登录

#### 基本说明

文件目录

    /opt/redis-4.0.11/redis.conf
    /opt/redis-4.0.11/redis.log
    /opt/redis-4.0.11/data
    
端口

    6379
    
#### redis压力测试

100个并发连接,100000个请求

    redis-benchmark -h 127.0.0.1 -p 6379 -c 100 -n 100000
   
存取大小为１００字节的数据包

    redis-benchmark -h 127.0.0.1 -p 6379 -q -d 100
    
只测试某些操作的性能

    redis-benchmark -t set,lpush -n 100000 -q
    
只测试某些数值存取的性能

    redis-benchmark -n 100000 -q script load "redis.call('set','foo','bar')"
    
    
## SpringBoot打ｗａｒ包

    1) 添加依赖、plugin，修改打包方式为war
    2）启动类继承类SpringBootServletInitializer，重写configure方法
    ３）进入project目录，　mvn clean package
    

