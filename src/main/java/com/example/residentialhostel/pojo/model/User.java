package com.example.residentialhostel.pojo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 用户id
     */
    @TableId
    private Integer userId;

    /**
     * 使用用户电话进行注册登录（暂时先这么设计）
     */
    private String phoneNumber;

    /**
     * 用户密码(应进行加密存储，不允许明文存储)
     */
    private String password;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户性别
     */
    private String userGender;

    /**
     * 用户编号
     */
    private String userNumber;

    /**
     * 用户年龄
     */
    private String userAge;

    /**
     * 审核状态,0未审核，1已审核
     */
    private String examineState;

    /**
     * 用户类型，100代表管理员，001代表租客，010代表房东
     */
    private Integer userType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 逻辑删除字段，0代表未删除，1代表已删除
     */
    private Integer isdelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}