package com.example.residentialhostel.pojo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 房子信息表
 * @TableName house_information
 */
@TableName(value ="house_information")
@Data
public class HouseInformation implements Serializable {
    /**
     * 房源信息id
     */
    @TableId
    private Integer houseInformationId;

    /**
     * 房源名称
     */
    private String houseName;

    /**
     * 房源类型
     */
    private String houseType;

    /**
     * 房源地址
     */
    private String houseAddress;

    /**
     * 房主id
     */
    private Integer ownerId;

    /**
     * 房主姓名
     */
    private String ownerName;

    /**
     * 单日价钱
     */
    private Integer oneDayPrice;

    /**
     * 押金
     */
    private Integer deposit;

    /**
     * 房源封面
     */
    private String houseCover;

    /**
     * 房主电话
     */
    private String homeownerTelephone;

    /**
     * 房源城市
     */
    private String houseCity;

    /**
     * 配套设施
     */
    private String supportingFacilities;

    /**
     * 房源介绍
     */
    private String houseIntroduction;

    /**
     * 租借日期的编码
     */
    private String leaseDate;

    /**
     * 点击数
     */
    private Integer hits;

    /**
     * 是否推荐
     */
    private Integer recommend;

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