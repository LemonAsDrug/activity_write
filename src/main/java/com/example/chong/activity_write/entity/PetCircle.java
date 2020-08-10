package com.example.chong.activity_write.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 宠圈帖子表
 * </p>
 *
 * @author wucunyang
 * @since 2020-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PetCircle extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 内容
     */
    private String detail;

    /**
     * 浏览量
     */
    private Long browseNum;

    /**
     * 评论量
     */
    private Long commentNum;

    /**
     * 点赞量
     */
    private Long praiseNum;

    /**
     * 用户id
     */
    private Long userId;

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
     * 热度
     */
    private Double hot;

    /**
     * 文章独有
     */
    private String title;

    /**
     * 封面
     */
    private String cover;

    /**
     * 类型0动态1文章
     */
    private Integer type;

    /**
     * 位置
     */
    private String address;

    /**
     * 1 活动
     */
    private Integer bizType;

    /**
     * 业务id
     */
    private Long bizId;

    /**
     * 是否精选 0 否 1 是
     */
    private Integer chosen;


}
