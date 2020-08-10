package com.example.chong.activity_write.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.chong.activity_write.entity.Activity;

/**
 * <p>
 * 活动表 服务类
 * </p>
 *
 * @author wucunyang
 * @since 2020-06-28
 */
public interface IActivityService extends IService<Activity> {

    /**
     * 可以声明方法将抛出异常，实际上却不抛出
     * 这样做的好处是，为异常先占个位子
     * @param pageNo
     * @param pageSize
     * @return
     * @throws NullPointerException
     */
    Page<Activity> getActivityPage(Integer pageNo, Integer pageSize) throws NullPointerException;

    Page<Activity> TestBaseMapperPage(Integer pageNo,Integer pageSize);

}
