-- auto-generated definition
create table contact
(
    contact_id             int                                not null comment '联系消息的主键id'
        primary key,
    active_user_telephone  int                                null comment '主动发起联系人的联系电话',
    active_user_name       varchar(64)                        not null comment '主动发起联系人的姓名',
    active_user_id         int                                not null comment '主动发起联系人的id',
    passive_user_id        int                                not null comment '被动联系的联系人编号id',
    passive_user_name      varchar(64)                        not null comment '被动联系的联系人名称',
    passive_user_telephone int                                null comment '被动联系的联系人电话',
    contact_content        text                               null comment '联系内容',
    reply                  text                               null comment '回复内容',
    last_contact_time      datetime default CURRENT_TIMESTAMP null comment '上一次发起联系的时间',
    last_reply_time        datetime default CURRENT_TIMESTAMP null comment '上一次回复的时间',
    isDelete               int      default 0                 not null comment '逻辑删除字段，0代表未删除，1代表已删除'
)
    comment '租客与房主之间联系表';

