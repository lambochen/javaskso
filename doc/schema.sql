
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


-- 商品表
create table goods(
id bigint not null auto_increment comment '商品ID',
goods_name varchar(16) default null comment '商品名称',
goods_title varchar(64) default null comment '商品标题',
goods_img varchar(64) default null comment '商品的图片',
goods_detail longtext comment '商品的详细介绍',
goods_price decimal(10,2) default '0.00' comment '商品单价',
goods_stock int default '0' comment '商品库存，-1表示没有限制',
primary key (`id`)
) engine=InnoDB auto_increment=3 default charset=utf8mb4;

-- 插入商品数据
insert into goods(goods_name,goods_title,goods_detail,goods_price,goods_stock)
  values('test','test_title','test_detail',123,123);

-- 秒杀商品表
create table seckill_goods(
id bigint not null auto_increment comment '秒杀的商品表',
goods_id bigint default null comment '商品ID',
seckill_price decimal(10,2) default '0.00' comment '秒杀价',
stock_count int default null comment '库存数量',
start_date datetime default null comment '秒杀开始时间',
end_date datetime default null comment '秒杀结束时间',
primary key (`id`)
) engine=InnoDB auto_increment=3 default charset=utf8mb4;

-- 插入秒杀商品表数据
insert into seckill_goods(goods_id,seckill_price,stock_count,start_date,end_date)
  values(3,22,100,'2018-09-12 00:00:00','2018-09-13 00:00:00');

-- 订单表
create table order_info(
id bigint(20) not null auto_increment,
user_id bigint(20) default null comment '用户ID',
goods_id bigint(20) default null comment '商品ID',
delivery_addr_id bigint(20) default null comment '收货地址ID',
goods_name varchar(16) default null comment '冗余过来的商品名称',
goods_count int default '0' comment '商品数量',
goods_price decimal(10,2) default '0.00' comment '商品单价',
order_channel tinyint(4) default '0' comment '1:pc 2:android 3:ios',
status tinyint(4) default '0' comment '订单状态，0：新建未支付 1：已支付 2：已发货 3：已收货 4：已退款 5：已完成',
create_date datetime default null comment '订单的创建时间',
pay_date datetime default null comment '支付时间',
primary key (`id`)
)engine=InnoDB auto_increment=12 default charset=utf8mb4;

-- 秒杀订单表
create table seckill_order(
id bigint(20) not null auto_increment,
user_id bigint(20) default null comment '用户ＩＤ',
order_id bigint(20) default null comment '订单ＩＤ',
goods_id bigint(20) default null comment '商品ＩＤ',
primary key (`id`)
)engine=InnoDB auto_increment=3 default charset=utf8mb4;

