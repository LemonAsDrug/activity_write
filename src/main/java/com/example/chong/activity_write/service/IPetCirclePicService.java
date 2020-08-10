package com.example.chong.activity_write.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.chong.activity_write.entity.PetCirclePic;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wucunyang
 * @since 2020-06-28
 */
public interface IPetCirclePicService extends IService<PetCirclePic> {

    /**
     * 测试aop
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page<PetCirclePic> getPetCirclePicList(Integer pageNo,Integer pageSize) throws NullPointerException;

}
