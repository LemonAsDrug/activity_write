package com.example.chong.activity_write.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.chong.activity_write.entity.Activity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 活动表 Mapper 接口
 * </p>
 * @Mapper实际也是把当前接口注入了spring容器
 * @author wucunyang
 * @since 2020-06-28
 */
@Mapper
public interface ActivityMapper extends BaseMapper<Activity> {


}
