package com.example.chong.activity_write.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.chong.activity_write.entity.Activity;
import com.example.chong.activity_write.mapper.ActivityMapper;
import com.example.chong.activity_write.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 活动表 服务实现类
 * </p>
 *
 * @author wucunyang
 * @since 2020-06-28
 */
@Service
//@SuppressWarnings("all")
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements IActivityService {

    @Autowired
    ActivityMapper activityMapper;

    @Override
    public Page<Activity> getActivityPage(Integer pageNo, Integer pageSize) {
        Page<Activity> activityPage = activityMapper.selectPage(new Page<>(pageNo, pageSize), null);
        return activityPage;
    }

    @Override
    public Page<Activity> TestBaseMapperPage(Integer pageNo, Integer pageSize) {
        QueryWrapper<Activity> aqw = new QueryWrapper<>();
        aqw.gt("id",95);
        Page<Activity> activityPage = activityMapper.selectPage(new Page<>(pageNo, pageSize), aqw);
        return activityPage;
    }

}
