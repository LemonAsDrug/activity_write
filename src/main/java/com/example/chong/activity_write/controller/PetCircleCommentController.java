package com.example.chong.activity_write.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.chong.activity_write.entity.PageDto;
import com.example.chong.activity_write.entity.PetCircleComment;
import com.example.chong.activity_write.service.IPetCircleCommentService;
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
 *  前端控制器
 * </p>
 *
 * @author wucunyang
 * @since 2020-06-28
 */
@RestController
@RequestMapping("/sys/petCircleComment")
public class PetCircleCommentController {

    @Autowired
    IPetCircleCommentService petCircleCommentService;

    @PostMapping("/app/testAop/getPetCircleCommentList")
    public R getPetCircleCommentList(@RequestBody P p){
        p.check("pageNo","pageSize");
        Integer pageNo = p.getInt("pageNo");
        Integer pageSize = p.getInt("pageSize");
        Page<PetCircleComment> petCircleComPage = petCircleCommentService.getPetCircleComService(pageNo, pageSize);
        List<PetCircleComment> petCircleComList = petCircleComPage.getRecords();
        HashMap<String, Object> data = new HashMap<>();
        PageDto pageDto = new PageDto();
        BeanUtils.copyProperties(petCircleComPage,pageDto);
        data.put("page",pageDto);
//        data.put("petCircleComList",petCircleComList);
        return R.ok(data);
    }


}
