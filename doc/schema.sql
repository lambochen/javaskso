
-- 创建用户表
create table user(
id bigint(20) not null comment '用户ID，手机号码',
nickname varchar(255) not null ,
password varchar(32) default null comment 'MD5(MD5(pass明文+固定salt)+salt)',
salt varchar(10) default null ,
head varchar(128) default null comment '头像，云存储的ID',
register_date datetime default null comment '注册时间',
last_login_date datetime default null comment '上次登录时间',
login_count int default '0' comment '登录次数',
primary key (`id`)
)engine=InnoDB default charset=utf8mb4;

-- 插入一条测试数据
insert into user(id,nickname,password,salt,head,register_date,last_login_date,login_count)
  values (1,'test','70754ec9cb2c80237f3ce6c2f59b31d9','abcd',null,null,null,1);

