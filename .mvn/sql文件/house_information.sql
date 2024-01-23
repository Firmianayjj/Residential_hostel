-- auto-generated definition
create table house_information
(
    house_information_id  int                                    not null comment '房源信息id'
        primary key,
    house_name            varchar(64)                            null comment '房源名称',
    house_type            varchar(64)                            null comment '房源类型',
    house_address         varchar(64)                            null comment '房源地址',
    owner_id              int                                    not null comment '房主id',
    owner_name            varchar(64)                            null comment '房主姓名',
    one_day_price         int                                    not null comment '单日价钱',
    deposit               int                                    not null comment '押金',
    house_cover           varchar(255)                           null comment '房源封面',
    homeowner_telephone   varchar(64)                            null comment '房主电话',
    house_city            varchar(64)                            null comment '房源城市',
    supporting_facilities text                                   null comment '配套设施',
    house_introduction    varchar(255)                           null comment '房源介绍',
    lease_date            varchar(64) default '0000000000000000' not null comment '租借日期的编码',
    hits                  int         default 0                  not null comment '点击数',
    recommend             int                                    not null comment '是否推荐',
    create_time           datetime    default CURRENT_TIMESTAMP  null comment '创建时间',
    update_time           datetime    default CURRENT_TIMESTAMP  null comment '更新时间',
    isDelete              int         default 0                  not null comment '逻辑删除字段，0代表未删除，1代表已删除'
)
    comment '房子信息表';
