package com.example.chong.activity_write.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wucunyang
 * @since 2020-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PetCircleComment extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 评论内容
     */
    private String comment;

    /**
     * 点赞量
     */
    private Integer praiseNum;

    /**
     * 评论级别
     */
    private Integer level;

    /**
     * 上级id
     */
    private Long pid;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 宠圈贴id
     */
    private Long petCircleId;


}
