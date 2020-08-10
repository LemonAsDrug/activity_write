package com.example.chong.activity_write.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.chong.activity_write.entity.PetCircleComment;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wucunyang
 * @since 2020-06-28
 */
public interface IPetCircleCommentService extends IService<PetCircleComment> {

    Page<PetCircleComment> getPetCircleComService(Integer pageNo, Integer pageSize) throws NullPointerException;

}
