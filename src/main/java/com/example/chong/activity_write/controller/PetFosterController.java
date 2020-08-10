package com.example.chong.activity_write.controller;


import com.example.chong.activity_write.entity.PetFoster;
import com.example.chong.activity_write.enums.PetFosterStaticKey;
import com.example.chong.activity_write.service.IPetFosterService;
import com.example.chong.activity_write.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 寄养表 前端控制器
 * </p>
 *
 * @author wucunyang
 * @since 2020-07-15
 */
@RestController
@RequestMapping("/sys/petFoster")
public class PetFosterController {

    @Autowired
    IPetFosterService petFosterService;

    @RequestMapping("/test/testBaseEntity")
    public R testBaseEntity(){
        PetFoster petFoster = new PetFoster();
        petFoster.initCreateData();
        petFoster.setPetName("丢失了的小狗");
        petFoster.setSex(PetFosterStaticKey.PET_FOSTER_SEX_MALE);
        boolean save = petFosterService.save(petFoster);
        return R.ok(save);
    }

    @RequestMapping("/test/testBaseEntityNoInit")
    public R testBaseEntityNoInit(){
        PetFoster petFoster = new PetFoster();
        petFoster.setPetName("丢失了的小狗2");
        petFoster.setSex(PetFosterStaticKey.PET_FOSTER_SEX_MALE);
        boolean save = petFosterService.save(petFoster);
        return R.ok(save);
    }

}
