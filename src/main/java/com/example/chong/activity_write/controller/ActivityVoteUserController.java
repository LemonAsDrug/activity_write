package com.example.chong.activity_write.controller;

import com.example.chong.activity_write.entity.ActivityVoteUser;
import com.example.chong.activity_write.service.IActivityVoteUserService;
import com.example.chong.activity_write.utils.P;
import com.example.chong.activity_write.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 * 活动投票用户 前端控制器
 * </p>
 *
 * @author wucunyang
 * @since 2020-06-28
 */
@RestController
@RequestMapping("/sys/activityVoteUser")
public class ActivityVoteUserController {

    @Autowired
    IActivityVoteUserService activityVoteUserService;

    /**
     * 用户对线上活动，pk、多选类型投票。
     * @param p
     * @return
     */
    @PostMapping("/app/saveRecord")
    public R saveRecord(@RequestBody P p){
        //没有做认证
        Long userId = p.getLong("userId");
        Long activityId = p.getLong("activityId");
        Long voteOptionsId = p.getLong("voteOptionsId");
        ActivityVoteUser activityVoteUser = new ActivityVoteUser();
        activityVoteUser.setUserId(userId);
        activityVoteUser.setActivityId(activityId);
        activityVoteUser.setVoteOptionsId(voteOptionsId);
        activityVoteUserService.save(activityVoteUser);
        return R.ok();
    }


}
