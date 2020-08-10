package com.example.chong.activity_write.service.impl;

import com.example.chong.activity_write.entity.ActivityVoteUser;
import com.example.chong.activity_write.mapper.ActivityVoteUserMapper;
import com.example.chong.activity_write.service.IActivityVoteUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 活动投票用户 服务实现类
 * </p>
 *
 * @author wucunyang
 * @since 2020-06-28
 */
@Service
public class ActivityVoteUserServiceImpl extends ServiceImpl<ActivityVoteUserMapper, ActivityVoteUser> implements IActivityVoteUserService {

}
