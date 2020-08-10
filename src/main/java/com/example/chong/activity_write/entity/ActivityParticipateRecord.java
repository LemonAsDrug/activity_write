package com.example.chong.activity_write.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 活动参与记录
 * </p>
 *
 * @author wucunyang
 * @since 2020-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ActivityParticipateRecord extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     *  类型 1 投票 2 发帖 3 评论
     */
    private Integer type;

    /**
     * 活动类型 线上 1 线下 2
     */
    private Integer activityType;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 人员数量
     */
    private Integer personnelNum;

    /**
     * 联系方式
     */
    private String userPhone;


}
