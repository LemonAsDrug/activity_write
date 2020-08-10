package com.example.chong.activity_write.controller;


import com.example.chong.activity_write.entity.ActivityParticipateRecord;
import com.example.chong.activity_write.service.IActivityParticipateRecordService;
import com.example.chong.activity_write.utils.P;
import com.example.chong.activity_write.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 活动参与记录 前端控制器
 * </p>
 *
 * @author wucunyang
 * @since 2020-06-28
 */
@RestController
@RequestMapping("/sys/activityParticipateRecord")
public class ActivityParticipateRecordController {

    @Autowired
    IActivityParticipateRecordService aprService;

    /**
     * 用户报名参加线下活动
     *
     * 只有线下活动才能报名
     * @param p
     * @return
     */
    @PostMapping("/app/saveAPR")
    public R saveAPR(@RequestBody P p){
        p.check("userId","activityId","personnelNum","userPhone");
        Long userid = p.getLong("userId");
        Long activityId = p.getLong("activityId");
        Integer personnelNum = p.getInt("personnelNum");
        String userPhone = p.getStr("userPhone");
        ActivityParticipateRecord apr = new ActivityParticipateRecord();
        apr.setUserId(userid);
        apr.setActivityId(activityId);
        apr.setPersonnelNum(personnelNum);
        apr.setUserPhone(userPhone);
        boolean save = aprService.save(apr);
        return R.ok(save);
    }

}
