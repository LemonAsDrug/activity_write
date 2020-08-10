package com.example.chong.activity_write.controller;


import com.example.chong.activity_write.entity.SeekPet;
import com.example.chong.activity_write.service.ISeekPetService;
import com.example.chong.activity_write.utils.P;
import com.example.chong.activity_write.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 寻宠表 前端控制器
 * </p>
 *
 * 测试xml写sql语句、注解只测了一个查询
 * @author wucunyang
 * @since 2020-07-14
 */
@RestController
@RequestMapping("/sys/seekPet")
public class SeekPetController {

    @Autowired
    ISeekPetService seekPetService;

    @PostMapping("/test/xmlSelect")
    public R xmlSelect(@RequestBody P p){
        p.check("id");
        Long id = p.getLong("id");
        SeekPet seekPetById = seekPetService.getSeekPetById(id);
        return R.ok(seekPetById);
    }

    @PostMapping("/test/AnnoSelect")
    public R AnnoSelect(@RequestBody P p){
        p.check("id");
        Long id = p.getLong("id");
        SeekPet seekPetById = seekPetService.getSeekPetByIdAnnoByService(id);
        System.out.println("seekPetById = " + seekPetById);
        return R.ok(seekPetById);
    }

    @RequestMapping("/test/insertSeekPet")
    public R insertSeekPet(){
        SeekPet seekPet = new SeekPet();
        seekPet.setMoney(new BigDecimal(12.5));
        seekPet.setCommentNum(100);
        seekPet.setAge(22);
        seekPetService.insertSeekPetByService(seekPet);
        return R.ok();
    }

    @RequestMapping("/test/updateSeekPet")
    public R updateSeekPet(){
        Long id = 146L;
        SeekPet seekPet = seekPetService.getSeekPetById(id);
        seekPet.setDetail("我是吴存洋");
        seekPet.setBrowseNum(1000);
        seekPetService.updateSeekPetByIdByService(seekPet);
        return R.ok();
    }

    @PostMapping("/test/deleteSeekPetById")
    public R deleteSeekPetById(@RequestBody P p){
        p.check("id");
        Long id = p.getLong("id");
        seekPetService.deleteSeekPetByIdByService(id);
        return R.ok();
    }

    @RequestMapping("/test/getSeekPetList")
    public R deleteSeekPetById(){
        List<SeekPet> seekPets = seekPetService.getSeekPets();
        return R.ok(seekPets);
    }







}
