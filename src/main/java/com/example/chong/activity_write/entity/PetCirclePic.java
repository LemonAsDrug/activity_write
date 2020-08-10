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
public class PetCirclePic extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 宠圈帖子id
     */
    private Long petCircleId;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 资源类型 0图片 1视频
     */
    private Integer type;

    /**
     * 用户id
     */
    private Long userId;


}
