package com.example.chong.activity_write.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.chong.activity_write.entity.Activity;
import com.example.chong.activity_write.entity.ActivityVoteOptions;
import com.example.chong.activity_write.entity.PageDto;
import com.example.chong.activity_write.enums.ActivityStaticKey;
import com.example.chong.activity_write.service.IActivityService;
import com.example.chong.activity_write.service.IActivityVoteOptionsService;
import com.example.chong.activity_write.service.IPetCircleService;
import com.example.chong.activity_write.utils.P;
import com.example.chong.activity_write.utils.R;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 活动表 前端控制器
 * </p>
 *
 * @author wucunyang
 * @since 2020-06-28
 */

@RestController
@RequestMapping("/sys/activity")
public class ActivityController {

    @Autowired
    IActivityService activityService;

    @Autowired
    IActivityVoteOptionsService activityVoteOptionsService;

    @Autowired
    IPetCircleService petCircleService;




    /**
     * 发布活动、线上线下
     * @param p
     * @return
     */
    @PostMapping("/web/saveActivity")
    public R saveActivity(@RequestBody P p){
        p.check("activityOption","startTime","endTime","title","brief","cover","detail");
        Integer activityOption = p.getInt("activityOption");
        Long startTime = p.getLong("startTime");
        Long endTime = p.getLong("endTime");
        //标题
        String title = p.getStr("title");
        //简介
        String brief = p.getStr("brief");
        //封面
        String cover = p.getStr("cover");
        //详情
        String detail = p.getStr("detail");

        //选填
        String detailPic = p.getStr("detailPic");

        //如果是线上活动
        //1普通2pk投票3多个选项投票
        Integer activityType = p.getInt("activityType");
        String voteName = p.getStr("voteName");
        List<String> pointList = p.getArr("pointList", String.class);
        //如果是线下活动
        Long applyStartTime = p.getLong("applyStartTime");
        Long applyEndTime = p.getLong("applyEndTime");
        Integer maxNumPeople = p.getInt("maxNumPeople");
        String activityUrl = p.getStr("activityUrl");

        Activity activity = new Activity();
        activity.setTitle(title);
        activity.setStartTime(startTime);
        activity.setEndTime(endTime);
        activity.setTitle(title);
        activity.setBrief(brief);
        activity.setCover(cover);
        activity.setDetail(detail);
        if (!detailPic.isEmpty()){
            activity.setDetailPic(detailPic);
        }
        activityService.save(activity);
        if (activityOption.equals(ActivityStaticKey.ACTIVITY_ON_LINE)){
            activity.setActivityType(activityType);
            activity.setVoteName(voteName);
            for (String point : pointList) {
                ActivityVoteOptions avo = new ActivityVoteOptions();
                avo.setActivityId(activity.getId());
                avo.setName(point);
                activityVoteOptionsService.save(avo);
            }
            activityService.updateById(activity);
        }else if (activityOption.equals(ActivityStaticKey.ACTIVITY_OFF_LINE)){
            activity.setApplyStartTime(applyStartTime);
            activity.setApplyEndTime(applyEndTime);
            activity.setMaxNumPeople(maxNumPeople);
            activity.setActivityUrl(activityUrl);
            activityService.updateById(activity);
        }else {
            R.error("活动状态值错误");
        }
        return R.ok();
    }

    /**
     * 修改活动
     * @param p
     * @return
     */
    @RequestMapping("/web/updateActivity")
    public R updateActivity(@RequestBody P p){
        return R.ok();
    }


    /**
     * 活动详情
     * @param p
     * @return
     */
    @RequestMapping("/web/getActivityInfo")
    public R getActivityInfo(@RequestBody P p){
        p.check("activityId");
        Long activityId = p.getLong("activityId");
        HashMap<String, Object> data = new HashMap<>();
        Activity activity = activityService.getById(activityId);
        return R.ok(activity);
    }


    /**
     * 后台获取活动列表
     * @param p
     * @return
     */
    @RequestMapping("/web/getActivityList")
    public R getActivityList(@RequestBody P p){
        p.check("pageNo","pageSize");
        Integer pageNo = p.getInt("pageNo");
        Integer pageSize = p.getInt("pageSize");
        Page<Activity> activityPage = null;
        try {
            activityPage = activityService.getActivityPage(pageNo, pageSize);
        }catch (NullPointerException e){
            e = new NullPointerException("空指针异常");
            e.printStackTrace(System.out);
        } catch(Exception e){
            //异常的错误信息可以保存在异常对象内部或者用异常类的名称来暗示
            e = new Exception("抓到一个异常");//异常的错误信息可以保存在异常对象内部
            e.printStackTrace(System.out);
        }
        HashMap<String, Object> data = new HashMap<>();
        PageDto pageDto = new PageDto();
        BeanUtils.copyProperties(activityPage,pageDto);
        List<Activity> activityList = activityPage.getRecords();
        data.put("page",pageDto);
        data.put("activityList",activityList);
        return R.ok(data);
    }


    /**
     * 测试IService接口的分页方法
     * @param p
     * @return
     */
    @PostMapping("/test/testPage1")
    public R testPage1(@RequestBody P p){
        p.check("pageNo","pageSize");
        Integer pageNo = p.getInt("pageNo");
        Integer pageSize = p.getInt("pageSize");
        QueryWrapper<Activity> aqw = new QueryWrapper<>();
        aqw.gt("id",95);
        Page<Activity> page = activityService.page(new Page<>(pageNo, pageSize), aqw);
        HashMap<String, Object> data = new HashMap<>();
        PageDto pageDto = new PageDto();
        BeanUtils.copyProperties(page,pageDto);
        data.put("activityList",page.getRecords());
        data.put("page",pageDto);
        return R.ok(data);
    }

    /**
     * 测试BaseMapper接口
     * @param p
     * @return
     */
    @PostMapping("/test/testPage2")
    public R testPage2(@RequestBody P p){
        p.check("pageNo","pageSize");
        Integer pageNo = p.getInt("pageNo");
        Integer pageSize = p.getInt("pageSize");
        Page<Activity> activityPage = activityService.TestBaseMapperPage(pageNo, pageSize);
        HashMap<String, Object> data = new HashMap<>();
        PageDto pageDto = new PageDto();
        BeanUtils.copyProperties(activityPage,pageDto);
        data.put("activityList",activityPage.getRecords());
        data.put("page",pageDto);
        return R.ok(data);
    }







}
