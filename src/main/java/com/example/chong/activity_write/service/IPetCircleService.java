package com.example.chong.activity_write.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.chong.activity_write.entity.PetCircle;

/**
 * <p>
 * 宠圈帖子表 服务类
 * </p>
 *
 * @author wucunyang
 * @since 2020-06-28
 */
public interface   IPetCircleService extends IService<PetCircle> {

    Integer setChosen(Long activityId,Long petCircleId) throws NullPointerException;

    Page<PetCircle> getPetCircleList(Integer pageNo, Integer pageSize, Long activityId) throws NullPointerException;

    /**
     * 测试aop
     * @return
     */
    Page<PetCircle> getPetCirclrList(Integer pageNo,Integer pageSize) throws NullPointerException;

}
