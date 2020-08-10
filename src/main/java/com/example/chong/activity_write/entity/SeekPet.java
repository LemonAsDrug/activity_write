package com.example.chong.activity_write.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * <p>
 * 寻宠表
 * </p>
 *
 * @author wucunyang
 * @since 2020-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SeekPet extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 内容详情
     */
    private String detail;

    /**
     * 浏览量
     */
    private Integer browseNum;

    /**
     * 评论量
     */
    private Integer commentNum;

    /**
     * 悬赏金额
     */
    private BigDecimal money;

    /**
     * 领赏用户id
     */
    private Long moneyUserId;

    /**
     * 领赏时间
     */
    private Long moneyTime;

    /**
     * 关联品种id
     */
    private Long varietyId;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 丢失时间
     */
    private Long loseTime;

    /**
     * 丢失地点
     */
    private String loseAdd;

    /**
     * 丢失地点经度
     */
    private BigDecimal lon;

    /**
     * 丢失地点维度
     */
    private BigDecimal lat;

    /**
     * 关联用户id
     */
    private Long userId;

    /**
     * 寻找状态 1进行中 3已找到未确认 5 已找到已确认
     */
    private Integer seekStatus;

    /**
     * 所属省
     */
    private Long province;

    /**
     * 所属市
     */
    private Long city;

    /**
     * 所属区
     */
    private Long district;

    /**
     * 城市id
     */
    private Long cityId;

    /**
     * 是否支付0未支付，1已支付，2免费帖子
     */
    private Integer isPay;


}
