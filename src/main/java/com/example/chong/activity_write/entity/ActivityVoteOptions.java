package com.example.chong.activity_write.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 投票选项表
 * </p>
 *
 * @author wucunyang
 * @since 2020-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ActivityVoteOptions extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 选择数量
     */
    private Integer selectNum;

    /**
     * 名称
     */
    private String name;

    /**
     * 活动id
     */
    private Long activityId;


}
