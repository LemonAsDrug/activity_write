package com.example.chong.activity_write.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.chong.activity_write.entity.PageDto;
import com.example.chong.activity_write.entity.PetCircle;
import com.example.chong.activity_write.enums.PetCircleStaticKey;
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
 * 宠圈帖子表 前端控制器
 * </p>
 *
 * @author wucunyang
 * @since 2020-06-28
 */
@RestController
@RequestMapping("/sys/petCircle")
public class PetCircleController {


    @Autowired
    IPetCircleService petCircleService;

    /**
     * 用户在活动下发帖
     * @param p
     * @return
     */
    @RequestMapping("/app/saveActivityRecord")
    public R saveActivityRecord(@RequestBody P p){
        p.check("detail","activityId");
        String detail = p.getStr("detail");
        Long activityId = p.getLong("activityId");
        PetCircle petCircle = new PetCircle();
        petCircle.setDetail(detail);
        petCircle.setBizId(activityId);
        //默认帖子非精选
        petCircle.setChosen(PetCircleStaticKey.NOT_CHOSEN);
        petCircleService.save(petCircle);
        return R.ok();
    }

    /**
     * 后台管理 活动详情 用户帖子列表
     */
    @PostMapping("/web/getPetCircleList")
    public R getPetCircleList(@RequestBody P p){
        p.check("activityId");
        Long activityId = p.getLong("activityId");
        Integer pageNo = p.getInt("pageNo");
        Integer pageSize = p.getInt("pageSize");
        Page<PetCircle> petCirclePage = petCircleService.getPetCircleList(pageNo, pageSize, activityId);
        HashMap<String, Object> data = new HashMap<>();
        PageDto pageDto = new PageDto();
        //宠家项目 mpboot启动器版本3.1.0，自己的版本3.3.2,版本更新，
        //不用在接口里写，返回IPage对象，再去BeansCopy.properties(Page<T> xxlist,pageDto)属性了。
        //Page<T> xxlist 可以直接BeanUtils.cop
        BeanUtils.copyProperties(petCirclePage,pageDto);
        List<PetCircle> records = petCirclePage.getRecords();
        data.put("page",pageDto);
        data.put("perCircleList",records);
        return R.ok(data);
    }

    /**
     * 后台管理 活动详情，用户帖子加精
     * @param p
     * @return
     */
    @RequestMapping("/web/setChosen")
    public R setChosen(@RequestBody P p){
        p.check("activityId","petCircleId");
        Long activityId = p.getLong("activityId");
        Long petCircleId = p.getLong("petCircleId");
        Integer integer = petCircleService.setChosen(activityId, petCircleId);
        return R.ok(integer);
    }

    @PostMapping("/app/testAop/getPetCircleLists")
    public R getPetCircleLists(@RequestBody P p){
        p.check("pageNo","pageSize");
        Integer pageNo = p.getInt("pageNo");
        Integer pageSize = p.getInt("pageSize");
        Page<PetCircle> petCirclePage= petCircleService.getPetCirclrList(pageNo, pageSize);
        List<PetCircle> petCirclrList = petCirclePage.getRecords();
        HashMap<String, Object> data = new HashMap<>();
        PageDto pageDto = new PageDto();
        BeanUtils.copyProperties(petCirclePage,pageDto);
        data.put("page",pageDto);
        data.put("petCircleList",petCirclrList);
        return R.ok(data);
    }

    @PostMapping("/app/testxml/getOneById")
    public R getOneById(@RequestBody P p){
        p.check("id");
        Long id = p.getLong("id");
        PetCircle oneById = petCircleService.getById(id);
        return R.ok(oneById);
    }

}
