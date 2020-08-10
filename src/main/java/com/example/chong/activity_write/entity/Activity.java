package com.example.chong.activity_write.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 活动表
 * </p>
 *
 * @author wucunyang
 * @since 2020-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Activity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
    private String title;

    /**
     * 详情
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
     * 摘要
     */
    private String brief;

    /**
     * 发布状态 0待发布 1已发布
     */
    private Integer publishStatus;

    /**
     * 活动状态 活动状态 1 未开始 2 已取消 3 进行中 4 已中止 5 已结束 
     */
    private Integer activityStatus;

    /**
     * 封面
     */
    private String cover;

    /**
     * 类型 1 线上 2 线下
     */
    private Integer activityOption;

    /**
     * 开始时间
     */
    private Long startTime;

    /**
     * 结束时间
     */
    private Long endTime;

    /**
     * 活动报名开始时间
     */
    private Long applyStartTime;

    /**
     * 活动报名结束时间
     */
    private Long applyEndTime;

    /**
     * 活动报名人数上限
     */
    private Integer maxNumPeople;

    /**
     * 跳转路由
     */
    private String activityUrl;

    /**
     * 详情图片
     */
    private String detailPic;

    /**
     * 活动类型 1 普通 2 pk 3 多选投票
     */
    private Integer activityType;

    /**
     * 投票话题描述
     */
    private String voteName;


}
