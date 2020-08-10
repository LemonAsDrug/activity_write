package com.example.chong.activity_write.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

@Data
public class ActivityDto {

    protected Long id;

    protected Byte status;

    protected Long createTime;

    private String title;

    private String detail;

    private Integer browseNum;

    private Integer commentNum;

    private String brief;

    private Integer publishStatus;

    private Integer activityStatus;

    private String cover;

    private Integer activityOption;

    private Long startTime;

    private Long endTime;

    private Long applyStartTime;

    private Long applyEndTime;

    private Integer maxNumPeople;

    private String activityUrl;

    private String detailPic;

    private Integer activityType;

    private String voteName;

    /**
     * 另外增加的字段
     *
     * 线下活动报名
     */


}
