package com.example.residentialhostel.pojo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 预订信息表
 * @TableName booking_information
 */
@TableName(value ="booking_information")
@Data
public class BookingInformation implements Serializable {
    /**
     * 预订信息的id
     */
    @TableId
    private Integer bookInformationId;

    /**
     * 房子名称
     */
    private String houseName;

    /**
     * 房子类型
     */
    private String houseType;

    /**
     * 单日价钱，与house_information表中的单日价格相关联
     */
    private Integer oneDayPrice;

    /**
     * 押金，与house_information表中的押金相关联
     */
    private Integer deposit;

    /**
     * 租客的id
     */
    private Integer userId;

    /**
     * 租客姓名
     */
    private String userName;

    /**
     * 租客电话号码
     */
    private String userTelephone;

    /**
     * 预订起始日期
     */
    private Date startDate;

    /**
     * 预订结束日期
     */
    private Date endingDays;

    /**
     * 总价
     */
    private String totalPrice;

    /**
     * 支付状态，0代表未支付，1代表已支付
     */
    private String payState;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 上一次更新时间
     */
    private Date updateTime;

    /**
     * 逻辑删除字段，0代表未删除，1代表已删除 租客退订将该字段设置为1即可视为删除，同时也保留了订单信息与不必单独开一个退订表
     */
    private Integer isdelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}