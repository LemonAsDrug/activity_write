package com.example.chong.activity_write.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.chong.activity_write.entity.PageDto;
import com.example.chong.activity_write.entity.PetCirclePic;
import com.example.chong.activity_write.service.IPetCirclePicService;
import com.example.chong.activity_write.utils.P;
import com.example.chong.activity_write.utils.R;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wucunyang
 * @since 2020-06-28
 */
@RestController
@RequestMapping("/sys/petCirclePic")
public class PetCirclePicController {

    @Autowired
    IPetCirclePicService petCirclePicService;

    @PostMapping("/app/testAop/getPetCirclePiclist")
    public R  getPetCirclePiclist(@RequestBody P p){
        p.check("pageNo","pageSize");
        Integer pageNo = p.getInt("pageNo");
        Integer pageSize = p.getInt("pageSize");
        HashMap<String, Object> data = new HashMap<>();
        Page<PetCirclePic> petCirclePicList = petCirclePicService.getPetCirclePicList(pageNo, pageSize);
        PageDto pageDto = new PageDto();
        BeanUtils.copyProperties(petCirclePicList,pageDto);
//        data.put("picList",petCirclePicList);
        data.put("page",pageDto);
        return R.ok(data);
    }

}
