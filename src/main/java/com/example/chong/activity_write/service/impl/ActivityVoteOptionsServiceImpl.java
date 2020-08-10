package com.example.chong.activity_write.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.chong.activity_write.entity.ActivityVoteOptions;
import com.example.chong.activity_write.mapper.ActivityVoteOptionsMapper;
import com.example.chong.activity_write.service.IActivityVoteOptionsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 投票选项表 服务实现类
 * </p>
 *
 * @author wucunyang
 * @since 2020-06-28
 */
@Service
public class ActivityVoteOptionsServiceImpl extends ServiceImpl<ActivityVoteOptionsMapper, ActivityVoteOptions> implements IActivityVoteOptionsService {

}
