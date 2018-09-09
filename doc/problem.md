# Problem

开发过程中遇到的一些坑点、问题

一、Ubuntu登录不上MySQL

    http://blog.51cto.com/alsww/1121676
    
    http://www.bbtang.info/database/mysql/267.html
    

二、Redis set方法出错

    报错：MISCONF Redis is configured to save RDB snapshots, but is currently not able to persist o
  
    127.0.0.1:6379> config set stop-writes-on-bgsave-error no

