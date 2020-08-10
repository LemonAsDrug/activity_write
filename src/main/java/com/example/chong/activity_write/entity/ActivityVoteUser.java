package com.example.chong.activity_write.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 活动投票用户
 * </p>
 *
 * @author wucunyang
 * @since 2020-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ActivityVoteUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 投票选项id
     */
    private Long voteOptionsId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 活动id
     */
    private Long activityId;


}
