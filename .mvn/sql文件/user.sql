-- auto-generated definition
create table user
(
    user_id       int auto_increment comment '用户id'
        primary key,
    phone_number  varchar(64)                           not null comment '使用用户电话进行注册登录（暂时先这么设计）',
    password      varchar(255)                          not null comment '用户密码(应进行加密存储，不允许明文存储)',
    user_name     varchar(64)                           null comment '用户姓名',
    user_gender   varchar(64)                           null comment '用户性别',
    user_number   varchar(64)                           not null comment '用户编号',
    user_age      varchar(64)                           null comment '用户年龄',
    examine_state varchar(16) default '0'               not null comment '审核状态,0未审核，1已审核',
    user_type     int                                   not null comment '用户类型，100代表管理员，001代表租客，010代表房东',
    create_time   datetime    default CURRENT_TIMESTAMP null comment '创建时间',
    update_time   datetime    default CURRENT_TIMESTAMP null comment '更新时间',
    isDelete      int         default 0                 not null comment '逻辑删除字段，0代表未删除，1代表已删除',
    constraint user_phoneNumber_uindex
        unique (phone_number)
)
    comment '用户';
