package com.example.chong.activity_write.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 寄养表
 * </p>
 *
 * @author wucunyang
 * @since 2020-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PetFoster extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 宠物名称
     */
    private String petName;

    /**
     * 品种id
     */
    private Long varietyId;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 体重
     */
    private Integer weight;

    /**
     * 绝育情况  0未绝育 1已绝育 2不详
     */
    private Integer sterilizationStatus;

    /**
     * 免疫情况  0未免疫 1已免疫 2不详
     */
    private Integer immuneStatus;

    /**
     * 体内驱虫情况 0未驱虫 1已驱虫 2不详
     */
    @TableField("Insect_repellent_status")
    private Integer insectRepellentStatus;

    /**
     * 联合疫苗情况 0未注射 1已注射 2不详
     */
    private Integer combinedVaccineStatus;

    /**
     * 狂犬疫苗情况 0未注射 1已注射 2不详
     */
    private Integer rabiesVaccineStatus;

    /**
     * 关联寄养总表
     */
    private Long petFosterMainId;

    /**
     * 用户id
     */
    private Long userId;


}
