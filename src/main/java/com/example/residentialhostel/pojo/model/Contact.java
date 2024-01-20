package com.example.residentialhostel.pojo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 租客与房主之间联系表
 * @TableName contact
 */
@TableName(value ="contact")
@Data
public class Contact implements Serializable {
    /**
     * 联系消息的主键id
     */
    @TableId
    private Integer contactId;

    /**
     * 主动发起联系人的联系电话
     */
    private Integer activeUserTelephone;

    /**
     * 主动发起联系人的姓名
     */
    private String activeUserName;

    /**
     * 主动发起联系人的id
     */
    private Integer activeUserId;

    /**
     * 被动联系的联系人编号id
     */
    private Integer passiveUserId;

    /**
     * 被动联系的联系人名称
     */
    private String passiveUserName;

    /**
     * 被动联系的联系人电话
     */
    private Integer passiveUserTelephone;

    /**
     * 联系内容
     */
    private String contactContent;

    /**
     * 回复内容
     */
    private String reply;

    /**
     * 上一次发起联系的时间
     */
    private Date lastContactTime;

    /**
     * 上一次回复的时间
     */
    private Date lastReplyTime;

    /**
     * 逻辑删除字段，0代表未删除，1代表已删除
     */
    private Integer isdelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}