-- auto-generated definition
create table booking_information
(
    book_information_id int                                   not null comment '预订信息的id'
        primary key,
    house_name          varchar(64)                           null comment '房子名称',
    house_type          varchar(64)                           null comment '房子类型',
    one_day_price       int                                   null comment '单日价钱，与house_information表中的单日价格相关联',
    deposit             int                                   null comment '押金，与house_information表中的押金相关联',
    user_id             int                                   null comment '租客的id',
    user_name           varchar(64)                           null comment '租客姓名',
    user_telephone      varchar(64)                           null comment '租客电话号码',
    start_date          date                                  not null comment '预订起始日期',
    ending_days         date                                  not null comment '预订结束日期',
    total_price         varchar(64)                           null comment '总价',
    pay_state           varchar(16) default '0'               not null comment '支付状态，0代表未支付，1代表已支付',
    create_time         datetime    default CURRENT_TIMESTAMP null comment '创建时间',
    update_time         datetime    default CURRENT_TIMESTAMP null comment '上一次更新时间',
    isDelete            int         default 0                 null comment '逻辑删除字段，0代表未删除，1代表已删除 租客退订将该字段设置为1即可视为删除，同时也保留了订单信息与不必单独开一个退订表'
)
    comment '预订信息表';

